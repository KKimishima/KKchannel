package com.github.KKimishima.model.beans;

import com.github.KKimishima.controller.Login;

import java.io.Serializable;

public class LoginUser implements Serializable{
  private String user;
  private String pass;
  private Integer userID;
  public LoginUser(){}
  public LoginUser(String user,String pass){
    this.user = user;
    this.pass = pass;
    this.userID = null;
  }

  public String getPass() {
    return pass;
  }

  public String getUser() {
    return user;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }
}
