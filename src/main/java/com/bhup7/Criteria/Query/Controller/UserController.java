package com.bhup7.Criteria.Query.Controller;

import com.bhup7.Criteria.Query.Entity.User;
import com.bhup7.Criteria.Query.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public List<User> getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        service.createUser(user);
        return "Data Successfully added";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "Data Deleted Succesfully";
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        service.updateUser(id, user);
        return "Data Updated";
    }

    @GetMapping("/userGreaterThan/{id}")
    public List<User> userGreaterThan(@PathVariable int id) {
        return service.userGreaterThan(id);
    }

    @GetMapping("/userGreaterThanEqual/{id}")
    public List<User> userGreaterThanEqual(int id) {
        return service.userGreaterThanEqual(id);
    }

    @GetMapping("/userLessThan/{id}")
    public List<User> userLessThan(@PathVariable int id) {
        return service.userLessThan(id);
    }

    @GetMapping("/userLessThanEqual/{id}")
    public List<User> userLessThanEqual(@PathVariable int id) {
        return service.userLessThanEqual(id);
    }

    @GetMapping("/userBetween/{id}/{id1}")
    public List<User> userBetween(@PathVariable int id, @PathVariable int id1) {
        return service.userBetween(id, id1);
    }

    @GetMapping("/userLike/{name}")
    public List<User> userLike(String name) {
        return service.userLike(name);
    }

    @GetMapping("/userNameAndAddress/{name}/{address}")
    public List<User> userNameAndAddress(@PathVariable String name, @PathVariable String address) {
        return service.userNameAndAddress(name, address);
    }

    @GetMapping("/userNameorEmail/{name}/{email}")
    public List<User> userNameorEmail(@PathVariable String name, @PathVariable String email) {
        return service.userNameorEmail(name, email);
    }

    @GetMapping("/userNotName/{name}")
    public List<User> userNotName(@PathVariable String name) {
        return service.userNotName(name);
    }

    /*@GetMapping("/userIsNull")
    public List<User> userIsNull(){
        return service.userIsNull();
    }*/
    @GetMapping("/userIn/{address}")
    public List<User> userIn(@PathVariable String address) {
        return service.userIn(address);

    }
}