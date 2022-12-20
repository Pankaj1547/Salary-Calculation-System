import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Dinsert extends JFrame  implements ActionListener{

	JLabel j1,j2,j3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	Dinsert()
	{
		setSize(700,700);
		setLayout(null);
		
		j1=new JLabel("Dept_id");
		j1.setBounds(100,50,200,50);
		add(j1);
		
		t1=new JTextField();
		t1.setBounds(170,50,200,50);
		add(t1);
		
		j2=new JLabel("Dept_Name");
		j2.setBounds(100,120,200,50);
		add(j2);
		
		t2=new JTextField();
		t2.setBounds(170,120,200,50);
		add(t2);
		
		j3=new JLabel("Hod");
		j3.setBounds(100,190,200,50);
		add(j3);
		
		t3=new JTextField();
		t3.setBounds(170,190,200,50);
		add(t3);
		
		
		
		b1=new JButton("Save");
		b1.setBounds(150,410,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Clear");
		b2.setBounds(300,410,100,50);
		add(b2);
		b2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Dinsert(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			String a=t1.getText();
			String b=t2.getText();
			String c=t3.getText();
			if (a.length()==0 || b.length()==0 || c.length()==0 ) {
				JOptionPane.showMessageDialog(this,"Error");
			}
		
		else {
			Connection con;
			PreparedStatement st;
			String x=t1.getText();
			String y=t2.getText();
			String z=t3.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="insert into department values(?,?,?)";
				st=con.prepareStatement(sql);
				st.setString(1,x);
				st.setString(2,y);
				st.setString(3,z);
				int g=st.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(this,"Datasaved");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
			}
			catch (Exception e2) {
				System.out.println(e2.toString());
			}
			}
		
		}
		
		if (e.getSource()==b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			}
	
	}

}
