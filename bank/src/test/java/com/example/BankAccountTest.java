package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

  BankAccount account = new BankAccount(100);
  
  @Before
  public void clearDatabse(){

  }

  @After
  public void runAfterEveryTest(){

  }

  @Test
  public void testCreatesAccountWithInitialBalance() {
    assertNotNull(account);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNegativeBalance(){
    BankAccount account = new BankAccount(-100);
  }

  @Test
  public void testDepositMoney(){
    BankAccount account = new BankAccount(100);
    account.addMoney(100);
    assertEquals(account.getBalance(), new Integer(200));
  }

  @Test
  public void testWithrawMoney(){
    BankAccountMock account = new BankAccountMock(100);
    account.withrawMoney(50);
    assertEquals(account.getBalance(),  new Integer(50));
  }
}
