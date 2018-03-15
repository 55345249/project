<html>
<head>

   <title>login</title>
   <link href="dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="dist/jquery-2.1.1/jquery.min.js"></script>
   <script src="dist/js/bootstrap.min.js"></script>
   <style type="text/css">
    body{
        background-image:url("image/login.jpg");
        background-repeat:no-repeat;
        background-position:center;
        margin-top: 320px;
    }

    #login{
        width:200px;
        margin-left: 830px;

    }

    .input-group-addon{
        width:40px;
        background-image:url("image/smallpic.jpg");
        background-size:388px 231px;
    }
    #username{

    }
    #password{
        background-position:162px 55px;
    }


    #loginbtn{
        width:120px;
        margin-left:50px;
    }
    #forget{
        font-size:20px;
        margin-left:-30px;
        color:grey;
    }
    #register{
        font-size:20px;
        color:grey;
    }



   </style>


</head>
   <body>
      <div id="login">
          <form id="loginform" class="bs-example bs-example-form" role="form">
              <div class="input-group">
                  <span id="username" class="input-group-addon" ></span>
                  <input id="username1" type="text" class="form-control" placeholder="username">
              </div>
              </br>
              <div class="input-group">
                  <span id="password" class="input-group-addon"></span>
                  <input id="password1" type="password" class="form-control" placeholder="password">
              </div>
              </br>
              <input id="loginbtn" class="btn btn-default" type="button" value="login" onclick="login()">
          </form>
          </br></br>
          <div>
          <a id="forget">forget password</a>&nbsp;|&nbsp;
          <a id="register">register</a>
          </div>

      </div>



   </body>

   <script type="text/javascript">
        function login(){
            var username=$("#username1").val();
            var password=$("#password1").val();


            var data=$('#loginform').serialize();
            //序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20

            var submitData=decodeURIComponent(data,true);
            //submitData是解码后的表单数据，结果同上

            $.ajax({
                url:'',
                data:submitData,
                cache:false,//false是不缓存，true为缓存
                async:true,//true为异步，false为同步
                beforeSend:function(){
                    //请求前
                    alert(data)
                },
                success:function(result){
                    //请求成功时
                    alert(submitData)
                },
                complete:function(){
                    //请求结束时
                    alert(submitData)
                },
                error:function(){
                    //请求失败时
                    alert(submitData)
                }
            })
        }



   </script>

   </html>

