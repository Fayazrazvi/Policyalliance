package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Amount {
	public int premiumTable(long num) throws Exception {
        Amount a = new Amount();
        Option o = new Option();
        Update u = new Update();
		Scanner sc = new Scanner(System.in);
		int num2 = sc.nextInt();
		String str;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_management", "root",
					"tiger");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM company_details where company_id = '" + num2 + "';");
			
			while (rs.next()) {
				System.out.println("company_id :" + rs.getInt("company_id") + "  " + "\ncompany_name :"
						+ rs.getString("company_name") + "  " + "\npremium_amount :" + rs.getInt("premium_amount")
						+ "\n------------------");
				System.out.println("Pay via :");
			}
			str = sc.next();

			System.out.println("Payment Successfull" + "\n---------------------");
			u.updateDetails(str, num ,num2);
			o.result();
			con.close();

		}

		catch (Exception e) {
			System.out.println(e);
		}
		return num2;
	}

}
