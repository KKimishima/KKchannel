<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- boostrapリンク -->
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <link rel="stylesheet" href="./css/common.css">

  <script src="./js/bootstrap.min.js"></script>
  <script src="./js/jquery-3.3.1.min.js"></script>
  <script src="./js/popper.min.js"></script>
  <title>KKchannel</title>
</head>

<body>

  <header>
    <div class="row">
      <div class="col-12">
        <nav class="navbar navbar-toggleable-md navbar-inverse bg-primary navbar-fixed-top">
          <a class=" navbar-brand " href="# ">KKchannel</a>
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="# ">掲示板</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="# ">連絡先</a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <span class="navbar-text"> xxさん</span>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="#">ログアウト</a>
              <li class="nav-item active">
                <a class="nav-link" href="#">ログイン</a>
              </li>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </header>

  <div class="container">
    <div class="jumbotron">
      <h1 class="display-3">KKchannelにようこそ!!</h1>
      <p class="lead">
        このサイト作者KKimishimaのwebアプリケーションの理解のために作られた掲示板です
        <br>デモなので過大な期待をしないでください
      </p>
      <hr class="my-4">
      <p>下記のボタンをクリックしてログインしてください</p>
      <p class="lead">
        <a class="btn btn-primary" href="#"> ログイン</a>
        <a class="btn btn-primary" href="#"> 掲示板へ</a>
      </p>
    </div>
  </div>

  <!-- フッタ -->

  <footer class="footer">
    <div class="container">

      <span class="text-muted">COPYRIGHT &#169; KKimishima.github.com ALL RIGHTS RESERVED. </span>
    </div>

  </footer>

</body>

<
