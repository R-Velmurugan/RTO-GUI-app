package bootathon1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Reg_form extends JFrame implements ActionListener,ItemListener{
    
    JPanel gifp,imagePanel,menuPanel,lt_iconpanel,whitepanel,drivepanel,panel2,contentPanel,internalpanel1;
    JButton logoutButton,aboutusButton,vehregButton,licButton,contactButton,loginButton,statusButton,userButton,registerButton,homeButton;
    JLabel lionLabel,templeLabel,govtLabel,govtLabel2;
    
    JLabel lbl_username,lbl_password,lbl_cpassword,lbl_gender,lbl_email,lbl_phone,lbl_register,lbl_login,lbl_dob;
    JLabel lbl_date;
    JTextField txt_username,txt_email,txt_phone,txt_dob ;
    JPasswordField txt_password,txt_cpassword;
    ButtonGroup btngroup;
    JRadioButton rdb_male,rdb_female,rdb_other;
    JButton jbtn_register,jbtn_close;
    Container co;
    String str_gender="";
    
    public Reg_form(){
        co=getContentPane();
        co.setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        homeButton=new JButton("Home");
		homeButton.setBounds(939,0,70,35);
		homeButton.setFocusable(false);
		homeButton.setOpaque(false);
		homeButton.setForeground(Color.WHITE);
		homeButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		homeButton.setBorder(null);
		homeButton.setBackground(new Color(0,0,0,10));
        
        statusButton=new JButton("View Status");
        statusButton.setBounds(1019,0,80,35);
        statusButton.setFocusable(false);
        statusButton.setOpaque(false);
        statusButton.setForeground(Color.WHITE);
        statusButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        statusButton.setBorder(null);
        statusButton.setBackground(new Color(0,0,0,10));
        statusButton.setEnabled(false);
        
        vehregButton=new JButton("Vehicle Registration");
        vehregButton.setBounds(1109,0,150,35);
        vehregButton.setFocusable(false);
        vehregButton.setOpaque(false);
        vehregButton.setForeground(Color.WHITE);
        vehregButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        vehregButton.setBorder(null);
        vehregButton.setBackground(new Color(0,0,0,10));
        vehregButton.setEnabled(false);
			
        licButton=new JButton("License Registration");
        licButton.setBounds(1269,0,150,35);
        licButton.setFocusable(false);
        licButton.setOpaque(false);
        licButton.setForeground(Color.WHITE);
        licButton.setFont(new Font("Helvetica",Font.PLAIN,15));
        licButton.setBorder(null);
        licButton.setBackground(new Color(0,0,0,10));
        licButton.setEnabled(false);
        
        menuPanel=new JPanel();
        menuPanel.setBounds(0,150,1950,40);
        menuPanel.setBackground(new Color(0,0,204));
        menuPanel.setBackground(Color.BLUE);
        menuPanel.setLayout(null);
        add(menuPanel);
        menuPanel.add(licButton);
        menuPanel.add(vehregButton);
        menuPanel.add(homeButton);
        menuPanel.add(statusButton);
        
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

        homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomePage();
				dispose();
			}
		});
        
        lbl_register=new JLabel("REGISTER");
        lbl_register.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        
       
        lbl_username=new JLabel("Username");
        lbl_username.setBounds(240,40,200,25);
        lbl_username.setFont(new Font("Arial",Font.BOLD,15));
        lbl_username.setForeground(Color.BLACK);
        contentPanel.add(lbl_username);  
        
        txt_username=new JTextField();
        txt_username.setBounds(240,65,700,30);
        contentPanel.add(txt_username);
        
        lbl_password=new JLabel("Password");
        lbl_password.setBounds(240, 110, 180, 25);
        lbl_password.setFont(new Font("Arial",Font.BOLD,15));
        lbl_password.setForeground(Color.BLACK);
        contentPanel.add(lbl_password);
        
        txt_password=new JPasswordField();
        txt_password.setBounds(240,135,700,30);
        contentPanel.add(txt_password);        
        
        lbl_cpassword=new JLabel("Confirm Password");
        lbl_cpassword.setBounds(240, 180, 180, 25);
        lbl_cpassword.setFont(new Font("Arial",Font.BOLD,15));
        lbl_cpassword.setForeground(Color.BLACK);
        contentPanel.add(lbl_cpassword);

        txt_cpassword=new JPasswordField();
        txt_cpassword.setBounds(240, 205, 700, 30);
        contentPanel.add(txt_cpassword);
        
        lbl_gender=new JLabel("Gender");
        lbl_gender.setBounds(240,250,180,25);
        lbl_gender.setFont(new Font("Arial",Font.BOLD,15));
        lbl_gender.setForeground(Color.BLACK);
        contentPanel.add(lbl_gender);
        
        btngroup=new ButtonGroup();
        
        rdb_male=new JRadioButton("Male");
        rdb_male.setBounds(430, 250, 100, 25);
        rdb_male.setFont(new Font("Arial",Font.BOLD,15));
        rdb_male.setForeground(Color.BLACK);
        contentPanel.add(rdb_male); 
		        
        rdb_female=new JRadioButton("Female");
        rdb_female.setBounds(530, 250, 100, 25);
        rdb_female.setFont(new Font("Arial",Font.BOLD,15));
        rdb_female.setForeground(Color.BLACK);
        contentPanel.add(rdb_female);
		        
        rdb_other=new JRadioButton("Other");
        rdb_other.setBounds(630,250,100,25);
        rdb_other.setFont(new Font("Arial",Font.BOLD,15));
        rdb_other.setForeground(Color.BLACK);
        contentPanel.add(rdb_other);
        
        btngroup.add(rdb_male);
        btngroup.add(rdb_female);
        btngroup.add(rdb_other);

        lbl_email=new JLabel("Email");
        lbl_email.setBounds(240,290,400,25);
        lbl_email.setFont(new Font("Arial",Font.BOLD,15));
        lbl_email.setForeground(Color.BLACK);
        contentPanel.add(lbl_email);
        
        txt_email=new JTextField();
        txt_email.setBounds(240,320,700,30);
        contentPanel.add(txt_email);
        
        lbl_phone=new JLabel("Phone No");
        lbl_phone.setBounds(240,370,400,25);
        lbl_phone.setFont(new Font("Arial",Font.BOLD,15));
        lbl_phone.setForeground(Color.BLACK);
        contentPanel.add(lbl_phone);

        txt_phone=new JTextField();
        txt_phone.setBounds(240,395,700,30);
        contentPanel.add(txt_phone);
        
        jbtn_close=new JButton("Cancel");
        jbtn_close.setBackground(new java.awt.Color(242, 38, 19));
        jbtn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jbtn_close.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_close.setBounds(400,550,100,50);
        contentPanel.add(jbtn_close);
        
        jbtn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CANCELActionPerformed(evt);
            }
        });
        
        jbtn_register=new JButton("Register");
        jbtn_register.setBackground(new java.awt.Color(34, 167, 240));
        jbtn_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_register.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jbtn_register.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_register.setBounds(650, 550, 100, 50);
        contentPanel.add(jbtn_register);
        
        lbl_login=new JLabel("Click here to login!");
        lbl_login.setFont(new java.awt.Font("Tahoma", 0, 18));
        lbl_login.setBounds(500,625,225,50);
        contentPanel.add(lbl_login);
        lbl_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });
        
        rdb_male.addItemListener(this);
        rdb_female.addItemListener(this);
        rdb_other.addItemListener(this);
        jbtn_register.addActionListener(this);
        
        setSize(1950, 1950);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent ie){
        ItemSelectable itemselected=ie.getItemSelectable();
        if(itemselected==rdb_male){
                str_gender="male";
        }
        else if(itemselected==rdb_female){
                str_gender="female";
        }
        else if(itemselected==rdb_other){
                str_gender="other";
        }
    }
    private void jButton_CANCELActionPerformed(java.awt.event.ActionEvent evt) {
       System.exit(0);
    }
    public boolean checkUsername(String username)
    {
        PreparedStatement ps=null;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM user_details WHERE uname =?";
        
        try {


            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Reg_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkUser;
    }
    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        new Login_form();
        this.dispose();
    }
    public void actionPerformed(ActionEvent ae){
        Object obj_source=ae.getSource();
        if(obj_source==jbtn_register){
            try{                
                String str_username=txt_username.getText();
                String str_password=String.valueOf(txt_password.getPassword());
                String str_cpassword=String.valueOf(txt_cpassword.getPassword());
                String str_email=txt_email.getText();
                String str_phone=txt_phone.getText();                
                
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9.]+[@][a-z]+[.][a-z]{2,3}$");
                Matcher matcher = pattern.matcher(str_email);
                if(matcher.matches()!=true) {
                	JOptionPane.showMessageDialog(null, "Add A valid email id");
                }
                if(str_username.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add A Username");
                }                
                else if(str_password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add A Password");
                }                
                else if(!str_password.equals(str_cpassword)) {
                    JOptionPane.showMessageDialog(null, "Retype The Password Again");
                }
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection(<your db link and password);
                java.sql.Statement stmt=con.createStatement();
                 
                PreparedStatement pstmt=con.prepareStatement("insert into user_details values(?,?,?,?,?)");  
                pstmt.setString(1,str_username);
                pstmt.setString(2,str_password);
                pstmt.setString(3,str_gender); 
                
                pstmt.setString(4,str_email); 
                pstmt.setString(5,str_phone); 
                
                int i=pstmt.executeUpdate();  
                System.out.println(i+" account created");  
                
                con.setAutoCommit(true);
                JOptionPane.showMessageDialog(this, "Registration successful");
                new Login_form();
                this.dispose();
            }
            catch(ClassNotFoundException exception) {
            	System.out.println(exception);
            }
            catch(SQLException ex){
                int errorCode=ex.getErrorCode();
                if(errorCode==1) {
                	JOptionPane.showMessageDialog(this, "username already exists..Pick a unique name");
                }
            }
        }
    }
}

