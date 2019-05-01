package example.dao;

import example.pojo.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IUserRepository {
    List<User> findAll(RowBounds rowBounds);
    User getById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
