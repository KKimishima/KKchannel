package com.github.KKimishima.model.DAO;

import java.sql.*;

public class DeleteDAO {
  private final String dbUser = "sa";
  private final String dbPass = "";
  private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";

  public boolean execute(int postID){
    try{
      try(Connection con = DriverManager.getConnection(dbPath, dbUser, dbPass);){
        PreparedStatement ps = con.prepareStatement(
            "delete from CONTENTS where POSTID = ?");
        ps.setInt(1,postID);
        int rs = ps.executeUpdate();

        if(rs == 0){
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
