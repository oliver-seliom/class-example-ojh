package com.example;

public class BankAccount {
  private Integer balance;

  public BankAccount(Integer balance) {
    if(balance < 0){
      throw new IllegalArgumentException("Accounts with negative balance are not permitted");
    }

    this.balance = balance;
  }

  public Integer getBalance() {
    return balance;
  }

  public void withrawMoney(Integer balance){
    if(this.getAccountStatus().equals("active")){
      this.balance -= balance;
    }
  }

  public void addMoney(Integer balance){
    this.balance += balance;
  }

  public Integer taxesOwed(){
    // 
    return 0;
  }

  public String getAccountStatus(){
    System.out.println("Calling API!");
    return new String("active");
  }

}
