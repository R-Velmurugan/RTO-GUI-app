package bootathon1;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ViewApp extends JFrame{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	public ViewApp(String id) {
		try {
			getContentPane().setBackground(Color.white);
			JLabel l=new JLabel("UserId - "+id);
			l.setBounds(10,10,300,30);
			l.setFont(new Font("Helvetica",Font.PLAIN,25));
			JPanel menu=new JPanel();
			menu.setBounds(0,54,800,40);
			menu.setBackground(Color.blue);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","velsystem","java");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bootVehicle where userid='"+id+"'");
			while(rs.next()) {
				l1=new JLabel("UserId");
				l1.setBounds(50,100,200,40);
				l1.setFont(new Font("Helvetica",Font.PLAIN,20));
				l9=new JLabel(rs.getString(1));
				l9.setBounds(300,100,250,40);
				l9.setFont(new Font("Helvetica",Font.PLAIN,20));
				l2=new JLabel("OwnerName");
				l2.setBounds(50,140,200,40);
				l2.setFont(new Font("Helvetica",Font.PLAIN,20));
				l10=new JLabel(rs.getString(2));
				l10.setBounds(300,140,250,40);
				l10.setFont(new Font("Helvetica",Font.PLAIN,20));
				l3=new JLabel("RegNumber");
				l3.setBounds(50,180,200,40);
				l3.setFont(new Font("Helvetica",Font.PLAIN,20));
				l11=new JLabel(rs.getString(3));
				l11.setBounds(300,180,250,40);
				l11.setFont(new Font("Helvetica",Font.PLAIN,20));
				l4=new JLabel("ChassisNumber");
				l4.setBounds(50,220,200,40);
				l4.setFont(new Font("Helvetica",Font.PLAIN,20));
				l12=new JLabel(rs.getString(4));
				l12.setBounds(300,220,250,40);
				l12.setFont(new Font("Helvetica",Font.PLAIN,20));
				l5=new JLabel("RegDate");
				l5.setBounds(50,260,200,40);
				l5.setFont(new Font("Helvetica",Font.PLAIN,20));
				l13=new JLabel(rs.getString(5));
				l13.setBounds(300,260,250,40);
				l13.setFont(new Font("Helvetica",Font.PLAIN,20));
				l6=new JLabel("ModelName");
				l6.setBounds(50,300,200,40);
				l6.setFont(new Font("Helvetica",Font.PLAIN,20));
				l14=new JLabel(rs.getString(6));
				l14.setBounds(300,300,250,40);
				l14.setFont(new Font("Helvetica",Font.PLAIN,20));
				l7=new JLabel("VehicleType");
				l7.setBounds(50,340,200,40);
				l7.setFont(new Font("Helvetica",Font.PLAIN,20));
				l15=new JLabel(rs.getString(7));
				l15.setBounds(300,340,250,40);
				l15.setFont(new Font("Helvetica",Font.PLAIN,20));
				l8=new JLabel("Email");
				l8.setBounds(50,380,200,40);
				l8.setFont(new Font("Helvetica",Font.PLAIN,20));
				l16=new JLabel(rs.getString(8));
				l16.setBounds(300,380,250,40);
				l16.setFont(new Font("Helvetica",Font.PLAIN,20));
			}
			connection.close();
			add(l);add(menu);add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);
			add(l9);add(l10);add(l11);add(l12);add(l13);add(l14);add(l15);add(l16);
			setTitle("Application "+id);
			setLayout(null);
			setSize(800,500);
			setBounds(280,220,800,500);
			setVisible(true);
		}
		catch(Exception ae){ 
			System.out.println(ae);
		}
	}
	public ViewApp(String id,int n) {
		try {
			getContentPane().setBackground(Color.white);
			JLabel l=new JLabel("UserId - "+id);
			l.setBounds(10,10,300,30);
			l.setFont(new Font("Helvetica",Font.PLAIN,25));
			JPanel menu=new JPanel();
			menu.setBounds(0,54,800,40);
			menu.setBackground(Color.blue);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","velsystem","java");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bootLicense where userid='"+id+"'");
			while(rs.next()) {
				l1=new JLabel("ApplicantName");
				l1.setBounds(50,100,200,40);
				l1.setFont(new Font("Helvetica",Font.PLAIN,20));
				l9=new JLabel(rs.getString(1));
				l9.setBounds(300,100,250,40);
				l9.setFont(new Font("Helvetica",Font.PLAIN,20));
				l2=new JLabel("UserId");
				l2.setBounds(50,140,200,40);
				l2.setFont(new Font("Helvetica",Font.PLAIN,20));
				l10=new JLabel(rs.getString(2));
				l10.setBounds(300,140,250,40);
				l10.setFont(new Font("Helvetica",Font.PLAIN,20));
				l3=new JLabel("EmailId");
				l3.setBounds(50,180,200,40);
				l3.setFont(new Font("Helvetica",Font.PLAIN,20));
				l11=new JLabel(rs.getString(3));
				l11.setBounds(300,180,250,40);
				l11.setFont(new Font("Helvetica",Font.PLAIN,20));
				l4=new JLabel("Gender");
				l4.setBounds(50,220,200,40);
				l4.setFont(new Font("Verdana",Font.PLAIN,20));
				l12=new JLabel(rs.getString(4));
				l12.setBounds(300,220,250,40);
				l12.setFont(new Font("Helvetica",Font.PLAIN,20));
				l5=new JLabel("DOB");
				l5.setBounds(50,260,200,40);
				l5.setFont(new Font("Helvetica",Font.PLAIN,20));
				l13=new JLabel(rs.getString(5));
				l13.setBounds(300,260,250,40);
				l13.setFont(new Font("Helvetica",Font.PLAIN,20));
				l6=new JLabel("City");
				l6.setBounds(50,300,200,40);
				l6.setFont(new Font("Helvetica",Font.PLAIN,20));
				l14=new JLabel(rs.getString(6));
				l14.setBounds(300,300,250,40);
				l14.setFont(new Font("Helvetica",Font.PLAIN,20));
				l7=new JLabel("Address");
				l7.setBounds(50,340,200,40);
				l7.setFont(new Font("Helvetica",Font.PLAIN,20));
				l15=new JLabel(rs.getString(7));
				l15.setBounds(300,340,450,40);
				l15.setFont(new Font("Helvetica",Font.PLAIN,20));
				l8=new JLabel("License Type");
				l8.setBounds(50,380,200,40);
				l8.setFont(new Font("Helvetica",Font.PLAIN,20));
				l16=new JLabel(rs.getString(8));
				l16.setBounds(300,380,250,40);
				l16.setFont(new Font("Helvetica",Font.PLAIN,20));
			}
			add(l);add(menu);add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);
			add(l9);add(l10);add(l11);add(l12);add(l13);add(l14);add(l15);add(l16);
			setTitle("Application "+id);
			setLayout(null);
			setSize(800,500);
			setBounds(280,220,800,500);
			setVisible(true);
			
		}
		catch(Exception ae){ 
			System.out.println(ae);
		}
	}
}
