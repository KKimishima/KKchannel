package com.github.KKimishima.controller;

import com.github.KKimishima.model.DAO.EditDAO;
import com.github.KKimishima.model.Logic.EditLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Main/Edit")
public class Edit extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String postID = req.getParameter("postID");
    String title = req.getParameter("title");
    String massage = req.getParameter("massage");

    Boolean check;
    int postIDNum = Integer.parseInt(postID);

    EditLogic editLogic = new EditLogic(postIDNum,title,massage);
    if (editLogic.execute()){
      check = true;
    }else{
      check = false;
    }

    System.out.println(String.format("postID = %s,title = %s,massage = %s",postID,title,massage));

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter pw = resp.getWriter();
    pw.print(check);
    pw.close();

  }
}
