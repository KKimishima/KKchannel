import jQuery from "jquery";
import "bootstrap"
import "popper.js"

import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "./common.css"

const $ = jQuery;


$(document).ready((() => {
  $('#edit').on('show.bs.modal', function (event) {
    // 警告を表示するinnerHTMLを初期化
    document.getElementById("edit-result").innerHTML = " "

    // ボタンのイベントからpostIDを抽出
    const buttun = $(event.relatedTarget)
    const post_data = buttun.attr("data-postid")

    // postIDkからタイトルとメッセージを取得
    const post_title = $(`#post-data-${post_data}`).find(".post-title h5").text()
    const post_massage = $(`#post-data-${post_data}`).find(".post-message p").text()

    // モーダルのinputにタイトルとメッセージを入れ込む
    $(this).find(".edit-title").val(post_title)
    $(this).find('.edit-massege').val(post_massage)

    // モーダルの送信ボタンのを押した時イベント
    $(this).find(".edit-post").on("click", () => {
      // ボタンを押した際のモーダルに入力したしたタイトルとメッセージ
      const edit_title = $(this).find(".edit-title").val()
      const edit_massage = $(this).find('.edit-massege').val()

      // モーダルの変更がなかった時
      if (post_title === edit_title && post_massage === edit_massage) {
        document.getElementById("edit-result").innerHTML = `
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
        </button>
        変更がありません
        </div>
        `
        return
      }

      // サーバ送信
      $.ajax({
        url: "hoge",
        type: "POST",
        data: {
          "postid": post_data,
          "title": edit_title,
          "massage": edit_massage
        }
      })
        // 送信成功
        .done((data) => {
          console.log("成功")
        })
        // 送信失敗
        .fail((data) => {
          document.getElementById("edit-result").innerHTML = `
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
          </button>
          サーバ接続エラー
          </div>
          `
          console.log("失敗")
        })
        // 必ず最後に実行される
        .always((data) => {
          return
        })
    })
  })
}))
