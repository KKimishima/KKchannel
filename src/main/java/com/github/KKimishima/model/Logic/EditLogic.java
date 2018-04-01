package com.github.KKimishima.model.Logic;

import com.github.KKimishima.model.DAO.EditDAO;

public class EditLogic {
  private int postID;
  private String title;
  private String message;
  public EditLogic(int postID,String title,String message){
    this.postID = postID;
    this.title = title;
    this.message = message;
  }
  public Boolean execute(){
    EditDAO editDAO = new EditDAO();
    return editDAO.execut(postID,title,message);
  }
}
