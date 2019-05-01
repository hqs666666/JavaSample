package example.service;

import example.pojo.User;
import example.pojo.PagedList;
import example.pojo.UserSearch;

public interface IUserService {
    PagedList<User> findAll(UserSearch search);
    User getById(int id);
    int addOrUpdateUser(User user);
    int deleteUser(int id);
}
