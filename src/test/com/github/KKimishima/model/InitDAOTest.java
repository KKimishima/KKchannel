package com.github.KKimishima.model;

import org.junit.Test;

import java.sql.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InitDAOTest {
  private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";
  private final String dbUser = "sa";
  private final String dbPass = "";

  @Test
  public void Test既存のDBがある場合() {
    InitDAO initDAO = new InitDAO();
    initDAO.createDB();
    Connection con = null;
    try{
      con = DriverManager.getConnection(dbPath, dbUser, dbPass);
      PreparedStatement ps1 = con.prepareStatement(
          "select * from LOGINUSER where USERNAME = ? ;"
      );
      ps1.setString(1,"admin");
      ResultSet rs1 = ps1.executeQuery();
      if (rs1.next()){
        assertThat("admin",is(rs1.getString("PASS")));
      }

      PreparedStatement ps2 = con.prepareStatement(
          "select * from CONTENTS where POSTID = ? ;"
      );
      ps2.setInt(1,1);
      ResultSet rs2 = ps2.executeQuery();
      if (rs2.next()){
        assertThat(1,is(rs2.getInt("POSTID")));
      }
    }catch (SQLException e){
      e.printStackTrace();
    }finally {
      try{
        if (con != null){
          con.close();
        }
      }catch (SQLException e){
        e.printStackTrace();
      }
    }
  }
}