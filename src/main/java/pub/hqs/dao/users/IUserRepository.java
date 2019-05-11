package pub.hqs.dao.users;

import pub.hqs.pojo.users.User;
import org.springframework.stereotype.Repository;
import pub.hqs.pojo.users.UserSearch;

import java.util.List;

@Repository
public interface IUserRepository {
    List<User> findAll(UserSearch search);
    User getById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
