package com.bhup7.Criteria.Query.Service;

import com.bhup7.Criteria.Query.Entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public List<User> getUser(int id);

    public void createUser(User user);

    public void deleteUser(int id);

    public User updateUser(int id, User user);

    public List<User> userGreaterThan(int id);

    public List<User> userGreaterThanEqual(int id);

    public List<User> userLessThan(int id);

    public List<User> userLessThanEqual(int id);

    public List<User> userBetween(int id, int id1);

    public List<User> userLike(String name);

    public List<User> userNameAndAddress(String name, String address);

    public List<User> userNameorEmail(String name, String email);


    public List<User> userNotName(String name);

    //public List<User> userIsNull();

    public List<User> userIn(String address);
}
