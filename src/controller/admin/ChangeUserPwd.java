package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;

import dao.CardDao;
import login.AdmnFunction;
import util.RButton;
import util.WindowSize;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeUserPwd implements WindowSize{

	private JFrame frame;
	private JPasswordField passwd1;
	private JPasswordField passwd2;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeUserPwd window = new ChangeUserPwd(null);
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
	public ChangeUserPwd(String card_id) {
		initialize(card_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String card_id) {
		System.out.println("dddf");
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入新密码：");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(158, 155, 140, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("再次确认新密码：");
		label.setFont(new Font("黑体", Font.BOLD, 18));
		label.setForeground(Color.WHITE);
		label.setBounds(146, 230, 152, 32);
		frame.getContentPane().add(label);
		
		passwd1=new JPasswordField();
		passwd1.setBounds(308, 155, 167, 32);
		frame.getContentPane().add(passwd1);
		passwd1.setColumns(10);
		
		passwd2=new JPasswordField();
		passwd2.setColumns(10);
		passwd2.setBounds(308, 230, 167, 32);
		frame.getContentPane().add(passwd2);
		
		button = new RButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwd1.getText().matches("[1-9]\\d{5}(?!\\d)")){
					if(passwd1.getText().equals(passwd2.getText())){
						new CardDao().changePasswd(passwd1.getText(),card_id);
						JOptionPane.showMessageDialog(frame.getContentPane(), "修改密码成功", "系统信息", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						new AdmnFunction();
					}
					else{
					JOptionPane.showMessageDialog(frame.getContentPane(), "两次输入密码不一致，请重新输入", "系统信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(frame.getContentPane(), "密码必须为六位数字", "系统信息", JOptionPane.INFORMATION_MESSAGE);
		}
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(F_2-149, 350, 133, 41);
		frame.getContentPane().add(button);
		
		button_1 = new RButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdmnFunction();
			}
		});
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0,350, 133, 41);
		frame.getContentPane().add(button_1);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setBackground(SystemColor.text);
		lblBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
		lblBackground.setIcon(new ImageIcon(".\\5.jpg"));
		lblBackground.setBounds(0, 0, 670, 501);
		frame.getContentPane().add(lblBackground);
		
		frame.setVisible(true);
	}

}
