package example.service;

import example.dao.IUserRepository;
import example.pojo.User;
import example.pojo.PagedList;
import example.pojo.UserSearch;
import example.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Override
    public PagedList<User> findAll(UserSearch search){
        SqlSession sqlSession = null;
        PagedList<User> users = new PagedList<>();
        try{
            sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
            RowBounds rowBounds = new RowBounds(search.getOffset(),search.getPagesize());
            List<User> list = userRepository.findAll(rowBounds);
            users.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return users;
    }

    @Override
    public User getById(int id){
        SqlSession sqlSession = null;
        User user = null;
        try{
            sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
            user = userRepository.getById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return user;
    }

    @Override
    public int addOrUpdateUser(User user){
        SqlSession sqlSession = null;
        int result = 0;
        try{
            sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

            if(user.getId() == 0){
                result = userRepository.insertUser(user);
            }else{
                result = userRepository.updateUser(user);
            }

            sqlSession.commit();    //手动提交
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return result;
    }

    @Override
    public int deleteUser(int id){
        SqlSession sqlSession = null;
        int result = 0;
        try{
            sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
            result = userRepository.deleteUser(id);
            sqlSession.commit();    //手动提交
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return result;
    }
}
