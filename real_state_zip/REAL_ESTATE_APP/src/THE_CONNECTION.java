
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class THE_CONNECTION {
    
    private static String servername ="localhost";
    private static String dbname="realstatedb";
    private static String username ="root";
    private static Integer portnumber =3306;
    private static String password="root";
    
   //create a function to get the connection
    public static Connection getTheConnection()
    {
        Connection connection;
        connection = null;
        MysqlDataSource datasource = new MysqlDataSource();
        
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setPassword(password);
        
      
        try
        {
            connection =datasource.getConnection();
        }
          catch (SQLException ex)
        {
            Logger.getLogger(THE_CONNECTION.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
                
                return connection;
        
    }
}
