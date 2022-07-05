package bootathon1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddData {
	public AddData()  {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","velsystem","java");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bootVehicle");
		while(rs.next()) {
			new AddVehicle(rs.getString(1));
		}}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}
	public AddData(int n) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","velsystem","java");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bootLicense");
		while(rs.next()) {
			new AddVehicle(rs.getString(2),5);
		}}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
