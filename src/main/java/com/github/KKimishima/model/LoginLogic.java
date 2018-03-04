package com.github.KKimishima.model;

import com.github.KKimishima.controller.Login;

public class LoginLogic {
  private String user;
  private String pass;
  private LoginDAO loginDAO = new LoginDAO();
  public LoginLogic(LoginUser loginUser){
    this.user = loginUser.getUser();
    this.pass = loginUser.getPass();
  }
  public Boolean execute(){
    if (loginDAO.execute(user,pass)){
      return true;
    }
      return false;
  }
}
