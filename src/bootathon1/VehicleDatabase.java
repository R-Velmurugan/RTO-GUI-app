package bootathon1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static bootathon1.Login_form.username;
import static bootathon1.VehicleRegistration_1.*;
public class VehicleDatabase {
	String ownerName=ownerNameField.getText(),regNumber=regNumberField.getText(),chassis=chassisNumberField.getText(),date=regDateField.getText(),model=modelNameField.getText(),mail=emailField.getText();
	public VehicleDatabase(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection(<db link and password>);
			Statement statement=connection.createStatement();
			String query="insert into bootVehicle values('"+username+"','"+ownerName+"','"+regNumber+"','"+chassis+"','"+date+"','"+model+"','"+vehicleType+"','"+mail+"')";
			statement.executeUpdate(query);
			connection.close();
		}
		catch(Exception exception) {
			System.out.println("Failed due to "+exception);
		}
	}
}
