import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {

	JLabel j1;
	JButton b1,b2;
	 Home()
	 {
		 setSize(700,700);
		 setTitle("Home page");
		 setLayout(null);
		 
		 j1=new JLabel("EMPLOYEE SALARY CALCULATION");
		 j1.setBounds(100,100,400,100);
		 add(j1);
		 j1.setFont(new Font("Arial",Font.BOLD,20));
		 
		 b1=new JButton("ADMIN");
		 b1.setBounds(100,200,200,100);
		 add(b1);
		 b1.setFont(new Font("Arial",Font.BOLD,40));
	     b1.addActionListener(this);
		 
		 b2=new JButton("USER");
		 b2.setBounds(350,200,200,100);
		 add(b2);
		 b2.setFont(new Font("Arial",Font.BOLD,40));
		 b2.addActionListener(this);
		 
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);
	 }
	public static void main(String[] args) {
		Home obj=new Home();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b2) {
			new Userlogin();
		}
		if (e.getSource()==b1) {
			new Adminlogin();
		}
		

	}

}
