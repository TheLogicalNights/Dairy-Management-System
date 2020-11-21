
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RegOpt extends JFrame
{
	JButton admin,employee,back;
	public RegOpt()
	{
	setTitle("Registeration Options.....");
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
	heading.setLayout(null);

	JLabel l1 = new JLabel("REGISTER AS.....");
	l1.setBounds(400,30,1000,80);
	l1.setForeground(Color.WHITE);
	Font font = new Font("TimesRoman",Font.BOLD,60);
	l1.setFont(font);
	heading.add(l1);

	JPanel option = new JPanel();
	option.setBackground(new Color(0,0,0,80));
	option.setBounds(530,350,180,280);
	option.setLayout(null);

	JLabel l2,l3,l4;
	Font f1 = new Font("TimesRoman",Font.BOLD,80);
	l2 = new JLabel("ADMIN");
	l3 = new JLabel("EMPLOYEE");
	l4 = new JLabel("BACK");
	l2.setFont(f1);
	l3.setFont(f1);
	l4.setFont(f1);
	admin = new JButton(l2.getText());
	employee = new JButton(l3.getText());
	back = new JButton(l4.getText());


	admin.setBounds(40,60,100,30);
	employee.setBounds(30,120,120,30);
	back.setBounds(40,180,100,30);

	admin.setMnemonic('A');
	employee.setMnemonic('E');

	option.add(admin);
	option.add(employee);
	option.add(back);

	add(background);
	background.add(heading);
	background.add(option);

	admin.addActionListener(new ButtonHandler());
	back.addActionListener(new ButtonHandler());
	employee.addActionListener(new ButtonHandler());

	setResizable(false);
	setVisible(true);
}
class ButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==admin)
			new AdminRegScreen();
		if(ae.getSource()==back)
			new MainScreen();
		if(ae.getSource()==employee)
			new EmpReg();

			setVisible(false);
	}
}

		public static void main(String args[])
		{
			new RegOpt();
		}
}

