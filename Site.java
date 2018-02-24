import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Site extends Frame implements ActionListener{
	Button b1,b2,b3;
	Site()
	{
		b1=new Button("Sign Up");
		b2=new Button("Login");
		
		b1.setBounds(200,200,100,30);
		b2.setBounds(200,250,100,30); 
		
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			RegistrationForm r=new RegistrationForm();
		}
		if(e.getSource()==b2)
		{
			Login l=new Login();
		}
	}
	public static void main(String args[])
	{
		Site s=new Site();
	}
}

class RegistrationForm extends Frame implements ActionListener{
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField tf2,tf4,tf3,tf5,tf6,tf7,tf8,tf9;
	Button b1,b2,back;
	Dialog d1,d2;
	String user,pass,email,contact,add,gen,qual,nationality;
	
	RegistrationForm()
	{
		  Frame f1= new Frame();  
		   Frame f2= new Frame();  
	       d1 = new Dialog(f1,"Submission successful",true);
	       d2 = new Dialog(f2,"Submission unsuccessful",true);
		
		tf2=new TextField();
		tf3=new TextField();
		tf4=new TextField();
		tf5=new TextField();
		tf6=new TextField();
		tf7=new TextField();
		tf8=new TextField();
		tf9=new TextField();
		
		l1=new Label("Registration Form");
		l2=new Label("Username");
		l3=new Label("Password");
		l4=new Label("Email");
		l5=new Label("Contact");
		l6=new Label("Address");
		l7=new Label("Gender");
		l8=new Label("Qualitfications");
		l9=new Label("Nationality");
		
		b1=new Button("Sign up");
		b2=new Button("Cancel");
		back=new Button("Back");
		
		l1.setBounds(400,50,150,30);
		l2.setBounds(100,90,100,30);
		tf2.setBounds(200,90,150,30);
		l3.setBounds(100,130,100,30);
		tf3.setBounds(200,130,150,30);
		l4.setBounds(100,170,100,30);
		tf4.setBounds(200,170,150,30);
		l5.setBounds(100,210,100,30);
		tf5.setBounds(200,210,150,30);
		l6.setBounds(100,250,100,30);
		tf6.setBounds(200,250,150,30);
		l7.setBounds(100,290,100,30);
		tf7.setBounds(200,290,150,30);
		l8.setBounds(100,330,100,30);
		tf8.setBounds(200,330,150,30);
		l9.setBounds(100,370,100,30);
		tf9.setBounds(200,370,150,30);
		back.setBounds(200,450,70,30);
		
		b1.setBounds(150,410,70,30);
		b2.setBounds(250,410,70,30);
		
		d1.setSize(300,300);
		d2.setSize(300,300);
		
		add(back);
		add(b1);
		add(b2);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(tf7);
		add(tf8);
		add(tf9);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);
		tf4.addActionListener(this);
		tf5.addActionListener(this);
		tf6.addActionListener(this);
		tf7.addActionListener(this);
		tf8.addActionListener(this);
		tf9.addActionListener(this);
		back.addActionListener(this);
		
		setSize(1000,1000);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		int id=100,id1=99;
		int val;
		user=tf2.getText();
		pass=tf3.getText();
		email=tf4.getText();
		contact=tf5.getText();
		add=tf6.getText();
		gen=tf7.getText();
		qual=tf8.getText();
		nationality=tf9.getText();
		
		if(user.length()>20)
		{
			d1.setVisible(true);
		}
		if(e.getSource()==b1)
		{  
		try{
            Class.forName("com.mysql.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","test");
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery("Select u_id from User ORDER BY u_id DESC LIMIT 1;");
		    while(rs.next())
	         {
	           id1=rs.getInt(1);
	         }
		    id=id1+1;
	         val=stmt.executeUpdate("insert into User values("+id+",'"+user+"','"+pass+"','"+email+"',"+contact+", '"+add+"','"+gen+"','"+qual+"','"+nationality+"');");
	       
	         if(val>0)
		       {
	        	 d1.setVisible(true);
		       }
		       else
		       {
		    	   d2.setVisible(true);
		       }
		}catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
	      }
		if(e.getSource()==b2)
		{
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
		    tf6.setText("");
			tf7.setText("");
			tf8.setText("");
			tf9.setText("");
		}
		if(e.getSource()==back)
		{
			Site s=new Site();
		}
	}
}
class AfterLogin extends Frame implements ActionListener
{
	Label l=new Label();
	Button b1,b2,b3,b4,b5;
	String user1;
	AfterLogin(String user)
	{
		user1=user;
		l=new Label("Welcome "+user+" you are successfully logged in");
		l.setBounds(200,250,300,30);
		add(l);
		
		b1=new Button("View FeedBack");
		b2=new Button("Give Feedback");
		b3=new Button("Logout");
		b4=new Button("View Profile");
		b5=new Button("Edit Profile");
		
		b1.setBounds(200,300,100,30);
		b2.setBounds(200,350,100,30);
		b3.setBounds(200,400,100,30);
		b4.setBounds(200,450,100,30);
		b5.setBounds(200,500,100,30);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setSize(700,500);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
		}
		if(e.getSource()==b2)
		{
			GiveFeedback g=new GiveFeedback(user1);
		}
		if(e.getSource()==b3)
		{
			Login l=new Login();
		}
		if(e.getSource()==b4)
		{
			ViewProfile v=new ViewProfile(user1);
		}
		
	}
}

