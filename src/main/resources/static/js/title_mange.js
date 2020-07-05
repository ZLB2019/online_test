new Vue({
    el:"#PUB",
    data:{
        title_list:[],
        res_list:[],
        new_title_id:0,
        title_information:{},
        delete_res_id:[],
        insert_res:[]
    },
    methods: {
        AllTitle: function () {
            that = this;
            axios.get('http://localhost:8080/online_test/manage/all_title')
                .then(function (response) {
                    that.title_list=response.data;
                }).catch(function (error) {
                alert(error);
            })
        },
        Return_Adm:function () {
            window.location.href='/online_test/administrator.html';
        },
        ClearResults_list:function () {
            this.res_list=[];
        }
        ,
        InsertTitle:function () {
            that = this;
            var title_name=that.$refs.insert_name.value;
            axios.get('http://localhost:8080/online_test/manage/insert_Title',{
                params:{
                    title_name:title_name
                }
            }).then(function (response) {
                that.new_title_id=response.data;
                alert("添加成功");
                 for (var i=0;i<that.res_list.length;i++){
                     var results_name = that.res_list[i].res;
                     var is_correct;
                     if (that.res_list[i].checked)
                         is_correct=1;
                     else
                         is_correct=0;
                    that.InsertResults(that.new_title_id,results_name,is_correct);
                 }
                that.AllTitle();
            }).catch(function (error) {
                alert(error);
            })
        },
        InsertResults:function (title_id,results_name,is_correct) {
            axios.get('http://localhost:8080/online_test/manage/insert_Results',{
                params:{
                    title_id:title_id,
                    results_name:results_name,
                    is_correct:is_correct
                }
            });
        }
        ,
        SelectTitle:function () {
            that = this;
            var title_id=this.$refs.select_id.value;
            axios.get('http://localhost:8080/online_test/manage/selectTitleById',{
                params:{
                    title_id:title_id
                }
            }).then(function (response) {
                if (response.data===null)
                    alert("未找到该用户！")
                else
                {
                    that.title_list=[];
                    that.title_list[0]=response.data;
                    console.log(that.title_list)
                }
            }).catch(function (error) {
                alert(error);
            })
        },
        RefreshRes_list:function (title_id) {
            var that=this;
            axios.get('http://localhost:8080/online_test/manage/selectResultsByTitle_id',{
                params:{
                    title_id:title_id
                }
            }).then(function (response) {
                that.res_list=response.data;
                for (var i=0;i<that.res_list.length;i++){
                    if ( that.res_list[i].is_correct===1)
                        that.res_list[i].is_correct=true;
                    else
                        that.res_list[i].is_correct=false;
                }
                console.log((that.res_list))
            }).catch(function (error) {
                alert(error);
            })
        }
        ,
        UpdateTitle:function (title_id,title_name) {
            this.$refs.update_id.innerHTML=title_id;
            this.$refs.update_name.value=title_name;
            this.RefreshRes_list(title_id);
            this.delete_res_id=[];
        },
        UpdateTitleSubmit:function () {
            that = this;
            var title_id = that.$refs.update_id.innerHTML;
            var title_name=that.$refs.update_name.value;
            var res=that.$refs.texts;
            axios.get('http://localhost:8080/online_test/manage/updateTitle',{
                params:{
                    title_id:title_id,
                    title_name:title_name
                }
            }).then(function (response) {
                console.log(that.res_list);
                for (var i=0;i<that.res_list.length;i++){
                    if (that.res_list[i].results_id===undefined){
                        break;
                    }
                    if (that.res_list[i].checked)
                        that.UpdateResults(title_id,res[i].value,1,that.res_list[i].results_id);
                    else
                        that.UpdateResults(title_id,res[i].value,0,that.res_list[i].results_id);
                }
                if (i<that.res_list.length)//编辑添加
                    for (;i<that.res_list.length;i++){
                        if (that.res_list[i].checked)
                            that.InsertResults(title_id,res[i].value,1);
                        else
                            that.InsertResults(title_id,res[i].value,0);
                    }
                for (i = 0;i<that.delete_res_id.length;i++)
                    that.DeleteResults(that.delete_res_id[i]);
                that.RefreshRes_list(title_id);
                that.AllTitle();
            }).catch(function (error) {
                alert(error);
            })
        },
        UpdateResults:function (title_id,results_name,is_correct,results_id) {
            axios.get('http://localhost:8080/online_test/manage/updateResults',{
                params:{
                    results_id:results_id,
                    title_id:title_id,
                    results_name:results_name,
                    is_correct:is_correct
                }
            })
        },
        RecordDeleteResults:function (index,results_id) {
            this.delete_res_id[this.delete_res_id.length]=results_id;
            this.res_list.splice(index,1);
        }
        ,
        DeleteResults:function (results_id) {
            axios.get('http://localhost:8080/online_test/manage/deleteResultsByResults_id',{
                params:{
                    results_id:results_id
                }
            })
        }
        ,
        DeleteTitle:function (index) {
            this.$refs.delete_id.innerHTML=this.title_list[index].title_id;
        },
        DeleteTitleSubmit:function () {
            that = this;
            var title_id = this.$refs.delete_id.innerHTML;
            axios.get('http://localhost:8080/online_test/manage/delete_Title',{
                params:{
                    title_id:title_id
                }
            }).then(function (response) {
                that.DeleteResultsByTitle_id(title_id);
                alert("删除成功！");
            }).catch(function (error) {
                alert(error);
            })
        },
        DeleteResultsByTitle_id:function (title_id) {
            var that = this;
            axios.get('http://localhost:8080/online_test/manage/delete_Results',{
                params:{
                    title_id:title_id
                }
            }).then(function (response) {
                that.AllTitle();
            }).catch(function (error) {
                alert(error);
            })
        }
        ,
        InsertRes_list:function () {
            this.res_list.push({res:"",checked:false});
        },
        is_correct_insert:function (index) {
            var obj=this.$refs.inputs;
            for (var i = 0;i<this.res_list.length;i++) {
                this.res_list[i].checked=obj[i].checked;
            }
        },
        is_correct_update:function (index) {
            var obj2=this.$refs.updates;
            for (var i = 0;i<this.res_list.length;i++) {
                this.res_list[i].checked=obj2[i].checked;
            }
            console.log(this.res_list);
        }
    }
});