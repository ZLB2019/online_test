var login = new Vue({
    el:"#login_con",
    data:{
        user_id:"",
        user_password:""
    },
    methods:{
        InputJudge:function(){
            if (isNaN(this.user_id)||this.user_id ===""||this.user_id===null||this.user_password ===""||this.user_password===null){
                alert("你的输入有误或不完整，请重新输入！");
            }else{
                this.loginJudge();
            }
        },
        loginJudge:function () {
            var that = this;
            axios.get('http://localhost:8080/online_test/login/judge',{
                params:{
                    user_id:that.user_id,
                    user_password:that.user_password
                }
            }).then(function (response) {
                if (response.data===1) {
                    sessionStorage.setItem("user_id",that.user_id);
                    window.location.href='/online_test/main.html';
                }
                else if (response.data===2) {
                        sessionStorage.setItem("user_id",that.user_id);
                        window.location.href='/online_test/administrator.html';
                       }else{
                        alert("账号或者密码错误！");
                        that.user_password="";
                    }
            }).catch(function (error) {
                    alert("错误"+error);
                });
        }
    },
    created:function () {
        if (sessionStorage.getItem("user_id")!==null) {
            sessionStorage.removeItem("user_id");
        }
    }
});