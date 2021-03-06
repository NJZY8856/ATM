package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import login.AdmnFunction;
import login.UserFunction;
import model.UserModel;
import service.UserService;
import util.RButton;
import util.WindowSize;
import javax.swing.JTextField;
/**
 * 修改用户信息-----通过卡号
 * @author LiangShuilian
 *
 */
public class UpdateUser implements WindowSize {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_back;
	private JLabel userid;
	private JLabel label_warn;
	
	private JPanel panel;
	
	UserService userSerice = new UserService();
	UserModel updateuser = new UserModel();
	UserModel user = new UserModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser window = new UpdateUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateUser() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		panel = new JPanel();
		panel.setBounds(P_0, P_1, P_2, P_3);
		panel.setLayout(null);
		
		JLabel label = new JLabel("请输入用户身份证号：");
		label.setFont(new Font("黑体", Font.BOLD, 16));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(19, 116, 212, 26);
		panel.add(label);
		
		id = new JTextField();
		id.setBounds(241, 113, 212, 34);
		panel.add(id);
		id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp=e.getKeyChar();//0-9:48-57   X：88  x：120
				if(temp>57 && temp < 88){
					e.consume();
				}else if(temp < 120 && temp > 88){  
					e.consume();  
				}else if(temp < 48 || temp > 120){  
					e.consume();  
				} 
			}
		});
		id.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("宋体", Font.BOLD, 15));
		label_1.setBounds(201, 171, 172, 26);
		panel.add(label_1);

		JLabel label_2 = new JLabel("身份证号：");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(201, 207, 83, 15);
		label_2.setVisible(false);
		panel.add(label_2);
		
		userid = new JLabel("");
		userid.setForeground(Color.WHITE);
		userid.setBounds(303, 207, 150, 30);
		panel.add(userid);
		
		JLabel label_4 = new JLabel("姓名：");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(201, 253, 83, 15);
		label_4.setVisible(false);
		panel.add(label_4);
		
		name = new JTextField();
		name.setBounds(303, 250, 150, 30);
		name.setVisible(false);
		panel.add(name);
		name.setColumns(10);
		
		JLabel label_5 = new JLabel("联系电话：");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(201, 303, 83, 15);
		label_5.setVisible(false);
		panel.add(label_5);
		
		phone = new JTextField();
		phone.setBounds(303, 300, 150, 30);
		phone.setVisible(false);
		panel.add(phone);
		phone.setColumns(10);
		
		JLabel label_6 = new JLabel("地址：");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(230, 350, 54, 15);
		label_6.setVisible(false);
		panel.add(label_6);
		
		address = new JTextField();
		address.setBounds(303, 347, 150, 30);
		address.setVisible(false);
		panel.add(address);
		address.setColumns(10);

		button = new RButton("查询");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(502, 115, 115, 32);
		panel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(id.getText().trim().equals(""))
					label_1.setText("身份证号不能为空");
				else if(!id.getText().trim().matches("\\d{17}[0-9xX]|\\d{15}")){
					label_1.setText("身份证号输入不规范");
				} else {
					user = userSerice.getUserModel(id.getText().trim());
					if(user != null){
						label_1.setText("查询结果如下:");
						userid.setText(user.getId());label_2.setVisible(true);
						label_4.setVisible(true);name.setVisible(true);name.setText(user.getName());
						label_5.setVisible(true);phone.setVisible(true);phone.setText(user.getPhone());
						label_6.setVisible(true);address.setVisible(true);address.setText(user.getAddress());
						button_2.setVisible(true);
					} else {
						label_1.setText("该身份证号不存在");
					}
				}
			}
		});

		button_1 = new RButton("返回");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0, 385, 133, 41);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AdmnFunction();
			}
		});
		
		button_2 = new RButton("保存");
		button_2.setBounds(538, 387, 133, 41);
		button_2.setVisible(false);
		panel.add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int value = -1;
				int rel = 0;
				value = JOptionPane.showConfirmDialog(null,"确认保存？","",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(value == 0){
					updateuser.setId(userid.getText().trim());
					updateuser.setName(name.getText().trim());
					updateuser.setPhone(phone.getText().trim());
					updateuser.setAddress(address.getText().trim());
					if(userSerice.updateUser(updateuser)){
						rel = 1;//跳转成功页面
						System.out.println("已保存");
					}
					else rel = 3;
				}
				if(rel == 1){
					panel.setVisible(false);
					label_warn.setText("用户信息保存成功");
					label_warn.setVisible(true);
					button_back.setVisible(true);
				}else if(rel == 3){
					panel.setVisible(false);
					label_warn.setText("用户信息保存失败");
					label_warn.setForeground(Color.red);
					label_warn.setVisible(true);
					button_back.setVisible(true);
				}
			}
		});
		
		
		////// 成功界面 按钮----start--------------------------
		
		label_warn = new JLabel("创建成功");				//提示/警告等
		label_warn.setHorizontalAlignment(SwingConstants.CENTER);
		label_warn.setFont(new Font("黑体", Font.BOLD, 26));
		label_warn.setForeground(Color.green);
		label_warn.setVisible(false);
		label_warn.setBounds(67, 180, 517, 56);
		frame.getContentPane().add(label_warn);
		
		button_back = new RButton("返回菜单");
		button_back.setFont(new Font("黑体", Font.BOLD, 18));
		button_back.setBounds(0, 362, 123, 39);
		button_back.setVisible(false);
		frame.getContentPane().add(button_back);
		button_back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					new AdmnFunction();
			}
		});
		
		////// ----------------ending--------------------------
		
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
