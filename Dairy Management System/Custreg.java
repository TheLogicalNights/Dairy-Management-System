import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Custreg extends JFrame
{
	private final JButton submit,reset;
	private final JTextField firstname,middlename,lastname,contact,add,t1;
	private final TextArea addtemp;
	public Custreg()
	{
		setTitle("Customer Registration.....");
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
		personal.setBounds(10,50,1240,620);
		main.add(personal);

		JLabel admreg = new JLabel("CUSTOMER REGISTRATION");
		admreg.setBounds(280,10,1000,80);
		admreg.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		admreg.setFont(font);
		heading3.add(admreg);

		firstname = new JTextField("");
		firstname.setBounds(500,80,250,30);
		personal.add(firstname);
		middlename = new JTextField("");
		middlename.setBounds(500,140,250,30);
		personal.add(middlename);
		lastname	= new JTextField("");
		lastname.setBounds(500,330,250,30);
		personal.add(lastname);
		contact = new JTextField("");
		contact.setBounds(500,390,250,30);
		personal.add(contact);
		add = new JTextField("");
		add.setBounds(500,450,250,30);
		personal.add(add);
		t1 = new JTextField("");
		t1.setBounds(500,510,250,30);
		personal.add(t1);

		addtemp = new TextArea("");
		addtemp.setBounds(500,200,300,100);
		personal.add(addtemp);

		submit = new JButton("SUBMIT");
		submit.setBounds(520,560,100,30);
		personal.add(submit);
		reset = new JButton("RESET");
		reset.setBounds(640,560,100,30);
		personal.add(reset);

		Font font2 = new Font("TimesRoman",Font.BOLD,18);
		JLabel st = new JLabel("Name");
		st.setBounds(300,83,80,15);
		st.setForeground(Color.BLACK);
		st.setFont(font2);
		personal.add(st);

		JLabel sq = new JLabel("Contact No.");
		sq.setBounds(300,143,150,15);
		sq.setForeground(Color.BLACK);
		sq.setFont(font2);
		personal.add(sq);

		JLabel fn = new JLabel("Address");
		fn.setBounds(300,203,150,15);
		fn.setForeground(Color.BLACK);
		fn.setFont(font2);
		personal.add(fn);

		JLabel mn = new JLabel("Username");
		mn.setBounds(300,333,150,15);
		mn.setForeground(Color.BLACK);
		mn.setFont(font2);
		personal.add(mn);

		JLabel ln  = new JLabel("Confirm Username");
		ln.setBounds(300,393,160,20);
		ln.setForeground(Color.BLACK);
		ln.setFont(font2);
		personal.add(ln);

		JLabel cn = new JLabel("Password");
		cn.setBounds(300,453,150,15);
		cn.setForeground(Color.BLACK);
		cn.setFont(font2);
		personal.add(cn);

		JLabel ea = new JLabel("Confirm Password");
		ea.setBounds(300,513,150,15);
		ea.setForeground(Color.BLACK);
		ea.setFont(font2);
		personal.add(ea);

		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				firstname.setText("");
				middlename.setText("");
				lastname.setText("");
				contact.setText("");
				add.setText("");
				t1.setText("");
				addtemp.setText("");
			}
		});
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				int p=0;int a=0;
				try
				{
							String fname = firstname.getText();
							String contno = middlename.getText();
							String address = addtemp.getText();
							String user1 = lastname.getText();
							String user2 = contact.getText();
							String pass1 = add.getText();
							String pass2 = t1.getText();

							//Class.forName("org.postgresql.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
							Statement stmt=conn.createStatement();
							ResultSet rs=stmt.executeQuery("select uid from custreg where uid = '"+user1+"';");
							if(rs.first())
							{
								JOptionPane.showMessageDialog(null,"Sorry! Username You Entered Is Aleardy Exist Please Enter Another Username","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								if(fname.equals("") || contno.equals("") || address.equals("") || user1.equals("") || user2.equals("") || pass1.equals("") || pass2.equals(""))
								{
									JOptionPane.showMessageDialog(null,"Please Fill All The Details Having (*) ","ERROR",JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
									PreparedStatement pst = con.prepareStatement("insert into custreg values(?,?,?,?,?)");
									if(user1.equals(user2) && pass1.equals(pass2))
									{
										pst.setString(1,fname);
										pst.setString(2,contno);
										pst.setString(3,address);
										pst.setString(4,user1);
										pst.setString(5,pass1);
										pst.executeUpdate();
										new CustLogin();
										setVisible(false);
										System.out.println("Complete");
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Username(id) & Password Dosn't match","ERROR",JOptionPane.ERROR_MESSAGE);
									}
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
	public static void main(String args[])
	{
		new Custreg();
	}
}