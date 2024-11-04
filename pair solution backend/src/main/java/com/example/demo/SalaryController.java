package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SalaryController {
  @GetMapping("employeeTypes")
  public ArrayList<String> getMethodName() {
    ArrayList<String> employeeTypes = new ArrayList<>();
    employeeTypes.add("Manager");
    employeeTypes.add("Seller");
    return employeeTypes;
  }
  
  @PostMapping("preTax")
  public Double preTax(@RequestBody SalaryCalculation entity) {
    return entity.pretaxSalary();
  }

  @PostMapping("postTax")
  public Double postTax(@RequestBody SalaryCalculation entity) {
    return entity.posttaxSalary();
  }
}
