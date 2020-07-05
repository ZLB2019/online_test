$(function () {
    var query = window.location.search.substring(1);
    var res = query.split("=")[1];
    console.log(res);
    $('span').text(res);
    $('button').click(function (){
        window.location.href = '/online_test/main.html';
    })
});