package com.github.KKimishima.model.beans;

import java.io.Serializable;

public class ContentsPost implements Serializable{
  private String title;
  private String text;
  private int userID;

  public ContentsPost(){}
  public ContentsPost(
      String title,
      String text,
      int    userID
  ){
    this.title = title;
    this.text = text;
    this.userID = userID;
  }

  public String getTitle() {
    return title;
  }

  public String getText() {
    return text;
  }

  public int getUserID() {
    return userID;
  }

}
