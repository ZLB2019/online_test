new Vue({
    el:"#PUB",
    data:{
        user_name:"",
        grade:[],
        user_id:""
    },
    created:function () {
    var that = this;
    if (sessionStorage.getItem("user_id")!==null)
    {
        var user_id = sessionStorage.getItem("user_id");
        that.user_id=user_id;
        axios.get('http://localhost:8080/online_test/main/user',{
            params:{
                user_id:user_id
            }
        }).then(function (response) {
             that.user_name=response.data.user_name;
            }).catch(function (error) {
        alert(error);
         });

        axios.get('http://localhost:8080/online_test/history_res/resList',{
            params:{
                user_id:user_id
            }
        }).then(function (response) {
                that.grade=response.data;
            }).catch(function (error) {
            alert(error);
        })
    }
}
});

