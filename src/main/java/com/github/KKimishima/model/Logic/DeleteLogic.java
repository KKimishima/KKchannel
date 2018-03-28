package com.github.KKimishima.model.Logic;

import com.github.KKimishima.model.DAO.DeleteDAO;

public class DeleteLogic {
  private int postID;
  public DeleteLogic(int postID){
    this.postID = postID;
  }
  public boolean execute(){
    DeleteDAO deleteDAO = new DeleteDAO();
    return deleteDAO.execute(this.postID);
  }
}
