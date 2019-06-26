package weimo.upload;

import common.CommonVO;
import common.ImageUploadBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import weimo.dal.image.ImageUploadMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class ImageUploadController {

    @Autowired
    private ImageUploadMapper imageUploadMapper;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public CommonVO uploadImage(HttpServletRequest request) {
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uploadTime = request.getParameter("uploadTime");
        String uploadPerson = request.getParameter("uploadPerson");
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    //上传
                    try {
                        String fileName = System.currentTimeMillis() + ".jpg";
                        file.transferTo(new File(uploadDir, fileName));
                        ImageUploadBean imageUploadBean = new ImageUploadBean();
                        imageUploadBean.setImagePath("/upload/" + fileName);
                        imageUploadBean.setUploadTime(uploadTime);
                        imageUploadBean.setUserName(uploadPerson);
                        imageUploadMapper.addImage(imageUploadBean);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + String.valueOf(endTime - startTime) + "ms");
        CommonVO<String> commonBean = new CommonVO<>();
        commonBean.setStatus(0);
        commonBean.setData("ok");
        return commonBean;
    }

    @RequestMapping(value = "/getAllImage")
    @ResponseBody
    public CommonVO getALlImage() {
        List<ImageUploadBean> allImage = imageUploadMapper.getAllImage();
        CommonVO<List<ImageUploadBean>> listCommonBean = new CommonVO<>();
        listCommonBean.setStatus(0);
        listCommonBean.setData(allImage);
        return listCommonBean;
    }
}