class Login extends Frame implements ActionListener{
	TextField name,pass;
	Button submit,cancel,back;
	Frame f1=new Frame();
	Dialog d1 = new Dialog(f1,"Login unsuccessful",true);
	Login(){
		setLayout(new FlowLayout());
		back=new Button("Back");
		this.setLayout(null);
		Label n=new Label("Name :",Label.CENTER);
		Label p=new Label("Password :",Label.CENTER);
		name =new TextField();
		pass =new TextField();
		pass.setEchoChar('*');
		submit=new Button("Submit");
		cancel=new Button("Cancel");
		
		d1.setSize(300,300);
		
		this.add(n);
		this.add(name);
		this.add(p);
		this.add(pass);
		this.add(submit);
		this.add(cancel);
		add(back);
		back.addActionListener(this);
		
		n.setBounds(70,90,90,60);
		p.setBounds(70,130,90,60);
		back.setBounds(250,300,90,30);
		name.setBounds(200,100,90,20);
		pass.setBounds(200,140,90,20);
		submit.setBounds(100,260,70,40);
		cancel.setBounds(180,260,70,40);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
		}});
		submit.addActionListener(this);
		setVisible(true);
		setSize(400,400);
		setTitle("Login Page");
		
	}
	public void actionPerformed(ActionEvent a){
		ResultSet rs;
		String user,passw;
			if(a.getSource()==submit)
			{
				String pas = null;
				user=name.getText();
				passw=pass.getText();
				
				try{
		            Class.forName("com.mysql.jdbc.Driver");	
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","test");
				    Statement stmt=con.createStatement();
			         rs=stmt.executeQuery("select u_pass from User where u_name='"+user+"';");
			         while(rs.next())
			         {
			           pas=rs.getString(1);
			         }
			         if(pas.equals(passw))
			         {
                          new AfterLogin(user);
			         }
			         else
			         {
			        	   d1.setVisible(true);
			         }
				}catch(Exception ex)
					{
						System.out.println(ex.toString());
					}
			}
			if(a.getSource()==back)
			{
				Site s=new Site();
			}
			if(a.getSource()==cancel)
			{
				name.setText("");
				pass.setText("");
			}
			
	}
}
class ViewFeedback extends Frame implements ActionListener{
	ViewFeedback()
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
}

class ViewProfile extends Frame {
	String user1;
	String msg="";
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	ViewProfile(String user)
	{
	l1=new Label();
	l1.setBounds(150,50,100,30);
	l2=new Label();
	l2.setBounds(150,100,100,30);
	l3=new Label();
	l3.setBounds(150,150,100,30);
	l4=new Label();
	l4.setBounds(150,200,100,30);
	l5=new Label();
	l5.setBounds(150,250,100,30);
	l6=new Label();
	l6.setBounds(150,300,100,30);
	l7=new Label();
	l7.setBounds(150,350,100,30);
	l8=new Label();
	l8.setBounds(150,400,100,30);
	l9=new Label();
	l9.setBounds(150,450,100,30);
	l10=new Label("ID");
	l10.setBounds(260,50,100,30);
	l11=new Label("Name");
	l11.setBounds(260,100,100,30);
	l12=new Label("Password");
	l12.setBounds(260,150,100,30);
	l13=new Label("Email");
	l13.setBounds(260,200,100,30);
	l14=new Label("Contact");
	l14.setBounds(260,250,100,30);
	l15=new Label("Address");
	l15.setBounds(260,300,100,30);
	l16=new Label("Gender");
	l16.setBounds(260,350,100,30);
	l17=new Label("Qualification");
	l17.setBounds(260,400,100,30);
	l18=new Label("Nationality");
	l18.setBounds(260,450,100,30);
	
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(l6);
	add(l7);
	add(l8);
	add(l9);
	add(l10);
	add(l11);
	add(l12);
	add(l13);
	add(l14);
	add(l15);
	add(l16);
	add(l17);
	add(l18);
	
	   	user1=user;
		try{
            Class.forName("com.mysql.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","test");
		    Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from User where u_name='"+user1+"';");
	        msg=("ID "+"Name  "+"Password "+" Email "+" Contact "+" Address "+" Gender "+" Qualifications "+" Nationality ");
	    	while (rs.next()) {
	    	l1.setText(rs.getString(1));
	    	l2.setText(rs.getString(2));
	    	l3.setText(rs.getString(3));
	    	l4.setText(rs.getString(4));
	    	l5.setText(rs.getString(5));
	    	l6.setText(rs.getString(6));
	    	l7.setText(rs.getString(7));
	    	l8.setText(rs.getString(8));
	    	l9.setText(rs.getString(9));
		    }
	    	 msg=("ID "+"Name  "+"Password "+" Email "+" Contact "+" Address "+" Gender "+" Qualifications "+" Nationality ");
	    	  
		  
		}catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
		  setSize(1500,1500);
		  setLayout(null);
		  setVisible(true);
	}


}
class GiveFeedback extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1;
	
	GiveFeedback(String user)
	{
		l1=new Label("user id :");
		l1.setBounds(30,50,70,30);
		
		t1=new TextField();
		t1.setBounds(120,50,70,30);
		
		l2=new Label("message :");
		l2.setBounds(30,100,70,30);
		
		t2=new TextField();
		t2.setBounds(120,100,70,50);
		
		b1=new Button("click here");
		b1.setBounds(200,200,100,40);
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		
	    b1.addActionListener(this);	
		setSize(400,400);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		int f_id=1;
		int flag=1;
		String u_id=t1.getText();
		String f_message=t2.getText();
		try{
            Class.forName("com.mysql.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","test");
		    Statement stmt=con.createStatement();
	         int val=stmt.executeUpdate("insert into Feedback values("+f_id+","+u_id+",'"+f_message+","+flag+");");
	       
	         if(val>0)
		       {
		       }
		       else
		       {
		       }
		}catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
	      }
	}
	
	