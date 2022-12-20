import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class DShow extends JFrame implements ActionListener{
	JLabel j1,j2,j3;
	JTextField a,b,c;
	JButton btn1,btn2,btn3,btn4;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	public DShow() {
		setSize(700,700);
		setLayout(null);
		
		j1=new JLabel("Rollno");
		j1.setBounds(100, 50,100,40);
		add(j1);
		
		a=new JTextField();
		a.setBounds(200,50,100,40);
		add(a);
		
		j2=new JLabel("NAME");
		j2.setBounds(100,100,100,40);
		add(j2);
		
		b=new JTextField();
		b.setBounds(200,100,100,40);
		add(b);
		
		j3=new JLabel("COURSE");
		j3.setBounds(100,150,100,40);
		add(j3);
		
		c=new JTextField();
		c.setBounds(200,150,100,40);
		add(c);
		
		btn1=new JButton("First");
		btn1.setBounds(200, 300, 100, 40);
		add(btn1);
		btn1.addActionListener(this);
		btn2=new JButton("Next");
		btn2.setBounds(320, 300, 100, 40);
		add(btn2);
		btn2.addActionListener(this);
		btn3=new JButton("Last");
		btn3.setBounds(420, 300, 100, 40);
		add(btn3);
		btn3.addActionListener(this);
		btn4=new JButton("Previous");
		btn4.setBounds(520, 300, 100, 40);
		add(btn4);
		btn4.addActionListener(this);
		showData();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DShow();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
		if(ae.getSource()==btn1)
		{
			rs.first();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			c.setText(rs.getString(3));
			
		}
		if(ae.getSource()==btn2)
		{
			rs.next();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			c.setText(rs.getString(3));
			
		}
		if(ae.getSource()==btn3)
		{
			rs.last();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			c.setText(rs.getString(3));
			
		}
		if(ae.getSource()==btn4)
		{
			rs.previous();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			c.setText(rs.getString(3));
			
		}
		}catch(Exception e) {}
		
	}
	void showData()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select DEPT_ID,DEPT_NAME,HOD from department ";
			st=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery();
			rs.first();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			c.setText(rs.getString(3));
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
	}
	}
}
