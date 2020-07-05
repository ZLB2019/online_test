new Vue({
    el:"#PUB",
    data:{
        user_list:[]
    },
    methods: {
        AllUser: function () {
            that = this;
            axios.get('http://localhost:8080/online_test/manage/all_user')
                .then(function (response) {
                    that.user_list=response.data;
                }).catch(function (error) {
                alert(error);
            })
        },
        Return_Adm:function () {
            window.location.href='/online_test/administrator.html';
        },
        InsertUser:function () {
            that = this;
            var user_id=this.$refs.insert_id.value;
            var user_password = this.$refs.insert_password.value;
            var user_name = this.$refs.insert_name.value;
            axios.get('http://localhost:8080/online_test/manage/insert_user',{
                params:{
                    user_id:user_id,
                    user_password:user_password,
                    user_name:user_name
                }
            }).then(function (response) {
                    if (response.data===0)
                        alert("用户id冲突，添加失败！")
                else
                    alert("添加成功");
                that.AllUser();
                }).catch(function (error) {
                alert(error);
            })
        },
        SelectUser:function () {
            that = this;
            var user_id=this.$refs.select_id.value;
            axios.get('http://localhost:8080/online_test/manage/selectUserById',{
                params:{
                    user_id:user_id
                }
            }).then(function (response) {
                if (response.data===null)
                    alert("未找到该用户！")
                else
                {
                    that.user_list=[];
                    that.user_list[0]=response.data;
                    console.log(that.user_list)
                }
            }).catch(function (error) {
                alert(error);
            })
        },
        UpdateUser:function (index) {
            this.$refs.update_id.innerHTML=that.user_list[index].user_id;
        },
        UpdateUserSubmit:function () {
            that = this;
            var user_id = this.$refs.update_id.innerHTML;
            var user_password = this.$refs.update_password.value;
            var user_name = this.$refs.update_name.value;
            axios.get('http://localhost:8080/online_test/manage/UpdateUser',{
                params:{
                    user_id:user_id,
                    user_password:user_password,
                    user_name:user_name
                }
            }).then(function (response) {
                alert("更改成功！");
                that.AllUser();
            }).catch(function (error) {
                alert(error);
            })
        },
        DeleteUser:function (index) {
            this.$refs.delete_id.innerHTML=this.user_list[index].user_id;
        },
        DeleteUserSubmit:function () {
            that = this;
            var user_id = this.$refs.delete_id.innerHTML;
            axios.get('http://localhost:8080/online_test/manage/DeleteUser',{
                params:{
                    user_id:user_id
                }
            }).then(function (response) {
                alert("删除成功！");
                that.AllUser();
            }).catch(function (error) {
                alert(error);
            })
        }
    }
});