import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class ViewOrder extends JFrame
{
	String productname;
	TextField product,cost;
	int productcost;
	ViewOrder(String un)
	{
		String usero = un;
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


		JLabel l1 = new JLabel("CUSTOMER DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		JButton back = new JButton("BACK");
		back.setBounds(500,430,100,30);
		main.add(back);

		JButton confirm = new JButton("Confirm");
		confirm.setBounds(630,430,100,30);
		main.add(confirm);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new RegOrd();
				setVisible(false);
			}
		});
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					PreparedStatement ps1 = con1.prepareStatement("delete from order1 where uid=?");
					ps1.setString(1,usero);
					ps1.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				new ViewOrder(usero);
				setVisible(false);
			}
		});
		try
					{
					int i = 0,no=1;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from order1 where uid='"+usero+"';");
					DefaultTableModel model = new DefaultTableModel();
					JTable table = new JTable(model);
					model.addColumn("Products");
					model.addColumn("Price");
					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					table.getColumnModel().getColumn(1).setPreferredWidth(45);
					while(rs.next())
					{

						String name = rs.getString(2);
						String cont = rs.getString(3);
						model.insertRow(i, new Object[] {name,cont});
						no++;
						i++;
					}
					sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					sp.setBounds(380,80,500,300);
					main.add(sp);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				add(background);
				setVisible(true);
				setResizable(false);
			}
			public static void main(String args[])
			{
				new ViewOrder("ath123");
			}
}
