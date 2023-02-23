package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Customers {
	void customerDetails() {
		Customers cs = new Customers();
		Option o = new Option ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mobile number ;");
		long num3 = sc.nextLong();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_management", "root",
					"tiger");
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from payment_details where mobile_number = '" + num3 + "';");
			ResultSet rs = stmt.executeQuery("SELECT payment_id,payment_via,policy_start_date,policy_end_date,company_details.premium_amount,name,company_name from payment_details inner join  user_details on payment_details.user_id = user_details.user_id inner join company_details on payment_details.company_id = company_details.company_id ");

			
			System.out.printf("%20s %20s %20s %20s %15s %15s %10s ", "Payment id |", "Payment via |",
					"policy start date |", "Policy end date |", "User name |", "Company name |", "Premium amount |");
			System.out.println(
					"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			boolean has_result = rs.next();
			if (has_result) {
				// while(rs.next())
				{
					System.out.printf("%15s %18s %20s %20s %17s %18s %15s  ", rs.getInt("payment_id"),rs.getString("payment_via"), rs.getString("policy_start_date"),
							rs.getString("policy_end_date"), rs.getString("name"), rs.getString("company_name"), rs.getInt("premium_amount"));
					System.out.println(
							"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					o.result();
				}
			} else {
				System.out.println("You don't have any policy , Please buy first");
				o.result();
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
