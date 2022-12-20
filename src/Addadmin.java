import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class addadmin extends JFrame implements ActionListener {

	JLabel j1,lblemail,lblpassword;
	JTextField txtemail,txtpassword;
	JButton b1,b2;
	addadmin()
   {
	     setSize(700,700);
		 setTitle("Home page");
		 setLayout(null);
		 
		 j1=new JLabel(" ADD ADMIN");
		 j1.setBounds(100,50,200,100);
		 add(j1);
		 j1.setFont(new Font("Arial",Font.CENTER_BASELINE,30));
		 
		 lblemail=new JLabel("EMAIL");
		 lblemail.setBounds(100,120,100,50);
		 add(lblemail);
		
		 txtemail=new JTextField();
		 txtemail.setBounds(200,120,100,50);
		 add(txtemail);
		 
		 lblpassword=new JLabel("PASSWORD");
		 lblpassword.setBounds(100,190,100,50);
		 add(lblpassword);
		 
		 txtpassword=new JTextField();
		 //t3.setFont(new Font("Arial",Font.BOLD,50));
		 txtpassword.setBounds(200,190,100,50);
		 add(txtpassword);
		 
		 
		 
		 b1=new JButton("Submit");
		 b1.setBounds(100,420,100,50);
		 add(b1);
		 b1.addActionListener(this);
		 
		 b2=new JButton("Back");
		 b2.setBounds(280,420,100,50);
		 add(b2);
		 b2.addActionListener(this);
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);

   }
	public static void main(String[] args) {
		addadmin obj=new addadmin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource()==b1){
			
			if(txtemail.getText()=="ronak123" && txtpassword.getText()=="1234"){
					JOptionPane.showMessageDialog(this, "Login Successfully");	
					new Addadminone();
				}
			else{
					JOptionPane.showMessageDialog(this, "Invalid UserName or Passward");
					System.out.println(txtemail.getText());
					System.out.println(txtpassword.getText() );
				}
		}
		if (e.getSource()==b2){
			new Adminmenu();
		}
	}
					
				}
				
			
		
		
		
		
			


