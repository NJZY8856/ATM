package controller.card;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import login.StartScreen;
import login.UserFunction;
import util.RButton;
import util.WindowSize;
import javax.swing.SwingConstants;

/**
 * 显示成功 或警告 或提示等panel界面
 * @author LiangShuilian
 *
 */
public class ConfirmPanel extends JPanel implements WindowSize {
	private JFrame frame;
	private JLabel label_warn;
	private JButton button_1;
	private JButton button_2;
	
	public  ConfirmPanel(JFrame frame,String str,Color color) {
		this.frame=frame;
		this.setLayout(null);
		this.setBounds(P_0, P_1, P_2, P_3);

		label_warn = new JLabel(str);				//提示/警告等
		label_warn.setHorizontalAlignment(SwingConstants.CENTER);
		label_warn.setFont(new Font("黑体", Font.BOLD, 26));
		label_warn.setForeground(color);
		label_warn.setBounds(66, 139, 517, 122);
		this.add(label_warn);
		
		button_1 = new RButton("返回");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0, 387, 133, 41);
		button_1.setVisible(true);
		this.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new UserFunction();
			}
		});
		
		button_2 = new RButton("退卡");
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		button_2.setBounds(547, 387, 133, 41);
		button_2.setVisible(true);
		this.add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new StartScreen();
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\4.jpg"));
		lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
		this.add(lblNewLabel);
	}
}
