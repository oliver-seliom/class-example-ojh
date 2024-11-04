package com.example.demo;

public class SalaryCalculation {
  private Double managerBaseSalary = 10000.0;
  private Double sellerBaseSalary = 10000.0;

  private Double managerBonus = 10000.0;
  private Double sellerBonus = 10000.0;

  private String employeeType;
  private Integer extraHoursWorked;
  private Integer sales;

  public SalaryCalculation(String employeeType, Integer extraHoursWorked, Integer sales) {
    this.employeeType = employeeType;
    this.extraHoursWorked = extraHoursWorked;
    this.sales = sales;
  }

  public String getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }

  public Integer getExtraHoursWorked() {
    return extraHoursWorked;
  }

  public void setExtraHoursWorked(Integer extraHoursWorked) {
    this.extraHoursWorked = extraHoursWorked;
  }

  public Integer getSales() {
    return sales;
  }

  public void setSales(Integer sales) {
    this.sales = sales;
  }

  public Double pretaxSalary(){
    Double salary = 0.0;

    if(this.getEmployeeType().equals("Manager")){
      salary = this.managerBaseSalary;
      salary += (this.getExtraHoursWorked() * this.managerBonus);
    } else {
      salary = this.sellerBaseSalary;
      salary += (this.getExtraHoursWorked() * this.sellerBonus);
    }

    if(this.getSales() >= 1000 && this.getSales() < 1500){
      salary += 100.0;
    }

    if(this.getSales() > 1500){
      salary += 200.0;
    }

    return salary;
  }

  public Double posttaxSalary(){
    Double salary = this.pretaxSalary();
    if(salary <= 1000){
      return salary;
    }

    if(salary >= 1000 && salary < 1500){
      return salary - (salary * 0.16);
    } else {
      return salary - (salary * 0.18);
    }
  }
}


