package org.vaadin.example;

import java.net.URI;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.lang.reflect.Type;

public class DataService {
  public static ArrayList<String> getEmployeeTypes() throws URISyntaxException, IOException, InterruptedException{
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(new URI("http://localhost:8080/employeeTypes"))
      .GET()
      .build();
    
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String responseBody = response.body();
    
    Gson gson = new Gson();
    Type employeeType = new TypeToken<ArrayList<String>>(){}.getType();
    
    ArrayList<String> types = gson.fromJson(responseBody, employeeType);
    return types;
  }

  public static String calculatePreTax(RequestBody requestBody) throws URISyntaxException, IOException, InterruptedException{
    Gson gson = new Gson();
    String body = gson.toJson(requestBody);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:8080/preTax"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(body))
    .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response);
    return response.body();
  }

  public static String calculatePostTax(RequestBody requestBody) throws URISyntaxException, IOException, InterruptedException{
    Gson gson = new Gson();
    String body = gson.toJson(requestBody);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:8080/postTax"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(body))
    .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }
}
