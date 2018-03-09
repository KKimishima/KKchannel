package com.github.KKimishima.model;

import com.github.KKimishima.model.DAO.LoginDAO;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoginDAOTest {

  @Test
  public void Testログインを成功させる() {
    LoginDAO loginDAO = new LoginDAO();
    assertThat(true,is(loginDAO.execute("admin","admin")));
  }
   @Test
  public void Testログインを失敗させる() {
    LoginDAO loginDAO = new LoginDAO();
    assertThat(false,is(loginDAO.execute("admin","hoge")));
  }
}