package com.weimo.fighting.shop.controller;

import com.google.gson.Gson;
import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.shop.mapper.ImageUploadMapper;
import com.weimo.fighting.shop.model.CommonBean;
import com.weimo.fighting.shop.model.ImageUploadBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class ImageUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String uploadImage(HttpServletRequest request){
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uploadTime = request.getParameter("uploadTime");
        String uploadPerson = request.getParameter("uploadPerson");
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ImageUploadMapper mapper = sqlSession.getMapper(ImageUploadMapper.class);
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    //上传
                    try {
                        String fileName=System.currentTimeMillis()+".jpg";
                        file.transferTo(new File(uploadDir,fileName));
                        ImageUploadBean imageUploadBean = new ImageUploadBean();
                        imageUploadBean.setImagePath("/upload/"+fileName);
                        imageUploadBean.setUploadTime(uploadTime);
                        imageUploadBean.setUserName(uploadPerson);
                        mapper.addImage(imageUploadBean);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            sqlSession.commit();
            sqlSession.close();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        CommonBean<String> commonBean = new CommonBean<>();
        commonBean.setStatus(0);
        commonBean.setData("ok");
        Gson gson = new Gson();
        return gson.toJson(commonBean);
    }

    @RequestMapping(value = "/getAllImage")
    @ResponseBody
    public CommonBean getALlImage(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ImageUploadMapper mapper = sqlSession.getMapper(ImageUploadMapper.class);
        List<ImageUploadBean> allImage = mapper.getAllImage();
        CommonBean<List<ImageUploadBean>> listCommonBean = new CommonBean<>();
        listCommonBean.setStatus(0);
        listCommonBean.setData(allImage);
        Gson gson = new Gson();
        sqlSession.close();
        return listCommonBean;
    }
}
