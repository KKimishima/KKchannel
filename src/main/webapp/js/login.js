let login = (ID_user, ID_pass, ID_result) => {
  document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("login-btn").addEventListener("click", () => {
      const user = document.getElementById("user").value
      const pass = document.getElementById("pass").value
      const re = document.getElementById(ID_result)
      let xhr = new XMLHttpRequest();

      xhr.addEventListener("loadstart", () => {
        re.innerHTML = `
        <div class="alert alert alert-info" role="alert">
        <strong>通信中</strong>
        <br> 認証作業を行っています
        </div>
        `
      }, false)

      xhr.addEventListener("error", () => {
        re.innerHTML = `
        <div class="alert alert-danger" role="alert">
        <strong>サーバーエラー</strong>
        <br> サーバーの認証機能が停止しています
        <br>　管理者に連絡したください
        </div>
        `
      }, false)

      xhr.addEventListener("load", () => {
        const data = JSON.parse(xhr.responseText)
        if (data[0].loginCheck === "true") {
          location.href = "/KKchannel/Main";
        } else {
          re.innerHTML = `
          <div class="alert alert-danger" role="alert">
          <strong>ログイン失敗</strong>
          <br> ユーザ名かパスワードが間違っています
          <br>再度入力してください
          </div>
          `
        }
      }, false)

      xhr.open("GET", "/KKchannel/LoginApi?user="
        + encodeURIComponent(user)
        + "&pass="
        + encodeURIComponent(pass))
      xhr.send(null)
    }, false)
  }, false)
}


login("user", "pass", "error_msg")
