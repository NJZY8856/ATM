﻿package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import model.AdminModel;
import service.AdminService;
import util.CurrentCardInfo;
import util.MyDocument;
import util.RButton;
import util.WindowSize;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Lanny
 *
 */
public class AdmnLogin implements WindowSize {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	private AdminModel admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmnLogin window = new AdmnLogin();
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
	public AdmnLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(78, 67, 233, -52);
		frame.getContentPane().add(tabbedPane);

		JLabel label = new JLabel("密  码");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("黑体", Font.BOLD, 18));
		label.setBounds(201, 330, 69, 33);
		frame.getContentPane().add(label);

		passwordField = new JPasswordField();
		passwordField.setDocument(new MyDocument(12));
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (!(temp >= 48 && temp <= 57 || temp >= 65 && temp <= 90 || temp >= 97 && temp <= 122))
					e.consume();
			}
		});
		passwordField.setBounds(280, 334, 130, 33);
		frame.getContentPane().add(passwordField);

		textField = new JTextField();
		textField.setDocument(new MyDocument(12));
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (!(temp >= 48 && temp <= 57))
					e.consume();
			}
		});
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(280, 283, 171, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("职工号");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("黑体", Font.BOLD, 18));
		label_2.setBounds(201, 283, 69, 33);
		frame.getContentPane().add(label_2);

		JLabel label_t1 = new JLabel("");
		label_t1.setForeground(Color.RED);
		label_t1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_t1.setBounds(462, 283, 148, 33);
		frame.getContentPane().add(label_t1);

		JLabel label_t2 = new JLabel("");
		label_t2.setForeground(Color.RED);
		label_t2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_t2.setBounds(420, 337, 117, 26);
		frame.getContentPane().add(label_t2);

		JButton btnNewButton = new RButton("登录");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * get Name/Pwd check Name/Pwd
				 */
				int input = getNamePwdRight(textField.getText(), passwordField.getPassword());
				if (input == 1) {// 登录成功
					// System.out.println("登录成功");
					new CurrentCardInfo().setAdmin_id(textField.getText());
					new CurrentCardInfo().setAdmin_pwd(passwordField.getText());
					frame.dispose();
					new AdmnFunction();
					// 传到下一界面

				} else if (input == 2) {
					label_t1.setText("工号不存在");
					System.out.println("工号不存在2");
				} else if (input == 5) {
					label_t1.setText("格式不规范");
					System.out.println("id格式不规范5");
				} else if (input == 3) {
					label_t2.setText("密码错误");
					System.out.println("密码错误3");
				} else if (input == 6) {
					label_t2.setText("格式不规范");
					System.out.println("pwd格式不规范6");
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(280, 387, 95, 33);
		frame.getContentPane().add(btnNewButton);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(".\\1.jpg"));
		label_1.setBounds(P_0, P_1, P_2, P_3);
		frame.getContentPane().add(label_1);

		frame.setResizable(false);
		frame.setVisible(true);

	}

	/**
	 * 
	 * @param Admin_id
	 * @param pwdChar
	 *            Admin_pwd
	 * @return 登录状态
	 */
	public int getNamePwdRight(String id, char[] pwdChar) {
		String pwd = String.valueOf(pwdChar);
		if (id.matches("[0-9]{6,12}")) {
			// 检查数据库中是否存在
			admin = new AdminService().getAdminModel(id);
			if (admin == null) {
				// System.out.println("卡号不存在2");
				return 2;
			} else {// 存在:判断状态与密码
				if (pwd.matches("[0-9a-zA-Z]{6,12}")) {
					if (!admin.getAdmin_pw().trim().equals(pwd)) {
						// System.out.println("密码错误3");
						return 3;
					}
				} else {
					// System.out.println("pwd格式不规范6");
					return 6;
				}
			}
		} else {
			// System.out.println("id格式不规范5");
			return 5;
		}
		return 1;
	}
}