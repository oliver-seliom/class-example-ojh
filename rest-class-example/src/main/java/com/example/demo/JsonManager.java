package com.example.demo;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonManager {
  public ArrayList<User> getUsers() throws IOException{
    String root = System.getProperty("user.dir");
    String path = root + "/src/main/resources/users.json";
    String jsonContent = new String(Files.readAllBytes(Paths.get(path)));
    Gson gson = new Gson();
    Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
    ArrayList<User> users = gson.fromJson(jsonContent, userListType);
    return users;
  }

  public void saveUsers(ArrayList<User> users) throws IOException{
    Gson gson = new Gson();
    String jsonContent = gson.toJson(users);
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/users.json";
    Writer writer = Files.newBufferedWriter(Paths.get(path));
    writer.write(jsonContent);
    writer.close();
  }
}
