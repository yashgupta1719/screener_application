package com.application.screener.screener_application.controller;

import com.application.screener.screener_application.models.User;
import com.application.screener.screener_application.models.UsersReponse;
import com.application.screener.screener_application.service.CommonService;
import com.application.screener.screener_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screener/api")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<UsersReponse> getAllUsers(){
        List<User> listOfUsers = userService.getAllUsers();
        UsersReponse usersReponse = new UsersReponse();
        usersReponse.setResult(listOfUsers);
        return new ResponseEntity<UsersReponse>(usersReponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/create-user",method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User userObj){
        userService.save(userObj);
        return new ResponseEntity<User>(userObj, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value="/remove-user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        Long userId = userService.deleteUser(id);
        return new ResponseEntity<Long>(userId, HttpStatus.OK);
    }
    @RequestMapping(value = "/update-user",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.update(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
