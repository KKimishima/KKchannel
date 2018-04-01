<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">

<c:import url="head.jsp" />

<body>

    <script>
        function checkForm() {
            if (document.post_form.title.value == ""|| document.post_form.body.value == "") {
                alert("タイトルか登録内容が空です\n内容を入力してください");
                return false;
            } else {
                return true;
            }
        }
    </script>

<c:import url="header.jsp" />
  <main>

    <div class="container">
      <!-- 説明 -->
      <div class="jumbotron">
        <h1 class="display-6">投稿内容が表示されます</h1>
        <hr class="my-6">
        <p class="lead">
          気軽に書き込みんでみてください
        </p>
      </div>

    <c:forEach var="obj" items="${list}" varStatus="status">
      <!-- 投稿内容 -->
      <div class="card my-4" id="post-data-<c:out value="${obj.postID}"/>">
        <div class="card-header  bg-info  card-post">
          <ul class="list-inline post-id">
            <li class="list-inline-item">
              <h5><c:out value="${obj.postID}"/></h5>
            </li>
            <li class="list-inline-item post-name">
                <h5><c:out value="${obj.userName}"/>さん</h5>
            <li class="list-inline-item post-title">
              <h5><c:out value="${obj.title}"/></h5>
            </li>
            <li class="list-inline-item post-date">
              <h5><c:out value="${obj.date}"/></h5>
            </li>
            <li class="list-inline-item post-time">
              <h5><c:out value="${obj.time}"/></h5>
            </li>
          </ul>
        </div>
        <div class="card-block post-message">
          <p class="card-text"><c:out value="${obj.text}"/></p>

          <div class="text-right">

            <button type="button" class="btn btn-warning" data-toggle="modal" data-postid="1" data-target="#edit">編集</button>

          <jsp:element name="button" >
          <jsp:attribute name="class">del-btn btn btn-danger</jsp:attribute>
          <jsp:attribute name="data-postID">
            <c:out value="${obj.postID}"/>
          </jsp:attribute>
          <jsp:body>削除</jsp:body>
          </jsp:element>
        </div>

        </div>
      </div>
    </c:forEach>

      <%-- 編集ダイアログ--%>
      <div class="modal fade" id="edit" data-postid="94" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">編集</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div id="edit-result"></div>
              <form>
                <div class="form-group">
                  <label for="recipient-name">タイトル：</label>
                  <input type="text" class="form-control edit-title">
                </div>
                <div class="form-group">
                  <label for="message-text">メッセージ：</label>
                  <textarea class="form-control edit-massege"></textarea>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
              <button type="button" class="btn btn-primary edit-post">送信</button>
            </div>
          </div>
        </div>
      </div>

      <!-- 投稿フォーム -->
      <div class="card">
        <div class="card-header card-inverse bg-primary ">
          <h4>投稿フォーム</h4>
        </div>
        <div class="card-body">
          <p class="card-text">
            <form action="/KKchannel/Main" method="post" name="post_form">
              <div class="form-group">
                <label for="UserName" class="form-cotntrol">タイトル</label>
                <input type="text" name="title" id="title" class="form-control">
              </div>
              <div class="form-group">
                <label for="body" class="form-label">
                  登録内容
                </label>
                <textarea name="body" id="text" cols="30" rows="10" placeholder="投稿内容" class="form-control"></textarea>
                <p class="help-block">10000文字まで入力できます</p>
              </div>
              <button type="submit" class="btn btn-primary" onclick="return checkForm()">投稿</button>
              <button type="reset" class="btn btn-danger">リセット</button>
            </form>
          </p>
        </div>
      </div>
    </div>
  </main>

  <c:import url="footer.jsp" />

  </body>