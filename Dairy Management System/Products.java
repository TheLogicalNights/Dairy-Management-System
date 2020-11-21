import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Products extends JFrame
{
	String productname;
	TextField product,cost;
	int productcost;
	Products()
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


		JLabel l1 = new JLabel("PRODUCT DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		product = new TextField("");
		product.setBounds(350,400,250,28);
		main.add(product);

		cost = new TextField("");
		cost.setBounds(650,400,250,28);
		main.add(cost);

		JButton back = new JButton("BACK");
		back.setBounds(620,455,100,30);
		main.add(back);

		JButton add = new JButton("ADD");
		add.setBounds(500,455,100,30);
		main.add(add);

		JLabel productn = new JLabel("Product Name");
		productn.setBounds(360,345,1000,80);
		productn.setForeground(Color.BLACK);
		Font font1 = new Font("TimesRoman",Font.BOLD,15);
		productn.setFont(font1);
		main.add(productn);

		JLabel productc = new JLabel("Price");
		productc.setBounds(660,345,1000,80);
		productc.setForeground(Color.BLACK);
		productc.setFont(font1);
		main.add(productc);

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
				productname = product.getText();
				productcost = Integer.parseInt(cost.getText());
				if(ae.getSource()==add)
				{
					try
					{

						if(productname.equals("") || cost.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null,"Sorry ! Please Fill All Details!","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
							PreparedStatement ps1 = con.prepareStatement("insert into product values(?,?)");
							ps1.setString(1,productname);
							ps1.setInt(2,productcost);
							ps1.executeUpdate();
							new Products();
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

			try
			{
			int i = 0,no=1;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.addColumn("Sr.No");
			model.addColumn("Product Name");
			model.addColumn("Price");
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			while(rs.next())
			{

				String name = rs.getString(1);
				int price = rs.getInt(2);

				model.insertRow(i, new Object[] {no,name,price});
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
	}
	public static void main(String args[])
	{
		new Products();
	}
}