import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oracle.security.o3logon.a;

public class Adminmenu extends JFrame implements ActionListener{

	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem eins,edel,eupd,efind,e,f,g,h,a1,b1,c1,d1,e1,f1,g1,h1,p,q,r,s;
	JButton btaddadmin,btadduser;
	JLabel lbllist;
	Adminmenu() 
	{
		 setSize(700,700);
		 setTitle("Home page");
		 setLayout(null);
		 
		 mb=new JMenuBar();
		 m1=new JMenu("Employee");
		 m2=new JMenu("Department");
		 m3=new JMenu("Holiday");
		 m4=new JMenu("Employee Attendance");
		 m5=new JMenu("Employee Salary calculation");
		 eins=new JMenuItem("insert");
		 eins.addActionListener(this);
		 edel=new JMenuItem("Delete");
		 edel.addActionListener(this);
		 eupd=new JMenuItem("Update");
		 eupd.addActionListener(this);
		 efind=new JMenuItem("Find");
		 efind.addActionListener(this);
		 m1.add(eins);
		 m1.addSeparator();
		 m1.add(edel);
		 m1.addSeparator();
		 m1.add(eupd);
		 m1.addSeparator();
		 m1.add(efind);
		 m1.addSeparator();
		 mb.add(m1);
		 mb.add(m2);
		 mb.add(m3);
		 mb.add(m4);
		 mb.add(m5);
		 setJMenuBar(mb);
		
		 e=new JMenuItem("insert");
		 e.addActionListener(this);
		 f=new JMenuItem("Delete");
		 f.addActionListener(this);
		 g=new JMenuItem("Update");
		 g.addActionListener(this);
		 h=new JMenuItem("Find");
		 h.addActionListener(this);
		 m2.add(e);
		 m2.addSeparator();
		 m2.add(f);
		 m2.addSeparator();
		 m2.add(g);
		 m2.addSeparator();
		 m2.add(h);
		 m2.addSeparator();
		 mb.add(m1);
		 mb.add(m2);
		 mb.add(m3);
		 mb.add(m4);
		 mb.add(m5);
		 setJMenuBar(mb);

		 a1=new JMenuItem("insert");
		 a1.addActionListener(this);
		 b1=new JMenuItem("Delete");
		 b1.addActionListener(this);
		 c1=new JMenuItem("Update");
		 c1.addActionListener(this);
		 d1=new JMenuItem("Find");
		 d1.addActionListener(this);
		 m3.add(a1);
		 m3.addSeparator();
		 m3.add(b1);
		 m3.addSeparator();
		 m3.add(c1);
		 m3.addSeparator();
		 m3.add(d1);
		 m3.addSeparator();
		 mb.add(m1);
		 mb.add(m2);
		 mb.add(m3);
		 mb.add(m4);
		 mb.add(m5);
		 setJMenuBar(mb);

		 e1=new JMenuItem("insert");
		 e1.addActionListener(this);
		 f1=new JMenuItem("Delete");
		 f1.addActionListener(this);
		 g1=new JMenuItem("Update");
		 g1.addActionListener(this);
		 h1=new JMenuItem("Find");
		 h1.addActionListener(this);
		 m4.add(e1);
		 m4.addSeparator();
		 m4.add(f1);
		 m4.addSeparator();
		 m4.add(g1);
		 m4.addSeparator();
		 m4.add(h1);
		 m4.addSeparator();
		 mb.add(m1);
		 mb.add(m2);
		 mb.add(m3);
		 mb.add(m4);
		 mb.add(m5);
		 setJMenuBar(mb);

		 p=new JMenuItem("insert");
		 p.addActionListener(this);
		 q=new JMenuItem("Delete");
		 q.addActionListener(this);
		 r=new JMenuItem("Update");
		 r.addActionListener(this);
		 s=new JMenuItem("Find");
		 s.addActionListener(this);
		 m5.add(p);
		 m5.addSeparator();
		 m5.add(q);
		 m5.addSeparator();
		 m5.add(r);
		 m5.addSeparator();
		 m5.add(s);
		 m5.addSeparator();
		 mb.add(m1);
		 mb.add(m2);
		 mb.add(m3);
		 mb.add(m4);
		 mb.add(m5);
		 setJMenuBar(mb);

		 btaddadmin=new JButton("ADD ADMIN");
		 btaddadmin.setBounds(100,200,200,50);
		 add(btaddadmin);
		 btaddadmin.addActionListener(this);
		 
		 btadduser=new JButton("ADD USER");
		 btadduser.setBounds(350,200,200,50);
		 add(btadduser);
		 btadduser.addActionListener(this);
		 
		 lbllist=new JLabel("List of add admin");
		 lbllist.setBounds(200,270,200,50);
		 add(lbllist);
		
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);

	}
	public static void main(String[] args) {
		Adminmenu obj=new Adminmenu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==eins) {
			new Empinsert();
		}
		if (e.getSource()==edel) {
			new Empdelete();
		}
	  if (e.getSource()==eupd) {
		    new Empupdate();
	}
	  if (e.getSource()==efind) {
		    new Empfind();
	}
	  if (e.getSource()==e) {
			new Dinsert();
		}
		if (e.getSource()==f) {
			new DDelete();
		}
	  if (e.getSource()==g) {
		    new Dupdate();
	}
	  if (e.getSource()==h) {
		    new Dfind();
	}

	  if (e.getSource()==btaddadmin) {
		  new addadmin();
	}
	  if (e.getSource()==btadduser) {
		  new Adduser();
	} 
	}

}
