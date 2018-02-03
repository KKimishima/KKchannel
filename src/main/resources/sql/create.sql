-- KKchannel関係地盤
-- ログインユーザテーブル
/*
    テーブル名
        LoginUser
    テーブル構造
        UserID      int             自動連番    not null   主キー
        UserName    varchar(255)                not null
        pass        varchar(8)                  not null
*/
CREATE TABLE LOGINUSER(
    USERID      int Identity(1,1)   not null    primary key,
    USERNAME    varchar(255)        not null,
    PASS        varchar(8)          not null
);

insert into LOGINUSER(USERNAME,PASS) values ('admin','admin');

-- 投稿内容
/*
    テーブル名
       Contents
    テーブル構造
        PostID      int             自動連番    not null   主キー
        Text        varchar(255)                not null
        PostTime        varchar(8)              not null
        UserID      int                         not null 外部キー
*/

CREATE TABLE CONTENTS(
    POSTID  int Identity(1,1)   not null    primary key,
    TEXT    varchar(255)        not null,
    POSTDATE DATE      not null,
    POSTTIME TIME       not null,
    USERID  int                 not null,
    foreign key(USERID) references LOGINUSER(USERID)
);

insert into CONTENTS(TEXT,POSTDATE,POSTTIME,USERID) values('こんにちわ',CURRENT_DATE(),CURRENT_TIME(),1);