package pub.hqs.service.users;

import com.github.pagehelper.PageInfo;
import pub.hqs.pojo.User;
import pub.hqs.pojo.UserSearch;

public interface IUserService {
    PageInfo<User> getUserList(UserSearch search);
    User getById(int id);
    int addOrUpdateUser(User user);
    int deleteUser(int id);
}
