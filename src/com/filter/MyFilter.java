package com.filter;  
  
import java.io.IOException;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class MyFilter implements Filter {  //implements表示实现接口
  
    public MyFilter() {  
        // TODO Auto-generated constructor stub  
    }  
  
    @Override  
    public void destroy() {  
        // TODO Auto-generated method stub  
  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain filterChain) throws IOException, ServletException {  
        // 过滤用户请求，判断是否登录  
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;  //强制转换
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;  
          
        httpServletRequest.setCharacterEncoding("utf-8");  
        httpServletResponse.setCharacterEncoding("utf-8");  
          
        String username = (String)httpServletRequest.getSession().getAttribute("username");  
          
        if (username == null) {  
            String path = httpServletRequest.getContextPath();  //getContextPath()返回当前页面所在的应用的名字
            httpServletResponse.sendRedirect(path+"/index.jsp");  //跳转到首页
        }         
        filterChain.doFilter(httpServletRequest, httpServletResponse);  //跳转到下个页面
    }  
  
    @Override  
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
  
    }  
  
}  