import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Adminlogin extends JFrame implements ActionListener {

	JLabel lbladd,lblemail,lblpassword;
	JTextField t2,t3;
	JButton b1,b2;
	Adminlogin()
   {
	     setSize(700,700);
		 setTitle("Home page");
		 setLayout(null);
		 
		 lbladd=new JLabel(" ADD ADMIN");
		 lbladd.setBounds(100,50,200,100);
		 add(lbladd);
		 lbladd.setFont(new Font("Arial",Font.CENTER_BASELINE,30));
		 
		 lblemail=new JLabel("EMAIL");
		 lblemail.setBounds(100,120,100,50);
		 add(lblemail);
		
		 t2=new JTextField();
		 t2.setBounds(200,120,100,50);
		 add(t2);
		 
		 lblpassword=new JLabel("PASSWORD");
		 lblpassword.setBounds(100,190,100,50);
		 add(lblpassword);
		 
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
		Adminlogin obj=new Adminlogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource()==b1){
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from admin where email='"+t2.getText()+"' and password ='"+t3.getText()+"'";
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()){
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
			System.exit(1);
		}
	}
					
				}
				
			
		
		
		
		
			


