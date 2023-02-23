package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CheckCustomer {
	long checkNumber() throws Exception {
		Scanner sc = new Scanner(System.in);
		CheckCustomer c = new CheckCustomer();
		 Option o = new Option();
		 Amount a = new Amount();
		System.out.println("Enter your mobile number ;");
		long num = sc.nextLong();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_management", "root",
					"tiger");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT mobile_number FROM user_details where mobile_number ='" + num + "';");
			boolean has_result = rs.next();
			if (has_result) {
				System.out.println("This is a registered account go ahead");
				ResultSet rs2 = stmt.executeQuery("select * from company_details");
				while (rs2.next()) {
					System.out.println("company_id :" + rs2.getInt("company_id") + "  " + "\ncompany_name :"
							+ rs2.getString("company_name") + "  " + "\npremium_amount :" + rs2.getInt("premium_amount")
							+ "\n------------------");
				}
				System.out.println("PLEASE CHOOSE ANY COMPANY :");
				con.close();
			} else {
				System.out.println("You don't have a account , Please Register");
				o.result();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		a.premiumTable(num);
		return num;

	}

}
