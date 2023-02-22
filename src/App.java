import java.sql.*;
public class App {
    public static void main(String[] args) {
        try(Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","sairam123");
        Statement stmt=con.createStatement();
        ) {
            String query="CREATE TABLE EMPLOYEE(EID int,EName varchar(10))";
            int res=stmt.executeUpdate(query);
            System.out.println(res);
            if(res==0){
                System.out.println("table created");
            }
            else{
                System.out.println("not created");
            }            
        } catch (Exception e) {
            System.out.println("error in query");
        }
    }
}

