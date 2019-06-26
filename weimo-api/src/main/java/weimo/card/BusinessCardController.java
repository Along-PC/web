package weimo.card;


import common.BusinessCardBean;
import common.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weimo.dal.card.BusinessCardMapper;

import java.util.List;

@Controller
public class BusinessCardController {

    @Autowired
    private BusinessCardMapper businessCardMapper;

    @RequestMapping(value = "/getAllCards")
    @ResponseBody
    public CommonVO getAllCards() {
        List<BusinessCardBean> allBusinessCard = businessCardMapper.getAllBusinessCard();
        CommonVO<List<BusinessCardBean>> listCommonBean = new CommonVO<>();
        listCommonBean.setStatus(0);
        listCommonBean.setData(allBusinessCard);
        return listCommonBean;
    }


}
