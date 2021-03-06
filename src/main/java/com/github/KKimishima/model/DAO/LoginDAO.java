package com.github.KKimishima.model.DAO;


import java.sql.*;

public class LoginDAO {
  private final String dbUser = "sa";
  private final String dbPass = "";
  private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";

  public Integer execute(String user, String userPass) {
    Connection con = null;

    try {
      con = DriverManager.getConnection(dbPath, dbUser, dbPass);

      PreparedStatement ps = con.prepareStatement(
          "select USERID from LOGINUSER where USERNAME = ? and PASS = ? ;"
      );
      ps.setString(1, user);
      ps.setString(2, userPass);
      ResultSet rs1 = ps.executeQuery();
      if (!rs1.next()){
        return null;
      }
      return rs1.getInt("USERID");

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
    }
  }
}
