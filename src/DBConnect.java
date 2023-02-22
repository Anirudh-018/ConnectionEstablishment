import java.sql.*;
import java.util.*;
public class DBConnect {
    Connection con=null;
    Scanner s=new Scanner(System.in);
    void getConnection() throws Exception{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "sairam123");
        System.out.println("connected succesfully");
    }
    void retrieveData(String tablename) throws Exception{
        Statement stmt=con.createStatement();
        String query="select * from "+tablename;
        ResultSet result=stmt.executeQuery(query);
        System.out.println("rollno  name        dob");
        while(result.next()){
            System.out.println(result.getString("rollno")+" "+result.getString("name")+" "+result.getString("dob"));
        }
    }
    void insertValues(String tablename) throws Exception{
        Statement stmt=con.createStatement();
        System.out.println("enter records");
        String record=s.nextLine();
        int affected=stmt.executeUpdate("insert into "+tablename+" values("+record+")");
        System.out.println("Affected rows are :"+affected);
    }
    public static void main(String[] args) throws Exception{
        DBConnect obj=new DBConnect();
        obj.getConnection();
        obj.retrieveData("details");
        obj.insertValues("details");
    }
}
