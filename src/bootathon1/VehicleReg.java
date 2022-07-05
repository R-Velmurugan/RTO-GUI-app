package bootathon1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static bootathon1.AddVehicle.vehicleList;
import static bootathon1.Admin.duplicateveh;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class VehicleReg extends JFrame {
	static List<String> acclst=new ArrayList<>();
	static List<String> rejlst=new ArrayList<>();
	JFrame f;
	public VehicleReg() {
		new AddData();	    
	    getContentPane().setBackground(Color.white);
		Set<String> a=vehicleList;
		int y=85;
		JLabel head=new JLabel("Vehicles Applied");
		head.setBounds(10,10,250,40);
		head.setFont(new Font("Helvetica",Font.PLAIN,25));
		JPanel menu=new JPanel();
		menu.setBounds(0,60,800,40);
		menu.setBackground(Color.blue);
		for(String id : a) {
			if(duplicateveh.contains(id)) continue;
			JLabel l=new JLabel(id);
			l.setBounds(10,y+=30,250,25);
			l.setFont(new Font("Helvetica",Font.PLAIN,20));
			JButton b1=new JButton("View");
			b1.setBounds(200,y,200,25);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ViewApp(id);
				}
			});
			JButton b2=new JButton("Accept");
			b2.setBackground(Color.GREEN);
			b2.setBounds(400,y,200,25);
			JButton b3=new JButton("Reject");
			b3.setBackground(Color.RED);
			b3.setBounds(600,y,200,25);
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int res=JOptionPane.showConfirmDialog(b2,"The Application "+id+" will be accepted",
							"Acceptance Confirmation", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.OK_OPTION) {
						b2.setText("Accepted");
						b3.setVisible(false);
						acclst.add(id+" (V)");
						duplicateveh.add(id);
						Document document =new Document();
						try {
							PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("Application.pdf"));
							document.open();
							Paragraph p=new Paragraph("Applicant ID : "+id);
							p.setAlignment(p.ALIGN_CENTER);
							document.add(p);
							Class.forName("oracle.jdbc.driver.OracleDriver");
			                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","velsystem","java");
							Statement stmt=con.createStatement();
							Statement statement=con.createStatement();
							ResultSet rs=stmt.executeQuery("select * from bootVehicle where userid='"+id+"'");
//							ResultSet rs1=statement.executeQuery("delete * from bootVehicle where userid='"+id+"'");
							String mail="";
							while(rs.next()) {
								document.add(new Paragraph("UserId "+": "+rs.getString(1)));
								document.add(new Paragraph("OwnerName "+" : "+rs.getString(2)));
								document.add(new Paragraph("RegNumber "+" : "+rs.getString(3)));
								document.add(new Paragraph("ChassisNumber "+" : "+rs.getString(4)));
								document.add(new Paragraph("RegDate "+" : "+rs.getString(5)));
								document.add(new Paragraph("ModelName "+" : "+rs.getString(6)));
								document.add(new Paragraph("VehicleType "+" : "+rs.getString(7)));
								document.add(new Paragraph("Email "+" : "+rs.getString(8)));
								mail=rs.getString(8);
							}
							con.close();
							document.close();
							writer.close();
							new Mail(mail);
						}
						catch(Exception ae) {
							System.out.println(ae);
						}
					}
				}
			});
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection=DriverManager.getConnection(<db link and password>);
						Statement statement=connection.createStatement();
//						ResultSet rs1=statement.executeQuery("delete * from bootVehicle where userid='"+id+"'");
						connection.close();
					}
					catch(Exception exce) {
						
					}
					new Rejectreason(id);
					rejlst.add(id+" (V)");
					duplicateveh.add(id);
					b2.setVisible(false);
					b3.setText("Rejected");
				}
			});
			add(l);add(head);add(menu);add(b1);add(b2);add(b3);
		}
		setLayout(null);
		setTitle("Vehicle Registration");
		setSize(800,500);
		setBounds(280,220,800,500);
		setVisible(true);
	}
}
