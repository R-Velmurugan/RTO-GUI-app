package bootathon1;
import static bootathon1.Login_form.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
//import java.awt.ima
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HomePage extends JFrame{
	JPanel imagePanel,contentPanel,menuPanel,mainimgPanel;
	JLabel lionLabel,templeLabel,govtLabel,govtLabel2,image1,textLabel;
	JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,loginButton,statusButton,userButton,homeButton;
	JRadioButton button1,button2,button3;
	ButtonGroup button;
	FileInputStream fileStream;
	String aboutString;
	boolean b;
	static boolean bool=false;
	public HomePage() {
		setSize(1540,900);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		userButton=new JButton();
		userButton.setBounds(1430,0,80,35);
		userButton.setFocusable(false);
		userButton.setOpaque(false);
		userButton.setForeground(Color.WHITE);
		userButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		userButton.setBorder(null);
		userButton.setBackground(new Color(0,0,0,10));

		loginButton=new JButton("Login");
		loginButton.setBounds(1349,0,80,35);
		loginButton.setFocusable(false);
		loginButton.setOpaque(false);
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		loginButton.setBorder(null);
		loginButton.setBackground(new Color(0,0,0,10));
		
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(1349,0,80,35);
		logoutButton.setFocusable(false);
		logoutButton.setOpaque(false);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		logoutButton.setBorder(null);
		logoutButton.setBackground(new Color(0,0,0,10));
		
		contactButton=new JButton("Contact us");
		contactButton.setBounds(1269,0,80,35);
		contactButton.setFocusable(false);
		contactButton.setOpaque(false);
		contactButton.setForeground(Color.WHITE);
		contactButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		contactButton.setBorder(null);
		contactButton.setBackground(new Color(0,0,0,10));
		
		vehregButton=new JButton("Vehicle Registration");
		vehregButton.setBounds(949,0,150,35);
		vehregButton.setFocusable(false);
		vehregButton.setOpaque(false);
		vehregButton.setForeground(Color.WHITE);
		vehregButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		vehregButton.setBorder(null);
		vehregButton.setBackground(new Color(0,0,0,10));
		
		licButton=new JButton("License Registration");
		licButton.setBounds(1109,0,150,35);
		licButton.setFocusable(false);
		licButton.setOpaque(false);
		licButton.setForeground(Color.WHITE);
		licButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		licButton.setBorder(null);
		licButton.setBackground(new Color(0,0,0,10));
		
		homeButton=new JButton("Home");
		homeButton.setBounds(800,0,70,35);
		homeButton.setFocusable(false);
		homeButton.setOpaque(false);
		homeButton.setForeground(Color.WHITE);
		homeButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		homeButton.setBorder(null);
		homeButton.setBackground(new Color(0,0,0,10));
		
		aboutusButton=new JButton("About us");
		aboutusButton.setBounds(865,0,80,35);
		aboutusButton.setFocusable(false);
		aboutusButton.setOpaque(false);
		aboutusButton.setForeground(Color.WHITE);
		aboutusButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		aboutusButton.setBorder(null);
		aboutusButton.setBackground(new Color(0,0,0,10));
        
        button=new ButtonGroup();
        button1=new JRadioButton();
        button1.setSelected(true);
        button2=new JRadioButton();
        button3=new JRadioButton();
        button1.setBounds(490, 375, 20, 25);
        button2.setBounds(520, 375, 20, 25);
        button3.setBounds(550,375,20,25);
        button1.setOpaque(false);
        button2.setOpaque(false);
        button3.setOpaque(false);
        button.add(button1);
        button.add(button2);
        button.add(button3);
		
		menuPanel=new JPanel();
		menuPanel.setBounds(0,150,1540,40);
		menuPanel.setBackground(new Color(0,0,204));
		menuPanel.setBackground(Color.BLUE);
		menuPanel.setLayout(null);
		add(menuPanel);
		menuPanel.add(loginButton);
		menuPanel.add(aboutusButton);
		menuPanel.add(licButton);
		menuPanel.add(vehregButton);
		menuPanel.add(contactButton);
		menuPanel.add(homeButton);
		
		if(!bool) {
			menuPanel.add(loginButton);
		}
		
		if(bool) {
			menuPanel.remove(loginButton);
			userButton.setText("Hey "+username);
			menuPanel.add(userButton);
			menuPanel.add(logoutButton);
		}
		
		lionLabel=new JLabel();
		lionLabel.setBounds(20, 0, 200, 200);
		lionLabel.setIcon(new ImageIcon("D:\\javaImages\\lion.png"));
		
		govtLabel=new JLabel("Regional Transport Office");
		govtLabel.setFont(new Font("Helvetica",Font.BOLD,20));
		govtLabel.setBounds(90,60,300,40);
		govtLabel2=new JLabel("Government of India");
		govtLabel2.setFont(new Font("Helvetica",Font.BOLD,16));
		govtLabel2.setBounds(90,100,300,20);
		
		image1=new JLabel();
		image1.setBounds(0, 0, 1200, 400);
		image1.setIcon(new ImageIcon("D:\\javaImages\\image3.jpg"));

		imagePanel=new JPanel();
		imagePanel.setBounds(0,0,1539,150);
		imagePanel.setBackground(Color.white);
		imagePanel.setLayout(null);
		add(imagePanel);
		imagePanel.add(lionLabel);
		imagePanel.add(govtLabel);
		imagePanel.add(govtLabel2);
		
		contentPanel=new JPanel();
		contentPanel.setBounds(0,190,1539,800);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		add(contentPanel);
		
		mainimgPanel=new JPanel();
		mainimgPanel.setBounds(150,80, 1200, 400);
		mainimgPanel.setLayout(null);
		contentPanel.add(mainimgPanel);
        
        mainimgPanel.add(button1);
        mainimgPanel.add(button2);
        mainimgPanel.add(button3);
        
        logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
        
        vehregButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!bool) {
					JOptionPane.showMessageDialog(null,"you have to Login first");
				}
				else {
					new VehicleRegistration_1();
				}
			}
		});
        
        licButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!bool) {
					JOptionPane.showMessageDialog(null,"you have to Login first");
				}
				else {
					new LicenseRegistration();
				};
			}
		});
        
        button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button1.isSelected()) {
					imageDecide(true,false,false,false,false);
				}
			}
		});
        
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageDecide(false,true,false,false,false);
			}
		});
        
        button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageDecide(false,false,true,false,false);
			}
		});
        
        aboutusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageDecide(false,false,false,true,false);
			}
		});
        
        contactButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageDecide(false, false, false, false, true);
			}
		});
        
        homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
		        button1.setSelected(true);
		        imageDecide(true, false, false,false,false);
			}
		});
        
		mainimgPanel.add(image1);
		
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login_form();
				dispose();
				b=true;
			}
		});
		if(b) {
			vehregButton.setEnabled(b);
			licButton.setEnabled(b);
			vehregButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VehicleRegistration_1();
				}
			});
			licButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new LicenseRegistration();
				}
			});
			
		}
		setVisible(true);
	}
	public void imageDecide(boolean pic1,boolean pic2,boolean pic3,boolean pic4,boolean pic5) {
		if(pic1) {
			image1.setIcon(new ImageIcon("D:\\javaImages\\image3.jpg"));
		}
		else if(pic2) {
			image1.setIcon(new ImageIcon("D:\\javaImages\\image2.jpg"));
		}
		else if(pic3) {
			image1.setIcon(new ImageIcon("D:\\javaImages\\image1.jpg"));
		}
		else if(pic4) {
			image1.setIcon(new ImageIcon("D:\\javaImages\\image4.png"));
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
		}
		else if(pic5) {
			image1.setIcon(new ImageIcon("D:\\javaImages\\image5.jpg"));
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
		}
	}
	public static void main(String args[]) {
		new HomePage();
	}
}
