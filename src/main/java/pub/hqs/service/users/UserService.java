package pub.hqs.service.users;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import pub.hqs.dao.users.IUserRepository;
import pub.hqs.pojo.User;
import pub.hqs.pojo.UserSearch;
import pub.hqs.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public PageInfo<User> getUserList(UserSearch search){
        PageHelper.startPage(search.getPage(),search.getPagesize());
        List<User> users = userRepository.findAll(search);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User getById(int id){
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public int addOrUpdateUser(User user){
        return user.getId() == 0 ? userRepository.insertUser(user) : userRepository.updateUser(user);
    }

    @Override
    @Transactional
    public int deleteUser(int id){
        return userRepository.deleteUser(id);
    }
}
