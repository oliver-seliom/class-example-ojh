package com.example;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
      Gson gson = new Gson();
      
      // Array Lists and JSON creation
      ArrayList<User> users = new ArrayList<>();
      User user3 = new User(3, "Ignacio", "De Albert");
      User user4 = new User(4, "User 1", "Hello world");
      users.add(user3);
      users.add(user4);

      String response = gson.toJson(users);
      System.out.println(response);      

      // JSON Parsing
      String requestBody = "{\"id\": 4, \"firstName\": \"Oliver\"}";
      User parsedUser = gson.fromJson(requestBody, User.class);
      System.out.println(parsedUser.getFirstName());

      // Hash Maps
      HashMap<Integer, User> hash = new HashMap<>();
      hash.put(user3.getId(), user3);
      hash.put(user4.getId(), user4);
      System.out.println(hash.get(3).getFirstName());
    }
}