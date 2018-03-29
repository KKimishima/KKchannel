package com.github.KKimishima.controller;

import com.github.KKimishima.model.Logic.DeleteLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/Main/Delete")
public class Delete extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String postID = req.getParameter("postID");
    int postIDNum = Integer.parseInt(postID);
    boolean check;

    DeleteLogic deleteLogic = new DeleteLogic(postIDNum);
    if (deleteLogic.execute()){
      check = true;
    }else{
      check = false;
    }

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter pw = resp.getWriter();
    pw.print(check);
    pw.close();
  }
}
