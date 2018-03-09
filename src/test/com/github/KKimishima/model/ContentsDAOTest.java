package com.github.KKimishima.model;

import com.github.KKimishima.model.DAO.ContentsDAO;
import com.github.KKimishima.model.beans.Contents;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ContentsDAOTest {

  @Test
  public void execute() {
    ContentsDAO contentsDAO = new ContentsDAO();
    List<Contents> list = contentsDAO.execute();
    assertThat(list.get(0).getPostID(),is("1"));
    assertThat(list.get(0).getTitle(),is("テスト投稿"));
    assertThat(list.get(0).getText(),is("こんにちわ"));
    assertThat(list.get(0).getDate(),is("2018-03-06"));
    assertThat(list.get(0).getTime(),is("22:17:07"));
    assertThat(list.get(0).getUserName(),is("admin"));
  }

  @Test
  public void ExecutePost() {
    ContentsDAO contentsDAO =  new ContentsDAO();
    contentsDAO.ExecutePost("ポストテストタイトル","postTest本文",1);
  }
}