import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class Empupdate extends JFrame implements ActionListener{
	JLabel j2,j3,j4,j5,j6,j7;
	JTextField b,c,d,e,f,g1;
	JComboBox cb;
	JPasswordField p1;
	JButton btn1,btn2;
	public Empupdate() {
		setSize(700,700);
		setLayout(null);
		cb=new JComboBox();
		cb.setBounds(200,50,100,40);
		fillStaffid();
		add(cb);
		btn1=new JButton("Find");
		btn1.setBounds(400, 50, 100, 40);
		add(btn1);
		btn1.addActionListener(this);
		
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
	
		
		btn2=new JButton("Update");
		btn2.setBounds(320, 300, 100, 40);
		add(btn2);
		btn2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Empupdate();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1)
		{
			Connection con;
			PreparedStatement st;ResultSet rs;
			String x=cb.getSelectedItem().toString(); //id
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select NAME,EMAIL,PASSWORD,ADDRESS,DEPT_ID,LEAVEPLAN_ID from employee where E_ID=?";
				st=con.prepareStatement(sql);
				st.setString(1, x);
				rs=st.executeQuery();
				b.setText("");
				d.setText("");
				p1.setText("");
				e.setText("");
				f.setText("");
				g1.setText("");
				
				if (rs.next())
				{
					b.setText(rs.getString(1));
					d.setText(rs.getString(2));
					p1.setText(String.valueOf(rs.getString(3)));
					e.setText(rs.getString(4));
					f.setText(rs.getString(5));
					g1.setText(rs.getString(6));
				
				}
				
				else {
					JOptionPane.showMessageDialog(this, "Not found..");
				}
				con.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
		}

		}
		if(ae.getSource()==btn2)
		{
			Connection con;
			PreparedStatement st;
			String x=cb.getSelectedItem().toString(); //id
			String y=b.getText();  
			String z=d.getText(); 
			String sa=(String.valueOf(p1.getPassword()));
		    String se=e.getText();
		    String sd=f.getText();
		    String as=g1.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="update employee set NAME=?,EMAIL=?,PASSWORD=?,ADDRESS=?,DEPT_ID=?,LEAVEPLAN_ID=? where E_ID=?";
				st=con.prepareStatement(sql);
				st.setString(1, y);
				st.setString(2, z);
				st.setString(3, sa);
				st.setString(4, se);
				st.setString(5, sd);
				st.setString(6, as);
				st.setString(7, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "record Updated..");
				cb.removeAllItems();
				fillStaffid();
				b.setText("");
				d.setText("");
				p1.setText("");
				e.setText("");
				f.setText("");
				g1.setText("");
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}
	void fillStaffid()
	{
		Connection con;
		PreparedStatement st;ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select E_ID from employee";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next())
			{
				cb.addItem((rs.getString(1)));
			}
		}
		catch(Exception e) {}
	}
}
