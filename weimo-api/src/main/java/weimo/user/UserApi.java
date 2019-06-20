package weimo.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserApi {

    @RequestMapping("/getUser.do")
    public Map<String,String> getUser(){
        return  new HashMap<>();
    }

}
