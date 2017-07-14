<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
Map<String,Object> map = (Map<String,Object>)request.getAttribute("productMap");  
  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>查看产品</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
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
#nav {
    line-height:25px;
    height:50px;
    width:50px;
    float:right;
    padding:5px;
    font-size:15px;
</style> 
  </head>  
    
  <body>  
   <div id="header">  
        <h3> 产品信息</h3>
   </div>
    <div id="nav">  
         <button type="button" onclick="javascript:history.go(-1)">返回</button>  
   </div> 
     <br><br>
  <div align="center">  
          
        <table width=70%">  
              
 
            <tr>  
                <td>  
                    <table width = 99% border =1 >  
                       
                        <tr align="center">  
 				<td colspan=2 width = 20%><img src="<%=path%>/upload/<%=map.get("proimage") %>"></td>                           
                        	  
                        </tr>  
                      
                      
                    </table>  
                </td>  
            </tr>  
           
          
        </table>  
          
      
  </div>  
  </body>  
</html>  