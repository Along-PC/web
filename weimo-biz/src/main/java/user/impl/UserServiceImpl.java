package user.impl;


import org.springframework.stereotype.Service;
import user.UserService;
import user.UserVO;
import weimo.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    @Override
    public boolean login(UserVO userVO) {
        return false;
    }
}
