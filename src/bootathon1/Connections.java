package bootathon1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
    
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(<your db password and link>);
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}

