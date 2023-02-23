package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NewCustomer {
	PreparedStatement preparedStatement = null;
	void register() throws Exception {
		MainClass obj =new MainClass();
		Option o = new Option();
		NewCustomer n = new NewCustomer(); 
		System.out.println("Welcome to Register page :");
		System.out.println("-------/--/--------/----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer's mobile number : ");
		long z = sc.nextLong();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_management", "root",
					"tiger");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT mobile_number FROM user_details where mobile_number ='" + z + "';");
			boolean has_result = rs.next();
			if (has_result) {
				System.out.println("Your number is already registered");
				o.result();
			}
			else {	
			System.out.println("This is the new number , please fill the following details ;");
			System.out.println("Enter the Customer Name : ");
			String x = sc.next();
			System.out.println("Enter the Customer's age : ");
			int y = sc.nextInt();
			preparedStatement = con.prepareStatement("insert into user_details( name , age , mobile_number) values (?,?,?)");
			preparedStatement.setString(1, x);
			preparedStatement.setInt(2, y);
			preparedStatement.setLong(3, z);
			preparedStatement.addBatch();
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Registered successfully!..\n--------------");
			}
			o.result();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
