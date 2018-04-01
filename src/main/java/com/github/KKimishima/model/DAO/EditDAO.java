package com.github.KKimishima.model.DAO;

import java.sql.*;

public class EditDAO {
  private final String dbUser = "sa";
  private final String dbPass = "";
  private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";

  public Boolean execut(int postID,String title,String massage){
    try{
      try(Connection con = DriverManager.getConnection(dbPath, dbUser, dbPass);) {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE CONTENTS SET TITLE = ?,TEXT = ? WHERE POSTID = ?"
        );
        ps.setString(1,title);
        ps.setString(2,massage);
        ps.setInt(3,postID);

        int rs = ps.executeUpdate();

        if (rs == 0){
          return false;
        }
      }
    }catch (SQLException e){
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
