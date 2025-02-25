package controller.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import service.impl.CustomerServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PasswordForgetUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordForgetUI frame = new PasswordForgetUI();
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
	public PasswordForgetUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("找回密碼");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(140, 73, 32, 15);
		contentPane.add(lblNewLabel_1_1);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(176, 70, 96, 21);
		contentPane.add(email);

		JButton findPassowrd = new JButton("找回密碼");
		findPassowrd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Email = email.getText();
				Customer customer = new CustomerServiceImpl().findPassword(Email);

				if (customer != null) {
					JOptionPane.showMessageDialog(null, "密碼為 " + customer.getCustomerPassword(), "",
							JOptionPane.WARNING_MESSAGE);
					new CustomerLoginUI().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "信箱未被註冊", "", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		findPassowrd.setBounds(176, 98, 87, 23);
		contentPane.add(findPassowrd);

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
