package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import login.AdmnFunction;
import login.UserFunction;
import model.CardModel;
import model.UserModel;
import service.CardService;
import service.UserService;
import util.RButton;
import util.WindowSize;
import javax.swing.JTextField;
/**
 * 查询用户信息 ---通过银行卡号查询
 * @author LiangShuilian
 *
 */
public class CheckUser implements WindowSize {

	private JFrame frame;
	private JTextField get_card_id;
	
	private JLabel id;
	private JLabel name;
	private JLabel phone;
	private JLabel address;
	
	private JButton button;
	private JButton button_1;
	
	private JLabel card_id;
	private JLabel bank_code;
	private JLabel moneys;
	private JLabel credit_line;
	private JLabel type;
	private JLabel status;
	private JLabel open_date;
	
	private JLabel label;
	private JLabel label_tip;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	
	private JPanel panel;
	
	UserService userSerice = new UserService();
	UserModel user = new UserModel();
	
	CardService cardSerice = new CardService();
	CardModel card = new CardModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUser window = new CheckUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CheckUser() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		panel = new JPanel();
		panel.setBounds(P_0, P_1, P_2, P_3);
		panel.setLayout(null);
		
		label = new JLabel("请输入用户银行卡号：");
		label.setFont(new Font("黑体", Font.BOLD, 16));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(43, 73, 190, 26);
		panel.add(label);
		
