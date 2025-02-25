package controller.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.ipml.CustomerDaoImpl;
import dao.ipml.EmployeeDaoImpl;
import model.Customer;
import model.Employee;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;
import util.FormatTool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("姓名");
		lblNewLabel_1_5.setBounds(78, 59, 25, 15);
		contentPane.add(lblNewLabel_1_5);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(107, 56, 96, 21);
		contentPane.add(name);

		JLabel lblNewLabel_1_2_1 = new JLabel("電話");
		lblNewLabel_1_2_1.setBounds(78, 87, 25, 15);
		contentPane.add(lblNewLabel_1_2_1);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(107, 84, 96, 21);
		contentPane.add(phone);

		JLabel lblNewLabel_1_3_1 = new JLabel("地址");
		lblNewLabel_1_3_1.setBounds(78, 115, 25, 15);
		contentPane.add(lblNewLabel_1_3_1);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(107, 112, 266, 21);
		contentPane.add(address);

		JLabel lblNewLabel_1_4_1 = new JLabel("Email");
		lblNewLabel_1_4_1.setBounds(75, 143, 32, 15);
		contentPane.add(lblNewLabel_1_4_1);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(107, 140, 141, 21);
		contentPane.add(email);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("密碼");
		lblNewLabel_1_2_1_1.setBounds(78, 171, 25, 15);
		contentPane.add(lblNewLabel_1_2_1_1);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(107, 168, 141, 21);
		contentPane.add(password);

		JButton addCustomer = new JButton("註冊");
		addCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				String Phone = phone.getText();
				String Address = address.getText();
				String Email = email.getText();
				String Password = password.getText();

				if (!FormatTool.phoneFormat(Phone)) {
					JOptionPane.showMessageDialog(null, "電話格式錯誤，需09開頭， 中間以-分隔，EX：0912-345-678", "格式錯誤",
							JOptionPane.WARNING_MESSAGE);
				} else if (!FormatTool.emailFormat(Email)) {
					JOptionPane.showMessageDialog(null, "信箱格式錯誤", "格式錯誤", JOptionPane.WARNING_MESSAGE);
				} else if (!FormatTool.passwordFormat(Password)) {
					JOptionPane.showMessageDialog(null, "密碼須包含英文大小寫及數字，長度最少八位", "格式錯誤", JOptionPane.WARNING_MESSAGE);
				} else {
					Customer customer = new CustomerServiceImpl().findPassword(Email);
					if (customer != null) {
						JOptionPane.showMessageDialog(null, "該信箱已被使用", "註冊失敗", JOptionPane.WARNING_MESSAGE);
					} else {
						new CustomerDaoImpl().addCustomer(new Customer(Name, Phone, Address, Email, Password));
						JOptionPane.showMessageDialog(null, "註冊成功", "註冊成功", JOptionPane.WARNING_MESSAGE);

						new CustomerLoginUI().setVisible(true);
						dispose();
					}
				}

			}
		});
		addCustomer.setBounds(117, 199, 85, 23);
		contentPane.add(addCustomer);

		JButton backLastPage = new JButton("←");
		backLastPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerLoginUI().setVisible(true);
				dispose();
			}
		});
		backLastPage.setBounds(10, 10, 50, 23);
		contentPane.add(backLastPage);

	}
}
