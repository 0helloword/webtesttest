package com.login;  
  
import java.sql.SQLException;  
import java.util.List;  
import java.util.Map;  
  
//import javax.mail.Flags.Flag;  
  
import com.jdbc.JdbcUtils;  
//DAO层一般有接口和该接口的实现类！ 接口用于规范实现类！ 实现类一般用于用于操作数据库！
//一般操作修改，添加，删除数据库操作的步骤很相似，就写了一个公共类DAO类 ，修改，添加，删除数据库操作时 直接调用公共类DAO类！  
public class LoginDao implements LoginService {  
  
    private JdbcUtils jdbcUtils;  
    public LoginDao() {  
        // TODO Auto-generated constructor stub  
        jdbcUtils = new JdbcUtils();  
    }  
  
    @Override  
    public boolean login(List<Object> params) {  
        // TODO Auto-generated method stub  
        boolean flag = false;  
          
        try {  
            jdbcUtils.getConnection();  
            String sql = "select * from userinfo where username = ? and pswd = ?";  
            Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);  
            flag = !map.isEmpty()?true:false;             
              
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }finally{  
              
        //关闭数据库  
        jdbcUtils.releaseConn();  
              
        }  
          
        return flag;  
    }     
  
}  