		get_card_id = new JTextField();
		get_card_id.setBounds(243, 70, 212, 34);
		panel.add(get_card_id);
		get_card_id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp=e.getKeyChar();
				if(temp>57){
					e.consume();
				}else if(temp < 48){  
					e.consume();  
				} 
			}
		});
		get_card_id.setColumns(10);
		
		label_tip = new JLabel("");
		label_tip.setForeground(Color.WHITE);
		label_tip.setFont(new Font("黑体", Font.BOLD, 16));
		label_tip.setBounds(214, 114, 172, 26);
		panel.add(label_tip);

		label1 = new JLabel("身份证号：");
		label1.setFont(new Font("黑体", Font.BOLD, 15));
		label1.setForeground(Color.WHITE);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setBounds(76, 163, 83, 15);
		label1.setVisible(false);
		panel.add(label1);
		
		id = new JLabel("");
		id.setFont(new Font("黑体", Font.BOLD, 15));
		id.setForeground(Color.WHITE);
		id.setBounds(161, 152, 180, 30);
		panel.add(id);
		
		label2 = new JLabel("姓名：");
		label2.setFont(new Font("黑体", Font.BOLD, 15));
		label2.setForeground(Color.WHITE);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setBounds(76, 213, 83, 15);
		label2.setVisible(false);
		panel.add(label2);
		
		name = new JLabel("");
		name.setFont(new Font("黑体", Font.BOLD, 15));
		name.setBounds(161, 202, 150, 30);
		name.setForeground(Color.WHITE);
		panel.add(name);
		
		label3 = new JLabel("联系电话：");
		label3.setFont(new Font("黑体", Font.BOLD, 15));
		label3.setForeground(Color.WHITE);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		label3.setBounds(76, 263, 83, 15);
		label3.setVisible(false);
		panel.add(label3);
		
		phone = new JLabel("");
		phone.setFont(new Font("黑体", Font.BOLD, 15));
		phone.setBounds(161, 252, 150, 30);
		phone.setForeground(Color.WHITE);
		panel.add(phone);
		
		label4 = new JLabel("地址：");
		label4.setFont(new Font("黑体", Font.BOLD, 15));
		label4.setForeground(Color.WHITE);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		label4.setBounds(76, 310, 83, 15);
		label4.setVisible(false);
		panel.add(label4);
		
		address = new JLabel("");
		address.setFont(new Font("黑体", Font.BOLD, 15));
		address.setBounds(161, 299, 150, 30);
		address.setForeground(Color.WHITE);
		panel.add(address);
		
		
		label5 = new JLabel("银行卡号：");
		label5.setFont(new Font("黑体", Font.BOLD, 15));
		label5.setForeground(Color.WHITE);
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		label5.setBounds(351, 163, 83, 15);
		label5.setVisible(false);
		panel.add(label5);
		
		card_id = new JLabel("");
		card_id.setFont(new Font("黑体", Font.BOLD, 15));
		card_id.setForeground(Color.WHITE);
		card_id.setBounds(444, 158, 190, 30);
		panel.add(card_id);
		
		label6 = new JLabel("银行编号：");
		label6.setFont(new Font("黑体", Font.BOLD, 15));
		label6.setForeground(Color.WHITE);
		label6.setHorizontalAlignment(SwingConstants.RIGHT);
		label6.setBounds(351, 201, 83, 15);
		label6.setVisible(false);
		panel.add(label6);
		
		bank_code = new JLabel("");
		bank_code.setFont(new Font("黑体", Font.BOLD, 15));
		bank_code.setBounds(444, 196, 150, 30);
		bank_code.setForeground(Color.WHITE);
		panel.add(bank_code);
		
		label7 = new JLabel("余额：");
		label7.setFont(new Font("黑体", Font.BOLD, 15));
		label7.setForeground(Color.WHITE);
		label7.setHorizontalAlignment(SwingConstants.RIGHT);
		label7.setBounds(351, 239, 83, 15);
		label7.setVisible(false);
		panel.add(label7);
		
		moneys = new JLabel("");
		moneys.setFont(new Font("黑体", Font.BOLD, 15));
		moneys.setBounds(444, 234, 160, 30);
		moneys.setForeground(Color.WHITE);
		panel.add(moneys);
		
		label8 = new JLabel("类型：");
		label8.setFont(new Font("黑体", Font.BOLD, 15));
		label8.setForeground(Color.WHITE);
		label8.setHorizontalAlignment(SwingConstants.RIGHT);
		label8.setBounds(351, 276, 83, 15);
		label8.setVisible(false);
		panel.add(label8);
		
		type = new JLabel("");
		type.setFont(new Font("黑体", Font.BOLD, 15));
		type.setBounds(444, 271, 150, 30);
		type.setForeground(Color.WHITE);
		panel.add(type);
		
		label9 = new JLabel("透支额度：");
		label9.setFont(new Font("黑体", Font.BOLD, 15));
		label9.setForeground(Color.WHITE);
		label9.setHorizontalAlignment(SwingConstants.RIGHT);
		label9.setBounds(351, 304, 83, 15);
		label9.setVisible(false);
		panel.add(label9);
		
		credit_line = new JLabel("");
		credit_line.setFont(new Font("黑体", Font.BOLD, 15));
		credit_line.setBounds(444, 299, 150, 30);
		credit_line.setForeground(Color.WHITE);
		panel.add(credit_line);
		
		label10 = new JLabel("状态：");
		label10.setFont(new Font("黑体", Font.BOLD, 15));
		label10.setForeground(Color.WHITE);
		label10.setHorizontalAlignment(SwingConstants.RIGHT);
		label10.setBounds(351, 337, 83, 15);
		label10.setVisible(false);
		panel.add(label10);
		
		status = new JLabel("");
		status.setFont(new Font("黑体", Font.BOLD, 15));
		status.setBounds(444, 332, 150, 30);
		status.setForeground(Color.WHITE);
		panel.add(status);
		
		label11 = new JLabel("开卡时间：");
		label11.setFont(new Font("黑体", Font.BOLD, 15));
		label11.setForeground(Color.WHITE);
		label11.setHorizontalAlignment(SwingConstants.RIGHT);
		label11.setBounds(351, 368, 83, 15);
		label11.setVisible(false);
		panel.add(label11);
		
		open_date = new JLabel("");
		open_date.setFont(new Font("黑体", Font.BOLD, 15));
		open_date.setBounds(444, 363, 150, 30);
		open_date.setForeground(Color.WHITE);
		panel.add(open_date);

		button = new RButton("查询");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(491, 72, 113, 32);
		panel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(get_card_id.getText().trim().equals(""))
					label_tip.setText("银行卡号不能为空");
				else if(!get_card_id.getText().trim().matches("[0-9]{19}")){
					label_tip.setText("银行卡号输入不规范");
				} else {
					String getType = null;
					String getStatus = null;
					
					label_tip.setText("查询结果如下:");
					card = cardSerice.getCardModel(get_card_id.getText().trim());
					if(card != null){
						user = userSerice.getUserModel(card.getId().trim());
						if(user != null){
							BigDecimal money = new BigDecimal(card.getMoneys()).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数
							BigDecimal line = new BigDecimal(card.getCredit_line()).setScale(2, BigDecimal.ROUND_HALF_UP);
							
							label1.setVisible(true);id.setText(user.getId());
							label2.setVisible(true);name.setText(user.getName());
							label3.setVisible(true);phone.setText(user.getPhone());
							label4.setVisible(true);address.setText(user.getAddress());
							label5.setVisible(true);card_id.setText(card.getCard_id());
							label6.setVisible(true);bank_code.setText(card.getBank_code());
							label7.setVisible(true);moneys.setText(String.valueOf(money)+" 元");
							label9.setVisible(true);credit_line.setText(String.valueOf(line)+" 元");
//							label11.setVisible(true);open_date.setText(card.getOpen_date());
							
							getType = String.valueOf(card.getType());
							if(card.getType() == 1) getType = "信用卡";
							else if(card.getType() == 2) getType = "储蓄卡";
							label8.setVisible(true);type.setText(getType);
							
							getStatus = String.valueOf(card.getStatus());
							if(card.getStatus() == 1) getStatus = "正常";
							else if(card.getStatus() == 2) getStatus = "挂失";
							else if(card.getStatus() == 3) getStatus = "冻结";
							else if(card.getStatus() == 4) getStatus = "销户";
							label10.setVisible(true);status.setText(getStatus);
							
						} else {
							label_tip.setText("查询出错");
						}
					} else {
						label_tip.setText("该银行卡号不存在");
					}
				}
			}
		});

		button_1 = new RButton("返回");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0, 389, 133, 41);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AdmnFunction();
			}
		});
		
	//////-------------------------------------------------
			
			JLabel panelBackground = new JLabel("background");
			panelBackground.setBackground(SystemColor.text);
			panelBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
			panelBackground.setIcon(new ImageIcon(".\\5.jpg"));
			panelBackground.setBounds(P_0, P_1, P_2, P_3);
			panel.add(panelBackground);
			
			frame.getContentPane().add(panel);
			
			JLabel lblBackground = new JLabel("background");
			lblBackground.setBackground(SystemColor.text);
			lblBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
			lblBackground.setIcon(new ImageIcon(".\\5.jpg"));
			lblBackground.setBounds(P_0, P_1, P_2, P_3);
			frame.getContentPane().add(lblBackground);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
	}
}
