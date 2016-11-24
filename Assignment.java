import java.sql.*;

public class Assignment 
{
public static void main(String args[]) throws SQLException
{
Driver d= new com.mysql.jdbc.Driver();
DriverManager.registerDriver(d);
Connection con= DriverManager.getConnection("jdbc:mysql://localhost/raushan?useSSL=false","raushan","rosh");

con.setAutoCommit(false);
PreparedStatement pstmt= con.prepareStatement("create table emp1(id int primary key, name varchar(10))");
pstmt.executeUpdate();

pstmt=con.prepareStatement("insert into emp1 values(1,'raushan')");
pstmt.executeUpdate();
pstmt=con.prepareStatement("insert into emp1 values(2,'arpit')");

pstmt.executeUpdate();


pstmt= con.prepareStatement("create table emp2(id int,address1 varchar(10),address2 varchar(10),FOREIGN KEY(id) REFERENCES emp1(id))");
pstmt.executeUpdate();


PreparedStatement pstmt2=con.prepareStatement("select id from emp1");
ResultSet rs=pstmt2.executeQuery();
//while(rs.next())
{
//int a=rs.getInt("id");
//System.out.println(a);
}
//rs.first();

String sql="insert into emp2 values(?,'abc','bcd')";
PreparedStatement pstmt3=con.prepareStatement(sql); 
pstmt3.addBatch();


while(rs.next())
{
int a=rs.getInt("id");
System.out.println(a);
pstmt3.setInt(1,rs.getInt("id"));
}

pstmt3.executeBatch();

con.commit();
}
}
