package com.product;  
  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
  
import com.jdbc.JdbcUtils;  
  
public class ProductDao implements ProductService {  
  
    private JdbcUtils jdbcUtils;  
    public ProductDao() {  
        // TODO Auto-generated constructor stub  
        jdbcUtils = new JdbcUtils();  
    }  
  
    @Override  
    public boolean addProduct(List<Object> params) {  
          
        boolean flag = false;  
        try {  
            jdbcUtils.getConnection();  
            String sql = "insert into product(proid,proname,proprice,proaddress,proimage) values(?,?,?,?,?)";  
            flag = jdbcUtils.updateByPreparedStatement(sql, params);  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }finally{  
              
            // 关闭数据库连接  
            jdbcUtils.releaseConn();  
              
        }  
          
          
        return flag;  
    }  
  
    @Override  
    public List<Map<String, Object>> listProduct(String proname ,int start ,int end) {  
        // TODO Auto-generated method stub  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        List<Object> params  = new ArrayList<Object>();       
        try {  
            jdbcUtils.getConnection();            
            String sql = "select * from product where 1=1 and proname like ? limit ? ,?";     
            if(proname.equals("")){  
                sql = "select * from product limit ? ,?";  
                params.add(start);  
                params.add(end);  
                  
            }else{                
                params.add("%"+proname+"%");  
                params.add(start);  
                params.add(end);  
            }         
                      
            list = jdbcUtils.findMoreResult(sql, params);             
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
          //Exception类是所有异常类的父类，e是指向子类的引用，因为你的程序在运行的过程中不知道会产生那种类型的异常，
			//所以使用Exception类的引用，不管程序产生什么类型的异常catch块都可以扑捉到
        } finally{  
              
              
            jdbcUtils.releaseConn();  
              
        }  
          
          
        return list;  
    }  
  
    //查询总记录数  
    @Override  
    public int getItemCount(String proname) {  
        // TODO Auto-generated method stub  
        int count = 0;  
        Map<String, Object> map = null;  
        List<Object> params = null;         
        try {  
            jdbcUtils.getConnection();            
            String sql = "select count(*) totalCount from product where 1=1 and proname like ?";      
            if(proname.equals("")){  
                sql = "select count(*) totalCount from product";  
                  
            }else{  
                params = new ArrayList<Object>();  
                params.add("%"+proname+"%");  
            }  
        map = jdbcUtils.findSimpleResult(sql, params);  
        count = Integer.parseInt(map.get("totalCount").toString());  
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        } finally{  
            // 关闭数据库连接  
            jdbcUtils.releaseConn();  
        }  
          
          
        return count;  
    }  
  
    @Override  
    public boolean delProduct(String[] ids) {  
        boolean flag = false;  
        try {  
            jdbcUtils.getConnection();  
            if (ids!=null) {  
                String[] sql = new String[ids.length];  
                for(int i = 0 ; i< ids.length; i++){  
                    sql[i] = "delete from product where proid = '"+ids[i]+"'";  
                    System.out.println(sql[i]);  
                }  
                flag = jdbcUtils.deleteByBatch(sql);      
            }  
                      
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        } finally{  
            // 关闭数据库连接  
            jdbcUtils.releaseConn();  
        }     
          
        return flag;  
    }  
  
    @Override  
    public Map<String, Object> viewProduct(String proid) {  
        // TODO Auto-generated method stub  
        Map<String, Object> map = null;  
        try {  
            jdbcUtils.getConnection();  
            List<Object> params = new ArrayList<Object>();  
            params.add(proid);  
            String sql = "select * from product where proid = ?";  
            map = jdbcUtils.findSimpleResult(sql, params);  
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        } finally{  
            // 关闭数据库连接  
            jdbcUtils.releaseConn();  
        }  
		//当try语句中出现异常是时，会执行catch中的语句，java运行时系统会自动将catch括号中的Exception e 初始化，
//		也就是实例化Exception类型的对象。e是此对象引用名称。然后e（引用）会自动调用Exception类中指定的方法，
//		也就出现了e.printStackTrace() ;。
//		printStackTrace()方法的意思是：在命令行打印异常信息在程序中出错的位置及原因。        
          
        return map;  
    }  
  
      
  
}  