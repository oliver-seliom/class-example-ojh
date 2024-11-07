package com.example;

public class BankAccountMock extends BankAccount {
  public BankAccountMock(Integer balance) {
    super(balance);
  }

  public String getAccountStatus(){
    return new String("active");
  }
  
}
