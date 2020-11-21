import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;


public class CustMain extends JFrame
{

	public JButton register,login,exit;
	public CustMain()
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

		JPanel heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,2560,150);

		JLabel l1 = new JLabel("DAIRY MANAGEMENT SYSTEM");
		l1.setBounds(200,30,1000,80);
		l1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		l1.setFont(font);

		JPanel operation = new JPanel();
		operation.setBackground(new Color(0,0,0,80));
		operation.setBounds(530,350,180,280);
		operation.setLayout(null);

		register = new JButton("REGISTER");
		login = new JButton("LOGIN");
		exit = new JButton("EXIT");
		register.setBounds(40,120,100,30);
		login.setBounds(40,60,100,30);
		exit.setBounds(40,180,100,30);

		register.setMnemonic('R');
		login.setMnemonic('L');
		exit.setMnemonic('E');

		operation.add(register);
		operation.add(login);
		operation.add(exit);

		add(background);

		background.add(heading);
		background.add(l1);
		background.add(operation);



		ButtonHandler bh = new ButtonHandler();
		register.addActionListener(bh);
		login.addActionListener(bh);
		exit.addActionListener(bh);


		setResizable(false);
		setVisible(true);
	}
	class ButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==register) new Custreg();
				if(ae.getSource()==login)	new CustLogin();
				if(ae.getSource()==exit)
				{
					int ip = JOptionPane.showConfirmDialog(null,"Do You Want To Exit ","LOGOUT",JOptionPane.WARNING_MESSAGE);
					if(ip==JOptionPane.YES_OPTION)
					{
						System.exit(0);
					}
					else
					{
						new MainScreen();
					}
					}
				setVisible(false);

			}
	}
	public static void main(String args[])
	{
		new CustMain();
	}

}

