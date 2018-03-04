package com.github.KKimishima.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoginLogicTest {

  @Test
  public void executeTest成功のパスワードを渡して成功させる() {
    LoginUser loginUser = new LoginUser("admin","admin");
    LoginLogic loginLogic = new LoginLogic(loginUser);
    assertThat(true,is(loginLogic.execute()));
  }
  @Test
  public void executeTest失敗のパスワードを渡して失敗させる() {
    LoginUser loginUser = new LoginUser("ほげ","ほげ");
    LoginLogic loginLogic = new LoginLogic(loginUser);
    assertThat(false,is(loginLogic.execute()));
  }
}