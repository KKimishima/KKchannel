package com.github.KKimishima.model.Logic;

public class PostCheckLogic {
  public Boolean execute(String title,String text){
    if ((title == null ||title.length() == 0)|| (text == null || text.length() ==0)){
          return false;
    }
    return true;
  }
}
