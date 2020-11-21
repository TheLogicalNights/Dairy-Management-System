import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Welcome extends JFrame
{
	public JButton emp,ord,cust,chnpass,bill,item,logout;
	String user1;
	Welcome()
	{

		setTitle("Version 1.1");
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
		heading.setBounds(0,0,2560,150);
		heading.setLayout(null);
		background.add(heading);

		JPanel option = new JPanel();
		option.setBackground(new Color(0,0,0,80));
		option.setBounds(530,250,250,430);
		option.setLayout(null);
		background.add(option);

		//Labels
		JLabel wel = new JLabel("WELCOME....");
		wel.setBounds(450,30,1000,80);
		wel.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		wel.setFont(font);
		heading.add(wel);

		//Buttons
		emp = new JButton("EMPLOYEE");
		emp.setBounds(50,20,140,30);
		option.add(emp);
		cust = new JButton("CUSTOMERS");
		cust.setBounds(50,80,140,30);
		option.add(cust);
		ord = new JButton("ORDER");
		ord.setBounds(50,140,140,30);
		option.add(ord);
		chnpass = new JButton("CHANGE PASSWORD");
		chnpass.setBounds(30,200,180,30);
		option.add(chnpass);
		item = new JButton("PRODUCTS");
		item.setBounds(50,260,140,30);
		option.add(item);
		bill = new JButton("BILL");
		bill.setBounds(50,320,140,30);
		option.add(bill);
		logout = new JButton("LOGOUT");
		logout.setBounds(50,380,140,30);
		option.add(logout);

		chnpass.addActionListener(new ButtonHandler());
		logout.addActionListener(new ButtonHandler());
		emp.addActionListener(new ButtonHandler());
		cust.addActionListener(new ButtonHandler());
		ord.addActionListener(new ButtonHandler());
		bill.addActionListener(new ButtonHandler());
		item.addActionListener(new ButtonHandler());

		add(background);
		setResizable(false);
		setVisible(true);
	}
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==chnpass)
				new ForgetPass();
			if(ae.getSource()==logout)
			{
				int ip = JOptionPane.showConfirmDialog(null,"Do You Want To Logout ","LOGOUT",JOptionPane.WARNING_MESSAGE);
				if(ip==JOptionPane.YES_OPTION)
				{
				new Login();
				}
				else
				{
					new Welcome();
				}

			}
			if(ae.getSource()==emp)
				new EmpOpt();
			if(ae.getSource()==cust)
				new RegCust();
			if(ae.getSource()==ord)
				new RegOrd();
			if(ae.getSource()==bill)
				new BillOpt();
			if(ae.getSource()==item)
				new Products();

			setVisible(false);

		}
	}
	public static void main(String args[])
	{
		new Welcome();
	}
}