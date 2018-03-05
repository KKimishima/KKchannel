<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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

          <c:if test="${not empty loginUser}" >
            <li class="nav-item active">
              <span class="navbar-text"> <c:out value="${loginUser.user}" />さん</span>
            </li>
           </c:if>

            <li class="nav-item active">

                <c:if test="${not empty loginUser}" >
                <a class="nav-link" href="/KKchannel/LogOff">ログアウト</a>
                </c:if>

              <li class="nav-item active">
                <c:if test="${empty loginUser}" >
                <a class="nav-link" href="/KKchannel/Login">ログイン</a>
                </c:if>
              </li>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </header>