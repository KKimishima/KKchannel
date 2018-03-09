package com.github.KKimishima.model.DAO;

import com.github.KKimishima.model.beans.Contents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContentsDAO {
  private final String dbUser = "sa";
  private final String dbPass = "";
  private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";
  private List<Contents> list = new ArrayList<>();

  public List<Contents> execute(){
    Connection con = null;

    try{
      con = DriverManager.getConnection(dbPath,dbUser,dbPass);

      StringBuilder sb = new StringBuilder();
      sb.append("SELECT POSTID,TITLE,TEXT,POSTDATE,POSTTIME,USERNAME ");
      sb.append("FROM CONTENTS ");
      sb.append("INNER JOIN LOGINUSER ");
      sb.append("ON  LOGINUSER.USERID = CONTENTS.USERID");
      PreparedStatement ps = con.prepareStatement(
          sb.toString()
      );
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
        Contents contents = new Contents(
            rs.getInt("POSTID"),
            rs.getString("TITLE"),
            rs.getString("TEXT"),
            rs.getDate("POSTDATE"),
            rs.getTime("POSTTIME"),
            rs.getString("USERNAME")
        );
        list.add(contents);
      }
      rs.close();

      return list;
    }catch (SQLException e){
      e.printStackTrace();
      return null;
    }finally {
      try {
        if (con != null){
          con.close();
        }
    }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
    }
  }
}
