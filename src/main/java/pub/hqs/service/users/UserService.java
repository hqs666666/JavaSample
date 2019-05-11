package pub.hqs.service.users;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.hqs.dao.users.IUserRepository;
import pub.hqs.pojo.users.User;
import pub.hqs.pojo.users.UserSearch;
import pub.hqs.service.BaseService;
import pub.hqs.utils.JedisHelper;

import java.util.List;

@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public PageInfo<User> getUserList(UserSearch search) {
        PageHelper.startPage(search.getPage(), search.getPagesize());
        List<User> users = userRepository.findAll(search);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    public List<User> getAllUsers(UserSearch search) {
        List<User> users = JedisHelper.get("user", new TypeReference<List<User>>() {
        });
        if (users == null) {
            users = userRepository.findAll(search);
            JedisHelper.set("user", users);
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user = JedisHelper.get("user-" + id, User.class);
        if (user == null) {
            user = userRepository.getById(id);
            JedisHelper.set("user-" + id, user,60);
        }
        return user;
    }

    @Override
    @Transactional
    public int addOrUpdateUser(User user) {
        return user.getId() == 0 ? userRepository.insertUser(user) : userRepository.updateUser(user);
    }

    @Override
    @Transactional
    public int deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
}
