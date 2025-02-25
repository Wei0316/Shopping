package controller.Customer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Customer;
import model.Order;
import service.impl.OrderDetailServiceImpl;
import util.ClockTool;

public class ShoppingListDetailUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Customer user;
	private Order order;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingListDetailUI frame = new ShoppingListDetailUI();
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
	public ShoppingListDetailUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			order = objectMapper.readValue(new File("order.json"), Order.class);
		} catch (IOException e) {
			order = null;
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("訂單明細");
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
				new ShoppingListUI().setVisible(true);
				dispose();
			}
		});
		backLastPage.setBounds(0, 0, 50, 23);
		panel.add(backLastPage);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 426, 210);
		contentPane.add(panel_1);

		DefaultTableModel orderDetailTable = new OrderDetailServiceImpl().OrderDetailTable(order.getOrderID());
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 406, 190);
		panel_1.add(scrollPane);

		table = new JTable(orderDetailTable);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
	}

}
