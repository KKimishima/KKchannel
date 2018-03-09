package com.github.KKimishima.model.beans;

import com.github.KKimishima.controller.Login;

import java.io.Serializable;

public class LoginUser implements Serializable{
  private String user;
  private String pass;
  public LoginUser(){}
  public LoginUser(String user,String pass){
    this.user = user;
    this.pass = pass;
  }

  public String getPass() {
    return pass;
  }

  public String getUser() {
    return user;
  }
}
