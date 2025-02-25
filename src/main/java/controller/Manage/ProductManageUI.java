package controller.Manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.ipml.ProductDaoImpl;
import model.Product;
import service.impl.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel ProductTable = new ProductServiceImpl().ProductSelectForTable();
	private JPanel contentPane;
	private JTable table;
	private JTextField updateName;
	private JTextField updatePrice;
	private JTextField updateStock;
	private Integer ProductID;
	private JTextField addName;
	private JTextField addPrice;
	private JTextField addStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManageUI frame = new ProductManageUI();
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
	public ProductManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("商品管理");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 426, 33);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("商品管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(54, 10, 317, 24);
		panel.add(lblNewLabel);

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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 169, 426, 94);
		contentPane.add(tabbedPane);

		JPanel updateProduct = new JPanel();
		tabbedPane.addTab("產品更新", null, updateProduct, null);
		updateProduct.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("商品名稱");
		lblNewLabel_1.setBounds(10, 13, 50, 15);
		updateProduct.add(lblNewLabel_1);

		updateName = new JTextField();
		updateName.setBounds(65, 10, 96, 21);
		updateProduct.add(updateName);
		updateName.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("單價");
		lblNewLabel_1_1.setBounds(35, 38, 25, 15);
		updateProduct.add(lblNewLabel_1_1);

		updatePrice = new JTextField();
		updatePrice.setColumns(10);
		updatePrice.setBounds(65, 35, 96, 21);
		updateProduct.add(updatePrice);

		JLabel lblNewLabel_1_1_1 = new JLabel("庫存");
		lblNewLabel_1_1_1.setBounds(171, 38, 25, 15);
		updateProduct.add(lblNewLabel_1_1_1);

		updateStock = new JTextField();
		updateStock.setColumns(10);
		updateStock.setBounds(200, 35, 96, 21);
		updateProduct.add(updateStock);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 426, 117);
		contentPane.add(scrollPane);

		table = new JTable(ProductTable);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				TableModel model = table.getModel();
				Object id = model.getValueAt(selectedRow, 0);
				Object name = model.getValueAt(selectedRow, 1);
				Object price = model.getValueAt(selectedRow, 2);
				Object stock = model.getValueAt(selectedRow, 3);

				ProductID = Integer.parseInt(id.toString());
				updateName.setText(name.toString());
				updatePrice.setText(price.toString());
				updateStock.setText(stock.toString());

			}
		});

		JButton update = new JButton("更新");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = updateName.getText();
				Integer Price = Integer.parseInt(updatePrice.getText().toString());
				Integer Stock = Integer.parseInt(updateStock.getText().toString());

				new ProductDaoImpl().updateProduct(new Product(ProductID, Name, Price, Stock));
				ProductTable = new ProductServiceImpl().ProductSelectForTable();
				table.setModel(ProductTable);
				JOptionPane.showMessageDialog(null, "更新成功", "更新成功", JOptionPane.WARNING_MESSAGE);

				updateName.setText("");
				updatePrice.setText("");
				updateStock.setText("");
			}
		});
		update.setBounds(326, 34, 85, 23);
		updateProduct.add(update);

		JPanel addProduct = new JPanel();
		tabbedPane.addTab("新增產品", null, addProduct, null);
		addProduct.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("商品名稱");
		lblNewLabel_1_2.setBounds(10, 13, 50, 15);
		addProduct.add(lblNewLabel_1_2);

		addName = new JTextField();
		addName.setColumns(10);
		addName.setBounds(65, 10, 96, 21);
		addProduct.add(addName);

		JLabel lblNewLabel_1_1_2 = new JLabel("單價");
		lblNewLabel_1_1_2.setBounds(35, 38, 25, 15);
		addProduct.add(lblNewLabel_1_1_2);

		addPrice = new JTextField();
		addPrice.setColumns(10);
		addPrice.setBounds(65, 35, 96, 21);
		addProduct.add(addPrice);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("庫存");
		lblNewLabel_1_1_1_1.setBounds(171, 38, 25, 15);
		addProduct.add(lblNewLabel_1_1_1_1);

		addStock = new JTextField();
		addStock.setColumns(10);
		addStock.setBounds(200, 35, 96, 21);
		addProduct.add(addStock);

		JButton add = new JButton("新增");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = addName.getText();
				Integer Price = Integer.parseInt(addPrice.getText().toString());
				Integer Stock = Integer.parseInt(addStock.getText().toString());

				new ProductDaoImpl().addProduct(new Product(Name, Price, Stock));
				ProductTable = new ProductServiceImpl().ProductSelectForTable();
				table.setModel(ProductTable);
				JOptionPane.showMessageDialog(null, "新增成功", "新增成功", JOptionPane.WARNING_MESSAGE);

				addName.setText("");
				addPrice.setText("");
				addStock.setText("");
			}
		});
		add.setBounds(326, 34, 85, 23);
		addProduct.add(add);

		JPanel deleteProduct = new JPanel();
		tabbedPane.addTab("移除產品", null, deleteProduct, null);
		deleteProduct.setLayout(null);

		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否確定刪除", "刪除確認", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					new ProductDaoImpl().deleteProduct(ProductID);
					ProductTable = new ProductServiceImpl().ProductSelectForTable();
					table.setModel(ProductTable);
					JOptionPane.showMessageDialog(null, "刪除成功", "刪除成功", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		delete.setBounds(165, 10, 85, 23);
		deleteProduct.add(delete);
	}
}
