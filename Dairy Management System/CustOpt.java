import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class CustOpt extends JFrame
{
	JButton regular,guest,back;
	CustOpt()
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
		heading.setBounds(0,0,2560,150);
		heading.setLayout(null);
		background.add(heading);

		JPanel option = new JPanel();
		option.setBackground(new Color(0,0,0,80));
		option.setBounds(530,350,250,200);
		option.setLayout(null);
		background.add(option);

		//Labels
		JLabel wel = new JLabel("CUSTOMERS");
		wel.setBounds(450,30,1000,80);
		wel.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		wel.setFont(font);
		heading.add(wel);

		//Buttons
		regular = new JButton("REGULAR");
		regular.setBounds(50,20,140,30);
		option.add(regular);
		guest = new JButton("GUEST");
		guest.setBounds(50,80,140,30);
		option.add(guest);
		back = new JButton("BACK");
		back.setBounds(50,140,140,30);
		option.add(back);

		back.addActionListener(new ButtonHandler());

		regular.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==regular)
				{
					new RegCust();
					setVisible(false);
				}
			}
		});


		add(background);
		setResizable(false);
		setVisible(true);
	}
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==back)
				new Welcome();

			setVisible(false);

		}
	}

	public static void main(String args[])
	{
		new CustOpt();
	}
}