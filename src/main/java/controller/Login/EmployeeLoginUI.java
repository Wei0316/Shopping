package controller.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Manage.EmployeeUI;
import controller.Manage.ManagerUI;
import model.Employee;
import service.impl.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class EmployeeLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLoginUI frame = new EmployeeLoginUI();
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
	public EmployeeLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("後台登入");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(102, 73, 32, 15);
		contentPane.add(lblNewLabel_1_1);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(144, 70, 128, 21);
		contentPane.add(email);

		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(102, 101, 25, 15);
		contentPane.add(lblNewLabel_1);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(144, 98, 128, 21);
		contentPane.add(password);

		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Email = email.getText();
				String Password = password.getText();

				Employee employee = new EmployeeServiceImpl().Login(Email, Password);

				if (employee != null) {
					try {
						ObjectMapper objectMapper = new ObjectMapper();
						objectMapper.writeValue(new File("user.json"), employee);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (employee.getEmployeePosition().equals("主管")) {
						new ManagerUI().setVisible(true);
						dispose();
					} else {
						new EmployeeUI().setVisible(true);
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "帳號密碼錯誤", "登入失敗", JOptionPane.WARNING_MESSAGE);
					email.setText("");
					password.setText("");
				}
			}
		});
		btnNewButton.setBounds(165, 129, 87, 23);
		contentPane.add(btnNewButton);

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
