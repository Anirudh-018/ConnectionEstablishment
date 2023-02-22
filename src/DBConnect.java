import java.sql.*;
public class DBConnect {
    Connection con=null;
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
    public static void main(String[] args) throws Exception{
        DBConnect obj=new DBConnect();
        obj.getConnection();
        obj.retrieveData("details");
    }
}
