package com.util;  
  
import java.util.UUID;  
  
public class UUIDTools {  
  
    public UUIDTools() {  
        // TODO Auto-generated constructor stub  
    }  
      
    /**返回一个 6位的字符串 
     * 实现为数据库获取一个唯一的主键id的代码
     * @return 
     */  
    public static String getUUID(){  
          
        UUID uuid = UUID.randomUUID();  
        return uuid.toString().replaceAll("-", "").substring(0, 6);   
          
    }  
  
}  