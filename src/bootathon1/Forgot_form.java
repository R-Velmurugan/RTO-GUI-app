package bootathon1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class Forgot_form extends JFrame implements ActionListener{
    
    JPanel gifp,imagePanel,menuPanel,lt_iconpanel,whitepanel,drivepanel,panel2,contentPanel,internalpanel1;
    JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,loginButton,statusButton,userButton,registerButton;
    JLabel lionLabel,templeLabel,govtLabel,govtLabel2;
    static String userID;
    JButton jbtn_close,sendButton,btn_verify;
    JLabel lbl_email,lbl_code,lbl_forgot,userLabel;
    JTextField txt_email,txt_code,userField;
    Container co;
    int randomCode;
    public Forgot_form() {
        co=getContentPane();
        co.setLayout(null);

        setSize(1540,900);
        setVisible(true);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        menuPanel=new JPanel();
        menuPanel.setBounds(0,150,1950,40);
        menuPanel.setBackground(new Color(0,0,204));
        menuPanel.setBackground(Color.BLUE);
        menuPanel.setLayout(null);
        add(menuPanel);
        
        imagePanel=new JPanel();
        imagePanel.setBounds(0,0,1950,150);
        imagePanel.setBackground(Color.white);
        imagePanel.setLayout(null);
        add(imagePanel);
				
        lionLabel=new JLabel();
        lionLabel.setBounds(20, 0, 200, 200);
        lionLabel.setIcon(new ImageIcon("D:\\lion.png"));
        imagePanel.add(lionLabel);
        
        govtLabel=new JLabel("Regional Transport Office");
        govtLabel.setFont(new Font("Helvetica",Font.BOLD,20));
        govtLabel.setBounds(90,60,300,40);
        govtLabel2=new JLabel("Government of India");
        govtLabel2.setFont(new Font("Helvetica",Font.BOLD,16));
        govtLabel2.setBounds(90,100,300,20);
        imagePanel.add(govtLabel);
        imagePanel.add(govtLabel2);
        
        contentPanel=new JPanel();
        contentPanel.setBounds(0,190,1950,800);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);
        add(contentPanel);        
        
        lbl_forgot = new JLabel("FORGOT PASSWORD");
        lbl_forgot.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        lbl_forgot.setBounds(450,40,300,40);
        contentPanel.add(lbl_forgot);
        
        userLabel=new JLabel("Enter username");
        userLabel.setBounds(240,90,200,35);
        userLabel.setFont(new Font("Arial",Font.BOLD,24));
        userLabel.setForeground(Color.BLACK);
        contentPanel.add(userLabel);
        
        userField=new JTextField();
        userField.setBounds(240, 135, 500, 35);
        userField.setFont(new Font("Arial",0,16));
        contentPanel.add(userField);
        
        lbl_email = new JLabel("Enter Email");
        lbl_email.setBounds(240,220,200,35);
        lbl_email.setFont(new Font("Arial",Font.BOLD,24));
        lbl_email.setForeground(Color.BLACK);
        contentPanel.add(lbl_email);
        
        txt_email = new JTextField();
        txt_email.setBounds(240,265,500,35);
        txt_email.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_email); 
        
        sendButton = new JButton("Send Code");
        sendButton.setBackground(new java.awt.Color(34, 167, 240));
        sendButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendButton.setBounds(825,265,150,35);
        contentPanel.add(sendButton);
        
        lbl_code = new JLabel("Enter Code");
        lbl_code.setBounds(240, 350, 180, 35);
        lbl_code.setFont(new Font("Arial",Font.BOLD,24));
        lbl_code.setForeground(Color.BLACK);
        contentPanel.add(lbl_code);        
        
        txt_code = new JTextField();
        txt_code.setBounds(240,405,500,35);
        txt_code.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_code);
        
        btn_verify = new JButton("Verify Code");
        btn_verify.setBackground(new java.awt.Color(34, 167, 240));
        btn_verify.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btn_verify.setForeground(new java.awt.Color(255, 255, 255));
        btn_verify.setBounds(825,405,150,35);
        contentPanel.add(btn_verify);
        
        sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            try{
	                String str_email=txt_email.getText();
	                userID=userField.getText();
	                System.out.println(userID);
	                Pattern pattern = Pattern.compile("^[a-zA-Z0-9.]+[@][a-z]+[.][a-z]{2,3}$");
	                Matcher matcher = pattern.matcher(str_email);
	                if(matcher.matches()!=true) {
	                	JOptionPane.showMessageDialog(null, "Add A valid email id");
	                }	
	                
	                Random rand = new Random();
	                randomCode = rand.nextInt(999999);
	                System.out.println(randomCode);
	            
	        		final String username = "javamuruganr@gmail.com";
	        		final String password = "javaMuruganR1506";
	                final String from = "javaperson1506@gmail.com";
	                final String to = str_email;
	        		Properties props = new Properties();
	        		props.put("mail.smtp.host", "smtp.gmail.com");
	        		props.put("mail.smtp.socketFactory.port", "465");
	        		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        		props.put("mail.smtp.auth", "true");
	        		props.put("mail.smtp.port", "465");	                        
	                Authenticator a =new Authenticator() {
	                     @Override
	                     protected PasswordAuthentication getPasswordAuthentication() {
	                    	 return new PasswordAuthentication(username, password);
	                     }  
	                };
	                        Session session = Session.getInstance(props, a);
	                try {
	                	Message message = new MimeMessage(session);
	                	message.setFrom(new InternetAddress(from));
	                	message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
	                	message.setSubject("Reset Password");
	                	message.setText("Your reset code is "+randomCode);
	                	Transport.send(message);
	                	System.out.println("Code has been sent to the email");
	                }
	                catch (MessagingException exc) {
	                	System.out.println(e);
	                }            
	            }
	            catch(Exception ex){
	            	JOptionPane.showMessageDialog(rootPane, ex);
	            }
			}
		});

        btn_verify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(Integer.valueOf(txt_code.getText())==randomCode){
                	new ChangePassword_form();
                	dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Code does not match");
                }
            }
        });
        
        jbtn_close=new JButton("Back");
        jbtn_close.setBackground(new java.awt.Color(242, 38, 19));
        jbtn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jbtn_close.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_close.setBounds(400,550,100,50);
        contentPanel.add(jbtn_close);
        
        jbtn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	new Login_form();
            	dispose();
            }
        });
        
     }

	@Override
	public void actionPerformed(ActionEvent e) {
	} 
}

