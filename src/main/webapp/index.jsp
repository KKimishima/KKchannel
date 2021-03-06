<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">

<c:import url="WEB-INF/jsp/head.jsp" />

<body>

<c:import url="WEB-INF/jsp/header.jsp" />


<main>
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
        <c:if test="${empty loginUser}" >
        <a class="btn btn-primary" href="/KKchannel/Login"> ログイン</a>
        </c:if>
        <c:if test="${not empty loginUser}" >
        <a class="btn btn-primary" href="/KKchannel/Main"> 掲示板へ</a>
        </c:if>
      </p>
    </div>
  </div>
</main>

<c:import url="WEB-INF/jsp/footer.jsp" />

</body>


