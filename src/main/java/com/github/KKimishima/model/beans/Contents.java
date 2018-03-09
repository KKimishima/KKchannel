package com.github.KKimishima.model.beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Contents implements Serializable{
  private  Integer postID;
  private String title;
  private String text;
  private Date date;
  private Time time;
  private String userName;

  public Contents(){}
  public Contents(
      Integer postID,
      String title,
      String text,
      Date data,
      Time time,
      String userName
  ){
    this.postID = postID;
    this.title = title;
    this.text = text;
    this.date = data;
    this.time = time;
    this.userName = userName;
  }

  public String getTitle() {
    return title;
  }

  public String getTime() {
    return time.toString();
  }

  public String getDate() {
    return date.toString();
  }
  public String getPostID() {
    return postID.toString();
  }
  public String getText() {
    return text;
  }

  public String getUserName() {
    return userName;
  }
}

