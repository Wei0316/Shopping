package controller.Manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;

import model.Employee;
import model.Order;
import service.impl.OrderServiceImpl;
import util.ClockTool;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmployeeOrderListUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Employee user;
	private JPanel contentPane;
	private JTable table;
	private Integer OrderID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeOrderListUI frame = new EmployeeOrderListUI();
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
	public EmployeeOrderListUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			user = objectMapper.readValue(new File("user.json"), Employee.class);
		} catch (IOException e) {
			user = null;
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("訂單資料");
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
				if (user.getEmployeePosition().equals("主管")) {
					new ManagerUI().setVisible(true);
					dispose();
				} else {
					new EmployeeUI().setVisible(true);
					dispose();
				}
			}
		});
		backLastPage.setBounds(0, 0, 50, 23);
		panel.add(backLastPage);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 426, 210);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		DefaultTableModel orderTable = new OrderServiceImpl().OrderTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 406, 136);
		panel_1.add(scrollPane);

		table = new JTable(orderTable);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				TableModel model = table.getModel();
				Object id = model.getValueAt(selectedRow, 0);

				OrderID = Integer.parseInt(id.toString());

				Order order = new Order();

				try {
					ObjectMapper objectMapper = new ObjectMapper();
					order.setOrderID(OrderID);
					objectMapper.writeValue(new File("Order.json"), order);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				new EmployeeOrderDetailListUI().setVisible(true);
				dispose();

			}
		});

		JLabel lblNewLabel_1 = new JLabel("依日期查詢");
		lblNewLabel_1.setBounds(10, 156, 63, 15);
		panel_1.add(lblNewLabel_1);

		JDateChooser startDate = new JDateChooser();
		startDate.setBounds(74, 151, 127, 20);
		panel_1.add(startDate);

		JLabel lblNewLabel_1_1 = new JLabel("～");
		lblNewLabel_1_1.setBounds(211, 156, 21, 15);
		panel_1.add(lblNewLabel_1_1);

		JDateChooser endDate = new JDateChooser();
		endDate.setBounds(230, 151, 127, 20);
		panel_1.add(endDate);

		JButton filter = new JButton("篩選");
		filter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String StartDate = DateFormat.format(startDate.getDate());
				String EndDate = DateFormat.format(endDate.getDate());

				DefaultTableModel orderTable2 = new OrderServiceImpl().OrderTable(StartDate, EndDate);
				table.setModel(orderTable2);

			}
		});
		filter.setBounds(270, 177, 87, 23);
		panel_1.add(filter);

		JButton unfilter = new JButton("取消篩選");
		unfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel orderTable = new OrderServiceImpl().OrderTable();
				table.setModel(orderTable);
			}
		});
		unfilter.setBounds(114, 177, 87, 23);
		panel_1.add(unfilter);

	}
}
