package controller.Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.Login.CustomerLoginUI;
import dao.ipml.OrderDaoImpl;
import dao.ipml.OrderDetailDaoImpl;
import dao.ipml.ProductDaoImpl;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Product;
import util.ClockTool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ShoppingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Customer user;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingUI frame = new ShoppingUI();
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
	public ShoppingUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("商品訂購");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			user = objectMapper.readValue(new File("user.json"), Customer.class);
		} catch (IOException e) {
			user = null;
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel(user.getCustomerName()+"您好");
		lblNewLabel_1.setBounds(10, 0, 95, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("商品訂購");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(172, 10, 83, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("2025-02-21 15:00:00");
		lblNewLabel_4.setBounds(311, 13, 115, 21);
		panel.add(lblNewLabel_4);
		new Thread(new ClockTool.ClockRunnable(lblNewLabel_4)).start();
		
		JLabel lblNewLabel_5 = new JLabel("登出");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerLoginUI().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setBounds(10, 16, 46, 15);
		panel.add(lblNewLabel_5);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 161, 426, 100);
		contentPane.add(tabbedPane);

		JPanel addList = new JPanel();
		tabbedPane.addTab("添加訂購", null, addList, null);
		addList.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("商品名稱");
		lblNewLabel_2.setBounds(15, 14, 50, 15);
		addList.add(lblNewLabel_2);

		JComboBox addName = new JComboBox();
		addName.setBounds(75, 10, 120, 22);
		addList.add(addName);
		addName.addItem("請選擇");

		JLabel lblNewLabel_2_1 = new JLabel("數量");
		lblNewLabel_2_1.setBounds(111, 42, 25, 15);
		addList.add(lblNewLabel_2_1);

		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		JSpinner addQuantity = new JSpinner(spinnerModel);
		addQuantity.setBounds(146, 39, 61, 22);
		addList.add(addQuantity);

		JLabel lblNewLabel_3_1 = new JLabel("庫存");
		lblNewLabel_3_1.setBounds(202, 14, 25, 15);
		addList.add(lblNewLabel_3_1);

		JLabel addStock = new JLabel("0");
		addStock.setBounds(236, 14, 46, 15);
		addList.add(addStock);

		JLabel lblNewLabel_3 = new JLabel("單價");
		lblNewLabel_3.setBounds(40, 42, 25, 15);
		addList.add(lblNewLabel_3);

		JLabel addOnePrice = new JLabel("0");
		addOnePrice.setBounds(75, 42, 37, 15);
		addList.add(addOnePrice);

		JLabel lblNewLabel_3_3 = new JLabel("金額");
		lblNewLabel_3_3.setBounds(217, 42, 25, 15);
		addList.add(lblNewLabel_3_3);

		JLabel addPrice = new JLabel("0");
		addPrice.setBounds(252, 42, 37, 15);
		addList.add(addPrice);

		addQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Integer Price = Integer.parseInt(addOnePrice.getText())
						* Integer.parseInt(addQuantity.getValue().toString());
				addPrice.setText(Integer.toString(Price));
			}
		});

		DefaultTableModel tableModel = new DefaultTableModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 426, 98);

		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		tableModel.addColumn("商品名稱");
		tableModel.addColumn("單價");
		tableModel.addColumn("數量");
		tableModel.addColumn("金額");

		JButton add = new JButton("添加");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ProductName = (String) addName.getSelectedItem();
				Integer ProductOnePrice = Integer.parseInt(addOnePrice.getText());
				Integer ProductQuantity = (Integer) addQuantity.getValue();
				Integer ProductPrice = ProductOnePrice * ProductQuantity;
				if (!ProductName.equals("請選擇")) {
					boolean productFound = false;
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						if (tableModel.getValueAt(i, 0).equals(ProductName)) {
							int currentQuantity = (Integer) tableModel.getValueAt(i, 2);
							int currentPrice = (Integer) tableModel.getValueAt(i, 3);
							tableModel.setValueAt(currentQuantity + ProductQuantity, i, 2);
							tableModel.setValueAt(currentPrice + ProductPrice, i, 3);
							productFound = true;
							break;
						}
					}
					if (!productFound) {

						tableModel.addRow(new Object[] { ProductName, ProductOnePrice, ProductQuantity, ProductPrice });
					}

				} else {
					JOptionPane.showMessageDialog(null, "請選擇商品", "添加失敗", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add.setBounds(299, 38, 87, 23);
		addList.add(add);
		contentPane.add(scrollPane);

		addName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ProductName = (String) addName.getSelectedItem();
				Integer ProductStock = new ProductDaoImpl()
						.selectProductStock(new ProductDaoImpl().selectProductID(ProductName));
				addOnePrice.setText((new ProductDaoImpl().selectProductPrice(ProductName)).toString());
				addStock.setText(ProductStock.toString());

				spinnerModel.setMaximum(ProductStock);
			}
		});

		List<Product> product = new ProductDaoImpl().selectAllProduct();
		for (Product p : product) {
			addName.addItem(p.getProductName());
		}

		JPanel updateList = new JPanel();
		updateList.setLayout(null);
		tabbedPane.addTab("修改數量", null, updateList, null);

		JLabel lblNewLabel_2_2 = new JLabel("商品名稱");
		lblNewLabel_2_2.setBounds(15, 14, 50, 15);
		updateList.add(lblNewLabel_2_2);

		JLabel updateName = new JLabel("");
		updateName.setBounds(75, 14, 106, 15);
		updateList.add(updateName);

		JLabel lblNewLabel_2_1_1 = new JLabel("數量");
		lblNewLabel_2_1_1.setBounds(111, 42, 25, 15);
		updateList.add(lblNewLabel_2_1_1);

		JSpinner updateQuantity = new JSpinner(spinnerModel);
		updateQuantity.setBounds(146, 39, 61, 22);
		updateList.add(updateQuantity);

		JLabel lblNewLabel_3_1_1 = new JLabel("庫存");
		lblNewLabel_3_1_1.setBounds(202, 14, 25, 15);
		updateList.add(lblNewLabel_3_1_1);

		JLabel updateStock = new JLabel("0");
		updateStock.setBounds(236, 14, 46, 15);
		updateList.add(updateStock);

		JLabel lblNewLabel_3_2 = new JLabel("單價");
		lblNewLabel_3_2.setBounds(40, 42, 25, 15);
		updateList.add(lblNewLabel_3_2);

		JLabel updateOnePrice = new JLabel("0");
		updateOnePrice.setBounds(75, 42, 46, 15);
		updateList.add(updateOnePrice);

		JLabel lblNewLabel_3_4 = new JLabel("金額");
		lblNewLabel_3_4.setBounds(217, 42, 25, 15);
		updateList.add(lblNewLabel_3_4);

		JLabel updatePrice = new JLabel("0");
		updatePrice.setBounds(252, 42, 37, 15);
		updateList.add(updatePrice);

		updateQuantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Integer Price = Integer.parseInt(updateOnePrice.getText())
						* Integer.parseInt(updateQuantity.getValue().toString());
				updatePrice.setText(Integer.toString(Price));
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				String ProductName = (table.getValueAt(selectedRow, 0)).toString();
				Integer ProductStock = new ProductDaoImpl()
						.selectProductStock(new ProductDaoImpl().selectProductID(ProductName));
				updateName.setText(ProductName);
				updateStock.setText(ProductStock.toString());
				updateOnePrice.setText((table.getValueAt(selectedRow, 1)).toString());
				updateQuantity.setValue(table.getValueAt(selectedRow, 2));
				updatePrice.setText(table.getValueAt(selectedRow, 3).toString());

			}
		});

		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				updateName.setText((table.getValueAt(selectedRow, 0)).toString());
				Integer ProductQuantity = (Integer) updateQuantity.getValue();
				Integer ProductPrice = ProductQuantity * Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
				table.setValueAt(ProductQuantity, selectedRow, 2);
				table.setValueAt(ProductPrice, selectedRow, 3);
			}
		});
		update.setBounds(299, 38, 87, 23);
		updateList.add(update);

		JPanel deleteList = new JPanel();
		tabbedPane.addTab("刪除商品", null, deleteList, null);
		deleteList.setLayout(null);

		JButton add_1 = new JButton("刪除");
		add_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				tableModel.removeRow(selectedRow);
			}
		});
		add_1.setBounds(167, 10, 87, 23);
		deleteList.add(add_1);

		JButton addOrder = new JButton("送出訂單");
		addOrder.setBounds(312, 271, 87, 23);
		contentPane.add(addOrder);

		JButton orderHistory = new JButton("訂購紀錄");
		orderHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShoppingListUI().setVisible(true);
				dispose();
			}
		});
		orderHistory.setBounds(105, 271, 85, 23);
		contentPane.add(orderHistory);

		JButton btnNewButton = new JButton("帳號管理");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerAccountManageUI().setVisible(true);
				dispose();
			}
		});

		btnNewButton.setBounds(10, 271, 85, 23);
		contentPane.add(btnNewButton);
		addOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModel.getRowCount();
				if (rowCount > 0) {
					int result = JOptionPane.showConfirmDialog(null, "是否送出訂單", "訂單確認", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {

						int total = 0;

						for (int i = 0; i < rowCount; i++) {
							total = total + ((Integer) tableModel.getValueAt(i, 3)).intValue();
						}

						new OrderDaoImpl().addOrder(new Order(user.getCustomerID(), total));

						Integer OrderID = new OrderDaoImpl().selectOrderID(user.getCustomerID(), ClockTool.getTime());

						for (int i = 0; i < rowCount; i++) {
							String productName = String.valueOf((tableModel.getValueAt(i, 0)));
							Integer productID = new ProductDaoImpl().selectProductID(productName);
							Integer productQuantity = ((Integer) tableModel.getValueAt(i, 2)).intValue();
							Integer productPrice = ((Integer) tableModel.getValueAt(i, 3)).intValue();

							new OrderDetailDaoImpl()
									.addOrderDetail(new OrderDetail(OrderID, productID, productQuantity, productPrice));

							int stock = new ProductDaoImpl().selectProductStock(productID);
							new ProductDaoImpl().updateProduct(new Product(productID, productName,
									productPrice / productQuantity, stock - productQuantity));
						}
						JOptionPane.showMessageDialog(null, "送出成功", "送出成功", JOptionPane.WARNING_MESSAGE);

						String ProductName = (String) addName.getSelectedItem();
						Integer ProductStock = new ProductDaoImpl()
								.selectProductStock(new ProductDaoImpl().selectProductID(ProductName));
						addOnePrice.setText((new ProductDaoImpl().selectProductPrice(ProductName)).toString());
						addStock.setText(ProductStock.toString());

						Order order = new Order();
						try {
							ObjectMapper objectMapper = new ObjectMapper();
							order.setOrderID(OrderID);
							objectMapper.writeValue(new File("Order.json"), order);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						new ShoppingListDetailUI().setVisible(true);
						dispose();

					}
				} else {
					JOptionPane.showMessageDialog(null, "請添加商品", "送出失敗", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

	}
}
