import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class Empshow extends JFrame implements ActionListener{
	JLabel j1,j2,j3,j4,j5,j6,j7;
	JTextField a,b,d,e,f,g1;
	JPasswordField p1;
	JButton btn1,btn2,btn3,btn4;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	public Empshow() {
		setSize(700,700);
		setLayout(null);
		
		j1=new JLabel("Rollno");
		j1.setBounds(100, 50,100,40);
		add(j1);
		
		a=new JTextField();
		a.setBounds(200,50,100,40);
		add(a);
		
		j2=new JLabel("Name");
		j2.setBounds(100,100,100,40);
		add(j2);
		
		b=new JTextField();
		b.setBounds(200,100,100,40);
		add(b);
		
		j3=new JLabel("Email");
		j3.setBounds(100,150,100,40);
		add(j3);
		d=new JTextField();
		d.setBounds(200,150,100,40);
		add(d);
		
	
		j4=new JLabel("Password");
		j4.setBounds(100,200,100,40);
		add(j4);
	
		p1=new JPasswordField();
		p1.setBounds(200,200,100,40);
		add(p1);
	
		j5=new JLabel("Address");
		j5.setBounds(100,250,100,40);
		add(j5);
		e=new JTextField();
		e.setBounds(200,250,100,40);
		add(e);
		
		j6=new JLabel("DEPT_id");
		j6.setBounds(100,300,100,40);
		add(j6);
		f=new JTextField();
		f.setBounds(200,300,100,40);
		add(f);
		
		j7=new JLabel("Leaveplan_id");
		j7.setBounds(100,350,100,40);
		add(j7);
		g1=new JTextField();
		g1.setBounds(200,350,100,40);
		add(g1);
	
			
		
		btn1=new JButton("First");
		btn1.setBounds(320, 400, 100, 40);
		add(btn1);
		btn1.addActionListener(this);
		btn2=new JButton("Next");
		btn2.setBounds(400, 400, 100, 40);
		add(btn2);
		btn2.addActionListener(this);
		btn3=new JButton("Last");
		btn3.setBounds(500, 400, 100, 40);
		add(btn3);
		btn3.addActionListener(this);
		btn4=new JButton("Previous");
		btn4.setBounds(600, 400, 100, 40);
		add(btn4);
		btn4.addActionListener(this);
		showData();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Empshow();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
		if(ae.getSource()==btn1)
		{
			rs.first();
			a.setText(rs.getString(1));
			b.setText(rs.getString(2));
			d.setText(rs.getString(3));
			p1.setText(String.valueOf(rs.getString(4)));
			e.setText(rs.getString(5));
			f.setText(rs.getString(6));
			g1.setText(rs.getString(7));
			
		}
		if(ae.getSource()==btn2)
		{
			rs.next();
			a.setText(String.valueOf(rs.getString(1)));
			b.setText(rs.getString(2));
			d.setText(rs.getString(3));
			p1.setText(String.valueOf(rs.getString(4)));
			e.setText(rs.getString(5));
			f.setText(rs.getString(6));
			g1.setText(rs.getString(7));
			
		}
		if(ae.getSource()==btn3)
		{
			rs.last();
			a.setText((rs.getString(1)));
			b.setText(rs.getString(2));
			d.setText(rs.getString(3));
			p1.setText(String.valueOf(rs.getString(4)));
			e.setText(rs.getString(5));
			f.setText(rs.getString(6));
			g1.setText(rs.getString(7));
			
		}
		if(ae.getSource()==btn4)
		{
			rs.previous();
			a.setText(rs.getString(1));
			b.setText(rs.getString(2));
			d.setText(rs.getString(3));
			p1.setText(String.valueOf(rs.getString(4)));
			e.setText(rs.getString(5));
			f.setText(rs.getString(6));
			g1.setText(rs.getString(7));
			
		}
		}catch(Exception e) {}
		
	}
	void showData()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select E_ID,NAME,EMAIL,PASSWORD,ADDRESS,DEPT_ID,LEAVEPLAN_ID from employee";
			st=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery();
			rs.first();
			a.setText(rs.getString(1));
			b.setText(rs.getString(2));
			d.setText(rs.getString(3));
			p1.setText(String.valueOf(rs.getString(4)));
			e.setText(rs.getString(5));
			f.setText(rs.getString(6));
			g1.setText(rs.getString(7));
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
	}
	}
}
