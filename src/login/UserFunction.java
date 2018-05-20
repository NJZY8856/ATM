﻿package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.card.ChangePwd;
import controller.card.CheckMoney;
import controller.card.StoreMoney;
import controller.card.TransMoney;
import controller.card.UCheckCardTrad;
import controller.card.WithdrawMoney;
import util.RButton;
import util.WindowSize;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserFunction implements WindowSize{

	JFrame frame;
	private JPanel panel;
	//private JLabel lblNewLabel_4=new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFunction window = new UserFunction();
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
	public UserFunction() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setBounds(F_0, F_1, F_2, F_3);
		
		
		panel.setBounds(P_0, P_1, P_2, P_3);
		panel.setLayout(null);
		
/*		lblNewLabel_4 = new JLabel("New label");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setOpaque(false);
		new Thread(new MyThread(lblNewLabel_4,frame)).start();*/
		
		
		JButton btnNewButton = new RButton("存款");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.getContentPane().add(new StoreMoney(frame));
				frame.validate();
			}
		});
		btnNewButton.setBounds(0, 173, 133, 41);
		panel.add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("取款"); 
		JButton btnNewButton_1 = new RButton("取款"); 
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(0, 239, 133, 41);

		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.remove(panel);
				frame.getContentPane().add(new WithdrawMoney(frame));
				frame.validate();
			}
		});
		
		JButton button = new RButton("转账");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(0, 313, 133, 41);
		panel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new TransMoney();
			}
		});

		JButton button_3 = new RButton("查询余额");
		button_3.setFont(new Font("黑体", Font.BOLD, 18));
		button_3.setBounds(547, 173, 133, 41);
		panel.add(button_3);
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new CheckMoney();
			}
		});
		
		JButton button_4 = new RButton("明细查询");
		button_4.setFont(new Font("黑体", Font.BOLD, 18));
		button_4.setBounds(547, 239, 133, 41);
		panel.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.getContentPane().add(new UCheckCardTrad(frame));
				frame.validate();
			}
		});

		JButton button_1 = new RButton("修改密码");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(547, 313, 133, 41);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new ChangePwd();
			}
		});
		
		JButton button_2 = new RButton("退卡");
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		button_2.setBounds(547, 380, 133, 41);
		panel.add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new StartScreen();
			}
		});
		
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon(".\\2.jpg"));
		lblBackground.setBounds(P_0, P_1, P_2, P_3);
		panel.add(lblBackground);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}