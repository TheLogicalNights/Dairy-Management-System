import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminRegScreen extends JFrame
{
	JButton submit,reset,back,cpy;
	JTextField firstname,middlename,lastname,contact,add,t1,pin,password1,password2,username1,username2;
	TextArea addtemp,addper;
	Choice c1,c2,c3,c4;
	public AdminRegScreen()
	{
		setTitle("Admin Registration.....");
		setLayout(null);
		setBounds(100,00,1300,1000);


		ImageIcon bg_img = new ImageIcon("IMG_2877.jpg");
		Image img = bg_img.getImage();
		Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBounds(0,0,1300,1000);
		background.setLayout(null);

//Panels
		JPanel heading3 = new JPanel();
		heading3.setBackground(new Color(0,0,0,80));
		heading3.setBounds(0,0,2560,100);
		heading3.setLayout(null);
		background.add(heading3);

		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(0,0,0,70));
		main.setBounds(10,110,1260,770);
		background.add(main);

		JPanel personal = new JPanel();
		personal.setBackground(new Color(255,255,255,90));
		personal.setLayout(null);
		personal.setBounds(10,50,880,200);
		main.add(personal);

		JPanel address = new JPanel();
		address.setBackground(new Color(255,255,255,90));
		address.setLayout(null);
		address.setBounds(10,260,880,370);
		main.add(address);

		JPanel gender = new JPanel();
		gender.setBackground(new Color(255,255,255,90));
		gender.setLayout(null);
		gender.setBounds(900,50,350,200);
		main.add(gender);

		JPanel security = new JPanel();
		security.setBackground(new Color(255,255,255,90));
		security.setLayout(null);
		security.setBounds(900,450,350,180);
		main.add(security);

		JPanel userpass = new JPanel();
		userpass.setBackground(new Color(255,255,255,90));
		userpass.setLayout(null);
		userpass.setBounds(900,260,350,180);
		main.add(userpass);

//Labels
		JLabel regform = new JLabel("REGISTRATION FORM...");
		regform.setBounds(20,-20,500,80);
		regform.setForeground(Color.WHITE);
		Font font1 = new Font("TimesRoman",Font.BOLD,40);
		regform.setFont(font1);
		main.add(regform);

		JLabel admreg = new JLabel("ADMIN REGISTRATION");
		admreg.setBounds(300,10,1000,80);
		admreg.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		admreg.setFont(font);
		heading3.add(admreg);

		JLabel perinfo = new JLabel("Personal Information.");
		perinfo.setBounds(10,0,500,50);
		perinfo.setForeground(Color.BLACK);
		Font font3 = new Font("TimesRoman",Font.BOLD,30);
		perinfo.setFont(font3);
		personal.add(perinfo);

		JLabel addinfo = new JLabel("Address Details.");
		addinfo.setBounds(10,0,500,50);
		addinfo.setForeground(Color.BLACK);
		addinfo.setFont(font3);
		address.add(addinfo);

		JLabel g1 = new JLabel("Username.");
		g1.setBounds(10,0,500,50);
		g1.setForeground(Color.BLACK);
		g1.setFont(font3);
		gender.add(g1);

		JLabel sqs = new JLabel("Security Questions.");
		sqs.setBounds(10,0,500,50);
		sqs.setForeground(Color.BLACK);
		sqs.setFont(font3);
		security.add(sqs);

		JLabel up = new JLabel("Password.");
		up.setBounds(10,0,500,50);
		up.setForeground(Color.BLACK);
		up.setFont(font3);
		userpass.add(up);

		JLabel cntr = new JLabel("Country");
		cntr.setBounds(25,220,80,15);
		cntr.setForeground(Color.BLACK);
		Font font2 = new Font("TimesRoman",Font.BOLD,15);
		cntr.setFont(font2);
		address.add(cntr);

		JLabel st = new JLabel("State");
		st.setBounds(305,220,80,15);
		st.setForeground(Color.BLACK);
		st.setFont(font2);
		address.add(st);

		JLabel sq = new JLabel("Scurity Question");
		sq.setBounds(15,60,150,15);
		sq.setForeground(Color.BLACK);
		sq.setFont(font2);
		security.add(sq);

		JLabel fn = new JLabel("First Name");
		fn.setBounds(25,60,150,15);
		fn.setForeground(Color.BLACK);
		fn.setFont(font2);
		personal.add(fn);

		JLabel mn = new JLabel("Middle Name");
		mn.setBounds(305,60,150,15);
		mn.setForeground(Color.BLACK);
		mn.setFont(font2);
		personal.add(mn);

		JLabel ln  = new JLabel("Last Name");
		ln.setBounds(585,60,150,15);
		ln.setForeground(Color.BLACK);
		ln.setFont(font2);
		personal.add(ln);

		JLabel cn = new JLabel("Contact No.");
		cn.setBounds(25,130,150,15);
		cn.setForeground(Color.BLACK);
		cn.setFont(font2);
		personal.add(cn);

		JLabel ea = new JLabel("Email Address");
		ea.setBounds(305,130,150,15);
		ea.setForeground(Color.BLACK);
		ea.setFont(font2);
		personal.add(ea);

		JLabel at = new JLabel("Address(Temparory)");
		at.setBounds(25,70,150,20);
		at.setForeground(Color.BLACK);
		at.setFont(font2);
		address.add(at);

		JLabel ap = new JLabel("Address(Parmenent)");
		ap.setBounds(545,70,150,15);
		ap.setForeground(Color.BLACK);
		ap.setFont(font2);
		address.add(ap);

		JLabel pc = new JLabel("PIN Code");
		pc.setBounds(25,300,150,15);
		pc.setForeground(Color.BLACK);
		pc.setFont(font2);
		address.add(pc);

		JLabel ans = new JLabel("Answer");
		ans.setBounds(15,120,150,15);
		ans.setForeground(Color.BLACK);
		ans.setFont(font2);
		security.add(ans);

		JLabel pass = new JLabel("Retype Password");
		pass.setBounds(25,120,150,15);
		pass.setForeground(Color.BLACK);
		pass.setFont(font2);
		userpass.add(pass);

		JLabel l8 = new JLabel("City");
		l8.setBounds(585,220,80,15);
		l8.setForeground(Color.BLACK);
		l8.setFont(font2);
		address.add(l8);

		JLabel user = new JLabel("Password");
		user.setBounds(25,60,150,15);
		user.setForeground(Color.BLACK);
		user.setFont(font2);
		userpass.add(user);

		JLabel user1 = new JLabel("Username(ID)");
		user1.setBounds(25,60,150,15);
		user1.setForeground(Color.BLACK);
		user1.setFont(font2);
		gender.add(user1);

		JLabel user2 = new JLabel("Confirm Username(ID)");
		user2.setBounds(25,120,150,15);
		user2.setForeground(Color.BLACK);
		user2.setFont(font2);
		gender.add(user2);

		Font font4 = new Font("TimesRoman",Font.BOLD,17);
		JLabel star1 = new JLabel("*");
		star1.setBounds(175,120,150,15);
		star1.setForeground(Color.RED);
		star1.setFont(font4);
		gender.add(star1);

		JLabel star2 = new JLabel("*");
		star2.setBounds(117,60,150,15);
		star2.setForeground(Color.RED);
		star2.setFont(font4);
		gender.add(star2);

		JLabel star3 = new JLabel("*");
		star3.setBounds(90,58,150,15);
		star3.setForeground(Color.RED);
		star3.setFont(font4);
		userpass.add(star3);

		JLabel star4 = new JLabel("*");
		star4.setBounds(140,120,150,15);
		star4.setForeground(Color.RED);
		star4.setFont(font4);
		userpass.add(star4);

		JLabel star5 = new JLabel("*");
		star5.setBounds(65,120,150,15);
		star5.setForeground(Color.RED);
		star5.setFont(font4);
		security.add(star5);

		JLabel star6 = new JLabel("*");
		star6.setBounds(100,60,150,15);
		star6.setForeground(Color.RED);
		star6.setFont(font4);
		personal.add(star6);

		JLabel star7 = new JLabel("*");
		star7.setBounds(395,60,150,15);
		star7.setForeground(Color.RED);
		star7.setFont(font4);
		personal.add(star7);

		JLabel star8 = new JLabel("*");
		star8.setBounds(657,60,150,15);
		star8.setForeground(Color.RED);
		star8.setFont(font4);
		personal.add(star8);

//Text Fields

		firstname = new JTextField("");
		firstname.setBounds(20,80,250,30);
		personal.add(firstname);
		middlename = new JTextField("");
		middlename.setBounds(300,80,250,30);
		personal.add(middlename);
		lastname	= new JTextField("");
		lastname.setBounds(580,80,250,30);
		personal.add(lastname);
		contact = new JTextField("");
		contact.setBounds(20,150,250,30);
		personal.add(contact);
		add = new JTextField("");
		add.setBounds(300,150,250,30);
		personal.add(add);
		t1 = new JTextField("");
		t1.setBounds(10,140,300,22);
		security.add(t1);
		pin = new JTextField("");
		pin.setBounds(20,320,250,22);
		address.add(pin);
		password1 = new JTextField("");
		password1.setBounds(20,80,250,22);
		userpass.add(password1);
		password2 = new JTextField("");
		password2.setBounds(20,140,250,22);
		userpass.add(password2);
		username1 = new JTextField("");
		username1.setBounds(20,80,250,22);
		gender.add(username1);
		username2 = new JTextField("");
		username2.setBounds(20,140,250,22);
		gender.add(username2);


//Buttons
		submit = new JButton("SUBMIT");
		submit.setBounds(400,640,100,30);
		main.add(submit);
		reset = new JButton("RESET");
		reset.setBounds(520,640,100,30);
		main.add(reset);
		back = new JButton("BACK");
		back.setBounds(640,640,100,30);
		main.add(back);
		cpy = new JButton(">>>");
		cpy.setBounds(400,120,70,50);
		address.add(cpy);

//Text Areas
		addtemp = new TextArea("");
		addtemp.setBounds(20,90,300,100);
		address.add(addtemp);
		addper = new TextArea("");
		addper.setBounds(540,90,300,100);
		address.add(addper);



//Choice Lists
		c1 = new Choice();
		c1.add("--Select--");
		c1.add("India");
		c1.setBounds(20,240,250,30);
		address.add(c1);

		c2 = new Choice();
		c2.add("--Select--");
		c2.add("Maharashtra");
		c2.add("Uttar Pradesh");
		c2.add("Andaman and Nicobar Islands ");
		c2.add("Andhra Pradesh");
		c2.add("Arunachal Pradesh");
		c2.add("Assam");
		c2.add("Bihar");
		c2.add("Chandigarh");
		c2.add("Chhattisgarh");
		c2.add("Goa");
		c2.add("Delhi");
		c2.add("Gujarat");
		c2.add("Haryana");
		c2.add("Himachal Pradesh");
		c2.add("Jammu and Kashmir");
		c2.add("Jharkhand");
		c2.add("Karnataka");
		c2.add("Kerala");
		c2.add("Ladakh");
		c2.add("Odisha");
		c2.add("Uttarakhand");
 		c2.setBounds(300,240,250,30);
		address.add(c2);

		c3 = new Choice();
		c3.add("--Select--");
		c3.add("Pune");
		c3.add("Mumbai");
		c3.add("Nagpur");
		c3.add("Satara");
		c3.add("Sangli");
		c3.add("Kolhapur");
		c3.add("Nashik");
		c3.add("Navi-Mumbai");
		c3.add("Hydrabad");
		c3.add("Ranchi");
		c3.add("Bengluru");
		c3.add("Delhi");
		c3.add("Kolkata");
		c3.add("Jaipur");
		c3.add("Bhopal");
		c3.add("Surat");
		c3.add("Kochi");
		c3.add("Varanasi");
		c3.add("Agra");
		c3.add("Indore");
		c3.add("Kanpur");
		c3.add("Guvahati");
		c3.add("Jabalpur");
		c3.add("Madurai");
		c3.add("Jabalpur");
		c3.add("Jodhpur");
		c3.add("Amritsar");
 		c3.setBounds(580,240,250,30);
		address.add(c3);

		c4 = new Choice();
		c4.add("--Select--");
		c4.add("What primary school did you attend?");
		c4.add("In what town or city was your first full time job?");
		c4.add("What is the name of your favorite childhood friend?");
		c4.add("What school did you attend for sixth grade?");
		c4.add("Who was your childhood hero?");
		c4.add("What is your current car registration number?");
		c4.add("What is your mother's middle name?");
		c4.add("What is the name of the first school you attended?");
		c4.add("What is your favorite TV program?");
		c4.add("What is your favorite sport?");
		c4.add("In what city were you born?");
		c4.setBounds(10,80,300,30);
		security.add(c4);


//Event Handling
		ButtonHandler bh = new ButtonHandler();
		back.addActionListener(bh);
		reset.addActionListener(new ResetButton());
		cpy.addActionListener(new ResetButton());
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==submit)
				{
					try
					{
						int uno = 0;
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						PreparedStatement pst1=con.prepareStatement("insert into admreg values(?,?,?,?,?,?)");
						PreparedStatement pst2=con.prepareStatement("select count(uid) from admreg");
						ResultSet rs1=pst2.executeQuery();
						Statement stmt=con.createStatement();
						if(rs1.next()){uno=Integer.parseInt(rs1.getString(1));System.out.println(uno);}
						uno++;
						System.out.println(uno);
						String uname = firstname.getText();
						String uid1 = username1.getText();
						String uid2 = username2.getText();
						String pass1=password1.getText();
						String pass2=password2.getText();
						String qn1 = c4.getSelectedItem();
						String ans1 = t1.getText();
						ResultSet rs=stmt.executeQuery("select uid from admreg where uid = '"+uid1+"';");
						if(rs.first())
						{
							JOptionPane.showMessageDialog(null,"Sorry! Username You Entered Is Aleardy Exist Please Enter Another Username","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else if(uname.equals("") || uid1.equals("") || uid2.equals("") || pass1.equals("") || pass2.equals("") || ans1.equals("") )
						{
							JOptionPane.showMessageDialog(null,"Please Fill All The Details Having (*) ","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							 if(pass1.equals(pass2) && uid1.equals(uid2))
							{
								pst1.setInt(1,uno);
								pst1.setString(2,uname);
								pst1.setString(3,uid1);
								pst1.setString(4,pass1);
								pst1.setString(5,qn1);
								pst1.setString(6,ans1);
								pst1.executeUpdate();
								System.out.println("complete");
								JOptionPane.showMessageDialog(null,"Registered Successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
								new MainScreen();
								setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Passwords or Username(id) Dosn't match","ERROR",JOptionPane.ERROR_MESSAGE);
							}
						}
					}

					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
	});
		add(background);
		setResizable(false);
		setVisible(true);

	}
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==back)
				new RegOpt();

				setVisible(false);
		}
	}
	class ResetButton implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==reset)
			{
				JOptionPane.showMessageDialog(null,"Do You Want To Reset Form ?","WARNING",JOptionPane.WARNING_MESSAGE);
				firstname.setText("");
				middlename.setText("");
				lastname.setText("");
				contact.setText("");
				add.setText("");
				t1.setText("");
				pin.setText("");
				password1.setText("");
				password2.setText("");
				username1.setText("");
				username2.setText("");
				addtemp.setText("");
				addper.setText("");
				c1.select(0);
				c2.select(0);
				c3.select(0);
				c4.select(0);
			}
			if(ae.getSource()==cpy)
			{
				String addfinal = addtemp.getText();
				addper.setText(addfinal);
			}
		}
	}
}
