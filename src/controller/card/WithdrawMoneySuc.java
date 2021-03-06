package controller.card;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.UserFunction;
import login.UserLogin;
import util.CurrentCardInfo;
import util.RButton;
import util.WindowSize;

public class WithdrawMoneySuc implements WindowSize{
		private JFrame frame;
		// 取款成功
		public WithdrawMoneySuc(CurrentCardInfo CurrCard,int curr_withdrawMoney) {
			System.out.println(CurrCard);
			frame=new JFrame("取款成功");
			frame.setLayout(null);
			frame.setBounds(F_0, F_1, F_2, F_3);

			JLabel label3 = new JLabel("取款成功！");
			label3.setForeground(new Color(127, 255, 0));
			label3.setFont(new Font("黑体", Font.BOLD, 25));
			label3.setBounds(269, 200, 153, 35);
			frame.getContentPane().add(label3);
			BigDecimal creditMoney = new BigDecimal(CurrCard.getCardInfo().getCredit_line()).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数 
			JLabel kyed = new JLabel("可透支额度为：" + creditMoney+ "元");
			kyed.setForeground(Color.WHITE); kyed.setFont(new Font("黑体",Font.BOLD, 23)); 
			kyed.setBounds(224, 245, 400, 35); frame.add(kyed);
			BigDecimal restMoney = new BigDecimal(CurrCard.getCardInfo().getMoneys()).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数 
			JLabel label4 = new JLabel("余额为:" + restMoney + "元");
			label4.setForeground(Color.WHITE);
			label4.setFont(new Font("黑体", Font.BOLD, 23));
		    label4.setBounds(255, 283, 265, 35);
			frame.getContentPane().add(label4);

			JButton button9 = new RButton("返回");
			button9.setBounds(0, 380, 133, 41);
			button9.setFont(new Font("黑体", Font.BOLD, 18));
			frame.getContentPane().add(button9);
			button9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new UserFunction();
				}
			});

			JButton button10 = new RButton("退卡");
			button10.setFont(new Font("黑体", Font.BOLD, 18));
			button10.setBounds(F_2-148, 380, 133, 41);
			frame.getContentPane().add(button10);
			button10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					new UserLogin();
				}
			});
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(".\\2.jpg"));
			label_1.setBounds(P_0, P_1, P_2, P_3);
			frame.getContentPane().add(label_1);
			frame.setVisible(true);
		}

}
