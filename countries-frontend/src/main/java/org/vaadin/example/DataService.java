package org.vaadin.example;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.lang.reflect.Type;

public class DataService {
  public static ArrayList<Country> getCountries() throws URISyntaxException, IOException, InterruptedException{
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(new URI("http://localhost:8081/countries"))
      .GET()
      .build();
    
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String responseBody = response.body();

    Gson gson = new Gson();
    Type countryListType = new TypeToken<ArrayList<Country>>(){}.getType();
  
    ArrayList<Country> countries = gson.fromJson(responseBody, countryListType);
    return countries;
  }

  public static Country createCountry(Country country) throws IOException, InterruptedException{
    Gson gson = new Gson();
    String body = gson.toJson(country);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:8081/countries"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(body))
    .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());

    return country;
  }
}
