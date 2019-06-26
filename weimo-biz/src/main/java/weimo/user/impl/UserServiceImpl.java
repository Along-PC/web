package weimo.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weimo.user.UserService;
import weimo.user.UserVO;
import weimo.dal.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(UserVO userVO) {
        userMapper.getUser(userVO);
        return false;
    }
}
