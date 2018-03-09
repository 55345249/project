<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>Bootstrap 实例 - 基本的表格</title>
   <link href="dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="dist/jquery-2.1.1/jquery.min.js"></script>
   <script src="dist/js/bootstrap.min.js"></script>
</head>
   <body style="padding:30px">>

   <nav class="navbar navbar-inverse" role="navigation">
       <div class="container-fluid">
       <div class="navbar-header">
           <a class="navbar-brand" href="#">菜鸟教程</a>
       </div>
       <div>
           <ul class="nav navbar-nav">
               <li class="active"><a href="#">iOS</a></li>
               <li><a href="#">SVN</a></li>
               <li class="dropdown">
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                       Java <b class="caret"></b>
                   </a>
                   <ul class="dropdown-menu">
                       <li><a href="#">jmeter</a></li>
                       <li><a href="#">EJB</a></li>
                       <li><a href="#">Jasper Report</a></li>
                       <li class="divider"></li>
                       <li><a href="#">分离的链接</a></li>
                       <li class="divider"></li>
                       <li><a href="#">另一个分离的链接</a></li>
                   </ul>
               </li>
           </ul>
       </div>
       </div>
   </nav>

      <table class="table">
      <caption>基本的表格布局</caption>
      <thead>
         <tr>
            <th>名称</th>
            <th>城市</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td>Tanmay</td>
            <td>Bangalore</td>
         </tr>
         <tr>
            <td>Sachin</td>
            <td>Mumbai</td>
         </tr>
      </tbody>
      </table>

   </body>
   </html>

