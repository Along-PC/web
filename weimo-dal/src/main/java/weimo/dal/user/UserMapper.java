package weimo.dal.user;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import weimo.user.UserDO;
import weimo.user.UserVO;

@Mapper
public interface UserMapper {

   @Select(" SELECT ID ,LOGIN_NAME FROM WEIMO.SYS_USER limit 1 ")
   UserDO getUser(UserVO userVO);


}
