package bootathon1;
import static bootathon1.HomePage.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Login_form  extends JFrame implements ActionListener {
    
    JPanel gifp,imagePanel,menuPanel,lt_iconpanel,whitepanel,drivepanel,panel2,contentPanel,internalpanel1;
    JButton aboutusButton,vehregButton,licButton,contactButton,loginButton,registerButton,statusButton,homeButton;
    JLabel lionLabel,govtLabel,govtLabel2;
    
    JButton closeButton,login2Button;
    JLabel lbl_login,lbl_username,lbl_password,lbl_Register,lbl_forgot;
    JPasswordField txt_password;
    JTextField txt_username;
    static String username;
    
    Container co;
    
    public Login_form() {
        co=getContentPane();
        co.setLayout(null);
        
        setSize(1540,900);
        setVisible(true);
        
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
        
        lbl_login = new JLabel("LOGIN");
        lbl_login.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        lbl_login.setBounds(450,40,200,40);
        contentPanel.add(lbl_login);
        
        lbl_username = new JLabel("USERNAME:");
        lbl_username.setBounds(240,90,200,35);
        lbl_username.setFont(new Font("Arial",Font.BOLD,24));
        lbl_username.setForeground(Color.BLACK);
        contentPanel.add(lbl_username);
        
        txt_username = new JTextField();
        txt_username.setBounds(240,135,700,35);
        txt_username.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_username);
        
        lbl_password = new JLabel("PASSWORD:");
        lbl_password.setBounds(240, 180, 180, 35);
        lbl_password.setFont(new Font("Arial",Font.BOLD,24));
        lbl_password.setForeground(Color.BLACK);
        contentPanel.add(lbl_password);
        
         
        txt_password = new JPasswordField();
        txt_password.setBounds(240,225,700,35);
        txt_password.setFont(new Font("Arial",0,16));
        contentPanel.add(txt_password);
        
        closeButton=new JButton("Cancel");
        closeButton.setBackground(new java.awt.Color(242, 38, 19));
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setBounds(400,350,100,50);
        contentPanel.add(closeButton);
        
        closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomePage();
				dispose();
			}
		});
        
        login2Button = new JButton("LOGIN");
        login2Button.setBackground(new java.awt.Color(34, 167, 240));
        login2Button.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        login2Button.setForeground(new java.awt.Color(255, 255, 255));
        login2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login2Button.setBounds(650, 350, 100, 50);
        contentPanel.add(login2Button);

        lbl_Register = new JLabel("Click here to create a new account");
        lbl_Register.setFont(new java.awt.Font("Tahoma", 0, 16));
        lbl_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Register.setBounds(450, 550, 250, 50);
        contentPanel.add(lbl_Register);
        
        lbl_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	new Reg_form();
                dispose();
            }
        });
        
        lbl_forgot = new JLabel("Forgot Password");
        lbl_forgot.setFont(new java.awt.Font("Tahoma", Font.ITALIC, 16));
        lbl_forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_forgot.setBounds(240, 270, 250, 50);
        contentPanel.add(lbl_forgot);
        
        lbl_forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jLabel_forgotMouseClicked(evt);
                new Forgot_form();
                dispose();
            }
        });
        login2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            try {
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	                Connection con=DriverManager.getConnection(<db link and password>);
	                PreparedStatement ps;
	                username = txt_username.getText();
	                String password = String.valueOf(txt_password.getPassword());
	                java.sql.Statement stmt=con.createStatement();
	                
	                String query = "SELECT * FROM user_details WHERE userName ='"+username+"' AND password = '"+password+"'";
	                stmt.execute(query);
	                ResultSet rs = stmt.executeQuery(query);
	            
	                if(rs.next()) {
	                	if(username.equals("admin") && password.equals("password")){
	                		new Admin();
		                	JOptionPane.showMessageDialog(null, "Welcome back Admin");
	                		dispose();
	                	}
	                	else {
		                	JOptionPane.showMessageDialog(null, "You have Logged In Succesfully");	                
		                	System.out.println(username);
		                	bool=true;
		                	new HomePage();
		                	dispose();
	                	}
	                }
	                else{
	                	JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
	                }
	            }    
	        
	            catch (Exception ex) {
	            	Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
	            }
			}
		});
        
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

