import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EmpReg extends JFrame
{
	JButton submit,reset,back,cpy;
	TextArea addtemp,addper;
	public EmpReg()
	{

		setTitle("Emplployee Registration.....");
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
		address.setBounds(10,260,880,180);
		main.add(address);

		JPanel gender = new JPanel();
		gender.setBackground(new Color(255,255,255,90));
		gender.setLayout(null);
		gender.setBounds(900,50,350,200);
		main.add(gender);



		JPanel userpass = new JPanel();
		userpass.setBackground(new Color(255,255,255,90));
		userpass.setLayout(null);
		userpass.setBounds(900,260,350,180);
		main.add(userpass);

		JPanel bankdet = new JPanel();
		bankdet.setBackground(new Color(255,255,255,90));
		bankdet.setLayout(null);
		bankdet.setBounds(10,450,1240,180);
		main.add(bankdet);

		//Labels


		JLabel regform = new JLabel("REGISTRATION FORM...");
		regform.setBounds(20,-20,500,80);
		regform.setForeground(Color.WHITE);
		Font font1 = new Font("TimesRoman",Font.BOLD,40);
		regform.setFont(font1);
		main.add(regform);

		JLabel admreg = new JLabel("EMPLOYEE  REGISTRATION...");
		admreg.setBounds(190,10,1000,80);
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

		JLabel g1 = new JLabel("Gender...");
		g1.setBounds(10,0,500,50);
		g1.setForeground(Color.BLACK);
		g1.setFont(font3);
		gender.add(g1);



		JLabel up = new JLabel("Username...");
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
		at.setBounds(25,50,150,15);
		at.setForeground(Color.BLACK);
		at.setFont(font2);
		address.add(at);

		JLabel ap = new JLabel("Address(Parmenent)");
		ap.setBounds(545,50,150,15);
		ap.setForeground(Color.BLACK);
		ap.setFont(font2);
		address.add(ap);

		JLabel pc = new JLabel("PIN Code");
		pc.setBounds(25,300,150,15);
		pc.setForeground(Color.BLACK);
		pc.setFont(font2);
		address.add(pc);



		JLabel pass = new JLabel("Re-Enter Username(ID)");
		pass.setBounds(25,120,200,15);
		pass.setForeground(Color.BLACK);
		pass.setFont(font2);
		userpass.add(pass);

		JLabel l8 = new JLabel("City");
		l8.setBounds(585,220,80,15);
		l8.setForeground(Color.BLACK);
		l8.setFont(font2);
		address.add(l8);

		JLabel user = new JLabel("Username(ID)");
		user.setBounds(25,60,150,15);
		user.setForeground(Color.BLACK);
		user.setFont(font2);
		userpass.add(user);

		JLabel bnk = new JLabel("Bank Details...");
		bnk.setBounds(500,0,500,50);
		bnk.setForeground(Color.BLACK);
		bnk.setFont(font3);
		bankdet.add(bnk);

		JLabel bhn = new JLabel("Bank Name");
		bhn.setBounds(65,80,150,15);
		bhn.setForeground(Color.BLACK);
		bhn.setFont(font2);
		bankdet.add(bhn);

		JLabel an = new JLabel("Bank Holder's Name");
		an.setBounds(345,80,150,15);
		an.setForeground(Color.BLACK);
		an.setFont(font2);
		bankdet.add(an);

		JLabel in  = new JLabel("Account Number");
		in.setBounds(625,80,150,15);
		in.setForeground(Color.BLACK);
		in.setFont(font2);
		bankdet.add(in);

		JLabel ic  = new JLabel("IFSC Code");
		ic.setBounds(905,80,150,15);
		ic.setForeground(Color.BLACK);
		ic.setFont(font2);
		bankdet.add(ic);

		Font font4 = new Font("TimesRoman",Font.BOLD,17);
		JLabel star1 = new JLabel("*");
		star1.setBounds(657,60,150,15);
		star1.setForeground(Color.RED);
		star1.setFont(font4);
		personal.add(star1);


		//TextFields
		JTextField firstname = new JTextField("");
		firstname.setBounds(20,80,250,30);
		personal.add(firstname);
		JTextField middlename = new JTextField("");
		middlename.setBounds(300,80,250,30);
		personal.add(middlename);
		JTextField lastname = new JTextField("");
		lastname.setBounds(580,80,250,30);
		personal.add(lastname);
		JTextField contact = new JTextField("");
		contact.setBounds(20,150,250,30);
		personal.add(contact);
		JTextField add = new JTextField("");
		add.setBounds(300,150,250,30);
		personal.add(add);
		JTextField username = new JTextField("");
		username.setBounds(20,80,250,22);
		userpass.add(username);
		JTextField username2 = new JTextField("");
		username2.setBounds(20,140,250,22);
		userpass.add(username2);
		JTextField bnkname = new JTextField("");
		bnkname.setBounds(60,100,250,30);
		bankdet.add(bnkname);
		JTextField holdername = new JTextField("");
		holdername.setBounds(340,100,250,30);
		bankdet.add(holdername);
		JTextField accno = new JTextField("");
		accno.setBounds(620,100,250,30);
		bankdet.add(accno);
		JTextField ifce = new JTextField("");
		ifce.setBounds(900,100,250,30);
		bankdet.add(ifce);

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
		cpy.setBounds(400,90,60,40);
		address.add(cpy);

		//Text Areas
		addtemp = new TextArea("");
		addtemp.setBounds(20,70,300,80);
		address.add(addtemp);
		addper = new TextArea("");
		addper.setBounds(540,70,300,80);
		address.add(addper);

		//Radio Buttons
		ButtonGroup cb = new ButtonGroup();
		JRadioButton male = new JRadioButton("1) MALE");
		male.setBounds(30,60,100,30);
		JRadioButton female = new JRadioButton("2) FEMALE");
		female.setBounds(30,90,100,30);
		JRadioButton other = new JRadioButton("3) OTHER");
		other.setBounds(30,120,100,30);
		cb.add(male);
		cb.add(female);
		cb.add(other);
		gender.add(male);
		gender.add(female);
		gender.add(other);

		//Event Handling
		ButtonHandler bh = new ButtonHandler();
		back.addActionListener(bh);
		cpy.addActionListener(bh);
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String gndr;
				int p=0;int a=0;
				try
				{
					String fname = firstname.getText();
					String lname = lastname.getText();
					String name = fname+" "+lname;
					String contno = contact.getText();
					String address = addper.getText();
					String bankname = bnkname.getText();
					String bankholder = holdername.getText();
					String account = accno.getText();
					String IFSC = ifce.getText();
					String user1 = username.getText();
					String user2 = username2.getText();

					if(male.isSelected())
					{
						gndr = "Male";
					}
					else if(female.isSelected())
					{
						gndr = "Female";
					}
					else
					{
						gndr = "Other";
					}
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery("select e_username from empreg where e_username = '"+user1+"';");
					if(rs.first())
					{
						JOptionPane.showMessageDialog(null,"Sorry! Username You Entered Is Aleardy Exist Please Enter Another Username","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else if(fname.equals("") || lname.equals("") || contno.equals("") || address.equals("") || bankname.equals("") || bankholder.equals("") || account.equals("") || IFSC.equals("") || user1.equals("") || user2.equals("") || gndr.equals("") )
					{
						JOptionPane.showMessageDialog(null,"Please Fill All The Details Having (*) ","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						PreparedStatement pst = con.prepareStatement("insert into empreg values(?,?,?,?,?,?,?,?,?)");
						PreparedStatement pst2 = con.prepareStatement("insert into empattendance values(?,?,?,?)");
						if(user1.equals(user2))
						{
							pst.setString(1,name);
							pst.setString(2,user1);
							pst.setString(3,contno);
							pst.setString(4,address);
							pst.setString(5,gndr);
							pst.setString(6,bankname);
							pst.setString(7,bankholder);
							pst.setString(8,account);
							pst.setString(9,IFSC);
							pst2.setString(1,name);
							pst2.setString(2,user1);
							pst2.setInt(3,p);
							pst2.setInt(4,a);
							pst.executeUpdate();
							pst2.executeUpdate();
							System.out.println("Complete");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Username(id) Dosn't match","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
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
			{	new RegOpt();
				setVisible(false);
			}
			if(ae.getSource()==cpy)
			{
				String addfinal = addtemp.getText();
				addper.setText(addfinal);
			}
		}
	}
	public static void main(String args[])
	{
		new EmpReg();
	}

}