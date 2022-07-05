package bootathon1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static bootathon1.LicenseRegistration.*;
import static bootathon1.Login_form.username;

public class LicenseDatabase {
	String ownerName=applicantNameField.getText(),userId=userIdField.getText(),emailId=emailIdField.getText(),dob=dobField.getText(),city=cityField.getText(),addrs=txt_addrs.getText();
	public LicenseDatabase(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection(<db link and password>);
			Statement statement=connection.createStatement();
			String query="insert into bootLicense values('"+ownerName+"','"+username+"','"+emailId+"','"+str_gender+"','"+dob+"','"+city+"','"+addrs+"','"+vehicleType+"')";
			statement.executeUpdate(query);
			connection.close();
		}
		catch(Exception exception) {
			System.out.println("Failed due to "+exception);
		}
	}
}
