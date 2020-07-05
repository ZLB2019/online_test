var Pub = new Vue({
    el:"#PUB",
    data:{
        test_data:[],
        new_data:{},
        cnt:0,
        grade:0,
        error_title:[]
    },
    methods:{
        Options:function(x){
            switch(x) {
                case 0:
                    return "A";
                    break;
                case 1:
                    return "B";
                    break;
                case 2:
                    return "C";
                    break;
                case 3:
                    return "D";
                    break;
                case 4:
                    return "E";
                    break;
                case 5:
                    return "F";
                    break;
            }
        },
        TitleUnder:function () {
            if(this.cnt === this.test_data.length-1){
                alert("已经是最后一题了！")
            }  else{
                this.cnt++;
                this.new_data=this.test_data[this.cnt];
            }
            var obj=this.$refs.inputs;
            for (var i = 0;i<obj.length;i++){
                if (this.test_data[this.cnt].user_res===i)
                    obj[i].checked=true;
                else
                    obj[i].checked=false;
            }
        },
        TitleOn :function () {
            if(this.cnt === 0){
                alert("已经是第一题了！")
            }  else{
                this.cnt--;
                this.new_data=this.test_data[this.cnt];
            }
            var obj=this.$refs.inputs;
            for (var i = 0;i<obj.length;i++){
                if(this.test_data[this.cnt].user_res===i)
                    obj[i].checked=true;
                else
                    obj[i].checked=false;
            }
        },
        judgeAndCalculate: function (is_correct,index) {
            this.test_data[this.cnt].user_res=index;
            if (is_correct===1)
                this.test_data[this.cnt].res=true;
            else
                this.test_data[this.cnt].res=false;
            this.grade=0;
            for (var i=0;i<this.test_data.length;i++)
                if (this.test_data[i].res)
                    this.grade++;
        },
        Submit:function () {
            var that=this;
            var user_id = sessionStorage.getItem("user_id");
            axios.get('http://localhost:8080/online_test/test/submitGrade',{
                params:{
                    user_id:user_id,
                    res:that.grade*10
                }
            });
            var num=0;
            for (var i=0;i<that.test_data.length;i++) {
                if (!that.test_data[i].res){
                    axios.get('http://localhost:8080/online_test/test/errorTitle',{
                        params:{
                            title_id:that.test_data[i].title.title_id,
                            user_id:user_id
                        }
                    });
                }
            }

            window.location.href = '/online_test/res.html?result='+this.grade*10;
        }
    },
    computed:{
    },
    created:function () {
        var that = this;
        axios.get('http://localhost:8080/online_test/test/simulation')
            .then(function (response) {
            console.log(response.data);
            that.test_data=response.data;
            for (var i=0;i<that.test_data.length;i++){
                Pub.$set(that.test_data[i],"res",false);
                Pub.$set(that.test_data[i],"user_res",-1);
            }
            that.new_data=that.test_data[0];
            }).catch(function (error) {
            alert("错误"+error);
        });
    }
});