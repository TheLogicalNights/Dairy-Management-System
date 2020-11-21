import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class CustLogin extends JFrame
{
	private final JButton login,back;
	private final JCheckBox cb1;
	private final JTextField username;
	private final JPasswordField password;
	public CustLogin()
	{
	setTitle("Login Page");
	setLayout(null);


	setBounds(100,00,1300,1000);

	ImageIcon bg_img1 = new ImageIcon("IMG_2877.jpg");
	Image img = bg_img1.getImage();
	Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
	bg_img1 = new ImageIcon(temp);
	JLabel background = new JLabel("",bg_img1,JLabel.CENTER);
	background.setBounds(0,0,1300,1000);

	JPanel heading4 = new JPanel();
	heading4.setBackground(new Color(0,0,0,80));
	heading4.setLayout(null);
	heading4.setBounds(0,0,2560,100);

	JPanel main = new JPanel();
	main.setLayout(null);
	main.setBackground(new Color(0,0,0,70));
	main.setBounds(10,110,1260,770);
	background.add(main);

	JPanel p1 = new JPanel();
	p1.setBounds(450,100,340,380);
	p1.setBackground(new Color(255,255,255,90));
	p1.setLayout(null);

	JLabel l1 = new JLabel("LOGIN....");
	l1.setBounds(550,10,1000,80);
	l1.setForeground(Color.WHITE);
	Font font = new Font("TimesRoman",Font.BOLD,60);
	l1.setFont(font);

	Font font2 = new Font("TimesRoman",Font.BOLD,15);
	JLabel un = new JLabel("Username(ID)");
	un.setBounds(25,30,500,50);
	un.setForeground(Color.BLACK);
	un.setFont(font2);
	p1.add(un);

	JLabel pw = new JLabel("Password");
	pw.setBounds(25,110,500,50);
	pw.setForeground(Color.BLACK);
	pw.setFont(font2);
	p1.add(pw);

	cb1 = new JCheckBox("Show Password");
	cb1.setBounds(30,190,120,25);
	p1.add(cb1);


	username = new JTextField();
	username.setBounds(20,70,300,30);

	password = new JPasswordField(10);
	password.setBounds(20,150,300,30);

	login = new JButton("LOGIN");
	login.setBounds(120,230,80,30);

	back = new JButton("Back");
	back.setBounds(120,310,80,30);

	ButtonHandler bh = new ButtonHandler();
	back.addActionListener(bh);
	cb1.addItemListener(new ItemListener()
	{
		public void itemStateChanged(ItemEvent ie)
		{
  			if (ie.getStateChange() == ItemEvent.SELECTED)
  			{
	        	password.setEchoChar((char) 0);
				cb1.setText("Hide Password");
	        }
	        else
	        {
	        	password.setEchoChar(('•'));
				cb1.setText("Show Password");
	        }
	    }
});
	login.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==login)
			{
				String uname = username.getText();
				String upass = password.getText();

				try
				{

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select uid from custreg where uid = '"+uname+"';");
					if(uname.equals("") || upass.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Fill All Details","Error",JOptionPane.ERROR_MESSAGE);
					}
					else if(rs.next())
					{
						Statement st1 = con.createStatement();
						ResultSet rs1 = st1.executeQuery("select password from custreg where uid = '"+uname+"';");
						if(rs1.next())
						{
							if(upass.equals(rs1.getString(1)))
							{
								new CustOrder();
								setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Password You Entered Is Incorrect","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else
						{
							JOptionPane.showMessageDialog(null,"Username(ID) You Entered Is Invalid.\n(If You Are Not Registered Please Register And Try Again)","Error",JOptionPane.ERROR_MESSAGE);
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
	background.add(heading4);
	heading4.add(l1);
	main.add(p1);
	p1.add(username);
	p1.add(password);
	p1.add(login);
	p1.add(back);

	setResizable(false);
	setVisible(true);
	}
	class ButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new CustMain();
				setVisible(false);

			}
	}

	public static void main(String args[])
	{
		new CustLogin();
	}

}
