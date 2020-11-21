import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class CustOrder extends JFrame
{
	String productname;
	private final TextField cost,username,qnt;
	private final JComboBox cmbProduct;
	private final DefaultTableModel model;
	private final JTable table;
	private final JButton back,add,remove,confirm;
	static int i,no;
	static
	{
		i=0;
		no=1;
	}
	int productcost;
	CustOrder()
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
		main.setBounds(00,150,2560,600);
		background.add(main);


		JLabel l1 = new JLabel("PRODUCT DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		cmbProduct = new JComboBox();
		cmbProduct.setBounds(350,450,250,28);
		main.add(cmbProduct);

		username = new TextField("");
		username.setBounds(500,20,250,28);
		main.add(username);

		cost = new TextField("");
		cost.setBounds(650,450,80,28);
		cost.setEditable(false);
		main.add(cost);

		qnt = new TextField("");
		qnt.setBounds(750,450,80,28);
		main.add(qnt);

		back = new JButton("LOGOUT");
		back.setBounds(620,500,100,30);
		main.add(back);

		add = new JButton("ADD");
		add.setBounds(500,500,100,30);
		main.add(add);

		remove = new JButton("Remove");
		remove.setBounds(720,500,100,30);
		main.add(remove);
		confirm = new JButton("SUBMIT");
		confirm.setBounds(820,500,100,30);
		main.add(confirm);
		JLabel productn = new JLabel("Product Name");
		productn.setBounds(360,395,1000,80);
		productn.setForeground(Color.BLACK);
		Font font1 = new Font("TimesRoman",Font.BOLD,15);
		productn.setFont(font1);
		main.add(productn);

		JLabel productc = new JLabel("Price");
		productc.setBounds(660,395,1000,80);
		productc.setForeground(Color.BLACK);
		productc.setFont(font1);
		main.add(productc);

		JLabel q = new JLabel("Quantity");
		q.setBounds(760,395,1000,80);
		q.setForeground(Color.BLACK);
		q.setFont(font1);
		main.add(q);

		JLabel u = new JLabel("Usrname");
		u.setBounds(400,20,200,30);
		Font font4 = new Font("TimesRoman",Font.BOLD,18);
		u.setForeground(Color.WHITE);
		u.setFont(font4);
		main.add(u);
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from product");
			cmbProduct.addItem("-select-");
			while(rs.next())
			{
				cmbProduct.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		cmbProduct.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				try
				{
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					String iname = cmbProduct.getSelectedItem().toString();
					Statement st1 = con1.createStatement();
					ResultSet rs1 = st1.executeQuery("select price from product where  productname='"+iname+"';");
					if(rs1.next())
					{
						cost.setText(rs1.getString(1));
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new Welcome();
				setVisible(false);
			}
		});
		remove.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				 int getSelectedRowForDeletion = table.getSelectedRow();
				 System.out.println(getSelectedRowForDeletion);
				 String uid = (String)table.getValueAt(getSelectedRowForDeletion,1);
      			 System.out.println(uid);
				 if (getSelectedRowForDeletion>=0)
				 {
					 try
					 {
				     model.removeRow(getSelectedRowForDeletion);
				     Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					 PreparedStatement ps3 = con3.prepareStatement("delete from order1 where product=?;");
					 ps3.setString(1,uid);
					 ps3.executeUpdate();
				 	}
				 	catch(Exception e)
				 	{
						System.out.println(e);
					}
				 }
				 else
				 {
				            JOptionPane.showMessageDialog(null, "Unable To Delete");
      			 }
			}
		});
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(username.getText().equals("") || cost.getText().equals("") || qnt.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter username");
				}
				else
				{
				try
				{
				String name = cmbProduct.getSelectedItem().toString();
				String price = cost.getText();
				String Q = qnt.getText();
				model.insertRow(i, new Object[] {no,name,price,Q});
				no++;i++;
				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
				PreparedStatement ps2 = con2.prepareStatement("insert into order1 values(?,?,?,?);");
				ps2.setString(1,username.getText());
				ps2.setString(2,name);
				ps2.setString(3,price);
				ps2.setString(4,Q);
				ps2.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				}
			}
		});
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(username.getText().equals("") || cost.getText().equals("") || qnt.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter username");
					}
					else
					{
							Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						Statement st2 = con2.createStatement();
						ResultSet rs2 = st2.executeQuery("select * from custreg where uid='"+username.getText()+"';");
						if(rs2.first())
						{
							String name = rs2.getString(1);
							String cont = rs2.getString(2);
							String addr = rs2.getString(3);
							String uname = rs2.getString(4);
							PreparedStatement ps1 = con2.prepareStatement("insert into orderfrom values(?,?,?,?);");
							ps1.setString(1,name);
							ps1.setString(2,cont);
							ps1.setString(3,addr);
							ps1.setString(4,uname);
							ps1.executeUpdate();
							new DispalyOrd(username.getText());
							setVisible(false);
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});

			model = new DefaultTableModel();
			table = new JTable(model);
			model.addColumn("Sr.No");
			model.addColumn("Product Name");
			model.addColumn("Price");
			model.addColumn("Quantity");
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			sp.setBounds(380,80,500,300);
			main.add(sp);

		add(background);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String args[])
	{
		new CustOrder();
	}
}