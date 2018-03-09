<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>login</title>
   <link href="dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="dist/jquery-2.1.1/jquery.min.js"></script>
   <script src="dist/js/bootstrap.min.js"></script>
   <style type="text/css">
    body{
        background-image:url("image/login.jpg");
        background-repeat:no-repeat;
        background-position:center;
    }

    #login{
        width:200px;
        margin-top: 280px;
        margin-left: 760px;
    }

    .input-group-addon{
        width:40px;
        background:url('image/smallpic.jpg');
        background-size:451px 258px;

    }

    #username{
        background-position:-360px -58px;
    }
    #password{
        background-position:-186px -58px;
    }
    #loginbtn{
        width:120px;
        margin-left:40px;
    }


   </style>


</head>
   <body>
      <div id="login">
          <form class="bs-example bs-example-form" role="form">
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
      </div>



   </body>

   <script type="text/javascript">
        function login(){
            var username=$("#username1").val();
            var password=$("#password1").val();
            alert(username);
        }


   </script>

   </html>

