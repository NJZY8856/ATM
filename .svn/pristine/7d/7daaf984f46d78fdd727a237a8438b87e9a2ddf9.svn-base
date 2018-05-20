package controller.card;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.StartScreen;
import login.UserFunction;
import model.CardModel;
import service.CardService;
import service.TradService;
import util.CurrentCardInfo;
import util.RButton;
import util.WindowSize;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
/**
 * 用户 查询 余额
 * @author LiangShuilian
 */
public class CheckMoney implements WindowSize {

	private JFrame frame;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckMoney window = new CheckMoney();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public CheckMoney() {
		initialize();
	}

	private void initialize() {
		//获取数据
		CardService cardService = new CardService();
		CurrentCardInfo cardInfo = new CurrentCardInfo();
		CardModel card = new CardModel();
		TradService tradService = new TradService();
		double today_trad_money = 0.0;//当日已经取款金额
		double today_get_money = 0.0;//当日可取款金额
		card = cardService.getCardModel(cardInfo.getCardInfo().getCard_id());
		today_trad_money = tradService.getTodayTrad(cardInfo.getCardInfo().getCard_id().trim(),2);
		today_get_money = cardInfo.maxGetMoney - today_trad_money;
		
		BigDecimal money = new BigDecimal(card.getMoneys()).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数
		BigDecimal line = new BigDecimal(card.getCredit_line()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("账户余额：");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("黑体", Font.BOLD, 18));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(190,190, 120, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(String.valueOf(money)+" 元");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("黑体", Font.BOLD, 18));
		label_1.setBounds(330, 190, 120, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("可透支额度：");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("黑体", Font.BOLD, 18));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(190, 250, 120, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(String.valueOf(line)+" 元");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("黑体", Font.BOLD, 18));
		label_3.setBounds(330, 250, 120, 30);
		frame.getContentPane().add(label_3);
		
		
//当日可取款金额		
		JLabel label_4 = new JLabel("当日可取款金额：");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("黑体", Font.BOLD, 18));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(143, 310, 167, 30);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(Double.toString(today_get_money)+" 元");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("黑体", Font.BOLD, 18));
		label_5.setBounds(330, 310, 120, 30);
		frame.getContentPane().add(label_5);

		JButton button_1 = new RButton("返回");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0, 387, 133, 41);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new UserFunction();
			}
		});
		
		JButton button_2 = new RButton("退卡");
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		button_2.setBounds(547, 387, 133, 41);
		frame.getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new StartScreen();
			}
		});
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon(".\\2.jpg"));
		lblBackground.setBounds(P_0, P_1, P_2, P_3);
		frame.getContentPane().add(lblBackground);

		frame.setResizable(false);
		frame.setVisible(true);
	}
}
