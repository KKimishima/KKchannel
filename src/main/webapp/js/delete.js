let del = () => {
  document.addEventListener("DOMContentLoaded", () => {
    const del = document.getElementsByClassName("del-btn")
    for (const i of del) {
      i.addEventListener("click", function () {
        const postID = this.getAttribute("data-postID")

        let xhr = new XMLHttpRequest

        xhr.addEventListener("error", () => {
          $("body").overhang({
            type: "warn", // success, error, info, warnの四種類
            message: "サーバ接続失敗", // 表示されるメッセージ
            duration: 5,
            closeConfirm: true // このオプションを指定するとcloseボタンが表示されます
          });
        })

        xhr.addEventListener("load", () => {
          if (xhr.responseText === "true") {
            $("body").overhang({
              type: "success", // success, error, info, warnの四種類
              message: "削除成功", // 表示されるメッセージ
              duration: 5,
              closeConfirm: true // このオプションを指定するとcloseボタンが表示されます
            })

            setTimeout(() => {
              location.href = "/KKchannel/Main";
            }, 1500)

          } else {
            $("body").overhang({
              type: "error", // success, error, info, warnの四種類
              message: "削除失敗!!!管理者に連絡してください", // 表示されるメッセージ
              duration: 5,
              closeConfirm: true // このオプションを指定するとcloseボタンが表示されます
            })
          }
        })

        xhr.open("GET", "/KKchannel/Main/Delete?postID="
          + encodeURIComponent(postID)
        )
        xhr.send(null)
      })
    }
  })
}
del()



