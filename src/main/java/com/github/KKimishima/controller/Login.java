package com.github.KKimishima.controller;

import com.github.KKimishima.model.InitDAO;
import com.github.KKimishima.model.LoginLogic;
import com.github.KKimishima.model.LoginUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet{
  private final static long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    InitDAO initDAO = new InitDAO();
    initDAO.createDB();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/Login.jsp"
    );
    rd.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // キャラセット
    req.setCharacterEncoding("UTF-8");
    HttpSession httpSession = req.getSession();

    // モデルに収納
    String user = req.getParameter("user");
    String pass = req.getParameter("pass");
    LoginUser loginUser = new LoginUser(user,pass);

    // ログインロジック
    LoginLogic loginLogic = new LoginLogic(loginUser);
    if (loginLogic.execute()){
      // 成功
      //セッションスコープに保存
      httpSession.setAttribute("loginUser",loginUser);
    }else {
      httpSession.removeAttribute("loginUser");
    }

    // ログイン画面にフォワード
    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/Login.jsp"
    );
   rd.forward(req,resp);
  }
}
