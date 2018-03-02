<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<c:import url="head.jsp" />

<body>

<c:import url="header.jsp" />
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
            <div class="alert alert-danger" role="alert">
              <strong>ログイン失敗</strong>
              <br> ユーザ名かパスワードが間違っています
              <br>再度入力してください
            </div>
            <form action="/login" method="post">
              <div class="form-group">
                <label for="UserName">ログイン名</label>
                <input type="text" name="user" id="user" class="form-control">
              </div>
              <div class="form-group">
                <label for="Pass">パスワード</label>
                <input type="password" name="pass" id="pass" class="form-control">
              </div>
              <button type="submit" class="btn btn-primary">ログイン</button>
            </form>
          </div>
        </div>
      </div>
    </div>
<c:import url="footer.jsp" />

</body>

