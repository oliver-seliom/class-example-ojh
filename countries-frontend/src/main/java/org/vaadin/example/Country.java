package org.vaadin.example;

public class Country {
  private String name;
  private String capitalCity;

  public String getCapitalCity() {
    return capitalCity;
  }

  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }

  public Country(String name, String capital) {
    this.name = name;
    this.capitalCity = capital;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
