package example.dao;

import example.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    List<User> findAll(RowBounds rowBounds);
    User getById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
