package com.login;  
  
import java.util.List;  
  
public interface LoginService {  //在接口(interface)中，所有的方法必须都是抽象的，不能有方法体
  
    public boolean login(List<Object> params);  
}  