package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CountryController {
  @GetMapping("countries")
  public ArrayList<Country> getCountries() {
    ArrayList<Country> countries  = new ArrayList<>();
    Country country1 = new Country("Spain", "Madrid");
    countries.add(country1);
    return countries;
  }

  @PostMapping("countries")
  public Country createCrountry(@RequestBody Country entity) {
      return entity;
  }
  
  
}
