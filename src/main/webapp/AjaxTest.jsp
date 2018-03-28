<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <script src="./js/bootstrap.min.js"></script>
  <script src="./js/jquery-3.3.1.min.js"></script>
  <script src="./js/popper.min.js"></script>
  <script src="./js/login.js"></script>
  <!-- boostrapリンク -->
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <link rel="stylesheet" href="./css/common.css">


  <title>KKchannel</title>
</head>

<body>
  <header>
    <div class="row">
      <div class="col-12">
        <nav class="navbar navbar-toggleable-md navbar-inverse bg-primary navbar-fixed-top">
          <a class=" navbar-brand " href="/KKchannel">KKchannel</a>
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="/KKchannel/Main">掲示板</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="# ">連絡先</a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">

            <c:if test="${not empty loginUser}">
              <li class="nav-item active">
                <span class="navbar-text">
                  <c:out value="${loginUser.user}" />さん</span>
              </li>
            </c:if>

            <li class="nav-item active">

              <c:if test="${not empty loginUser}">
                <a class="nav-link" href="/KKchannel/LogOff">ログアウト</a>
              </c:if>

              <li class="nav-item active">
                <c:if test="${empty loginUser}">
                  <a class="nav-link" href="/KKchannel/Login">ログイン</a>
                </c:if>
              </li>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </header>

  <main>

    <!-- ログインフォーム -->
    <div class="container">
      <div class="mx-auto login-window">
        <div class="card">
          <div class="card-header card-primary card-inverse">
            <h1>KKchannelへログイン</h1>
          </div>
          <div class="card-block">
            <p class="card-text">
              事前に申請したアカウントでロクグインしてください
            </p>

            <div id="error_msg">
            </div>
              
            <form>
              <div class="form-group">
                <label for="UserName">ログイン名</label>
                <input type="text" name="user" id="user" class="form-control">
              </div>
              <div class="form-group">
                <label for="Pass">パスワード</label>
                <input type="password" name="pass" id="pass" class="form-control">
              </div>
              <input type="button" id="login-btn" value="ログイン" class="btn btn-primary">
            </form>
          </div>
        </div>
      </div>
    </div>
  </main>

  <footer class="footer">
    <div class="container">
      <span class="text-muted">COPYRIGHT &#169; KKimishima.github.com ALL RIGHTS RESERVED. </span>
    </div>
  </footer>
</body>

</html>