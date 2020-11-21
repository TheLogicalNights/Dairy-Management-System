import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ChangePass extends JFrame
{
	JButton	submit,reset,back,confirm,cancle;
	ChangePass()
	{
		setTitle("Registeration Options.....");
			setBounds(100,00,1300,1000);


			ImageIcon bg_img = new ImageIcon("password1.jpg");
			Image img = bg_img.getImage();
			Image temp = img.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
			bg_img = new ImageIcon(temp);
			JLabel background = new JLabel("",bg_img,JLabel.CENTER);
			background.setBounds(0,0,1300,1000);

			//Panels
			JPanel heading3 = new JPanel();
			heading3.setBackground(new Color(0,0,0,80));
			heading3.setBounds(0,0,2560,100);
			heading3.setLayout(null);
			background.add(heading3);

			JPanel main = new JPanel();
			main.setLayout(null);
			main.setBackground(new Color(0,0,0,70));
			main.setBounds(10,110,1260,770);
			background.add(main);

			JPanel uname = new JPanel();
			uname.setBackground(new Color(255,255,255,90));
			uname.setLayout(null);
			uname.setBounds(310,50,600,200);
			main.add(uname);

			JPanel secqn = new JPanel();
			secqn.setBackground(new Color(255,255,255,90));
			secqn.setLayout(null);
			secqn.setBounds(310,400,600,200);
			main.add(secqn);




			//Labels
			JLabel admreg = new JLabel("CHANGE  PASSWORD....");
			admreg.setBounds(300,10,1000,80);
			admreg.setForeground(Color.WHITE);
			Font font = new Font("TimesRoman",Font.BOLD,60);
			admreg.setFont(font);
			heading3.add(admreg);

			JLabel fn = new JLabel("Enter Your Username");
			fn.setBounds(150,20,500,30);
			fn.setForeground(Color.BLACK);
			Font font2 = new Font("TimesRoman",Font.BOLD,30);
			fn.setFont(font2);
			uname.add(fn);

			JLabel ans = new JLabel("ANSWER OF SECURITY QUESTION");
			ans.setBounds(30,10,700,40);
			ans.setForeground(Color.BLACK);
			ans.setFont(font2);
			secqn.add(ans);


			//TextFields
			JTextField username = new JTextField("");
			username.setBounds(20,80,550,30);
			uname.add(username);

			JTextField answer = new JTextField("");
			answer.setBounds(20,80,550,30);
			secqn.add(answer);


			//Buttons
			submit = new JButton("SUBMIT");
			submit.setBounds(130,150,100,30);
			uname.add(submit);
			reset = new JButton("RESET");
			reset.setBounds(250,150,100,30);
			uname.add(reset);
			back = new JButton("BACK");
			back.setBounds(370,150,100,30);
			uname.add(back);
			confirm = new JButton("CONFIRM");
			confirm.setBounds(190,140,100,30);
			secqn.add(confirm);
			cancle = new JButton("CANCLE");
			cancle.setBounds(310,140,100,30);
			secqn.add(cancle);

			back.addActionListener(new ButtonHandler());
			cancle.addActionListener(new ButtonHandler());
			confirm.addActionListener(new ButtonHandler());


			add(background);
			setResizable(false);
			setVisible(true);

	}
	class ButtonHandler implements ActionListener
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(ae.getSource()==back || ae.getSource()==cancle)
						new Welcome();
					if(ae.getSource()==confirm)
						new ResetAdminPass();

					setVisible(false);

				}
		}

	public static void main(String args[])
	{
		new ChangePass();
	}
}
