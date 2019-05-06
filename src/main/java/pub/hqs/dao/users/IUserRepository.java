package pub.hqs.dao.users;

import pub.hqs.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    List<User> findAll();
    User getById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
