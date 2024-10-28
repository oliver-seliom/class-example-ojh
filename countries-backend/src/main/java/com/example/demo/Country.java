package com.example.demo;

public class Country {
  private String name;
  private String capitalCity;

  public Country(String name, String capitalCity) {
    this.name = name;
    this.capitalCity = capitalCity;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCapitalCity() {
    return capitalCity;
  }
  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }

  
}
