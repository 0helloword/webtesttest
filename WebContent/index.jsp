<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>Welcome</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
          
<script type="text/javascript">  
function login(){  
    var th = document.form1;  
    if(th.username.value==""){  
        alert("用户名不能为空！");  
        th.username.focus();  
        return;  
    }  
    if(th.pswd.value==""){  
        alert("密码不能为空！");  
        th.pswd.focus();  
        return;  
    }  
      
    th.action = "<%=path%>/servlet/LoginAction";  
    th.submit();  
  
  
}  
  
</script>  
      
  </head>  
    
  <body style="background: #ecf0f5;">  
    
   <div style="text-align:center">     
   <form name="form1" action="" method="post">  
   <div>
   <img src="<%=path%>/images/login.jpg" alt="" style="height: 30px;width: 30px;margin-top:60px;">
   <h1 style="color: #2b425b;font-size: 16px;margin-bottom: 5px;">管理中心欢迎您</h1>
   </div>
	<br><br>
   <table  style="margin:auto"  width=25% align="center">     

    <tr>  
        <td>用户：</td>  
        <td><input type="text" name="username"></input></td>          
    </tr> 

    <tr>  
        <td>密码：</td>  
        <td><input type="password" name="pswd"></input></td>          
    </tr>  
   </table>  
   <br>
   <div style="text-align:center">
        <button type="button" name="" value="" onclick="login()" >登录</button>  
        <button type="button" name="" value="" onclick="javascript:location.href='register.jsp'">注册</button>  
   </div>
   </form>  
  </div>  
        
  </body>  
</html>  