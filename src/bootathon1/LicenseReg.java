package bootathon1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static bootathon1.AddVehicle.licenseList;
import static bootathon1.VehicleReg.acclst;
import static bootathon1.VehicleReg.rejlst;
import static bootathon1.Admin.duplicatelic;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class LicenseReg extends JFrame{
	public LicenseReg(){
		new AddData(5);
		getContentPane().setBackground(Color.white);
		Set<String> a=licenseList;
		int y=80;
		JLabel head=new JLabel("License Applied");
		head.setBounds(10,10,250,40);
		head.setFont(new Font("Helvetica",Font.PLAIN,25));
		JPanel menu=new JPanel();
		menu.setBounds(0,60,800,40);
		menu.setBackground(Color.blue);
		for(String i : a) {
			if(duplicatelic.contains(i)) continue;
			JLabel l=new JLabel(i);
			l.setBounds(10,y+=30,250,30);
			l.setFont(new Font("Helvetica",Font.PLAIN,20));
			JButton b1=new JButton("View");
			b1.setBounds(200,y,200,25);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ViewApp(i,5);
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
					int res=JOptionPane.showConfirmDialog(b2,"The Application "+i+" will be accepted",
							"Acceptance Confirmation", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.OK_OPTION) {
						b2.setText("Accepted");
						b3.setVisible(false);
						acclst.add(i+" (L)");
						duplicatelic.add(i);
						Document document =new Document();
						try {
							PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("Application.pdf"));
							document.open();
							Paragraph head=new Paragraph("REGIONAL TRANSPORT OFFICE");
							head.setAlignment(head.ALIGN_LEFT);
							document.add(head);
							Paragraph p=new Paragraph("LICENSE REGISTRATION");
							p.setAlignment(p.ALIGN_CENTER);
							document.add(p);
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection connection=DriverManager.getConnection(<db link and password>);
							Statement stmt=connection.createStatement();
							Statement statement=connection.createStatement();
							ResultSet rs=stmt.executeQuery("select * from bootLicense where userid='"+i+"'");
//							ResultSet rs1=statement.executeQuery("delete * from bootLicense where userid='"+i+"'");
							String mail="";
							while(rs.next()) {
								document.add(new Paragraph("ApplicantName "+": "+rs.getString(1)));
								document.add(new Paragraph("UserId "+" : "+rs.getString(2)));
								document.add(new Paragraph("EmailId "+" : "+rs.getString(3)));
								document.add(new Paragraph("Gender "+" : "+rs.getString(4)));
								document.add(new Paragraph("DOB "+" : "+rs.getString(5)));
								document.add(new Paragraph("City "+" : "+rs.getString(6)));
								document.add(new Paragraph("Address "+" : "+rs.getString(7)));
								document.add(new Paragraph("LicenseType "+" : "+rs.getString(8)));
								mail=rs.getString(3);
							}
							connection.close();
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
//						ResultSet rs1=statement.executeQuery("delete * from bootLicense where userid='"+i+"'");
						connection.close();
					}
					catch(Exception er) {
						
					}
					new Rejectreason(i,5);
					rejlst.add(i+" (L)");
					duplicatelic.add(i);
					b2.setVisible(false);
					b3.setText("Rejected");
				}
			});
			add(l);add(head);add(menu);add(b1);add(b2);add(b3);
		}
		setLayout(null);
		setTitle("License Registration");
		setBounds(280,220,800,500);
		setSize(800,500);
		setVisible(true);
	}
}
