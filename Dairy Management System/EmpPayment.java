import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class EmpPayment extends JFrame
{
	JScrollPane sp;
	EmpPayment()
	{
		setTitle("Payment");
		setLayout(null);

		setBounds(100,00,1300,1000);

		ImageIcon bg_img = new ImageIcon("main2.jpg");
		Image img = bg_img.getImage();
		Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBounds(0,0,1300,1000);
		add(background);

		JPanel heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setLayout(null);
		heading.setBounds(0,0,2560,150);
		background.add(heading);

		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(0,0,0,70));
		main.setBounds(00,200,2560,500);
		background.add(main);

		JLabel l1 = new JLabel("PAYMENT");
		l1.setBounds(500,30,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		TextField uname = new TextField("");
		uname.setBounds(450,400,300,30);
		main.add(uname);

		JLabel label = new JLabel("Enter Username(ID) To Check Absent Details.");
		label.setBounds(450,340,1000,80);
		label.setForeground(Color.BLACK);
		Font font1 = new Font("TimesRoman",Font.BOLD,15);
		label.setFont(font1);
		main.add(label);

		JButton go = new JButton("GO");
		go.setBounds(435,450,100,30);
		main.add(go);

		JButton back = new JButton("BACK");
		back.setBounds(555,450,100,30);
		main.add(back);

		JButton reset = new JButton("RESET");
		reset.setBounds(675,450,100,30);
		main.add(reset);

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

		go.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==go)
				{
					if(uname.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Sorry ! Please Enter Username(ID)","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						new EmpAbsent(uname.getText());
						setVisible(false);
					}
				}
			}
		});

		try
		{
			int i = 0;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from empattendance");
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.addColumn("Name");
			model.addColumn("Username");
			model.addColumn("No Of Present Days");
			model.addColumn("Payment(In Rs.)");
			table.getColumnModel().getColumn(0).setPreferredWidth(70);
			table.getColumnModel().getColumn(1).setPreferredWidth(57);
			table.getColumnModel().getColumn(2).setPreferredWidth(25);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			while(rs.next())
			{
				String name = rs.getString(1);
				String username = rs.getString(2);
				int present = rs.getInt(3);
				int payment = 400*present;
				model.insertRow(i, new Object[] {name,username,present,payment});
				i++;
			}
			sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			sp.setBounds(150,20,950,300);
			main.add(sp);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

			reset.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(ae.getSource()==reset)
					{
						try
						{
							int ip = JOptionPane.showConfirmDialog(null,"Do You Want To Logout ","LOGOUT",JOptionPane.WARNING_MESSAGE);
							if(ip==JOptionPane.YES_OPTION)
							{
								Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
								PreparedStatement ps1 = con1.prepareStatement("UPDATE empattendance set NoofPresentDays='0'");
								PreparedStatement ps2 = con1.prepareStatement("UPDATE empattendance set NoofAbsentDays='0'");
								PreparedStatement ps3 = con1.prepareStatement("DELETE FROM empabsentdate;");
								ps1.executeUpdate();
								ps2.executeUpdate();
								ps3.executeUpdate();
								new EmpPayment();
								setVisible(false);
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
				}
		});
		setResizable(false);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new EmpPayment();
	}

}