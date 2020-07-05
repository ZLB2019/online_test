var top =new Vue({
    el:"#title_top",
    data:{
        user_name:"",
        type:"登录",
        user_name_css:"margin-top: 9px;margin-right:30px;font-size: 20px;display:none;"
    },
    created:function () {
        var that = this;
        if (sessionStorage.getItem("user_id")!==null)
        {
            that.user_name_css="margin-top: 9px;margin-right:30px;font-size: 20px;";
            that.type="退出登录";
            var user_id = sessionStorage.getItem("user_id");
            axios.get('http://localhost:8080/online_test/main/user',{
                params:{
                    user_id:user_id
                }
            })
                .then(function (response) {
                    that.user_name=response.data.user_name;
                }).catch(function (error) {
                alert(error);
            })
        }
    }
});

var top =new Vue({
    el:"#PUB",
    methods: {
        SimulationTest: function () {
            window.location.href = '/online_test/test.html';
        },
        TestResults:function () {
            window.location.href = '/online_test/history_res.html';
        },
        WrongTitle:function () {
            window.location.href = '/online_test/wrong_topic.html';
        }
    }
});