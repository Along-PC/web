package weimo.user;

import common.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public ResultDTO getUser(){
        userService.login(new UserVO());
        return  new ResultDTO();
    }

}
