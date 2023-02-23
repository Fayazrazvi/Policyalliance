package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Update {
	void updateDetails(String str, long num,int num2) {
		Update u = new Update();
		Scanner sc = new Scanner(System.in);
		LocalDate date = LocalDate.now();
		LocalDate oneyearafter = date.plusYears(1);
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_management","root","tiger");  
				Statement stmt=con.createStatement();
				stmt.executeUpdate("Update payment_details set payment_via = '"+str+"',policy_start_date =  '"+date+"' , policy_end_date ='"+oneyearafter+"',premium_amount = '"+num2+"'where company_id='"+num2+"';");
				//stmt.executeUpdate("update company_details set company_name = '"+num2+"',premium_amount = '"+num2+"'where company_id = '"+num2+"';");
				ResultSet rs1 = stmt.executeQuery("SELECT payment_id,payment_via,policy_start_date,policy_end_date,company_details.premium_amount,name,company_name from payment_details inner join  user_details on payment_details.user_id = user_details.user_id inner join company_details on payment_details.company_id = company_details.company_id where company_details.company_id='"+num2+"'; ");

				System.out.printf("%20s %20s %20s %20s %15s %15s %10s ", "Payment id |", "Payment via |",
						"policy start date |", "Policy end date |", "User name |", "Company name |", "Premium amount |");
				System.out.println(
						"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

				while(rs1.next())
				
					System.out.printf("%15s %18s %20s %20s %17s %18s %15s  ", rs1.getInt("payment_id"),rs1.getString("payment_via"), rs1.getString("policy_start_date"),
							rs1.getString("policy_end_date"), rs1.getString("name"), rs1.getString("company_name"), rs1.getInt("premium_amount"));
					System.out.println(
							"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					 System.out.println("Policy Bought Successfully....."+"\n---------------------------");
				
				
			}
				catch(Exception e)
				{ 
					System.out.println(e);
				}

		}

}
