package com.github.KKimishima.model;

import java.io.Serializable;

public class LoginResult implements Serializable{
  private Boolean result;
  public LoginResult(){}
  public LoginResult(Boolean result){
    this.result = result;
  }

  public Boolean getResult() {
    return result;
  }
}
