import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class RegOrd extends JFrame
{
	String productname;
	TextField product,cost;
	int productcost;
	private JTable table;
	RegOrd()
	{
		setBounds(100,00,1300,1000);
		setLayout(null);
		JScrollPane sp;

		ImageIcon bg_img = new ImageIcon("main2.jpg");
		Image img = bg_img.getImage();
		Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBounds(0,0,1300,1000);

		JPanel heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,2560,130);
		heading.setLayout(null);
		background.add(heading);

		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(0,0,0,70));
		main.setBounds(00,180,2560,500);
		background.add(main);


		JLabel l1 = new JLabel("ORDER DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		product = new TextField("");
		product.setBounds(500,400,250,28);
		main.add(product);
		JButton back = new JButton("BACK");
		back.setBounds(580,455,100,30);
		main.add(back);

		JButton add = new JButton("View");
		add.setBounds(450,455,100,30);
		main.add(add);

		JButton delev = new JButton("Delevered");
		delev.setBounds(710,455,100,30);
		main.add(delev);

		JLabel productn = new JLabel("Enter Username To View Orders");
		productn.setBounds(510,345,1000,80);
		productn.setForeground(Color.BLACK);
		Font font1 = new Font("TimesRoman",Font.BOLD,15);
		productn.setFont(font1);
		main.add(productn);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new Welcome();
				setVisible(false);
			}
		});
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String name = product.getText();
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill All The Details!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						Statement st2 = con2.createStatement();
						ResultSet rs2 = st2.executeQuery("Select * from orderfrom where uid='"+name+"';");
						if(rs2.first())
						{
								new ViewOrder(name);
								setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"You Didn't Receive any from this user","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		});


			try
			{
			int i = 0,no=1;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from orderfrom");
			DefaultTableModel model = new DefaultTableModel();
			table = new JTable(model);
			model.addColumn("Name");
			model.addColumn("Contact No.");
			model.addColumn("Address");
			model.addColumn("Username");
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			while(rs.next())
			{

				String name = rs.getString(1);
				String cont = rs.getString(2);
				String addr = rs.getString(3);
				String user = rs.getString(4);

				model.insertRow(i, new Object[] {name,cont,addr,user});
				no++;
				i++;
			}
			sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			sp.setBounds(380,20,500,300);
			main.add(sp);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		add(background);
		setVisible(true);
		setResizable(false);
		delev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				int i=table.getSelectedRow();
				System.out.println(""+i);
				String un =(table.getValueAt(i,3).toString());
				System.out.println(""+un);
				try
				{
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					PreparedStatement ps1 = con1.prepareStatement("delete from orderfrom where uid=?");
					ps1.setString(1,un);
					ps1.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				new RegOrd();
				setVisible(false);
			}
		});
	}
	public static void main(String args[])
	{
			new RegOrd();
	}
}