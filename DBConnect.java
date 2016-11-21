import java.sql.*;

public class DBConnect
{
public static void main(String args[]) throws SQLException
{

DriverManager.registerDriver(new com.mysql.jdbc.Driver());
Connection con= DriverManager.getConnection("jdbc:mysql://localhost/raushan?useSSL=false","raushan","rosh");
Statement stmt=con.createStatement();
stmt.executeUpdate("create table college(dept_id int,name varchar(10))");

System.out.println("Hello");
}
}
