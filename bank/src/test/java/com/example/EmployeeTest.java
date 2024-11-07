package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {
  Employee employee = new Employee("oliver", "hoffman");
  
  @Test
  public void testGetFirstName() {
    assertEquals("Hello", employee.getFirstName());
  }

  @Test
  public void testGetLastName() {
    assertEquals("hoffman", employee.getLastName());
  }
}
