import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class MarkAttScr extends JFrame implements Runnable,ActionListener,MouseMotionListener,KeyListener{
	
	static long time123=System.currentTimeMillis();

	JLabel title,name,aadhar,mobile,mail,address,empname,deptname;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton bt1,bt2;
	DateTimeFormatter date =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate now=LocalDate.now();
	String a=String.valueOf(now);
	int period=Integer.parseInt(a.substring(8, 10));
	int x=0;
	static LocalTime time2 =LocalTime.now();
	static String time=String.valueOf(time2);
	
	static int x2=Integer.parseInt(time.substring(0, 2));
	static int [] period1={10,12};
	static Thread t1;
	static int sec=Integer.parseInt(time.substring(6,8));
	static int sec2=sec+5;
	MarkAttScr(){
		setSize(1900,1000);
		setTitle("My Insert frame");
		setLayout(null);
		title=new JLabel("Salary Calculation System");
		title.setBounds(600, 20, 300, 40);
		add(title);
		
		aadhar=new JLabel("Enter your ID Number Again : ");
		aadhar.setBounds(400, 300, 200, 40);
		add(aadhar);
		tf2=new JTextField();
		tf2.setBounds(700, 200, 200, 40);
		add(tf2);
		
		tf3=new JTextField();
		tf3.setBounds(700, 300, 200, 40);
		add(tf3);

		name=new JLabel("Mark Your Today's Attendence ");
		name.setBounds(600, 100, 200, 40);
		add(name);
		mobile=new JLabel("Enter Your department Please : ");
		mobile.setBounds(400, 200, 200, 40);
		add(mobile);
		
		
		
		bt2=new JButton("Cancel");
		bt2.setBounds(600, 500, 200, 40);
		add(bt2);
		bt2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		System.out.println(sec);
		MarkAttScr obj=	new MarkAttScr();
			
		System.out.println(x2);
		System.out.println(time123);
	}
	
	public void run(){
		if ((sec-sec2)>10){
		try {
			bt1=new JButton("Mark");
			bt1.setBounds(400, 500, 200, 40);
			add(bt1);
			bt1.addActionListener(this);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ar) {
		if (ar.getSource()==bt1){
			x=x+1;
			System.out.println(a);
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from holiday where day='"+a+"' and deptid='"+tf2.getText()+"'";
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Can't Mark");	
				}else{
					if (x==1 && x2==10){
						JOptionPane.showMessageDialog(this, "Attendence Marked");
					}
					else{
						JOptionPane.showMessageDialog(this, "Can't mark now");
						String sql2="update leaveplan set LEAVEPLANID='L001' where empid=?";
						PreparedStatement ps2= con.prepareStatement(sql2);
						ps2.setString(1, tf3.getText());
						int g2=ps2.executeUpdate();
						con.close();
					}
				}
				
			}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		}
		if (ar.getSource()==bt2){
			System.exit(1);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	
}