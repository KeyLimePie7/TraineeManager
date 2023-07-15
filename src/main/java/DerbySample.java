import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DerbySample {
 
	public static void main(String[] args) {
        String databaseURL = "jdbc:derby:traineeDB;create=true";
 
        try {
        	Connection conn = DriverManager.getConnection(databaseURL);
            Statement statement = conn.createStatement();
            //statement.executeUpdate ("DROP TABLE employee"); 
            if (!doesTableExists("trainee", conn)) {
                String sql = "CREATE TABLE trainee (emp_id int primary key, name varchar(100), lg_name varchar(10), rating int, feedback varchar(50))";
                statement.execute(sql);
                System.out.println("Created table trainee.");
 
                statement.executeUpdate("INSERT INTO trainee VALUES (1001,'Tisha', 'TJA98', 5, 'Excellent')"); 
                statement.executeUpdate("INSERT INTO trainee VALUES (1002,'Shubha', 'TJA98', 5, 'Excellent')"); 
                statement.executeUpdate("INSERT INTO trainee VALUES (1003,'Asha', 'TJA98', 5, 'Excellent')"); 
                statement.executeUpdate("INSERT INTO trainee VALUES (1004,'Banu', 'TJA98', 4, 'Good')"); 
                statement.executeUpdate("INSERT INTO trainee VALUES (1005,'Yash', 'TJA99', 4, 'Good')"); 
                statement.executeUpdate("INSERT INTO trainee VALUES (1006,'Piyush', 'TJA100', 3, 'Average')"); 
                System.out.println("Inserted 5 rows.");
            }

            String sql = "SELECT * FROM trainee";
            ResultSet result = statement.executeQuery(sql);
 
            while (result.next()) {
                System.out.println(result.getInt("emp_id")+":"+result.getString("name")+":"+result.getString("lg_name"));
            }
 
 
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
 
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("XJ015")) {
                System.out.println("Derby shutdown normally");
            } else {
                ex.printStackTrace();
            }
        }
    }
 
    private static boolean doesTableExists(String tableName, Connection conn)
            throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
 
        return result.next();
    }
}