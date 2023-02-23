package miniProject;

import java.util.Scanner;

public class Option {
	void result() throws Exception {
		Scanner sc = new Scanner(System.in);
		MainClass obj = new MainClass();
        Option o = new Option();
        CheckCustomer c = new CheckCustomer();
        NewCustomer n = new NewCustomer();
        Customers cs = new Customers();
		System.out.println("Please select any one option as given below :");
		System.out.println("1.Buy Now");
		System.out.println("2.Register");
		System.out.println("3.Customer Details");
		int choise = sc.nextInt();
		switch (choise) {
		case 1:
		    c.checkNumber();
			break;
		case 2:
			n.register();
			break;
		case 3:
			cs.customerDetails();
		}
	}

}
