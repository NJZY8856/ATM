package controller.card;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import util.CurrentCardInfo;
import util.FitTableColumns;
import util.MyDocument;
import util.RButton;
import util.StrADate;
import util.WindowSize;
import javax.swing.JTextField;
import login.UserFunction;
import login.UserLogin;
import model.TradModel;
import service.TradService;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UCheckCardTrad extends JPanel implements WindowSize {
	private JTextField textField;
	private JTextField textField_1;
	private String[] columnNames = { "交易类型", "交易金额", "交易目标", "交易时间" };
	private List<TradModel> trade;
	private JLabel label_2;
	private String startStr = "";
	private String finalStr = "";
	private JTable table;
	private JTable table_1;
	private JFrame frame;
	//private JLabel lblNewLabel_4=new JLabel("");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public UCheckCardTrad(JFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBounds(P_0, P_1, P_2, P_3);
		
		/*lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setOpaque(false);
		new Thread(new MyThread(lblNewLabel_4,frame)).start();
		add(lblNewLabel_4);*/

		String trCard_id = new CurrentCardInfo().getCardInfo().getCard_id();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 161, 680, 294);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setVisible(false);
		add(panel_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 161, 680, 294);
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(null);

		JButton button_6 = new RButton("退卡");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserLogin();
			}
		});
		button_6.setFont(new Font("黑体", Font.BOLD, 18));
		button_6.setBounds(556, 214, 124, 42);
		panel_1.add(button_6);

		JButton btnNewButton = new RButton("返回");
		btnNewButton.setBounds(556, 158, 124, 42);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
				label_2.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 523, 274);
		panel_1.add(scrollPane);

		table = new JTable();
		showTrade(null);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setDocument(new MyDocument(8));
		textField.setBounds(158, 62, 113, 27);
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (temp > 57) {
					e.consume();
				} else if (temp < 48) {
					e.consume();
				}
			}
		});
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("起始时间");
		lblNewLabel_1.setBounds(59, 60, 89, 27);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setDocument(new MyDocument(8));
		textField_1.setBounds(158, 111, 113, 27);
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (temp > 57) {
					e.consume();
				} else if (temp < 48) {
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		panel.add(textField_1);

		JLabel label_1 = new JLabel("截止时间");
		label_1.setBounds(59, 109, 89, 27);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		panel.add(label_1);

		JLabel label = new JLabel("输入如:20180101");
		label.setBounds(75, 10, 196, 27);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 23));
		panel.add(label);

		label_2 = new JLabel("输入时间不规范！");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.BOLD, 23));
		label_2.setBounds(75, 164, 196, 27);
		label_2.setVisible(false);
		panel.add(label_2);

		JRadioButton button_2 = new JRadioButton("转入信息");
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(292, 101, 113, 42);
		button_2.setOpaque(false);
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(button_2);
		panel.add(button_2);

		JRadioButton button_4 = new JRadioButton("转出信息");
		button_4.setForeground(Color.WHITE);
		button_4.setBounds(402, 101, 124, 42);
		button_4.setOpaque(false);
		button_4.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(button_4);
		panel.add(button_4);

		JRadioButton button_3 = new JRadioButton("存款信息");
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(292, 52, 101, 42);
		button_3.setOpaque(false);
		button_3.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(button_3);
		panel.add(button_3);

		JRadioButton button = new JRadioButton("取款信息");
		button.setForeground(Color.WHITE);
		button.setBounds(402, 52, 124, 42);
		button.setOpaque(false);
		button.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(button);
		panel.add(button);

		JButton button_1 = new RButton("退卡");
		button_1.setBounds(556, 215, 124, 42);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserLogin();
			}
		});
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		panel.add(button_1);

		JRadioButton button_5 = new JRadioButton("默认显示");
		button_5.setForeground(Color.WHITE);
		button_5.setBounds(292, 158, 113, 42);
		button_5.setSelected(true);
		;
		button_5.setOpaque(false);
		button_5.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(button_5);
		panel.add(button_5);

		JButton button_7 = new RButton("返回");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserFunction();
			}
		});
		button_7.setFont(new Font("黑体", Font.BOLD, 18));
		button_7.setBounds(556, 158, 124, 42);
		panel.add(button_7);

		JButton btnNewButton_1 = new RButton("查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkDateStr()) {
					int setrad_type = 0;
					if (button_3.isSelected()) {
						setrad_type = 1;
					} else if (button.isSelected()) {
						setrad_type = 2;
					} else if (button_2.isSelected()) {
						setrad_type = 4;
					} else if (button_4.isSelected()) {
						setrad_type = 3;
					} else if (button_5.isSelected()) {
						setrad_type = 0;
					}
					/*
					 * 调用查询服务，返回trade信息
					 */
					trade = new TradService().checkTradWithDate(trCard_id, startStr, finalStr, setrad_type);
					showTrade(trade);
					panel.setVisible(false);
					scrollPane.remove(table);
					scrollPane.setViewportView(table_1);
					panel_1.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(556, 96, 124, 42);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\4.jpg"));
		lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
		add(lblNewLabel);
	}

	public boolean showTrade(List<TradModel> trad) {
		Object[][] sT = null;
		if (trad == null) {// 只有列名的空表
			sT = new Object[5][4];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					sT[i][j] = null;
				}
			}
			table = new JTable(sT, columnNames);
			table_1 = new JTable(sT, columnNames);
			table.setOpaque(false);
			return false;
		}
		sT = new Object[trad.size()][4];
		for (int i = 0; i < trad.size(); i++) {
			if (trad.get(i).getTrad_type() == 1) {
				sT[i][0] = "存款";
			} else if (trad.get(i).getTrad_type() == 2) {
				sT[i][0] = "取款";
			} else if (trad.get(i).getTrad_type() == 3) {
				sT[i][0] = "转出";
			} else {
				sT[i][0] = "转入";
			}
			sT[i][1] = trad.get(i).getAmount();
			sT[i][2] = trad.get(i).getTrad_to();
			sT[i][3] = trad.get(i).getTrad_time();
		}
		table_1 = new JTable(sT, columnNames);
		new FitTableColumns(table_1);
		return true;
	}

	public boolean checkDateStr() {
		if (new StrADate().checkDate(textField.getText())) {
			startStr = textField.getText();
			if (new StrADate().checkDate(textField_1.getText())) {
				finalStr = textField_1.getText();
				if (startStr.equals("") || finalStr.equals("")) {// 两者要么同时空要么同时不空
					if (!startStr.equals("") || !finalStr.equals("")) {
						label_2.setVisible(true);
						return false;
					}
				}
				return true;
			} else {
				label_2.setVisible(true);
				return false;
			}
		} else {
			label_2.setVisible(true);
			return false;
		}
	}
}
