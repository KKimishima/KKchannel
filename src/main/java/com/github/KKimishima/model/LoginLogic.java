package com.github.KKimishima.model;

import com.github.KKimishima.controller.Login;

public class LoginLogic {
  private String user;
  private String pass;
  public LoginLogic(LoginUser loginUser){
    this.user = loginUser.getUser();
    this.pass = loginUser.getPass();
  }
  public Boolean execute(){
    if (user.equals("admin") || pass.equals("admin123")){
      return true;
    }
      return false;
  }
}
