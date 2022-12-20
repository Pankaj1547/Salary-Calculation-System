import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class DDelete extends JFrame implements ActionListener{
	JLabel j2,j3;
	JTextField b,c;
	JComboBox cb;
	JButton btn1,btn2;
	public DDelete() {
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
		
		j3=new JLabel("Course");
		j3.setBounds(100,150,100,40);
		add(j3);
		
		c=new JTextField();
		c.setBounds(200,150,100,40);
		add(c);
		
		
		btn2=new JButton("Delete");
		btn2.setBounds(320, 300, 100, 40);
		add(btn2);
		btn2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DDelete();
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
				String sql="select DEPT_NAME,HOD from department where DEPT_ID=?";
				st=con.prepareStatement(sql);
				st.setString(1, x);
				rs=st.executeQuery();
				b.setText("");
				c.setText("");
				if (rs.next())
				{
					b.setText(rs.getString(1));
					c.setText(rs.getString(2));
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
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="delete from department where DEPT_ID=?";
				st=con.prepareStatement(sql);
				st.setString(1, x);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "record deleted..");
				cb.removeAllItems();
				fillStaffid();
				b.setText("");
				c.setText("");
				con.close();
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
			String sql="select DEPT_ID from department";
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
