package controller.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import login.AdmnFunction;
import login.AdmnLogin;
import model.AdminModel;
import model.CardModel;
import model.UserModel;
import service.AdminService;
import service.CardService;
import service.UserService;
import util.CurrentCardInfo;
import util.RButton;
import util.WindowSize;

import java.awt.BorderLayout;
import java.awt.Color;
/**
 * 创建管理员
 * @author LiangShuilian
 *
 */
public class CreateAdmin implements WindowSize{

	private JFrame frame;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_4;
	private JTextField admin_id;
	private JLabel label_6;
	private JPasswordField password;
	private JLabel label_6_2;
	private JPasswordField password2;

	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_warn;
	
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAdmin window = new CreateAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateAdmin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		panel = new JPanel();
		
		panel.setBounds(P_0, P_1, P_2, P_3);
		panel.setLayout(null);
		
		label_4 = new JLabel("新编号：");
		label_4.setFont(new Font("Dialog", Font.BOLD, 18));
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(139, 133, 108, 30);
		panel.add(label_4);
		
		admin_id = new JTextField();
		admin_id.setBounds(276, 133, 156, 30);
		panel.add(admin_id);
		admin_id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int temp = e.getKeyChar();
				if (temp > 57) {
					e.consume();
				} else if (temp < 48) {
					e.consume();
				}
			}
		});
		admin_id.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(287, 160, 181, 30);
		panel.add(label_1);
		
		label_9 = new JLabel("6-12位数字");
		label_9.setFont(new Font("Dialog", Font.BOLD, 18));
		label_9.setForeground(Color.RED);
		label_9.setBounds(442, 133, 133, 30);
		panel.add(label_9);
		
		label_10 = new JLabel("6-12位数字字母");
		label_10.setFont(new Font("Dialog", Font.BOLD, 18));
		label_10.setForeground(Color.RED);
		label_10.setBounds(442, 195, 153, 30);
		panel.add(label_10);
		
		label_6 = new JLabel("密码：");
		label_6.setFont(new Font("Dialog", Font.BOLD, 18));
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(139, 195, 108, 30);
		panel.add(label_6);
		
		password = new JPasswordField();
		password.setBounds(276, 195, 156, 30);
		panel.add(password);
		password.setColumns(10);
		
		label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(287, 235, 181, 30);
		panel.add(label_2);
		
		label_6_2 = new JLabel("确认密码：");
		label_6_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_6_2.setForeground(Color.WHITE);
		label_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6_2.setBounds(124, 261, 123, 30);
		panel.add(label_6_2);
		
		password2 = new JPasswordField();
		password2.setBounds(276, 261, 156, 30);
		panel.add(password2);
		password2.setColumns(10);
		
		button = new RButton("提交");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(557, 362, 123, 39);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminService adminSerice = new AdminService();
				AdminModel admin = new AdminModel();
				AdminModel admin2 = null;
				boolean flag = false;
				int rel = 0;
				if(admin_id.getText().trim().equals("")){
					label_1.setText("编号不能为空");
				} else if(!admin_id.getText().trim().matches("\\d{6,12}"))
					label_1.setText("编号不规范");
				else {
					admin2 =  adminSerice.getAdminModel(admin_id.getText().trim());
					if(admin2 != null)
						label_1.setText("该编号已经存在");
					else{
						admin.setAdmin_id(admin_id.getText().trim());
						flag = true;
					}
				}
				if(flag){
					if(password.getText().trim().equals("")||password2.getText().trim().equals("")){
						label_2.setText("密码不能为空");
					}else if(!password.getText().trim().matches("(\\d|\\w){6,12}")){
						label_2.setText("密码不规范");
					}else if(!password.getText().trim().equals(password2.getText().trim())){
						label_2.setText("确认密码不正确");
					}else {
						int value = -1;
						value = JOptionPane.showConfirmDialog(null,"确认提交信息？","",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(value == 0){
							admin.setAdmin_pw(password.getText().trim());
							if(adminSerice.addAdmin(admin))
								rel = 1;//跳转成功页面
							else rel = 3;
						}else{
							rel = 2;
						}
					}
					
				} 
				if(rel == 1){
					panel.setVisible(false);
					label_warn.setText("新管理员创建成功");
					label_warn.setVisible(true);
					button_2.setVisible(true);
				}else if(rel == 2){
					panel.setVisible(false);
					label_warn.setText("信息已取消保存");
					label_warn.setForeground(Color.red);
					label_warn.setVisible(true);
					button_2.setVisible(true);
				}else if(rel == 3){
					panel.setVisible(false);
					label_warn.setText("新管理员创建失败");
					label_warn.setForeground(Color.red);
					label_warn.setVisible(true);
					button_2.setVisible(true);
				}
			}
		});
		
		button_1 = new RButton("返回");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(0, 362, 123, 39);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					new AdmnFunction();
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
		
		button_2 = new RButton("返回菜单");
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		button_2.setBounds(0, 362, 123, 39);
		button_2.setVisible(false);
		frame.getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					new AdmnFunction();
			}
		});
		
		////// ----------------ending--------------------------
		
		JLabel panelBackground = new JLabel("background");
		panelBackground.setBackground(SystemColor.text);
		panelBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
		panelBackground.setIcon(new ImageIcon(".\\5.jpg"));
		panelBackground.setBounds(0, 0, 696, 501);
		panel.add(panelBackground);
		
		frame.getContentPane().add(panel);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setBackground(SystemColor.text);
		lblBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
		lblBackground.setIcon(new ImageIcon(".\\5.jpg"));
		lblBackground.setBounds(0, 0, 670, 501);
		frame.getContentPane().add(lblBackground);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
