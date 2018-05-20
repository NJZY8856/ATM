package controller.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.CardDao;
import login.AdmnFunction;
import model.CardModel;
import model.TradModel;
import service.CardService;
import service.TradService;
import util.FitTableColumns;
import util.JDateChooser;
import util.MyDocument;
import util.RButton;
import util.StrADate;
import util.WindowSize;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class ACheckCardTrad implements WindowSize {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private String[] columnNames = { "卡号", "交易类型", "交易金额", "交易目标", "交易时间" };
	private JTextField textField_1;
	private JTextField textField_2;
	private String startStr = "";
	private String finalStr = "";
	private JPanel panel_1 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACheckCardTrad window = new ACheckCardTrad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ACheckCardTrad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("查询交易明细");
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel_1.setBounds(0, 108, 670, 116);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		frame.getContentPane().add(panel_1);

		JLabel lblNewLabel = new JLabel("卡号");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
		lblNewLabel.setBounds(24, 11, 47, 28);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setDocument(new MyDocument(19));
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
		textField.setBounds(82, 14, 168, 24);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("时间");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("黑体", Font.BOLD, 18));
		label.setBounds(24, 49, 47, 28);
		panel_1.add(label);

		textField_1 = new JTextField();
		textField_1.setDocument(new MyDocument(8));
		textField_1.setBounds(81, 53, 120, 21);
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

		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("选择起始时间");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("黑体", Font.BOLD, 18));
		label_3.setBounds(239, 53, 120, 21);
		panel_1.add(label_3);

		frame.getContentPane().add(panel_1);

		textField_2 = new JTextField();
		textField_2.setDocument(new MyDocument(8));
		textField_2.setColumns(10);
		textField_2.setBounds(82, 84, 119, 21);
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (temp > 57) {
					e.consume();
				} else if (temp < 48) {
					e.consume();
				}
			}
		});
		panel_1.add(textField_2);

		JLabel label_7 = new JLabel("—");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("黑体", Font.BOLD, 30));
		label_7.setBounds(34, 84, 37, 21);
		panel_1.add(label_7);

		JRadioButton radioButton = new JRadioButton("存款");
		radioButton.setFont(new Font("黑体", Font.BOLD, 18));
		radioButton.setForeground(Color.WHITE);
		radioButton.setOpaque(false);
		buttonGroup.add(radioButton);
		radioButton.setBounds(376, 52, 67, 23);
		panel_1.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("取款");
		radioButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		radioButton_1.setForeground(Color.WHITE);
		buttonGroup.add(radioButton_1);
		radioButton_1.setOpaque(false);
		radioButton_1.setBounds(470, 52, 67, 23);
		panel_1.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("转入");
		radioButton_2.setFont(new Font("黑体", Font.BOLD, 18));
		radioButton_2.setForeground(Color.WHITE);
		buttonGroup.add(radioButton_2);
		radioButton_2.setOpaque(false);
		radioButton_2.setBounds(376, 81, 67, 23);
		panel_1.add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("转出");
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(radioButton_3);
		radioButton_3.setOpaque(false);
		radioButton_3.setBounds(470, 81, 67, 23);
		panel_1.add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("所有");
		radioButton_4.setForeground(Color.WHITE);
		radioButton_4.setFont(new Font("黑体", Font.BOLD, 18));
		buttonGroup.add(radioButton_4);
		radioButton_4.setOpaque(false);
		radioButton_4.setBounds(564, 52, 67, 23);
		panel_1.add(radioButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 660, 229);

		table = new JTable();
		List<TradModel> trad = new TradService().checkTradWithDate("", "", "", 0);
		showTrade(trad);
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new RButton("查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trCardId = textField.getText();
				// 检查startStr/finalStr输入正确？
				if (getNamePwdRight(trCardId) == 1) {
					checkDateStr();
					int setrad_type = 0;
					if (radioButton.isSelected()) {
						setrad_type = 1;
					} else if (radioButton_1.isSelected()) {
						setrad_type = 2;
					} else if (radioButton_2.isSelected()) {
						setrad_type = 4;
					} else if (radioButton_3.isSelected()) {
						setrad_type = 3;
					} else if (radioButton_4.isSelected()) {
						setrad_type = 0;
					}
					/*
					 * 调用查询服务，返回trade信息
					 */
					List<TradModel> tradLs = new TradService().checkTradWithDate(trCardId, startStr, finalStr,
							setrad_type);
					showTrade(tradLs);
					scrollPane.remove(table);
					scrollPane.setViewportView(table_1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(387, 8, 109, 34);
		panel_1.add(btnNewButton_1);

		JLabel label_1 = new JLabel("选择截止时间");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("黑体", Font.BOLD, 18));
		label_1.setBounds(239, 84, 120, 21);
		panel_1.add(label_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 225, 660, 224);

		panel.add(scrollPane);
		panel.setLayout(null);
		frame.getContentPane().add(panel_1);

		JButton button = new RButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new AdmnFunction();
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(561, 9, 109, 32);
		panel_1.add(button);
		
		JButton btnNewButton = new JButton("···");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=new JDateChooser().main(null);
				textField_1.setText(str);;
				
			}
		});
		btnNewButton.setBounds(205, 54, 30, 20);
		btnNewButton.getColorModel();
		panel_1.add(btnNewButton);
		
		JButton button_1 = new JButton("···");
		button_1.setBounds(205, 84, 30, 20);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=new JDateChooser().main(null);
				textField_2.setText(str);;
			}
		});
		panel_1.add(button_1);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(P_0, P_1, P_2, P_3);
		lblNewLabel_1.setIcon(new ImageIcon(".\\5.jpg"));
		frame.getContentPane().add(lblNewLabel_1);
		frame.setResizable(false); // 禁止改变大小在调用显示之前
		frame.setVisible(true);
	}

	/**
	 * 初始化表格以及表格显示查询结果
	 */
	public boolean showTrade(List<TradModel> trad) {
		Object[][] sT = null;
		if (trad == null) {// 只有列名的空表
			sT = new Object[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					sT[i][j] = null;
				}
			}
			table = new JTable(sT, columnNames);
			table_1 = new JTable(sT, columnNames);
			return false;
		}
		sT = new Object[trad.size()][5];
		for (int i = 0; i < trad.size(); i++) {
			sT[i][0] = trad.get(i).getCard_id();
			if (trad.get(i).getTrad_type() == 1) {
				sT[i][1] = "存款";
			} else if (trad.get(i).getTrad_type() == 2) {
				sT[i][1] = "取款";
			} else if (trad.get(i).getTrad_type() == 3) {
				sT[i][1] = "转出";
			} else {
				sT[i][1] = "转入";
			}
			sT[i][2] = trad.get(i).getAmount();
			sT[i][3] = trad.get(i).getTrad_to();
			sT[i][4] = trad.get(i).getTrad_time();
		}
		table = new JTable(sT, columnNames);
		new FitTableColumns(table);
		table_1 = new JTable(sT, columnNames);
		new FitTableColumns(table_1);
		return true;
	}

	public void checkDateStr() {
		if (new StrADate().checkDate(textField_1.getText())) {
			startStr = textField_1.getText();
			if (new StrADate().checkDate(textField_2.getText())) {
				finalStr = textField_2.getText();
				if (startStr.equals("") || finalStr.equals("")) {// 两者要么同时空要么同时不空
					if (!startStr.equals("") || !finalStr.equals("")) {
						JOptionPane.showMessageDialog(null, "不允许其中一个时间为空！", "提示", JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "输入时间格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "输入时间格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	public int getNamePwdRight(String id) {
		if (id.matches("[0-9]{19}")) {
			CardModel card = new CardService().getCardModel(id);
			if (card == null) {
				JOptionPane.showMessageDialog(null, "卡号不存在！", "提示", JOptionPane.WARNING_MESSAGE);
			} else {
				return 1;
			}
		} else if (!id.equals("")) {
			JOptionPane.showMessageDialog(null, "输入的卡号不符合规范！", "提示", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		return 1;
	}
}
