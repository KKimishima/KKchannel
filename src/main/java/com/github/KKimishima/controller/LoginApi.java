package com.github.KKimishima.controller;

import com.github.KKimishima.model.Logic.LoginLogic;
import com.github.KKimishima.model.beans.LoginResult;
import com.github.KKimishima.model.beans.LoginUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginApi")
public class LoginApi extends HttpServlet{
  private final static long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 非同期テスト
    try{
      Thread.sleep(1000);
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("失敗");
    }

    // キャラセット
    HttpSession httpSession = req.getSession();

    // モデルに収納
    String user = req.getParameter("user");
    String pass = req.getParameter("pass");
    LoginUser loginUser = new LoginUser(user,pass);
    String json;

    // ログインロジック
    LoginLogic loginLogic = new LoginLogic(loginUser);
    if (loginLogic.execute(loginUser)){
      // 成功
      //セッションスコープに保存
      httpSession.setAttribute("loginUser",loginUser);
      // メイン画面にリダイレクト
//      resp.sendRedirect("/KKchannel/Main");
      json = "[{\"login\":\"loginApi\",\"loginCheck\":\"true\"}]";
    }else {
      // 失敗
      LoginResult loginResult = new LoginResult(false);
      req.setAttribute("loginResult", loginResult);
      httpSession.removeAttribute("loginUser");
      // ログイン画面にフォワード
//      RequestDispatcher rd = req.getRequestDispatcher(
//          "/WEB-INF/jsp/Login.jsp"
//      );
//      rd.forward(req, resp);
      json = "[{\"login\":\"LoginApi\",\"loginCheck\":\"false\"}]";
    }
    resp.setContentType("application/json;charset=UTF-8");
    PrintWriter pw = resp.getWriter();
    pw.print(json);
    pw.close();

  }
}
