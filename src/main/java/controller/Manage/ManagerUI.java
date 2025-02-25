package controller.Manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Login.EmployeeLoginUI;
import dao.ipml.OrderDaoImpl;
import dao.ipml.OrderDetailDaoImpl;
import model.Employee;
import model.Order;
import model.OrderDetail;
import util.ClockTool;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Employee user;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI frame = new ManagerUI();
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
	public ManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 300);
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
		setTitle("主管" + user.getEmployeeName());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("歡迎" + user.getEmployeeName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 10, 338, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("2025-02-21 15:00:00");
		lblNewLabel_4.setBounds(311, 13, 115, 21);
		panel.add(lblNewLabel_4);
		new Thread(new ClockTool.ClockRunnable(lblNewLabel_4)).start();

		JLabel lblNewLabel_1 = new JLabel("登出");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeLoginUI().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setBounds(10, 16, 25, 15);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 426, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("<html>員工<br>管理</html>");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeManageUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(218, 10, 94, 85);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<html>訂單<br>清單</html>");
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeOrderListUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(114, 10, 94, 85);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("<html>商品<br>管理</html>");
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ProductManageUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 10, 94, 85);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("<html>匯出<br>訂單</html>");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Order> orderData = new OrderDaoImpl().selectAllOrder();
				List<OrderDetail> orderDetailData = new OrderDetailDaoImpl().selectAllOrderDetail();
				Tool.exportToExcel(orderData, orderDetailData, "訂單資料.xlsx");
				JOptionPane.showMessageDialog(null, "匯出成功", "匯出成功", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(10, 103, 94, 85);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("<html>銷量<br>統計</html>");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFrame frame = new JFrame("JFreeChart Example");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(800, 600);

				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				// 生成圖表
				JFreeChart barChart = Tool.createBarChart();
				JFreeChart pieChart = Tool.createPieChart();

				// 顯示圖表
				panel.add(new ChartPanel(barChart));
				panel.add(new ChartPanel(pieChart));

				frame.getContentPane().add(panel);

				frame.setVisible(true);

			}
		});
		btnNewButton_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(114, 103, 94, 85);
		panel_1.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("<html>帳號<br>管理</html>");
		btnNewButton_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeAccountManageUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(322, 10, 94, 85);
		panel_1.add(btnNewButton_1_3);
	}
}
