import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class EmpAttendance extends JFrame
{
	JButton attendance,details,payment,back;
	int pr=0,ab=0;
	String currdate="";
	EmpAttendance()
	{
		setTitle("WELCOME");
		setLayout(null);
		setBounds(100,00,1300,1000);

		ImageIcon bg_img = new ImageIcon("main2.jpg");
		Image img = bg_img.getImage();
		Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBounds(0,0,1300,1000);

		//Panels
		JPanel heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,2560,100);
		heading.setLayout(null);
		background.add(heading);

		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(0,0,0,70));
		main.setBounds(10,110,1260,770);
		background.add(main);

		JPanel p1 = new JPanel();
		p1.setBounds(450,100,340,380);
		p1.setBackground(new Color(255,255,255,90));
		p1.setLayout(null);
		main.add(p1);

		//Labels
		JLabel l1 = new JLabel("ATTENDANCE");
		l1.setBounds(450,10,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		Font font2 = new Font("TimesRoman",Font.BOLD,15);
		JLabel un = new JLabel("Username(ID)");
		un.setBounds(25,40,500,30);
		un.setForeground(Color.BLACK);
		un.setFont(font2);
		p1.add(un);

		//TextFields
		TextField username = new TextField("");
		username.setBounds(20,70,300,30);
		p1.add(username);

		//Buttons
		JButton mark = new JButton("MARK");
		mark.setBounds(120,220,100,30);
		p1.add(mark);

		JButton reset = new JButton("RESET");
		reset.setBounds(120,260,100,30);
		p1.add(reset);

		JButton back = new JButton("BACK");
		back.setBounds(120,300,100,30);
		p1.add(back);

		//RadioButtons
		ButtonGroup cb = new ButtonGroup();

		JRadioButton present = new JRadioButton("Present");
		present.setBounds(120,130,100,30);
		JRadioButton absent = new JRadioButton("Absent");
		absent.setBounds(120,160,100,30);

		//EventHandling
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
				{
					new EmpOpt();
					setVisible(false);
				}
			}
		});

		mark.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==mark)
				{
					String uname = username.getText();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();

    				try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select * from empattendance where uid='"+uname+"';");
						if(rs.next())
						{
							pr = rs.getInt(3);
							ab = rs.getInt(4);
							if(present.isSelected())
							{
								pr++;
							}
							else if(absent.isSelected())
							{
								ab++;
								currdate = formatter.format(date);
								PreparedStatement ps3 = con.prepareStatement("insert into empabsentdate values(?,?)");
								ps3.setString(1,uname);
								ps3.setString(2,currdate);
								ps3.executeUpdate();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Sorry ! Please Select Present or Absent","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							PreparedStatement ps1 = con.prepareStatement("UPDATE empattendance set  NoofPresentDays=? where uid='"+uname+"';");
							PreparedStatement ps2 = con.prepareStatement("UPDATE empattendance set   NoofAbsentDays=? where uid='"+uname+"';");

							ps1.setInt(1,pr);
							ps2.setInt(1,ab);

							ps1.executeUpdate();
							ps2.executeUpdate();

						}
						else
						{
								JOptionPane.showMessageDialog(null,"Sorry ! Invalid Username\n(If You Are Not Registered Please Register And Try Again)","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		});


		cb.add(present);
		cb.add(absent);
		p1.add(present);
		p1.add(absent);

		add(background);
		setResizable(false);
		setVisible(true);

	}

}