import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.Random;

public class Bill extends JFrame
{
	private JLabel lblBillNo,lblBillDate,lblCustomer,lblAddress,lblPhone,lblProduct,lblRate,lblQty,lblAmount,lblTotal;

	private JTable tabProducts;
	private DefaultTableModel dtmBill;
	private JScrollPane spBill;
	private JTextField txtBillNo,txtBillDate,txtRate,txtQty,txtAmount,txtPhone;
	private JComboBox cmbProduct,cmbCustomer;
	private JTextArea txtAddress;

	private SimpleDateFormat sdf;

	private JButton btnAdd,btnDelete,btnEdit,btnClose,btnSave,btnPrint;

	private JTextField txtTotal;

	private Connection con;
  	private Statement s;
  	private PreparedStatement ps;
  	private ResultSet rs;

	private int bno;
	private float total;

	public Bill()
	{
		lblBillNo = new JLabel("Bill No:");
		lblBillDate = new JLabel("Bill Date:");
		lblCustomer = new JLabel("Customer:");
		lblAddress = new JLabel("Address:");
		lblPhone = new JLabel("Phone:");


		lblProduct = new JLabel("Product");
		lblRate = new JLabel("Rate");
		lblQty = new JLabel("Qty");
		lblAmount = new JLabel("Amount");
		lblTotal = new JLabel("Total:");


		lblBillNo.setBounds(12, 12, 70, 15);
		lblBillDate.setBounds(261, 12, 70, 15);
		lblCustomer.setBounds(12, 39, 95, 15);
		lblAddress.setBounds(12, 77, 70, 15);
		lblPhone.setBounds(12, 148, 70, 15);

		lblProduct.setBounds(139, 189, 70, 15);
		lblRate.setBounds(277, 189, 70, 15);
		lblQty.setBounds(393, 189, 70, 15);
		lblAmount.setBounds(517, 192, 70, 15);
		lblTotal.setBounds(446, 407, 70, 15);

		dtmBill = new DefaultTableModel();
		dtmBill.addColumn("Product");
		dtmBill.addColumn("Rate");
		dtmBill.addColumn("Qty");
		dtmBill.addColumn("Amt");

		tabProducts = new JTable(dtmBill);
		spBill = new JScrollPane(tabProducts);
		spBill.setBounds(12, 241, 630, 161);

		Random rand = new Random();
		txtBillNo = new JTextField(""+rand.nextInt(1000));
		txtBillNo.setEditable(false);
		txtBillNo.setBounds(129, 10, 114, 19);
		txtBillNo.setColumns(10);

		sdf = new SimpleDateFormat("yyyy-MM-dd");
		txtBillDate = new JTextField(sdf.format(new java.util.Date()));
		txtBillDate.setEditable(false);
		txtBillDate.setBounds(349, 10, 114, 19);
		txtBillDate.setColumns(10);

		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		btnEdit = new JButton("Back");
		btnClose = new JButton("Close");
		btnSave = new JButton("Save");
		btnPrint = new JButton("Print");

		btnAdd.setMnemonic('A');
		btnAdd.setBounds(654, 236, 117, 25);
		btnDelete.setMnemonic('D');
		btnDelete.setBounds(654, 273, 117, 25);
		btnEdit.setMnemonic('E');
		btnEdit.setBounds(654, 314, 117, 25);
		btnClose.setMnemonic('C');
		btnClose.setBounds(654, 351, 117, 25);
		btnSave.setMnemonic('S');
		btnSave.setBounds(217, 449, 117, 25);
		btnPrint.setMnemonic('P');
		btnPrint.setBounds(346, 449, 117, 25);

		txtTotal = new JTextField("0.0");
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(528, 405, 114, 19);

		txtRate = new JTextField();
		txtRate.setEditable(false);
		txtRate.setBounds(265, 208, 122, 19);
		txtRate.setColumns(10);

		txtQty = new JTextField();
		txtQty.setBounds(393, 208, 123, 19);
		txtQty.setColumns(10);

		txtAmount = new JTextField();
		txtAmount.setEditable(false);
		txtAmount.setBounds(517, 208, 114, 19);
		txtAmount.setColumns(10);


		cmbProduct = new JComboBox();
		cmbProduct.setBounds(139, 208, 126, 19);

		cmbCustomer = new JComboBox();
		cmbCustomer.setBounds(129, 37, 114, 19);

		txtAddress = new JTextArea(4,40);
		txtAddress.setEditable(false);
		txtAddress.setBounds(129, 66, 219, 68);

		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setBounds(129, 148, 114, 19);
		txtPhone.setColumns(10);

		setTitle("Bill Details");
		setSize(850,550);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    		setLocation(x, y);
		setLayout(null);
		add(lblBillNo);
		add(lblBillDate);
		add(lblCustomer);
		add(lblAddress);
		add(lblPhone);
		add(lblProduct);
		add(lblRate);
		add(lblQty);
		add(lblAmount);
		add(lblTotal);
		add(spBill);
		add(txtBillNo);
		add(txtBillDate);
		add(btnAdd);
		add(btnDelete);
		add(btnEdit);
		add(btnClose);
		//add(btnSave);
		add(btnPrint);
		add(txtTotal);
		add(txtRate);
		add(txtQty);
		add(txtAmount);
		add(cmbProduct);
		add(cmbCustomer);
		add(txtAddress);
		add(txtPhone);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
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
				Statement stmt = con.createStatement();
				ResultSet rset = stmt.executeQuery("Select * from custreg");
				cmbCustomer.addItem("-select-");
				while(rset.next())
				{
					cmbCustomer.addItem(rset.getString(1));
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
							txtRate.setText(rs1.getString(1));
							txtQty.requestFocus();
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
			}
		});
		txtQty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				float r = Float.parseFloat(txtRate.getText());
				int q = Integer.parseInt(txtQty.getText());
				float amt = r*q;
				txtAmount.setText(Float.toString(amt));
				btnAdd.requestFocus();
			}
		});
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Vector v = new Vector();
				v.add(cmbProduct.getSelectedItem());
				v.add(txtRate.getText());
				v.add(txtQty.getText());
				v.add(txtAmount.getText());
				dtmBill.addRow(v);
				total+=Float.parseFloat(txtAmount.getText());
				txtTotal.setText(Float.toString(total));
				cmbProduct.removeAllItems();
				txtRate.setText("");
				txtQty.setText("");
				txtAmount.setText("");
				cmbProduct.requestFocus();
				try
				{
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					Statement st2 = con2.createStatement();
					ResultSet rs2 = st2.executeQuery("Select * from product");
					cmbProduct.addItem("-select-");
					while(rs2.next())
					{
						cmbProduct.addItem(rs2.getString(1));
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}

			}
		});
		cmbCustomer.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				try
				{
					Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","swapnil123");
					Statement st3 = con3.createStatement();
					String cust = cmbCustomer.getSelectedItem().toString();
					ResultSet rs3 = st3.executeQuery("Select * from custreg where name='"+cust+"';");
					if(rs3.next())
					{
						txtAddress.setText(rs3.getString(3));
						txtPhone.setText(rs3.getString(2));
					}
				}
    			catch(Exception e)
    			{
					System.out.println(e);
				}
			}
		});
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		btnEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new BillOpt();
				dispose();
			}
		});
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int i=tabProducts.getSelectedRow();
				float amt = Float.parseFloat(dtmBill.getValueAt(i,3).toString());
				total-=amt;
				txtTotal.setText(Float.toString(total));
				dtmBill.removeRow(i);
				clearRow();
			}
		});
}
public void clearRow()
{
	cmbProduct.setSelectedIndex(0);
	txtRate.setText("");
	txtQty.setText("");
	txtAmount.setText("");
	total+=Float.parseFloat(txtAmount.getText());
	txtTotal.setText(Float.toString(total));
}
public static void main(String args[])
	{
		new Bill();
	}
}
