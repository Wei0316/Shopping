package controller.Manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ipml.EmployeeDaoImpl;
import model.Employee;
import util.ClockTool;
import util.FormatTool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeAccountManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Employee user;
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
					EmployeeAccountManageUI frame = new EmployeeAccountManageUI();
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
	public EmployeeAccountManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("帳號管理");

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			user = objectMapper.readValue(new File("user.json"), Employee.class);
		} catch (IOException e) {
			user = null;
			e.printStackTrace();
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("帳號管理");
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
				new EmployeeUI().setVisible(true);
				dispose();
			}
		});
		backLastPage.setBounds(0, 0, 50, 23);
		panel.add(backLastPage);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 425, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("姓名");
		lblNewLabel_1_5.setBounds(85, 19, 25, 15);
		panel_1.add(lblNewLabel_1_5);

		name = new JTextField(user.getEmployeeName());
		name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (name.getText().equals(user.getEmployeeName())) {
					name.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (name.getText().isEmpty() || name.getText().equals(user.getEmployeeName())) {
					name.setText(user.getEmployeeName());
				}
			}
		});
		name.setColumns(10);
		name.setBounds(114, 16, 96, 21);
		panel_1.add(name);

		JLabel lblNewLabel_1_2_1 = new JLabel("電話");
		lblNewLabel_1_2_1.setBounds(85, 47, 25, 15);
		panel_1.add(lblNewLabel_1_2_1);

		phone = new JTextField(user.getEmployeePhone());
		phone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (phone.getText().equals(user.getEmployeePhone())) {
					phone.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (phone.getText().isEmpty() || phone.getText().equals(user.getEmployeePhone())) {
					phone.setText(user.getEmployeePhone());
				}
			}
		});
		phone.setColumns(10);
		phone.setBounds(114, 44, 96, 21);
		panel_1.add(phone);

		JLabel lblNewLabel_1_3_1 = new JLabel("地址");
		lblNewLabel_1_3_1.setBounds(85, 75, 25, 15);
		panel_1.add(lblNewLabel_1_3_1);

		address = new JTextField(user.getEmployeeAddress());
		address.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (address.getText().equals(user.getEmployeeAddress())) {
					address.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (address.getText().isEmpty() || address.getText().equals(user.getEmployeeAddress())) {
					address.setText(user.getEmployeeAddress());
				}
			}
		});
		address.setColumns(10);
		address.setBounds(114, 72, 266, 21);
		panel_1.add(address);

		JLabel lblNewLabel_1_4_1 = new JLabel("Email");
		lblNewLabel_1_4_1.setBounds(82, 103, 32, 15);
		panel_1.add(lblNewLabel_1_4_1);

		email = new JTextField(user.getEmployeeEmail());
		email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (email.getText().equals(user.getEmployeeEmail())) {
					email.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (email.getText().isEmpty() || email.getText().equals(user.getEmployeeEmail())) {
					email.setText(user.getEmployeeEmail());
				}
			}
		});
		email.setColumns(10);
		email.setBounds(114, 100, 141, 21);
		panel_1.add(email);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("密碼");
		lblNewLabel_1_2_1_1.setBounds(85, 131, 25, 15);
		panel_1.add(lblNewLabel_1_2_1_1);

		password = new JPasswordField(user.getEmployeePassword());
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().equals(user.getEmployeePassword())) {
					password.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (password.getText().isEmpty() || password.getText().equals(user.getEmployeePassword())) {
					password.setText(user.getEmployeePassword());
				}
			}
		});
		password.setColumns(10);
		password.setBounds(114, 128, 141, 21);
		panel_1.add(password);

		JButton save = new JButton("儲存");
		save.addMouseListener(new MouseAdapter() {
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
					new EmployeeDaoImpl().updateEmployee(new Employee(user.getEmployeeID(), Name,
							user.getEmployeePosition(), Phone, Address, Email, Password));
					Employee updateUser = new EmployeeDaoImpl().getEmployeeByEmployeeID(user.getEmployeeID());

					try {
						ObjectMapper objectMapper = new ObjectMapper();
						objectMapper.writeValue(new File("user.json"), updateUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					user = updateUser;
					JOptionPane.showMessageDialog(null, "儲存成功", "儲存成功", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		save.setBounds(125, 159, 85, 23);
		panel_1.add(save);
	}
}
