package controller.Manage;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import util.Tool;

public class SalesStatisticsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesStatisticsUI frame = new SalesStatisticsUI();
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
	public SalesStatisticsUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("銷量統計表");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("JFreeChart Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 600);

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			// 生成圖表
			JFreeChart barChart = Tool.createBarChart();
			JFreeChart pieChart = Tool.createPieChart();

			// 顯示圖表
			panel.add(new ChartPanel(barChart));
			panel.add(new ChartPanel(pieChart));

			frame.add(panel);
			frame.setVisible(true);
		});
	}

}
