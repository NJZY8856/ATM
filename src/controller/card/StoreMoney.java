package controller.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import login.UserFunction;
import login.UserLogin;
import model.CardModel;
import service.CardService;
import util.CurrentCardInfo;
import util.MyDocument;
import util.RButton;
import util.WindowSize;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 实现取款金额页面以及金额返回
 * 
 * @author Lanny
 */
public class StoreMoney extends JPanel implements WindowSize {
	private JTextField textField;
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JFrame frame;
	private JLabel lbln = new JLabel("");
	private JLabel lblNewLabel_3=new JLabel("");
	//private JLabel lblNewLabel_4=new JLabel("");
	CardModel card = new CurrentCardInfo().getCardInfo();

	/**
	 * Create the panel.
	 */
	public StoreMoney(JFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setBounds(P_0, P_1, P_2, P_3);

		panel.setBackground(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 680, 447);
		add(panel);
		
	/*	lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setOpaque(false);
		new Thread(new MyThread(lblNewLabel_4,frame)).start();
		panel.add(lblNewLabel_4);*/
		panel.setLayout(null);
		
		JButton btnNewButton = new RButton("确认");
		btnNewButton.setBounds(551, 311, 130, 43);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				double credit_line = card.getCredit_line();
				if (isStoreMoney()==2) {
					double moneys = Double.parseDouble(textField.getText());
					if (credit_line < 2000) {
						BigDecimal credit_line2=BigDecimal.valueOf(credit_line);
						BigDecimal moneys2=BigDecimal.valueOf(moneys);
						BigDecimal sum=moneys2.add(credit_line2);
						BigDecimal sum2=BigDecimal.valueOf(2000).subtract(credit_line2);
						int result=sum.compareTo(BigDecimal.valueOf(2000));
						if (result<0)
							lbln=new JLabel("还款金额为:" + moneys + "元");
						else
							lbln = new JLabel("还款金额为:" + sum2 + "元");
					} else {
						lbln = new JLabel("存款金额为:" + moneys + "元");
					}
					panel1.removeAll();
					storeMoneySuc();
					panel1.setVisible(true);
				/*	panel.remove(lblNewLabel_4);
					frame.remove(lblNewLabel_4);
					lblNewLabel_4 = new JLabel("New label");
					lblNewLabel_4.setOpaque(false);
					new Thread(new MyThread(lblNewLabel_4,frame)).start();
					panel1.add(lblNewLabel_4);*/
					
				} else if(isStoreMoney()==10){
					storeMoneyFail();
					panel2.setVisible(true);
/*					frame.remove(lblNewLabel_4);
					panel.remove(lblNewLabel_4);
					lblNewLabel_4 = new JLabel("New label");
					lblNewLabel_4.setOpaque(false);
					new Thread(new MyThread(lblNewLabel_4,frame)).start();
					panel2.add(lblNewLabel_4);*/
					
				}else{
					storeMoneyFail();
					panel3.setVisible(true);
/*					frame.remove(lblNewLabel_4);
					panel.remove(lblNewLabel_4);
					lblNewLabel_4 = new JLabel("New label");
					lblNewLabel_4.setOpaque(false);
					new Thread(new MyThread(lblNewLabel_4,frame)).start();
					panel3.add(lblNewLabel_4);*/
				}
			}
		});

		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));

		JLabel lblNewLabel_1 = new JLabel("请输入存款金额");
		lblNewLabel_1.setBounds(259, 199, 159, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 21));

		textField = new JTextField();
		textField.setBounds(275, 244, 117, 37);
		textField.setDocument(new MyDocument(5));
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp=e.getKeyChar();
				if(temp>57){
					e.consume();
				}else if(temp < 48){  
                    e.consume();  
                } 
			}
		});
		panel.add(textField);
		textField.setColumns(10);

		JButton button = new RButton("返回");
		button.setBounds(0, 379, 117, 43);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserFunction();
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 18));
		panel.add(button);

		JButton button_1 = new RButton("退卡");
		button_1.setBounds(551, 379, 130, 43);
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserLogin();
			}
		});
		storeMoneyFail2();
		add(panel3);
		
		storeMoneySuc();
		add(panel1);

		storeMoneyFail();
		add(panel2);
		
		
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\2.jpg"));
		lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
		add(lblNewLabel);

	}

	public int isStoreMoney() {
		if (textField.getText().equals("")) {
			return 10;
		}
		double stMoney = Double.parseDouble(textField.getText());
		if (textField.getText().matches("^[1-9]{1,2}[0]{2,4}")) {
			if (stMoney > 10000) {// 输入框必须是100整数且小于10000
				// 放钞失败，切换到窗口：提示放钞失败，请重新放钞/退出
				return 10;
			} else {// 放钞成功后切换页面，显示存款成功
				CardModel card = new CurrentCardInfo().getCardInfo();
				if(new CardService().storeCardMoneys(stMoney, card.getCard_id())){
					return 2;
				}
				return 11;
			}
		} else { // 放钞失败，切换到窗口：提示放钞失败，请重新放钞/退出 }
			return 10;
		}
	}

	/**
	 * 存款成功panel
	 */
	public void storeMoneySuc() {
		panel1.setLayout(null);
		panel1.setBounds(P_0, P_1, P_2, P_3);
		panel1.setOpaque(false);

		JLabel lblNewLabel_2 = new JLabel("存款成功！");
		lblNewLabel_2.setForeground(new Color(127, 255, 0));
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 25));
		lblNewLabel_2.setBounds(269, 200, 153, 35);
		panel1.add(lblNewLabel_2);

		lbln.setForeground(Color.WHITE);
		lbln.setFont(new Font("黑体", Font.BOLD, 23));
		lbln.setBounds(224, 245, 296, 35);
		panel1.add(lbln);
		
		CardModel card = new CurrentCardInfo().getCardInfo();
	BigDecimal cgmoney = new BigDecimal(card.getMoneys()).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数
		JLabel label = new JLabel("余额为:" + cgmoney + "元");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("黑体", Font.BOLD, 23));
		label.setBounds(255, 283, 265, 35);
		panel1.add(label);

		JButton btnNewButton_2 = new RButton("返回");
		btnNewButton_2.setBounds(0, 370, 118, 41);
		panel1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UserFunction();
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.BOLD, 18));

		
		JButton btnNewButton_1 = new RButton("退卡");
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(562, 370, 118, 41);
		panel1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserLogin();
			}
		});
	}

	/**
	 * 存款失败panel
	 */
	public void storeMoneyFail() {
		panel2.setLayout(null);
		panel2.setBounds(P_0, P_1, P_2, P_3);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_3.setBounds(179, 160, 491, 50);
		panel2.add(lblNewLabel_3);
		
		lblNewLabel_3 = new JLabel("存款金额是100元的整数倍且不超过10000元！");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_3.setBounds(150, 160, 491, 50);
		panel2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("存款失败，请重新输入存款金额！");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_1.setBounds(179, 202, 425, 40);
		panel2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("请按确认返回输入存款金额");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_2.setBounds(209, 256, 323, 35);
		panel2.add(lblNewLabel_2);

		JButton button = new RButton("确认");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(0, 371, 118, 40);
		panel2.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel2.setVisible(false);
				panel.setVisible(true);
			//	panel.add(lblNewLabel_4);
			}
		});

		JButton btnNewButton_1 = new RButton("退卡");
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(562, 371, 118, 40);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserLogin();
			}
		});
		panel2.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\2.jpg"));
		lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
		panel2.add(lblNewLabel);
	}
	/**
	 * 存款失败panel2
	 */
	public void storeMoneyFail2() {
		panel3.setLayout(null);
		panel3.setBounds(P_0, P_1, P_2, P_3);

		lblNewLabel_3 = new JLabel("当日存款已超过20000元！");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_3.setBounds(179, 180, 491, 50);
		panel3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("存款失败！");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 23));
		lblNewLabel_1.setBounds(245, 230, 425, 40);
		panel3.add(lblNewLabel_1);
		

		JButton button = new RButton("返回");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(0, 381, 118, 40);
		panel3.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserFunction();
			}
		});

		JButton btnNewButton_1 = new RButton("退卡");
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(562, 381, 118, 40);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserLogin();
			}
		});
		panel3.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\2.jpg"));
		lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
		panel3.add(lblNewLabel);
	}
}
