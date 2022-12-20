import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class SalaryCal extends JFrame implements ActionListener {

	JLabel lbleid,lblename,lbladdress,lblp_no,lblsalary,lblctc,lblpf,lbllta,lblnetsalary,lblleaveplanid;
	JTextField txteid,txtename,txtaddress,txtp_no,txtsalary,txtctc,txtpf,txtlta,txtnetsalary,txtleaveplanid;
	JButton btn1;
	public SalaryCal() {
		setSize(2000,2000);
		setTitle("Salary");
		setLayout(null);
		
		lbleid=new JLabel("E_id");
		lbleid.setBounds(100,100,100,50);
		add(lbleid);
		
		txteid=new JTextField();
		txteid.setBounds(200,100,100,50);
		add(txteid);
		
		lblename=new JLabel("ename");
		lblename.setBounds(100,150,100,50);
		add(lblename);
		
		txtename=new JTextField();
		txtename.setBounds(200,150,100,50);
		add(txtename);
		
		lbladdress=new JLabel("address");
		lbladdress.setBounds(100,200,100,50);
		add(lbladdress);
		
		txtaddress=new JTextField();
		txtaddress.setBounds(200,200,100,50);
		add(txtaddress);
		
		lblctc=new JLabel("Ctc");
		lblctc.setBounds(100,250,100,50);
		add(lblctc);
		
		txtctc=new JTextField();
		txtctc.setBounds(200,250,100,50);
		add(txtctc);
		
		lblpf=new JLabel("PF");
		lblpf.setBounds(100,300,100,50);
		add(lblpf);
		
		txtpf=new JTextField();
		txtpf.setBounds(200,300,100,50);
		add(txtpf);
		
		lbllta=new JLabel("LTA");
		lbllta.setBounds(100,350,100,50);
		add(lbllta);
		
		txtlta=new JTextField();
		txtlta.setBounds(200,350,100,50);
		add(txtlta);

		lblsalary=new JLabel("Salary");
		lblsalary.setBounds(100,400,100,50);
		add(lblsalary);
		
		txtsalary=new JTextField();
		txtsalary.setBounds(200,400,100,50);
		add(txtsalary);
		
		lblnetsalary=new JLabel("NET Salary");
		lblnetsalary.setBounds(100,450,100,50);
		add(lblnetsalary);
		
		txtnetsalary=new JTextField();
		txtnetsalary.setBounds(200,450,100,50);
		add(txtnetsalary);
		
		lblp_no=new JLabel("Phone no");
		lblp_no.setBounds(100,500,100,50);
		add(lblp_no);
		
		txtp_no=new JTextField();
		txtp_no.setBounds(200,500,100,50);
		add(txtp_no);

		lblleaveplanid=new JLabel("leaveplanid");
		lblleaveplanid.setBounds(100,550,100,50);
		add(lblleaveplanid);
		
		txtleaveplanid=new JTextField();
		txtleaveplanid.setBounds(200,550,100,50);
		add(txtleaveplanid);
		
		btn1=new JButton("Save");
		btn1.setBounds(200,600,100,50);
		add(btn1);
		btn1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
			SalaryCal obj=new SalaryCal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1) {
				System.out.println("FJKENF");
				Connection con;
				PreparedStatement st,st2;ResultSet rs,rs2;
				String x=txteid.getText();//id
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select name,address,leaveplanid from employee where e_id=?";
					String sql2="select ctc,pf,lta,salary,netsalary,phone_no from esalary where eid=?";
					st=con.prepareStatement(sql);
					st.setString(1, x);
					st2=con.prepareStatement(sql2);
					st2.setString(1, x);
					rs=st.executeQuery();
					rs2=st2.executeQuery();
					
					txteid.setText("");
					txtename.setText("");
					txtaddress.setText("");
					txtp_no.setText("");
					txtctc.setText("");
					txtleaveplanid.setText("");
					txtlta.setText("");
					txtnetsalary.setText("");
					txtpf.setText("");
					txtsalary.setText("");
					
					if (rs.next())
					{
						txtename.setText(rs.getString(1));
						txtaddress.setText(rs.getString(2));
						txtleaveplanid.setText(rs.getString(3));
					}
					if (rs2.next()) {
						txtctc.setText(rs.getString(1));
						txtpf.setText(rs.getString(2));
						txtlta.setText(rs.getString(3));
						txtsalary.setText(rs.getString(4));
						txtnetsalary.setText(rs.getString(5));
						txtp_no.setText(rs.getString(6));
					}
					
					else {
						JOptionPane.showMessageDialog(this, "Not found..");
					}
					con.close();
					
				} catch (Exception e1) {
					System.out.println(e1.toString());
			}
			}
	}

}