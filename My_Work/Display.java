import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display {
	public void makeConnection(Connection con) throws SQLException {

		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Connection con=
		// DriverManager.getConnection("jdbc:mysql://localhost/raushan?useSSL=false","raushan","rosh");

		Connection con_select = con;
		Statement stmt = con_select.createStatement();
		String sql = "select * from course";
		ResultSet rs = stmt.executeQuery(sql);
		System.out
				.println("***************************************************");
		System.out.print("C_id" + "\t");
		System.out.print("C_code" + "\t");
		System.out.print("C_name" + "\t");
		System.out.print("C_duration" + "\t");
		System.out.println("C_eligibility" + "\t");
		System.out
				.println("***************************************************");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getString(4) + "\t" + "\t");
			System.out.println(rs.getString(5) + "\t");

		}

	}

}