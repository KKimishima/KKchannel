package com.github.KKimishima.controller;

import com.github.KKimishima.model.Logic.ContentsLogic;
import com.github.KKimishima.model.beans.Contents;
import com.github.KKimishima.model.beans.LoginUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Main")
public class Main  extends HttpServlet{
  private final static long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ContentsLogic contentsLogic = new ContentsLogic();
    List<Contents> list = contentsLogic.execute();

    req.setAttribute("list",list);

    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/main.jsp"
    );
    rd.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ContentsLogic contentsLogic = new ContentsLogic();
    List<Contents> list = contentsLogic.execute();


    req.setAttribute("list",list);

    String title = req.getParameter("title");
    String text = req.getParameter("text");


    HttpSession httpSession = req.getSession();
    LoginUser loginUser =(LoginUser)httpSession.getAttribute("loginUser");

    System.out.println("title = "+ title + ": text =" +text + ": userID = "+ loginUser.getUserID());
    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/main.jsp"
    );
    rd.forward(req,resp);
  }
}
