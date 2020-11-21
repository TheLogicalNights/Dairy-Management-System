import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

class StoreBill extends JFrame
{
	private JLabel lblBillNo,lblBillDate,lblCustomer,lblAddress,lblPhone,lblCategory,lblProduct,lblRate,lblQty,lblAmount,lblTotal;

	private JTable tabProducts;
	private DefaultTableModel dtmBill;
	private JScrollPane spBill;
	private JTextField txtBillNo,txtBillDate,txtRate,txtQty,txtAmount,txtPhone;
	private JComboBox cmbCategory,cmbProduct,cmbCustomer;
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

	public StoreBill()
	{
		lblBillNo = new JLabel("Bill No:");
		lblBillDate = new JLabel("Bill Date:");
		lblCustomer = new JLabel("Customer:");
		lblAddress = new JLabel("Address:");
		lblPhone = new JLabel("Phone:");

		lblCategory = new JLabel("Category");
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

		lblCategory.setBounds(12, 189, 70, 15);
		lblProduct.setBounds(139, 189, 70, 15);
		lblRate.setBounds(277, 189, 70, 15);
		lblQty.setBounds(393, 189, 70, 15);
		lblAmount.setBounds(517, 192, 70, 15);
		lblTotal.setBounds(446, 407, 70, 15);

		dtmBill = new DefaultTableModel();
		dtmBill.addColumn("Category");
		dtmBill.addColumn("Product");
		dtmBill.addColumn("Rate");
		dtmBill.addColumn("Qty");
		dtmBill.addColumn("Amt");

		tabProducts = new JTable(dtmBill);
		spBill = new JScrollPane(tabProducts);
		spBill.setBounds(12, 241, 630, 161);

		txtBillNo = new JTextField();
		txtBillNo.setEditable(false);
		txtBillNo.setBounds(129, 10, 114, 19);
		txtBillNo.setColumns(10);

		sdf = new SimpleDateFormat("DD-MM-YYYY");
		txtBillDate = new JTextField(sdf.format(new java.util.Date()));
		txtBillDate.setEditable(false);
		txtBillDate.setBounds(349, 10, 114, 19);
		txtBillDate.setColumns(10);

		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		btnEdit = new JButton("Edit");
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

		cmbCategory = new JComboBox();
		cmbCategory.setBounds(12, 208, 126, 19);

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
		add(lblCategory);
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
		add(btnSave);
		add(btnPrint);
		add(txtTotal);
		add(txtRate);
		add(txtQty);
		add(txtAmount);
		add(cmbCategory);
		add(cmbProduct);
		add(cmbCustomer);
		add(txtAddress);
		add(txtPhone);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String args[])
	{
		new StoreBill();
	}
}
