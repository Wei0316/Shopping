package controller.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Customer.ShoppingUI;
import model.Customer;
import service.impl.CustomerServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class CustomerLoginUI extends JFrame {

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
					CustomerLoginUI frame = new CustomerLoginUI();
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
	public CustomerLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("顧客登入");

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

		JLabel lblNewLabel = new JLabel("後台登入");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeLoginUI().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel.setBounds(286, 133, 50, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("忘記密碼");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PasswordForgetUI().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_2.setBounds(286, 101, 50, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("註冊");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterUI().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(289, 73, 25, 15);
		contentPane.add(lblNewLabel_2_1);

		JButton Login = new JButton("登入");
		Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Email = email.getText();
				String Password = password.getText();

				Customer customer = new CustomerServiceImpl().Login(Email, Password);
				
				if (customer != null) {
					try {
						ObjectMapper objectMapper = new ObjectMapper();
						objectMapper.writeValue(new File("user.json"), customer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					new ShoppingUI().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "帳號密碼錯誤", "登入失敗", JOptionPane.WARNING_MESSAGE);
					email.setText("");
					password.setText("");
				}
			}
		});
		Login.setBounds(165, 129, 87, 23);
		contentPane.add(Login);

	}
}
