import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class DispalyOrd extends JFrame
{
	DispalyOrd(String un)
	{
		 String uid = un;
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
		main.setBounds(00,250,2560,340);
		background.add(main);


		JLabel l1 = new JLabel("ORDER DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		JLabel l2 = new JLabel("You Placed Order Succeassfully,To Cancel Order Call on:8446736267");
		l2.setBounds(300,150,1000,80);
		l2.setForeground(Color.WHITE);
		Font font1 = new Font("TimesRoman",Font.BOLD,25);
		l2.setFont(font1);
		background.add(l2);

		JButton back = new JButton("BACK");
		back.setBounds(550,650,100,30);
		background.add(back);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new CustOrder();
				setVisible(false);
			}
		});

		try
		{
			int i = 0;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from order1 where uid='"+un+"';");
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.addColumn("Product");
			model.addColumn("Price");
			model.addColumn("Quantity");
			table.getColumnModel().getColumn(0).setPreferredWidth(70);
			table.getColumnModel().getColumn(1).setPreferredWidth(57);
			table.getColumnModel().getColumn(2).setPreferredWidth(25);
			while(rs.next())
			{

				String pro = rs.getString(2);
				String pri = rs.getString(3);
				String Q = rs.getString(4);
				model.insertRow(i, new Object[] {pro,pri,Q});
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
		new DispalyOrd("swapnil123");
	}
}