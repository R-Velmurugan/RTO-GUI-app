package bootathon1;
import static bootathon1.HomePage.bool;
import static bootathon1.Login_form.username;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static bootathon1.Login_form.username;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VehicleRegistration_1 extends JFrame{
	JPanel imagePanel,contentPanel,menuPanel;
	JLabel lionLabel,templeLabel,govtLabel,govtLabel2;
	JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,loginButton,statusButton,userButton,registerButton;
	JLabel imageLabel,ownerNameLabel,regDateLabel,regNumberLabel,modelNameLabel,vehicleTypeLabel,chassisNumberLabel,emailLabel;
	static JTextField ownerNameField,regDateField,regNumberField,modelNameField,chassisNumberField,emailField;
	static String vehicleType;
	JLabel regexName,regexRegNumber,regexChassis,regexDate,regexModel,regexType,regexEmail;
	boolean [] array= {false,false,false,false,false,false,false};
	public static final int bool1=0,bool2=1,bool3=2,bool4=3,bool5=4,bool6=5,bool7=6;
	JRadioButton twoWheeler,fourWheeler;
	ButtonGroup check;
	public VehicleRegistration_1() {
		setSize(1540,900);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		userButton=new JButton("Hey "+username);
		userButton.setBounds(1050,0,80,35);
		userButton.setFocusable(false);
		userButton.setOpaque(false);
		userButton.setForeground(Color.WHITE);
		userButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		userButton.setBorder(null);
		userButton.setBackground(new Color(0,0,0,10));
		
		vehregButton=new JButton("Vehicle Registration");
		vehregButton.setBounds(1120,0,150,35);
		vehregButton.setFocusable(false);
		vehregButton.setOpaque(false);
		vehregButton.setForeground(Color.WHITE);
		vehregButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		vehregButton.setBorder(null);
		vehregButton.setBackground(new Color(0,0,0,10));
		vehregButton.setEnabled(false);
		
		licButton=new JButton("License Registration");
		licButton.setBounds(1280,0,150,35);
		licButton.setFocusable(false);
		licButton.setOpaque(false);
		licButton.setForeground(Color.WHITE);
		licButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		licButton.setBorder(null);
		licButton.setBackground(new Color(0,0,0,10));
		
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(1429,0,80,35);
		logoutButton.setFocusable(false);
		logoutButton.setOpaque(false);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		logoutButton.setBorder(null);
		logoutButton.setBackground(new Color(0,0,0,10));
		
		menuPanel=new JPanel();
		menuPanel.setBounds(0,150,1540,40);
		menuPanel.setBackground(new Color(0,0,204));
		menuPanel.setBackground(Color.BLUE);
		menuPanel.setLayout(null);
		add(menuPanel);
		menuPanel.add(logoutButton);
		menuPanel.add(licButton);
		menuPanel.add(vehregButton);
		menuPanel.add(userButton);
		
		lionLabel=new JLabel();
		lionLabel.setBounds(20, 0, 200, 200);
		lionLabel.setIcon(new ImageIcon("D:\\lion.png"));
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HomePage();
			}
		});
		
		licButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LicenseRegistration();
			}
		});
		
		govtLabel=new JLabel("Regional Transport Office");
		govtLabel.setFont(new Font("Helvetica",Font.BOLD,20));
		govtLabel.setBounds(90,60,300,40);
		govtLabel2=new JLabel("Government of India");
		govtLabel2.setFont(new Font("Helvetica",Font.BOLD,16));
		govtLabel2.setBounds(90,100,300,20);

		imagePanel=new JPanel();
		imagePanel.setBounds(0,0,1539,150);
		imagePanel.setBackground(Color.white);
		imagePanel.setLayout(null);
		add(imagePanel);
		imagePanel.add(lionLabel);
		imagePanel.add(govtLabel);
		imagePanel.add(govtLabel2);
		
		ownerNameLabel=new JLabel("Owner Name:");
		ownerNameLabel.setBounds(240,40,90,25);
		
		ownerNameField=new JTextField();
		ownerNameField.setBounds(240,65,700,30);
		
		regexName=new JLabel();
		regexName.setBounds(240,100, 500, 10);
		regexName.setFont(new Font("Consolas",Font.ITALIC,10));
		regexName.setForeground(Color.RED);
		
		ownerNameField.getDocument().addDocumentListener(new TextListener() {

			public void  update(DocumentEvent e){
				Pattern namePattern=Pattern.compile("^[a-zA-Z]{1,15}$");
				Matcher matchName=namePattern.matcher(ownerNameField.getText());
				array[bool1]=matchName.matches();
				if(array[bool1]) regexName.setText(" ");
				else regexName.setText("*invalid name");
				enableRegister();
			}
			
		});
		contentPanel=new JPanel();
		contentPanel.setBounds(0,190,1539,800);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		add(contentPanel);
		contentPanel.add(ownerNameLabel);
		contentPanel.add(ownerNameField);
		contentPanel.add(regexName);
		
		regNumberLabel=new JLabel("Registration number");
		regNumberLabel.setBounds(240, 110, 180, 25);
		contentPanel.add(regNumberLabel);
		
		regNumberField=new JTextField();
		regNumberField.setBounds(240,135,700,30);
		contentPanel.add(regNumberField);
		
		regexRegNumber=new JLabel();
		regexRegNumber.setBounds(240,170, 500, 10);
		regexRegNumber.setFont(new Font("Consolas",Font.ITALIC,10));
		regexRegNumber.setForeground(Color.RED);
		contentPanel.add(regexRegNumber);
		
		regNumberField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern regPattern=Pattern.compile("^[T][N][0-9]{2}[A-Z]{2}[0-9]{4}$");
				Matcher matchRegNum=regPattern.matcher(regNumberField.getText());
				array[bool2]=matchRegNum.matches();
				if(array[bool2]) regexRegNumber.setText(" ");
				else regexRegNumber.setText("*invalid Registration number");
				enableRegister();
			}
		});
		
		chassisNumberLabel=new JLabel("Chassis number");
		chassisNumberLabel.setBounds(240, 180, 180, 25);
		contentPanel.add(chassisNumberLabel);
		
		chassisNumberField=new JTextField();
		chassisNumberField.setBounds(240, 205, 700, 30);
		contentPanel.add(chassisNumberField);
		
		regexChassis=new JLabel();
		regexChassis.setBounds(240,240, 500, 10);
		regexChassis.setFont(new Font("Consolas",Font.ITALIC,10));
		regexChassis.setForeground(Color.RED);
		contentPanel.add(regexChassis);
		
		chassisNumberField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern chassisPattern=Pattern.compile("^[A-Z0-9]{17}$");
				Matcher matchChassis=chassisPattern.matcher(chassisNumberField.getText());
				array[bool3]=matchChassis.matches();
				if(array[bool3]) regexChassis.setText(" ");
				else regexChassis.setText("*invalid Chassis number");
				enableRegister();
			}
		});
		
		regDateLabel=new JLabel("Registration date");
		regDateLabel.setBounds(240,250,180,25);
		contentPanel.add(regDateLabel);
		
		regDateField=new JTextField();
		regDateField.setBounds(240,275,700,30);
		contentPanel.add(regDateField);
		
		regexDate=new JLabel();
		regexDate.setBounds(240, 310, 500, 10);
		regexDate.setFont(new Font("Consolas",Font.ITALIC,10));
		regexDate.setForeground(Color.RED);
		contentPanel.add(regexDate);
		
		regDateField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern datePattern=Pattern.compile("^((0?[1-9])|([1][0-9])|([2][0-9])|([3][01]))/(0?[1-9]|[1][012])/(([1][9][0-9]{2})|([2][0][0-9]{2}))$");
				Matcher matchdate=datePattern.matcher(regDateField.getText());
				array[bool4]=matchdate.matches();
				if(array[bool4]) regexDate.setText(" ");
				else regexDate.setText("*invalid date");
				enableRegister();
			}
		});
		
		modelNameLabel=new JLabel("Model Name:");
		modelNameLabel.setBounds(240,320,90,25);
		contentPanel.add(modelNameLabel);
		
		modelNameField=new JTextField();
		modelNameField.setBounds(240,350,700,30);
		contentPanel.add(modelNameField);
		
		regexModel=new JLabel();
		regexModel.setBounds(240,385, 500, 10);
		regexModel.setFont(new Font("Consolas",Font.ITALIC,10));
		regexModel.setForeground(Color.RED);
		contentPanel.add(regexModel);
		
		modelNameField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern modelPattern=Pattern.compile("^[a-zA-Z0-9]{1,15}$");
				Matcher matchModel=modelPattern.matcher(modelNameField.getText());
				array[bool5]=matchModel.matches();
				if(array[bool5]) regexChassis.setText(" ");
				else regexChassis.setText("*invalid model name");
				enableRegister();
			}
		});
		
		vehicleTypeLabel=new JLabel("Vehicle type");
		vehicleTypeLabel.setBounds(240,395,70,25);
		contentPanel.add(vehicleTypeLabel);
		
        regexType=new JLabel();
        regexType.setBounds(240, 425, 500, 10);
		regexType.setFont(new Font("Consolas",Font.ITALIC,10));
		regexType.setForeground(Color.RED);
		contentPanel.add(regexType);
		
        check=new ButtonGroup();
        twoWheeler=new JRadioButton("Two wheeler");
        fourWheeler=new JRadioButton("Four wheeler");
        twoWheeler.setBounds(330, 395, 100, 25);
        fourWheeler.setBounds(430, 395, 100, 25);
        check.add(twoWheeler);
        check.add(fourWheeler);
        contentPanel.add(twoWheeler);
        contentPanel.add(fourWheeler);
        
        twoWheeler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				array[bool7]=twoWheeler.isSelected();
				enableRegister();
			}
		});
        fourWheeler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				array[bool7]=fourWheeler.isSelected();
				enableRegister();
			}
		});
        
		emailLabel=new JLabel("e-mail");
		emailLabel.setBounds(240,435,180,25);
		contentPanel.add(emailLabel);
		
		emailField=new JTextField();
		emailField.setBounds(240, 465, 700, 30);
		contentPanel.add(emailField);
		
		regexEmail=new JLabel();
		regexEmail.setBounds(350,495,300,10);
		regexEmail.setFont(new Font("Consolas",Font.ITALIC,10));
		regexEmail.setForeground(Color.RED);
		contentPanel.add(regexEmail);
		
		emailField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern mailPattern=Pattern.compile("^[a-zA-Z0-9.]+[@][a-z]+[.][a-z]{2,3}$");
				Matcher matchMail=mailPattern.matcher(emailField.getText());
				array[bool6]=matchMail.matches();
				if(array[bool6]) regexEmail.setText(" ");
				else regexEmail.setText("*invalid email");
				enableRegister();
			}
		});
		
		registerButton = new JButton("Register");
		registerButton.setBounds(700,600,90,25);
		registerButton.setFocusable(false);
		registerButton.setForeground(Color.WHITE);
		registerButton.setBackground(Color.BLUE);
		contentPanel.add(registerButton);
		registerButton.setEnabled(false);

		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(twoWheeler.isSelected()) {
					vehicleType="Two wheeler";
					regexType.setText(" ");
				}
				else if(fourWheeler.isSelected()) {
					vehicleType="Four wheeler";
					regexType.setText(" ");
				}
				new AddVehicle(username);
				new VehicleDatabase();
			}
		});
		setVisible(true);
		
	}	
	private void enableRegister() {
		boolean checkState=true;
		for(boolean i:array) {
			if(!i) {
				checkState=false;
				break;
			}
		}
//		System. out.println(Arrays.toString(array));
		if((array[6]==false)&&(array[0]&&array[1]&&array[2]&&array[3]&&array[4]&&array[5])) regexType.setText("*This field is mandatory");
		registerButton.setEnabled(checkState);
	}
	public static interface TextListener extends DocumentListener {
	    void update(DocumentEvent e);
	    @Override
	    default void insertUpdate(DocumentEvent e) {
	        update(e);
	    }
	    @Override
	    default void removeUpdate(DocumentEvent e) {
	        update(e);
	    }
	    @Override
	    default void changedUpdate(DocumentEvent e) {
	        update(e);
	    }
	}
}


