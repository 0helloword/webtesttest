<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>新增产品</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
<script type="text/javascript">  
function dosubmit(){  
    var th = document.form1;  
    th.action="<%= path%>/servlet/ProductAction?action_flag=add";  
    th.submit();  
  
}  
  
</script> 
 <style>
#header {
    background-color:#5b9bd1;
    color:white;
    text-align:center;
    padding:5px;
} 
#content {
	font-size:2;
    text-align:center;
    padding:10px;
    font-family:courier;
    cellpadding:50;
}
</style>
  </head>  
    
  <body>  
  <div id="header">  
        <h3> 产品信息添加</h3>
   </div>  <br><br>
    <div id="content" >  
                    <form id="form1" name="form1" action="" method="post" enctype="multipart/form-data">  
                    <table border=0 width=100%>  
                        <tr >  
                            <td align="right">产品名称：</td>  
                            <td align="left"><input type="text" name="proname" id="proname"/></td> 
                        </tr>
                        <tr>
                            <td align="right">产品价格：</td>  
                            <td align="left"><input type="text" name="proprice" id="proprice"/></td>  
                        </tr>  
                        <tr>  
                            <td align="right">产品产地：</td>  
                            <td align="left"><input type="text" name="proaddress" id="proaddress"/></td>  
                        </tr>  
                        <tr>  
                            <td align="right">产品图片：</td>  
                            <td align="left"><input type="file" name="proimage" id="proimage"  size=35/></td>  
                        </tr>                                     
                  
       <tr>
                <td colspan="2" align="center">  
                    <button type="button" onclick="javascript:dosubmit();">确定</button>  
                    <button type="button" onclick="javascript:location.href='main.jsp'">返回</button>  
                  
                </td>  
                </tr>
       
          
        </table>  
           </form>  
    </div>  
  </body>  
</html>  