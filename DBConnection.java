import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String URL="jdbc:mysql://localhost:3306/employee_db";
    private static String USER="root";
    private static String PASSWORD="";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
