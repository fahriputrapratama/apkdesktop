

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connect {
   public static Connection configDB() throws SQLException {
        Connection connection = null;
         try {
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "";
            
            connection = DriverManager.getConnection(url,user,password);
//
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            throw e;
        }
         return connection;
    }

    static Connection Go() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
