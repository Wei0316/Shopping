package util;

import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import dao.ipml.OrderDaoImpl;
import dao.ipml.OrderDetailDaoImpl;
import model.Order;
import model.OrderDetail;

public class Tool {

	public static void main(String[] args) {
		List<Order> orderData = new OrderDaoImpl().selectAllOrder();
		List<OrderDetail> orderDetailData = new OrderDetailDaoImpl().selectAllOrderDetail();
		exportToExcel(orderData, orderDetailData, "sales_data.xlsx");
	}

	public static void exportToExcel(List<Order> orderData, List<OrderDetail> orderDetailData, String filePath) {
		try {
			Workbook workbook = new XSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream(filePath);

			exportOorderData(workbook, orderData);

			exportOorderDetailData(workbook, orderDetailData);

			workbook.write(fileOut);
			System.out.println("Excel匯出成功" + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exportOorderData(Workbook workbook, List<Order> orderData) {

		Sheet sheet = workbook.createSheet("訂單列表");

		sheet.createRow(0).createCell(0).setCellValue("訂單列表");

		Row headerRow = sheet.createRow(2);
		String[] headers = { "訂單編號", "客戶姓名", "客戶電話", "聯絡地址", "建立時間", "總金額" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
		}

		int rowNum = 3;
		for (Order order : orderData) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(order.OrderID);
			row.createCell(1).setCellValue(order.customerName);
			row.createCell(2).setCellValue(order.customerPhone);
			row.createCell(3).setCellValue(order.customerAddress);
			row.createCell(4).setCellValue(order.OrderTime);
			row.createCell(5).setCellValue(order.OrderTotal);
		}

		sheet.createRow(rowNum + 1).createCell(5).setCellValue("生成時間：" + ClockTool.getTime());

		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private static void exportOorderDetailData(Workbook workbook, List<OrderDetail> orderDetailData) {

		Sheet sheet = workbook.createSheet("訂單明細表");
		Row headerRow = sheet.createRow(2);
		String[] headers = { "訂單編號", "明細編號", "商品名稱", "商品單價", "訂購數量", "金額" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);

		}

		sheet.createRow(0).createCell(0).setCellValue("訂單明細表");

		int rowNum = 3;
		for (OrderDetail orderDetail : orderDetailData) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(orderDetail.OrderID);
			row.createCell(1).setCellValue(orderDetail.OrderDetailID);
			row.createCell(2).setCellValue(orderDetail.ProductName);
			row.createCell(3).setCellValue(orderDetail.ProductOnePrice);
			row.createCell(4).setCellValue(orderDetail.ProductQuantity);
			row.createCell(5).setCellValue(orderDetail.ProductPrice);
		}

		sheet.createRow(rowNum + 1).createCell(5).setCellValue("生成時間：" + ClockTool.getTime());

		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

	}

	private static Connection connection = DBConnection.getDB();

	public static JFreeChart createBarChart() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(
					"select ProductName, sum(ProductQuantity) as TotalQuantity from orderdetaillist group by ProductName");

			while (resultSet.next()) {
				String ProductName = resultSet.getString("ProductName");
				int TotalQuantity = resultSet.getInt("TotalQuantity");
				dataset.addValue(TotalQuantity, "銷量", ProductName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JFreeChart chart = ChartFactory.createBarChart("商品銷售量統計", "商品", "銷售量", dataset, PlotOrientation.VERTICAL, true,
				true, false);

		Font font = new Font("宋體", Font.PLAIN, 12);

		chart.getTitle().setFont(font);

		CategoryPlot plot = chart.getCategoryPlot();
		plot.getDomainAxis().setTickLabelFont(font);
		plot.getDomainAxis().setLabelFont(font);
		plot.getRangeAxis().setTickLabelFont(font);
		plot.getRangeAxis().setLabelFont(font);
		chart.getLegend().setItemFont(font);

		return chart;
	}

	public static JFreeChart createPieChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(
					"select ProductName, sum(ProductQuantity) as TotalQuantity from orderdetaillist group by ProductName");

			while (resultSet.next()) {
				String ProductName = resultSet.getString("ProductName");
				int TotalQuantity = resultSet.getInt("TotalQuantity");
				dataset.setValue(ProductName, TotalQuantity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JFreeChart chart = ChartFactory.createPieChart("商品銷售分佈", dataset, true, true, false);

		Font font = new Font("宋體", Font.PLAIN, 12);
		chart.getTitle().setFont(new Font("宋體", Font.BOLD, 20));
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(font);
		chart.getLegend().setItemFont(font);

		return chart;
	}

}
