$(function () {
    $('#user_id').text(sessionStorage.getItem("user_id"));
    $('#exitAdm').click(function () {
        window.location.href="/online_test/login.html";
    })
});