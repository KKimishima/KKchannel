package com.github.KKimishima.model;

import java.sql.*;

public class InitDAO {
 private final String dbPath = "jdbc:h2:file:~/.KKchannel/db/db";
 private final String dbUser = "sa";
 private final String dbPass = "";
 public void initTable(){
  Connection con =null;

  try {
   con = DriverManager.getConnection(dbPath, dbUser, dbPass);
   con.setAutoCommit(false);

   // ログインユーザ作製
   PreparedStatement loginTB = con.prepareStatement(
       "CREATE TABLE  IF NOT EXISTS  LOGINUSER(\n" +
           "    USERID      int Identity(1,1)   not null    primary key,\n" +
           "    USERNAME    varchar(255)        not null,\n" +
           "    PASS        varchar(8)          not null\n" +
           ");"
   );
   loginTB.execute();
   loginTB.close();

   // ユーザテーブルが空なら空なら管理者アカウント作製
   PreparedStatement loginFN = con.prepareStatement(
       "select USERNAME from LOGINUSER where USERNAME = ?"
   );
   loginFN.setString(1,"admin");
   ResultSet loginFNRS = loginFN.executeQuery();
   if (!loginFNRS.next()){
    PreparedStatement intoSet = con.prepareStatement(
        "insert into LOGINUSER(USERNAME,PASS) values ('admin','admin');"
    );
    intoSet.execute();
   }

//    コンテツ用DB作製
   PreparedStatement contetsTB = con.prepareStatement(
       "CREATE TABLE IF NOT EXISTS  CONTENTS(\n" +
           "    POSTID  int Identity(1,1)   not null    primary key,\n" +
           "    TEXT    varchar(255)        not null,\n" +
           "    POSTDATE DATE      not null,\n" +
           "    POSTTIME TIME       not null,\n" +
           "    USERID  int                 not null,\n" +
           "    foreign key(USERID) references LOGINUSER(USERID)\n" +
           ");"
   );
   contetsTB.execute();
   contetsTB.close();

//    コンテツテーブルが空ならサンプル投稿追加
   PreparedStatement contentsFN = con.prepareStatement(
       "select * from CONTENTS;"
   );
   ResultSet contetusFNRS = contentsFN.executeQuery();
   if (!contetusFNRS.next()){
    PreparedStatement setDB = con.prepareStatement(
        "insert into CONTENTS(TEXT,POSTDATE,POSTTIME,USERID) values('こんにちわ',CURRENT_DATE(),CURRENT_TIME(),1);"
    );
    setDB.execute();
   }

   con.commit();
  }catch (SQLException e){
   try{
    e.printStackTrace();
    con.rollback();
   }catch (SQLException e2){
    e2.printStackTrace();
   }
  }finally {
   try{
    if(con != null){
     con.close();
    }
   }catch (SQLException e){
    e.printStackTrace();
   }
  }
 }
}
