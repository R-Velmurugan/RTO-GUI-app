package bootathon1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import static bootathon1.Forgot_form.userID;

public class ChangePassword_form extends JFrame implements ActionListener{
    JButton jbtn_close,btn_reset;
    JLabel lbl_pword,lbl_cpword,lbl_change;
    JTextField txt_pword,txt_cpword;
    Container co;    
    JPanel gifp,imagePanel,menuPanel,lt_iconpanel,whitepanel,drivepanel,panel2,contentPanel,internalpanel1;
    JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,loginButton,statusButton,userButton,registerButton;
    JLabel lionLabel,templeLabel,govtLabel,govtLabel2;
    String email;
    public ChangePassword_form() {
        co=getContentPane();
        co.setLayout(null);
        setSize(1950, 1950);
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        userButton=new JButton("Hey ");
        userButton.setBounds(700,0,80,35);
        userButton.setFocusable(false);
        userButton.setOpaque(false);
        userButton.setForeground(Color.WHITE);
        userButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        userButton.setBorder(null);
        userButton.setBackground(new Color(0,0,0,10));
        
        statusButton=new JButton("View Status");
        statusButton.setBounds(790,0,80,35);
        statusButton.setFocusable(false);
        statusButton.setOpaque(false);
        statusButton.setForeground(Color.WHITE);
        statusButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        statusButton.setBorder(null);
        statusButton.setBackground(new Color(0,0,0,10));
        
        loginButton=new JButton("Login");
        loginButton.setBounds(879,0,60,35);
        loginButton.setFocusable(false);
        loginButton.setOpaque(false);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        loginButton.setBorder(null);
        loginButton.setBackground(new Color(0,0,0,10));
				
        contactButton=new JButton("Contact us");
        contactButton.setBounds(939,0,80,35);
        contactButton.setFocusable(false);
        contactButton.setOpaque(false);
        contactButton.setForeground(Color.WHITE);
        contactButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        contactButton.setBorder(null);
        contactButton.setBackground(new Color(0,0,0,10));
        
        vehregButton=new JButton("Vehicle Registration");
        vehregButton.setBounds(1029,0,150,35);
        vehregButton.setFocusable(false);
        vehregButton.setOpaque(false);
        vehregButton.setForeground(Color.WHITE);
        vehregButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        vehregButton.setBorder(null);
        vehregButton.setBackground(new Color(0,0,0,10));
			
        licButton=new JButton("License Registration");
        licButton.setBounds(1189,0,150,35);
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
				
        aboutusButton=new JButton("About us");
        aboutusButton.setBounds(1349,0,80,35);
        aboutusButton.setFocusable(false);
        aboutusButton.setOpaque(false);
        aboutusButton.setForeground(Color.WHITE);
        aboutusButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        aboutusButton.setBorder(null);
        aboutusButton.setBackground(new Color(0,0,0,10));
        
        menuPanel=new JPanel();
        menuPanel.setBounds(0,150,1950,40);
        menuPanel.setBackground(new Color(0,0,204));
        menuPanel.setBackground(Color.BLUE);
        menuPanel.setLayout(null);
        add(menuPanel);
        menuPanel.add(logoutButton);
        menuPanel.add(aboutusButton);
        menuPanel.add(licButton);
        menuPanel.add(vehregButton);
        menuPanel.add(contactButton);
        menuPanel.add(loginButton);
        menuPanel.add(statusButton);
        menuPanel.add(userButton);
        
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
            
        lbl_change = new JLabel("RESET PASSWORD");
        lbl_change.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        lbl_change.setBounds(450,40,400,40);
        contentPanel.add(lbl_change);
        
        lbl_pword = new JLabel("Enter New Password");
        lbl_pword.setBounds(240,90,300,35);
        lbl_pword.setFont(new Font("Arial",Font.BOLD,24));
        lbl_pword.setForeground(Color.BLACK);
        contentPanel.add(lbl_pword);
        
        txt_pword = new JTextField();
        txt_pword.setBounds(240,135,700,35);
        txt_pword.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_pword); 
        
        lbl_cpword = new JLabel("Confirm Password");
        lbl_cpword.setBounds(240, 180, 300, 35);
        lbl_cpword.setFont(new Font("Arial",Font.BOLD,24));
        lbl_cpword.setForeground(Color.BLACK);
        contentPanel.add(lbl_cpword);
        
        txt_cpword = new JTextField();
        txt_cpword.setBounds(240,225,700,35);
        txt_cpword.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_cpword);
        
        jbtn_close=new JButton("Cancel");
        jbtn_close.setBackground(new java.awt.Color(242, 38, 19));
        jbtn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jbtn_close.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_close.setBounds(400,550,100,50);
        contentPanel.add(jbtn_close);
        
        jbtn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.exit(0);
            }
        });
        
        btn_reset = new JButton("Reset");
        btn_reset.setBackground(new java.awt.Color(34, 167, 240));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.setBounds(650, 550, 100, 50);
        contentPanel.add(btn_reset);
        btn_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            try {
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	                Connection con=DriverManager.getConnection(<your db password>);
	                String password = txt_pword.getText();
	                String cpassword = String.valueOf(txt_cpword.getText());
	                java.sql.Statement stmt=con.createStatement();
	                PreparedStatement pst = null;
	                String email = null;
	                System.out.println(password);
	                System.out.println(cpassword);
                    System.out.println(userID);
	                if(password.equals(cpassword)){
	                    try{
	                        String updateQuery = " UPDATE user_details SET password='"+password+"' where username='"+userID+"'";
	                        System.out.println(userID);
//	                        pst=con.prepareStatement(updateQuery);
//	                        pst.setString(1, cpassword);
//	                        pst.setString(2, email);	                        
//	                        pst.executeUpdate();
	                        stmt.execute(updateQuery);
	                        JOptionPane.showMessageDialog(null, "Reset Successfully");
	                    }
	                    catch(Exception ex){
	                        JOptionPane.showMessageDialog(null, ex);
	                        System.out.println(ex);
	                    }
	                }
	                else{
	                    JOptionPane.showMessageDialog(null, "password do not match");
	                }
	            }
	            catch(Exception ex){
	                JOptionPane.showMessageDialog(null, ex.toString());
	            }
			}
		});
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
}



















