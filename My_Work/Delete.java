import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	int a;
	String c;

	public void delete_me(Connection con) throws SQLException, IOException {

		Scanner sc = new Scanner(System.in);

		System.out
				.println("Select the column number of column based on which u want to delete");
		System.out.println("Column:1 c_id");
		System.out.println("Column:2 c_code");
		System.out.println("Column:3 c_name");
		System.out.println("Column:4 c_duration");
		System.out.println("Column:5 c_eligibility");

		int option = sc.nextInt();
		sc.nextLine();
		String sql = null;
		if (option == 1) {
			System.out
					.println("Enter c_id for which you want to delete the record");
			sql = "delete from course where c_id=?";
		} else if (option == 2) {
			System.out
					.println("Enter c_code for which you want to delete the record");
			sql = "delete from course where c_code=?";
		} else if (option == 3) {
			System.out
					.println("Enter c_name for which you want to delete the record");
			sql = "delete from course where c_name=?";
		} else if (option == 4) {
			System.out
					.println("Enter c_duration for which you want to delete the record");
			sql = "delete from course where c_duration=?";
		} else if (option == 5) {
			System.out
					.println("Enter c_eligibility for which you want to delete the record");
			sql = "delete from course where c_eligibility=?";
		}
		else
		{
			System.out.println("Enter the correct column number");
			System.out.println("Sorry Enter Your Choice Again");
			String[] args={};
	        MainFn.main(args);
			//System.exit(0);
		}

		if (option == 1) {
			a = sc.nextInt();

		} else {
			c = sc.nextLine();
		}

		con.setAutoCommit(false);

		PreparedStatement preparedStatement = con.prepareStatement(sql);

		if (option == 1) {
			preparedStatement.setInt(1, a);
		} else {
			preparedStatement.setString(1, c);
		}

		preparedStatement.addBatch();

		preparedStatement.executeBatch();

		con.commit();
		//sc.close();

	}
}
