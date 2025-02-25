package controller.Manage;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.ipml.EmployeeDaoImpl;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.ClockTool;
import util.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class EmployeeManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Connection connection = DBConnection.getDB();
	DefaultTableModel EmployeeTable = new EmployeeServiceImpl().EmployeeSelectForTable();
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private JTextField updateName;
	private JTextField updatePhone;
	private JTextField updateAddress;
	private JTextField updateEmail;
	private JTextField addName;
	private JTextField addPhone;
	private JTextField addAddress;
	private JTextField addEmail;
	private JTextField updatePassword;
	private JTextField addPassword;
	private Integer EmpolyeeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManageUI frame = new EmployeeManageUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("員工管理");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("員工管理");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(170, 10, 80, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("2025-02-21 15:00:00");
		lblNewLabel_4.setBounds(311, 13, 115, 21);
		panel.add(lblNewLabel_4);
		new Thread(new ClockTool.ClockRunnable(lblNewLabel_4)).start();
		
		JButton backLastPage = new JButton("←");
		backLastPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ManagerUI().setVisible(true);
				dispose();
			}
		});
		backLastPage.setBounds(0, 0, 50, 23);
		panel.add(backLastPage);

		JTabbedPane Panel_2 = new JTabbedPane(JTabbedPane.TOP);
		Panel_2.setBounds(10, 53, 426, 265);
		contentPane.add(Panel_2);

		JPanel updatePanel = new JPanel();
		Panel_2.addTab("修改資料", null, updatePanel, null);
		updatePanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 10, 406, 125);
		updatePanel.add(scrollPane);

		table = new JTable(EmployeeTable);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(7, 10, 406, 125);

		table2 = new JTable(EmployeeTable);
		table2.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(table2);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 148, 25, 15);
		updatePanel.add(lblNewLabel_1);

		updateName = new JTextField();
		updateName.setBounds(39, 145, 96, 21);
		updatePanel.add(updateName);
		updateName.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("職位");
		lblNewLabel_1_1.setBounds(145, 148, 25, 15);
		updatePanel.add(lblNewLabel_1_1);

		String[] positionchange = { "員工", "主管" };
		JComboBox updatePosition = new JComboBox(positionchange);
		updatePosition.setBounds(174, 145, 96, 21);
		updatePanel.add(updatePosition);

		JLabel lblNewLabel_1_2 = new JLabel("電話");
		lblNewLabel_1_2.setBounds(280, 148, 25, 15);
		updatePanel.add(lblNewLabel_1_2);

		updatePhone = new JTextField();
		updatePhone.setColumns(10);
		updatePhone.setBounds(309, 145, 96, 21);
		updatePanel.add(updatePhone);

		JLabel lblNewLabel_1_3 = new JLabel("地址");
		lblNewLabel_1_3.setBounds(10, 176, 25, 15);
		updatePanel.add(lblNewLabel_1_3);

		updateAddress = new JTextField();
		updateAddress.setColumns(10);
		updateAddress.setBounds(39, 173, 366, 21);
		updatePanel.add(updateAddress);

		JLabel lblNewLabel_1_4 = new JLabel("Email");
		lblNewLabel_1_4.setBounds(7, 204, 32, 15);
		updatePanel.add(lblNewLabel_1_4);

		updateEmail = new JTextField();
		updateEmail.setColumns(10);
		updateEmail.setBounds(39, 201, 141, 21);
		updatePanel.add(updateEmail);

		JLabel lblNewLabel_1_2_2 = new JLabel("密碼");
		lblNewLabel_1_2_2.setBounds(190, 203, 25, 15);
		updatePanel.add(lblNewLabel_1_2_2);

		updatePassword = new JTextField();
		updatePassword.setColumns(10);
		updatePassword.setBounds(219, 200, 96, 21);
		updatePanel.add(updatePassword);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				TableModel model = table.getModel();
				Object id = model.getValueAt(selectedRow, 0);
				Object name = model.getValueAt(selectedRow, 1);
				Object position = model.getValueAt(selectedRow, 2);
				Object phone = model.getValueAt(selectedRow, 3);
				Object address = model.getValueAt(selectedRow, 4);
				Object email = model.getValueAt(selectedRow, 5);
				Object password = model.getValueAt(selectedRow, 6);

				EmpolyeeID = Integer.parseInt(id.toString());
				updateName.setText(name.toString());
				updatePosition.setSelectedItem(position);
				updatePhone.setText(phone.toString());
				updateAddress.setText(address.toString());
				updateEmail.setText(email.toString());
				updatePassword.setText(password.toString());

			}
		});

		JButton updateEmployee = new JButton("修改");
		updateEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = updateName.getText();
				String Position = (String) updatePosition.getSelectedItem();
				String Phone = updatePhone.getText();
				String Address = updateAddress.getText();
				String Email = updateEmail.getText();
				String Password = updatePassword.getText();
				int selectedRow = table.getSelectedRow();

				int result = JOptionPane.showConfirmDialog(null, "是否確定修改", "修改確認", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					new EmployeeDaoImpl()
							.updateEmployee(new Employee(EmpolyeeID, Name, Position, Phone, Address, Email, Password));
					JOptionPane.showMessageDialog(null, "修改成功", "修改成功", JOptionPane.WARNING_MESSAGE);

					EmployeeTable = new EmployeeServiceImpl().EmployeeSelectForTable();
					table.setModel(EmployeeTable);
					table2.setModel(EmployeeTable);

				}
			}
		});
		updateEmployee.setBounds(320, 200, 85, 23);
		updatePanel.add(updateEmployee);

		JPanel addPanel = new JPanel();
		Panel_2.addTab("新增員工", null, addPanel, null);
		addPanel.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("姓名");
		lblNewLabel_1_5.setBounds(13, 13, 25, 15);
		addPanel.add(lblNewLabel_1_5);

		addName = new JTextField();
		addName.setColumns(10);
		addName.setBounds(42, 10, 96, 21);
		addPanel.add(addName);

		JLabel lblNewLabel_1_1_1 = new JLabel("職位");
		lblNewLabel_1_1_1.setBounds(13, 41, 25, 15);
		addPanel.add(lblNewLabel_1_1_1);

		JComboBox addPosition = new JComboBox(positionchange);
		addPosition.setBounds(42, 38, 96, 21);
		addPanel.add(addPosition);

		JLabel lblNewLabel_1_2_1 = new JLabel("電話");
		lblNewLabel_1_2_1.setBounds(13, 69, 25, 15);
		addPanel.add(lblNewLabel_1_2_1);

		addPhone = new JTextField();
		addPhone.setColumns(10);
		addPhone.setBounds(42, 66, 96, 21);
		addPanel.add(addPhone);

		JLabel lblNewLabel_1_3_1 = new JLabel("地址");
		lblNewLabel_1_3_1.setBounds(13, 97, 25, 15);
		addPanel.add(lblNewLabel_1_3_1);

		addAddress = new JTextField();
		addAddress.setColumns(10);
		addAddress.setBounds(42, 94, 266, 21);
		addPanel.add(addAddress);

		JLabel lblNewLabel_1_4_1 = new JLabel("Email");
		lblNewLabel_1_4_1.setBounds(10, 125, 32, 15);
		addPanel.add(lblNewLabel_1_4_1);

		addEmail = new JTextField();
		addEmail.setColumns(10);
		addEmail.setBounds(42, 122, 141, 21);
		addPanel.add(addEmail);

		JButton addEmployee = new JButton("新增");
		addEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = addName.getText();
				String Position = (String) addPosition.getSelectedItem();
				String Phone = addPhone.getText();
				String Address = addAddress.getText();
				String Email = addEmail.getText();
				String Password = addPassword.getText();

				int result = JOptionPane.showConfirmDialog(null, "是否確定新增", "新增確認", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					new EmployeeDaoImpl().addEmployee(new Employee(Name, Position, Phone, Address, Email, Password));

					JOptionPane.showMessageDialog(null, "新增成功", "新增成功", JOptionPane.WARNING_MESSAGE);

					EmployeeTable = new EmployeeServiceImpl().EmployeeSelectForTable();
					table.setModel(EmployeeTable);
					table2.setModel(EmployeeTable);

					addName.setText("");
					addPosition.setSelectedItem("員工");
					addPhone.setText("");
					addAddress.setText("");
					addEmail.setText("");
					addPassword.setText("");
					addName.setText("");

				}
			}
		});
		addEmployee.setBounds(53, 191, 85, 23);
		addPanel.add(addEmployee);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("密碼");
		lblNewLabel_1_2_1_1.setBounds(13, 153, 25, 15);
		addPanel.add(lblNewLabel_1_2_1_1);

		addPassword = new JTextField();
		addPassword.setColumns(10);
		addPassword.setBounds(42, 150, 96, 21);
		addPanel.add(addPassword);

		JPanel deletePanel = new JPanel();
		Panel_2.addTab("刪除員工資料", null, deletePanel, null);
		deletePanel.setLayout(null);

		deletePanel.add(scrollPane_1);

		JButton deleteEmployee = new JButton("刪除");
		deleteEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否確定刪除", "刪除確認", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					new EmployeeDaoImpl().deleteEmployee(EmpolyeeID);
					JOptionPane.showMessageDialog(null, "刪除成功", "刪除成功", JOptionPane.WARNING_MESSAGE);

					EmployeeTable = new EmployeeServiceImpl().EmployeeSelectForTable();
					table.setModel(EmployeeTable);
					table2.setModel(EmployeeTable);

				}
			}
		});
		deleteEmployee.setBounds(163, 155, 85, 23);
		deletePanel.add(deleteEmployee);

		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table2.getSelectedRow();
				TableModel model = table2.getModel();
				Object id = model.getValueAt(selectedRow, 0);

				EmpolyeeID = Integer.parseInt(id.toString());

			}
		});
	}
}
