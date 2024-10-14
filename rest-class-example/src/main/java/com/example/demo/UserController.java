package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
  @GetMapping("/users")
  public ArrayList<User> getUsers() throws IOException {
    JsonManager manager = new JsonManager();
    ArrayList<User> users = manager.getUsers();
    return users;
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User newUser) throws IOException {  
    JsonManager manager = new JsonManager();
    ArrayList<User> users = manager.getUsers();
    users.add(newUser);
    manager.saveUsers(users);
    return newUser;
  }

  @DeleteMapping("/users/{firstName}")
  public String deleteUser(@PathVariable String firstName) throws IOException{
    JsonManager manager = new JsonManager();
    ArrayList<User> users = manager.getUsers();
    ArrayList<User> newUsers = new ArrayList<>();

    for (User user : users) {
      if(!user.getFirstName().equals(firstName)){
        newUsers.add(user);
      }
    }

    manager.saveUsers(newUsers);

    return new String("User deleted successfully");
  }
}
