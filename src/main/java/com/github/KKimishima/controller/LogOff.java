package com.github.KKimishima.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogOff")
public class LogOff extends HttpServlet{
  private final static long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    httpSession.removeAttribute("loginUser");
    // ログイン画面にフォワード
    resp.sendRedirect("/KKchannel/Login");
  }
}
