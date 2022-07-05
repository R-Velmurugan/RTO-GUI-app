package bootathon1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LicenseRegistration extends JFrame{
	JPanel imagePanel,contentPanel,menuPanel;
	JLabel lionLabel,govtLabel,govtLabel2;
	JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,statusButton,userButton,registerButton;
	JLabel lbl_gender,lbl_addrs,imageLabel,applicantName,dobLabel,userIdLabel,cityLabel,LicenseTypeLabel,emailIdLabel,emailLabel;
	static JTextField txt_addrs,applicantNameField,dobField,userIdField,cityField,emailIdField;
	static String vehicleType;
    static  String str_gender="";
	JLabel regexName,regexUser,regexCity,regexDate,regexemail,regexType,regexAddre;
	ButtonGroup btngroup;
    JRadioButton rdb_male,rdb_female,rdb_other;
	boolean [] array= {false,false,false,false,false,false,false};
	public static final int bool1=0,bool2=1,bool3=2,bool4=3,bool5=4,bool6=5,bool7=6,bool8=7;
	JRadioButton twoWheeler,fourWheeler;
	ButtonGroup check;
	public LicenseRegistration() {
		setSize(1950,1950);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		userButton=new JButton("Hey "+username);
		userButton.setBounds(1040,0,80,35);
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
		
		licButton=new JButton("License Registration");
		licButton.setBounds(1280,0,150,35);
		licButton.setFocusable(false);
		licButton.setOpaque(false);
		licButton.setForeground(Color.WHITE);
		licButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		licButton.setBorder(null);
		licButton.setBackground(new Color(0,0,0,10));
		licButton.setEnabled(false);
		
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
		
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HomePage();
			}
		});
		
		vehregButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VehicleRegistration_1();
			}
		});
		
		lionLabel=new JLabel();
		lionLabel.setBounds(20, 0, 200, 200);
		lionLabel.setIcon(new ImageIcon("D:\\lion.png"));
		
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
		
		contentPanel=new JPanel();
		contentPanel.setBounds(0,190,1539,800);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		add(contentPanel);
		
		applicantName=new JLabel("Enter the Applicant Name :");
		applicantName.setBounds(240,40,190,25);
		
		applicantNameField=new JTextField();
		applicantNameField.setBounds(240,65,700,30);
		
		regexName=new JLabel();
		regexName.setBounds(240,100, 500, 10);
		regexName.setFont(new Font("Consolas",Font.ITALIC,10));
		regexName.setForeground(Color.RED);
		
		applicantNameField.getDocument().addDocumentListener(new TextListener() {

			public void  update(DocumentEvent e){
				Pattern namePattern=Pattern.compile("^[a-zA-Z]{1,15}$");
				Matcher matchName=namePattern.matcher(applicantNameField.getText());
				array[bool1]=matchName.matches();
				if(array[bool1]) regexName.setText(" ");
				else regexName.setText("*invalid name");
				enableRegister();
			}
			
		});
		contentPanel.add(applicantName);
		contentPanel.add(applicantNameField);
		contentPanel.add(regexName);
		
		regexUser=new JLabel();
		regexUser.setBounds(240,170, 500, 10);
		regexUser.setFont(new Font("Consolas",Font.ITALIC,10));
		regexUser.setForeground(Color.RED);
		contentPanel.add(regexUser);
		
		emailIdLabel=new JLabel("Enter the Email id");
		emailIdLabel.setBounds(240, 110, 180, 25);
		contentPanel.add(emailIdLabel);
		
		emailIdField=new JTextField();
		emailIdField.setBounds(240, 135, 700, 30);
		contentPanel.add(emailIdField);
		
		regexemail=new JLabel();
		regexemail.setBounds(240,170, 500, 10);
		regexemail.setFont(new Font("Consolas",Font.ITALIC,10));
		regexemail.setForeground(Color.RED);
		contentPanel.add(regexemail);
		
		emailIdField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern emailPattern=Pattern.compile("^[a-zA-Z0-9.]+[@][a-z]+[.][a-z]{2,3}$");
				Matcher matchEmail=emailPattern.matcher(emailIdField.getText());
				array[bool2]=matchEmail.matches();
				if(array[bool2]) regexemail.setText(" ");
				else regexemail.setText("*invalid mail id");
				enableRegister();
			}
		});
		
        lbl_gender=new JLabel("Select the Gender");
        lbl_gender.setBounds(240,180,110,25);
        lbl_gender.setForeground(Color.BLACK);
        contentPanel.add(lbl_gender);       
           
        btngroup=new ButtonGroup();
        
        rdb_male=new JRadioButton("Male");
        rdb_male.setBounds(370, 180, 70, 25);
        rdb_male.setForeground(Color.BLACK);
        contentPanel.add(rdb_male); 
        
        rdb_female=new JRadioButton("Female");
        rdb_female.setBounds(440, 180, 70, 25);
        rdb_female.setForeground(Color.BLACK);
        contentPanel.add(rdb_female);
        
        rdb_other=new JRadioButton("Other");
        rdb_other.setBounds(510,180,70,25);
        rdb_other.setForeground(Color.BLACK);
        contentPanel.add(rdb_other);        

        btngroup.add(rdb_male);
        btngroup.add(rdb_female);
        btngroup.add(rdb_other);
                
        rdb_male.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		array[bool3]=rdb_male.isSelected();
        		enableRegister();
        	}
        });
        rdb_female.addActionListener(new ActionListener() {	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		array[bool3]=rdb_female.isSelected();
        		enableRegister();
        	}
        });
        rdb_other.addActionListener(new ActionListener() {	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		array[bool3]=rdb_other.isSelected();
        		enableRegister();
        	}
        });
        
		dobLabel=new JLabel("Enter the dob");
		dobLabel.setBounds(240,220,180,25);
		contentPanel.add(dobLabel);
		
		dobField=new JTextField();
		dobField.setBounds(240,245,700,30);
		contentPanel.add(dobField);
		
		regexDate=new JLabel();
		regexDate.setBounds(240, 280, 500, 10);
		regexDate.setFont(new Font("Consolas",Font.ITALIC,10));
		regexDate.setForeground(Color.RED);
		contentPanel.add(regexDate);
		
		dobField.getDocument().addDocumentListener(new TextListener() {
			@Override
			public void update(DocumentEvent e) {
				Pattern datePattern=Pattern.compile("^((0?[1-9])|([1][0-9])|([2][0-9])|([3][01]))/(0?[1-9]|[1][012])/(([1][9][0-9]{2})|([2][0][0-9]{2}))$");
				Matcher matchdate=datePattern.matcher(dobField.getText());
				array[bool4]=matchdate.matches();
				if(array[bool4]) regexDate.setText(" ");
				else regexDate.setText("*invalid date");
				enableRegister();
			}
		});
		
		cityLabel=new JLabel("Enter the City");
		cityLabel.setBounds(240,290,90,25);
		contentPanel.add(cityLabel);
		
		cityField=new JTextField();
		cityField.setBounds(240,315,700,30);
		contentPanel.add(cityField);
		
		regexCity=new JLabel();
		regexCity.setBounds(240,350, 500, 10);
		regexCity.setFont(new Font("Consolas",Font.ITALIC,10));
		regexCity.setForeground(Color.RED);
		contentPanel.add(regexCity);
		
		cityField.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern cityPattern=Pattern.compile("^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$");
				Matcher matchCity=cityPattern.matcher(cityField.getText());
				array[bool5]=matchCity.matches();
				if(array[bool5]) regexCity.setText(" ");
				else regexCity.setText("*invalid city name");
				enableRegister();
			}
		});
		
		lbl_addrs=new JLabel("Enter the Address");
		lbl_addrs.setBounds(240,405,400,25);
		lbl_addrs.setForeground(Color.BLACK);
		contentPanel.add(lbl_addrs);
		        
		txt_addrs=new JTextField();
		txt_addrs.setBounds(240,430,225,50);
		contentPanel.add(txt_addrs);
                    
        regexAddre=new JLabel();
		regexAddre.setBounds(240,465, 500, 10);
		regexAddre.setFont(new Font("Consolas",Font.ITALIC,10));
		regexAddre.setForeground(Color.RED);
		contentPanel.add(regexAddre);
		
		txt_addrs.getDocument().addDocumentListener(new TextListener() {
			
			@Override
			public void update(DocumentEvent e) {
				Pattern cityPattern=Pattern.compile("^[#.0-9a-zA-Z\\s,-]+$");
				Matcher matchCity=cityPattern.matcher(txt_addrs.getText());
				array[bool6]=matchCity.matches();
				if(array[bool6]) regexAddre.setText(" ");
				else regexAddre.setText("*invalid address ");
				enableRegister();
			}
		});   
                        
                        
		LicenseTypeLabel=new JLabel("Vehicle type");
		LicenseTypeLabel.setBounds(240,360,70,25);
		contentPanel.add(LicenseTypeLabel);
		
        regexType=new JLabel();
        regexType.setBounds(240, 395, 500, 10);
		regexType.setFont(new Font("Consolas",Font.ITALIC,10));
		regexType.setForeground(Color.RED);
		contentPanel.add(regexType);
		
        check=new ButtonGroup();
        twoWheeler=new JRadioButton("Two wheeler");
        fourWheeler=new JRadioButton("Four wheeler");
        twoWheeler.setBounds(330, 360, 100, 25);
        fourWheeler.setBounds(430, 360, 100, 25);
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
        
		registerButton = new JButton("Apply");
		registerButton.setBounds(700,550,90,25);
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
				}
				else if(fourWheeler.isSelected()) {
					vehicleType="Four wheeler";
				}
				if(rdb_male.isSelected()) {
					str_gender="Male";
				}
				else if(rdb_female.isSelected()) {
					str_gender="Female";
				}
				else if(rdb_other.isSelected()) {
					str_gender="Other";
				}
				new LicenseDatabase();
				new AddVehicle(username,1);
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
