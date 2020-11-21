import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class BillOpt extends JFrame
{
	JButton regular,guest,store,back;
	BillOpt()
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
		option.setBounds(530,360,250,190);
		option.setLayout(null);
		background.add(option);

		//Labels
		JLabel wel = new JLabel("BILL");
		wel.setBounds(580,30,1000,80);
		wel.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		wel.setFont(font);
		heading.add(wel);

		//Buttons
		regular = new JButton("REGULAR");
		regular.setBounds(50,20,140,30);
		option.add(regular);
		store = new JButton("STORE");
		store.setBounds(50,80,140,30);
		option.add(store);
		back = new JButton("BACK");
		back.setBounds(50,140,140,30);
		option.add(back);

		back.addActionListener(new ButtonHandler());
		regular.addActionListener(new ButtonHandler());
		store.addActionListener(new ButtonHandler());
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
			if(ae.getSource()==regular)
				new Bill();
			if(ae.getSource()==store)
				new Bill1();

				setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new BillOpt();
	}
}