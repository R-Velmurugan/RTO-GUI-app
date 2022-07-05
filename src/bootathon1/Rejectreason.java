package bootathon1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class Rejectreason extends JFrame{
	JTextArea rejt;
	public Rejectreason(String id) {
		JLabel l=new JLabel("Reason for the rejection of application");
		l.setBounds(0,10,250,30);
		l.setFont(new Font("Helvetica",Font.PLAIN,10));
		rejt=new JTextArea();
		rejt.setBounds(20,50,200,100);
		JButton b=new JButton("OK");
		b.setBounds(90,170,70,30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=rejt.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection(<db link and password>);
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select mail from bootVehicle where userid='"+id+"'");
					String mail="";
					while(rs.next()) {
						mail = rs.getString(1);
					}
					new Mail(mail,s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		add(l);add(rejt);add(b);
		setLayout(null);
		setSize(250,250);
		setBounds(600,400,250,250);
		setVisible(true);
	}
	public Rejectreason(String id,int n) {
		JLabel l=new JLabel("Reason for the rejection of application");
		l.setBounds(0,10,250,30);
		l.setFont(new Font("Helvetica",Font.PLAIN,10));
		rejt=new JTextArea();
		rejt.setBounds(20,50,200,100);
		JButton b=new JButton("OK");
		b.setBounds(90,170,70,30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=rejt.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection(<db link and password>);
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select emailid from bootLicense where userid='"+id+"'");
					String mail="";
					while(rs.next()) {
						mail = rs.getString(1);
					}
					con.close();
					new Mail(mail,s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		add(l);add(rejt);add(b);
		setLayout(null);
		setSize(250,250);
		setBounds(600,400,250,250);
		setVisible(true);
	}
}
