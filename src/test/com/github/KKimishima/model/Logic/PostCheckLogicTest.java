package com.github.KKimishima.model.Logic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PostCheckLogicTest {

  @Test
  public void execute() {
    PostCheckLogic postCheckLogic = new PostCheckLogic();
    assertThat(false,is(postCheckLogic.execute("","")));
  }
}