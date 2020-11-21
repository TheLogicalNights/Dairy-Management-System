import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class EmpDetails extends JFrame
{
	EmpDetails()
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
		main.setBounds(00,250,2560,340);
		background.add(main);


		JLabel l1 = new JLabel("EMPLOYEE DETAILS");
		l1.setBounds(350,20,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);
		heading.add(l1);

		JButton back = new JButton("BACK");
		back.setBounds(550,650,100,30);
		background.add(back);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==back)
					new EmpOpt();
				setVisible(false);
			}
		});

		try
		{
			int i = 0;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from empreg");
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.addColumn("Name");
			model.addColumn("Username");
			model.addColumn("Contact NO");
			model.addColumn("Address");
			model.addColumn("Gender");
			model.addColumn("Bank Name");
			model.addColumn("Account Holder's Name");
			model.addColumn("Account No");
			model.addColumn("IFSC Code");
			table.getColumnModel().getColumn(0).setPreferredWidth(70);
			table.getColumnModel().getColumn(1).setPreferredWidth(57);
			table.getColumnModel().getColumn(2).setPreferredWidth(25);
			table.getColumnModel().getColumn(3).setPreferredWidth(220);
			table.getColumnModel().getColumn(4).setPreferredWidth(10);
			table.getColumnModel().getColumn(5).setPreferredWidth(130);
			table.getColumnModel().getColumn(6).setPreferredWidth(150);
			table.getColumnModel().getColumn(7).setPreferredWidth(47);
			table.getColumnModel().getColumn(8).setPreferredWidth(47);
			while(rs.next())
			{

				String name = rs.getString(1);
				String username = rs.getString(2);
				String contact = rs.getString(3);
				String address = rs.getString(4);
				String gender = rs.getString(5);
				String bankname = rs.getString(6);
				String holdername = rs.getString(7);
				String accno = rs.getString(8);
				String ifsc = rs.getString(9);
				model.insertRow(i, new Object[] {name,username,contact,address,gender,bankname,holdername,accno,ifsc});
				i++;
			}
			sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			sp.setBounds(0,20,1290,300);
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
		new EmpDetails();
	}

}