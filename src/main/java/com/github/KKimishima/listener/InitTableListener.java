package com.github.KKimishima.listener;

import com.github.KKimishima.model.DAO.InitDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitTableListener implements ServletContextListener{
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    InitDAO initDAO = new InitDAO();
    initDAO.initTable();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
