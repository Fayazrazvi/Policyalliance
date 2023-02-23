package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClass {
public static void main(String[] args) throws Exception {
		MainClass obj = new MainClass();
		Option o = new Option();
		System.out.println("Welcom to my project policy management :");
		o.result();

	}
}