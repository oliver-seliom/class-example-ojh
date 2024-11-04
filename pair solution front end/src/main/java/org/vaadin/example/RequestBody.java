package org.vaadin.example;

public class RequestBody {
  private String employeeType;
  private Integer extraHoursWorked;
  private Integer sales;

  public RequestBody(String employeeType, Integer extraHoursWorked, Integer sales) {
    this.employeeType = employeeType;
    this.extraHoursWorked = extraHoursWorked;
    this.sales = sales;
  }
}
