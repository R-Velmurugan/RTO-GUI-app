package bootathon1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.*;
class Admin extends JFrame {
	JButton vehAppliedButton,licAppliedButton,acceptedButton,rejectedButton,b5,logoutButton;
	JPanel headpanel,menupanel,imgpanel;
	JLabel img1,img2,img3,imga;
	int i=1;
	static Set<String> duplicateveh=new HashSet<>();
	static Set<String> duplicatelic =new HashSet<>();
	
	public Admin() {
		setLayout(null);
		setTitle("Admin Home");
		setSize(1540,900);
		getContentPane().setBackground(Color.white);
		
		headpanel=new JPanel();
		headpanel.setBounds(30,40,50,85);
		headpanel.setLayout(null);
		JLabel img=new JLabel();
		img.setIcon(new ImageIcon("D:\\indiasmall.jpeg"));
		img.setBounds(0,0,50,85);
		headpanel.add(img);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	    JLabel l2=new JLabel();
	    l2.setText("Date : "+String.valueOf(java.time.LocalDate.now()));
	    l2.setFont(new Font("Arial",Font.PLAIN,15));
	    l2.setBounds(1350,10,200,20);
		JLabel l=new JLabel("REGIONAL TRANSPORT OFFICE");
		l.setFont(new Font("Helvetica",Font.PLAIN,25));
		l.setBounds(110,42,600,30);
		JLabel l1=new JLabel("Government of India");
		l1.setFont(new Font("Helvetica",Font.PLAIN,20));
		l1.setBounds(110,80,800,30);
		menupanel=new JPanel();
		menupanel.setBounds(0,150,1540,40);
		menupanel.setBackground(Color.BLUE);
		menupanel.setLayout(null);
		
		vehAppliedButton=new JButton("Vehicles Applied");
		vehAppliedButton.setBounds(835,8,120,30);
		vehAppliedButton.setFocusable(false);
		vehAppliedButton.setOpaque(false);
		vehAppliedButton.setForeground(Color.WHITE);
		vehAppliedButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		vehAppliedButton.setBorder(null);
		vehAppliedButton.setBackground(new Color(0,0,0,10));
		menupanel.add(vehAppliedButton);
		
		licAppliedButton=new JButton("License Applied");
		licAppliedButton.setBounds(975,8,110,30);
		licAppliedButton.setFocusable(false);
		licAppliedButton.setOpaque(false);
		licAppliedButton.setForeground(Color.WHITE);
		licAppliedButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		licAppliedButton.setBorder(null);
		licAppliedButton.setBackground(new Color(0,0,0,10));
		menupanel.add(licAppliedButton);
		
		acceptedButton=new JButton("Accepted Applications");
		acceptedButton.setBounds(1097,8,165,30);
		acceptedButton.setFocusable(false);
		acceptedButton.setOpaque(false);
		acceptedButton.setForeground(Color.WHITE);
		acceptedButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		acceptedButton.setBorder(null);
		acceptedButton.setBackground(new Color(0,0,0,10));
		menupanel.add(acceptedButton);
		
		rejectedButton=new JButton("Rejected Applications");
		rejectedButton.setBounds(1267,8,150,30);
		rejectedButton.setFocusable(false);
		rejectedButton.setOpaque(false);
		rejectedButton.setForeground(Color.WHITE);
		rejectedButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		rejectedButton.setBorder(null);
		rejectedButton.setBackground(new Color(0,0,0,10));
		menupanel.add(rejectedButton);
		
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(1430,8,90,30);
		logoutButton.setFocusable(false);
		logoutButton.setOpaque(false);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		logoutButton.setBorder(null);
		logoutButton.setBackground(new Color(0,0,0,10));
		menupanel.add(logoutButton);
		
		imgpanel=new JPanel();
		imgpanel.setBounds(0,195,1600,750);
		imgpanel.setLayout(null);
		imga=new JLabel();
		imga.setIcon(new ImageIcon("D:\\vehicle2.jpg"));
		imga.setBounds(0,0,2100,750);
		imgpanel.add(imga);
		add(imgpanel);
		
		Timer t=new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(i==1) {
					imga.setIcon(new ImageIcon("D:\\r6.jpg"));
					i=2;
				}else if(i==2) {
					imga.setIcon(new ImageIcon("D:\\li6.jpg"));
					i=3;
				}else {
					imga.setIcon(new ImageIcon("D:\\car6.jpg"));
					i=1;
				}
			}
		},0,1500);
		vehAppliedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VehicleReg();
			}
		});
		licAppliedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LicenseReg();
			}
		});
		acceptedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AcceptedApp();
			}
		});
		rejectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RejectedApp();
			}
		});
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage();
			}
		});
		add(l);add(l1);add(l2);add(headpanel);add(menupanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}