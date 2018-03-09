package com.github.KKimishima.model.Logic;

import com.github.KKimishima.model.DAO.ContentsDAO;
import com.github.KKimishima.model.beans.Contents;

import java.util.List;

public class ContentsLogic {
  private ContentsDAO contentsDAO = new ContentsDAO();
  public List<Contents> execute(){
    return contentsDAO.execute();
  }
}
