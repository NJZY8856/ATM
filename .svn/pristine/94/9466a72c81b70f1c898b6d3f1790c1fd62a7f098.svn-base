package controller.card;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.AdmnFunction;
import login.UserFunction;
import util.RButton;
import util.WindowSize;

public class ChangePwdSucc implements WindowSize{
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	
	public static void main(String[] args) {
					ChangePwdSucc window = new ChangePwdSucc(0);
					window.frame.setVisible(true);
	}
	
	public ChangePwdSucc(int i){
		frame=new JFrame("修改密码成功！");
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button1=new RButton("返回");
		button1.setBounds(0,386,133, 41);
		//button1.setForeground(Color.WHITE);
		button1.setFont(new Font("黑体", Font.BOLD, 18));
		frame.getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				if(i==1){
					new UserFunction();
				}
				if(i==2){
					new AdmnFunction();
				}
			}
		});
		
		JButton button2=new RButton("退卡");
		button2.setBounds(F_2-149,386,133,41);
		button2.setFont(new Font("黑体",Font.BOLD,18));
		frame.getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(".\\3.jpg"));
		label_1.setBounds(0, -16, 689, 541);
		frame.getContentPane().add(label_1);
		
		frame.setVisible(true);
}
	}

