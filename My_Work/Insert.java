import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	public void insert_me(Connection con) throws SQLException {

		String sql = "INSERT INTO course"
				+ "(c_id,c_code,c_name,c_duration,c_eligibility) VALUES"
				+ "(?,?,?,?,?)";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Course code");
		String code = sc.nextLine();
		System.out.println("Enter Course name");
		String name = sc.nextLine();
		System.out.println("Enter Course duration");
		String dur = sc.nextLine();
		System.out.println("Enter Course eligibility");
		String eli = sc.nextLine();

		con.setAutoCommit(false);

		PreparedStatement preparedStatement = con.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, code);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, dur);
		preparedStatement.setString(5, eli);
		preparedStatement.addBatch();

		preparedStatement.executeBatch();
		//sc.close();

		con.commit();

	}
}
