<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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
<c:import url="footer.jsp" />

</body>

