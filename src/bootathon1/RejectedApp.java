package bootathon1;

import static bootathon1.VehicleReg.rejlst;
import static bootathon1.AddVehicle.vehicleList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class RejectedApp extends JFrame{
	public RejectedApp() {
		getContentPane().setBackground(Color.white);
		JLabel l3=new JLabel("UserId");
		l3.setBounds(60,32,120,30);
		l3.setFont(new Font("Helvetica",Font.PLAIN,20));
		JLabel l4=new JLabel("Status");
		l4.setBounds(330,32,100,30);
		l4.setFont(new Font("Helvetica",Font.PLAIN,20));
		JPanel menu=new JPanel();
		menu.setBounds(0,28,500,40);
		menu.setBackground(Color.blue);
		int dim=50;
		for(String s : rejlst) {
			JLabel l1=new JLabel(s);
			l1.setBounds(60,dim+=30,200,30);
			l1.setFont(new Font("Helvetica",Font.LAYOUT_LEFT_TO_RIGHT,15));
			JLabel l2=new JLabel("Rejected");
			l2.setFont(new Font("Helvetica",Font.LAYOUT_LEFT_TO_RIGHT,15));
			l2.setBounds(330,dim,150,30);
			add(l1);add(l2);
		}
		add(l3);add(l4);add(menu);
		setLayout(null);
		setTitle("Rejected Applications");
		setSize(500,500);
		setBounds(440,220,500,500);
		setVisible(true);
	}
}