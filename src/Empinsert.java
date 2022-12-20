import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Empinsert extends JFrame  implements ActionListener{

	JLabel lblempid,lblname,lblemail,lblpassword,lbladdress,lblgender,lblmess,lblconfirmpassword;
	JTextField txtempid,txtname,txtemail,txtaddress,txtdeptid;
	JButton btn1,btn2,btfind,btconfirm;
	JPasswordField pass1,pass2;
	JRadioButton rm,rf;
	ButtonGroup bg;
	JComboBox cb;
	Empinsert()
	{
		setSize(1000,1000);
		setLayout(null);
		
		lblempid=new JLabel("E_id");
		lblempid.setBounds(100,50,200,50);
		add(lblempid);
		
		txtempid=new JTextField();
		txtempid.setBounds(170,50,200,50);
		add(txtempid);
		
		btfind=new  JButton("check");
		btfind.setBounds(400,50,100,50);
		add(btfind);
		btfind.addActionListener(this);
		lblmess=new JLabel("Status");
		lblmess.setBounds(550, 50, 100, 40);
		add(lblmess); 
		
		
		lblname=new JLabel("Name");
		lblname.setBounds(100,120,200,50);
		add(lblname);
		
		txtname=new JTextField();
		txtname.setBounds(170,120,200,50);
		add(txtname);
		
		lblemail=new JLabel("Email");
		lblemail.setBounds(100,190,200,50);
		add(lblemail);
		
		txtemail=new JTextField();
		txtemail.setBounds(170,190,200,50);
		add(txtemail);
		
		lblpassword=new JLabel("password");
		lblpassword.setBounds(100,260,200,50);
		add(lblpassword);
		
		pass1=new JPasswordField();
		pass1.setBounds(170,260,200,50);
		add(pass1);
		
		lblconfirmpassword=new JLabel("C_password");
		lblconfirmpassword.setBounds(90,340,200,50);
		add(lblconfirmpassword);
		
		pass2=new JPasswordField();
		pass2.setBounds(170,340,200,50);
		add(pass2);
		
		btconfirm =new JButton("Confirm");
		btconfirm.setBounds(400,340,200,50);
		add(btconfirm);	
		btconfirm.addActionListener(this);
		
		lbladdress=new JLabel("Address");
		lbladdress.setBounds(100,420,200,50);
		add(lbladdress);
		
		txtaddress=new JTextField();
		txtaddress.setBounds(170,420,200,50);
		add(txtaddress);
		
		JLabel lbldeptid = new JLabel("Dept_id");
		lbldeptid.setBounds(100,500,200,50);
		add(lbldeptid);
		
		txtdeptid=new JTextField();
		txtdeptid.setBounds(170,500,200,50);
		add(txtdeptid);
		
		
		
		
		
	    lblgender=new JLabel("Gender");
	    lblgender.setBounds(100,570,200,50);
		add(lblgender);
		
		rm=new JRadioButton("Male");
		rf=new JRadioButton("Female");
		bg=new ButtonGroup();
		bg.add(rm);
		bg.add(rf);
		rm.setBounds(170,570,200,50);
		add(rm);
		
		rf.setBounds(400,570,200,50);
		add(rf);
		
		
		btn1=new JButton("Save");
		btn1.setBounds(150,640,100,50);
		add(btn1);
		btn1.addActionListener(this);
		btn2=new JButton("Clear");
		btn2.setBounds(300,640,100,50);
		add(btn2);
		btn2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Empinsert(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn1) {
			String t1=txtempid.getText();
			String t2=txtname.getText();
			String t3=txtemail.getText();
			String t4=pass1.getText();
			String t5=pass2.getText();			
			String t6=txtaddress.getText();
			String t7=txtdeptid.getText();
			if (t1.length()==0 || t2.length()==0 || t3.length()==0 || t4.length()==0 || t5.length()==0 || t6.length()==0 || t7.length()==0) {
				JOptionPane.showMessageDialog(this,"Error");
			
			}
		
		else {
			Connection con;
			PreparedStatement st;
			ResultSet rs;
			String x='E'+txtempid.getText();
			String y=txtname.getText();
			String z=txtemail.getText();
			String w=pass1.getText();
			String w1=pass1.getText();
			String s=txtaddress.getText();
			String sa=txtdeptid.getText();
			String sg=null;
			if (rm.isSelected())
			{
				sg="Male";
			}
			else
			{
				sg="FeMale";
			}
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="insert into employee values(?,?,?,?,?,?,?,?,?)";
				st=con.prepareStatement(sql);
				st.setString(1,x);
				st.setString(2,y);
				st.setString(3,z);
				st.setString(4,w);
				st.setString(5,w1);
				st.setString(6,s);
				st.setString(7,sa);
				st.setString(8,"L000");
				st.setString(9,sg);
				
				rm.setSelected(false);
				rf.setSelected(false);
				int g=st.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(this,"Datasaved");
				txtempid.setText("");
				txtname.setText("");
				txtemail.setText("");
				pass1.setText("");
				pass2.setText("");
				txtaddress.setText("");
				txtdeptid.setText("");
				
			}
			catch (Exception e2) {
				System.out.println(e2.toString());
			}
		}
		}
		if (e.getSource()==btn2) {
			txtempid.setText("");
			txtname.setText("");
			txtemail.setText("");
			pass1.setText("");
			pass2.setText("");
			txtaddress.setText("");
			txtdeptid.setText("");
			
		}		
			
	
		if(e.getSource()==btfind)
			
		{
			int r=0;
			try {
			Connection con; 
			PreparedStatement st;
			ResultSet rs;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from employee where e_id=?";
				st=con.prepareStatement(sql);
				String q=txtempid.getText(); 
				st.setString(1, q);
				rs=st.executeQuery();
				if (rs.next())
				{
				r=r+1;
				}
				if (r==0)
				{
					lblmess.setText("FINE GO");
					lblmess.setForeground(java.awt.Color.GREEN);
				}
				else
				{
					lblmess.setText("ALREADY PRESENT");
					lblmess.setForeground(java.awt.Color.RED);
				}
				
				
				
		}
			catch(Exception ex) {
			System.out.println(ex.toString());	
			}
	}
		if (e.getSource()==btconfirm) {
			String a1=pass1.getText();
			String b1=pass2.getText();			
			if (a1.length()==0 || b1.length()==0) {
				JOptionPane.showMessageDialog(this,"Error");
			}
		
			else if (a1.equals(b1)){
					JOptionPane.showMessageDialog(this,"Confirm");
			}
			else {
				JOptionPane.showMessageDialog(this," not Confirm");
				}
		  }
		}
			}



