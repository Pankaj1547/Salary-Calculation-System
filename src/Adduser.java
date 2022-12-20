import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Adduser extends JFrame implements ActionListener {

	JLabel j1,j2,j3;
	JTextField t2,t3;
	JButton b1,b2;
	Adduser()
   {
	     setSize(700,700);
		 setTitle("Home page");
		 setLayout(null);
		 
		 j1=new JLabel(" ADD ADMIN");
		 j1.setBounds(100,50,200,100);
		 add(j1);
		 j1.setFont(new Font("Arial",Font.CENTER_BASELINE,30));
		 
		 j2=new JLabel("EMAIL");
		 j2.setBounds(100,120,100,50);
		 add(j2);
		
		 t2=new JTextField();
		 t2.setBounds(200,120,100,50);
		 add(t2);
		 
		 j3=new JLabel("PASSWORD");
		 j3.setBounds(100,190,100,50);
		 add(j3);
		 
		 t3=new JTextField();
		 //t3.setFont(new Font("Arial",Font.BOLD,50));
		 t3.setBounds(200,190,100,50);
		 add(t3);
		 
		 b1=new JButton("Submit");
		 b1.setBounds(100,260,100,50);
		 add(b1);
		 b1.addActionListener(this);
		 
		 b2=new JButton("Back");
		 b2.setBounds(280,260,100,50);
		 add(b2);
		 b2.addActionListener(this);
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);

   }
	public static void main(String[] args) {
		Adduser obj=new Adduser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource()==b1){
			
			try{
				
				if(t2.getText()=="ronak123" && t3.getText()=="1234"){
					JOptionPane.showMessageDialog(null, "Login Successfully");	
					new Adminmenu();
				}else{
					JOptionPane.showMessageDialog(null, "Invalid UserName or Passward");
				}
			}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		}
		if (e.getSource()==b2){
			new Adminmenu();
		}
	}
					
				}
				
			
		
		
		
		
			


