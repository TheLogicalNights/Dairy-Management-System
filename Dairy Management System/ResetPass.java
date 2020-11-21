import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

class ResetPass extends JFrame
{
	JButton	submit,reset,cancle;
	ResetPass(String uid)
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
		uname.setBounds(310,200,600,300);
		main.add(uname);


		//Labels
		JLabel reset1 = new JLabel("RESET  PASSWORD...");
		reset1.setBounds(350,10,1000,80);
		reset1.setForeground(Color.WHITE);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		reset1.setFont(font);
		heading3.add(reset1);

		JLabel fn = new JLabel("Enter NEW PASSWORD");
		fn.setBounds(130,20,500,30);
		fn.setForeground(Color.BLACK);
		Font font2 = new Font("TimesRoman",Font.BOLD,30);
		fn.setFont(font2);
		uname.add(fn);

		JLabel ans = new JLabel("RE-ENTER PASSWORD");
		ans.setBounds(130,120,700,40);
		ans.setForeground(Color.BLACK);
		ans.setFont(font2);
		uname.add(ans);

		//TextFields
		JTextField username = new JTextField("");
		username.setBounds(20,70,550,30);
		uname.add(username);

		JTextField pass = new JTextField("");
		pass.setBounds(20,180,550,30);
		uname.add(pass);

		//Buttons
		submit = new JButton("SUBMIT");
		submit.setBounds(130,240,100,30);
		uname.add(submit);
		reset = new JButton("RESET");
		reset.setBounds(250,240,100,30);
		uname.add(reset);
		cancle = new JButton("CANCLE");
		cancle.setBounds(370,240,100,30);
		uname.add(cancle);

		cancle.addActionListener(new ButtonHandler());

		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==reset)
				{
					username.setText("");
					pass.setText("");
				}
			}
		});

		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource()==submit)
				{
					String pass1 = username.getText();
					String pass2 = pass.getText();
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
						PreparedStatement pst1 = con.prepareStatement("UPDATE admreg set password=? where uid=?");
						pst1.setString(1,pass1);
						pst1.setString(2,uid);
						if(pass1.equals("") || pass2.equals(""))
						{
							JOptionPane.showMessageDialog(null,"Please Fill All Details","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else if(pass1.equals(pass2))
						{
							pst1.executeUpdate();
							JOptionPane.showMessageDialog(null,"Password Updated Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
								JOptionPane.showMessageDialog(null,"Password Enterd Does Not Match","ERROR",JOptionPane.ERROR_MESSAGE);
						}

					}
					catch(Exception e)
					{
						System.out.println(e);
					}
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
						if(ae.getSource()==cancle)
							new Login();

						setVisible(false);

					}
			}

	}