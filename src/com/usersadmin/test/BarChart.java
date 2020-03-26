package com.usersadmin.test;

//这是引入包名，根据自己创建的包名可以进行修改
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class BarChart {
	ChartPanel frame1;

	public BarChart() {
		CategoryDataset dataset = getDataSet();// 将获得的数据传递给CategoryDataset类的对象
		JFreeChart chart1 = ChartFactory.createBarChart3D("有疫情疑似症状人数统计表", // 图表标题
				"日期", // 目录轴的显示标签
				"人数", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		CategoryPlot plot = chart1.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart1.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		chart1.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
		frame1 = new ChartPanel(chart1, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame
	}

	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(6, "3.1", "3.1");// 数据1
		dataset.addValue(5, "3.2", "3.2");// 数据2
		dataset.addValue(4, "3.3", "3.3");// 数据3
		dataset.addValue(3, "3.4", "3.4");// 数据4
		dataset.addValue(3, "3.5", "3.5");// 数据1
		dataset.addValue(3, "3.6", "3.6");// 数据2
		dataset.addValue(3, "3.7", "3.7");// 数据3
		dataset.addValue(3, "3.8", "3.8");// 数据4
		dataset.addValue(3, "3.9", "3.9");// 数据1
		dataset.addValue(3, "3.10", "3.10");// 数据2
		dataset.addValue(3, "3.11", "3.11");// 数据3
		dataset.addValue(2, "3.12", "3.12");// 数据4
		dataset.addValue(2, "3.13", "3.13");// 数据3
		dataset.addValue(2, "3.14", "3.14");// 成绩4
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("有疫情疑似症状人数统计表");
		frame.setLayout(new GridLayout(2, 2, 10, 10));
		frame.add(new BarChart().getChartPanel()); // 添加柱形图
		frame.setBounds(0, 0, 900, 800);
		frame.setVisible(true);
	}
}
