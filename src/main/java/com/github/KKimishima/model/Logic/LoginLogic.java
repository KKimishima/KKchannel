package com.github.KKimishima.model.Logic;

import com.github.KKimishima.model.DAO.LoginDAO;
import com.github.KKimishima.model.beans.LoginUser;

public class LoginLogic {
  private String user;
  private String pass;
  private LoginDAO loginDAO = new LoginDAO();
  public LoginLogic(LoginUser loginUser){
    this.user = loginUser.getUser();
    this.pass = loginUser.getPass();
  }
  public Boolean execute(LoginUser loginUser){
    Integer result = loginDAO.execute(user,pass);
    if (!(result == null)){
      loginUser.setUserID(result);
      return true;
    }
      return false;
  }
}
