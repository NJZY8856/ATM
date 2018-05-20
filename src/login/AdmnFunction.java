package login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.admin.ACheckCardTrad;
import controller.admin.AdminOpenAccount;
import controller.admin.ChangeAdminPwd;
import controller.admin.CheckUser;
import controller.admin.CreateAdmin;
import controller.admin.SelectUser;
import controller.admin.UpdateUser;
import util.RButton;
import util.WindowSize;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdmnFunction implements WindowSize{

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmnFunction window = new AdmnFunction();
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
	public AdmnFunction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("管理员后台管理");
		frame.setBounds(F_0,F_1,F_2,F_3);
		
		panel = new JPanel();
		panel.setBounds(P_0, P_1, P_2, P_3);
		panel.setLayout(null);
		
		JButton btnNewButton = new RButton("开户");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new AdminOpenAccount();
			}
		});
		btnNewButton.setBounds(0, 147, 156, 38);
		panel.add(btnNewButton);
		
		frame.getContentPane().add(panel);
		
		JButton button = new RButton("销户");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectUser(1);
			}
		});
		button.setBounds(0, 210, 156, 35);
		panel.add(button);
		
		JButton button_1 = new RButton("查询用户信息");
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CheckUser();
			}
		});
		button_1.setBounds(0, 273, 156, 38);
		panel.add(button_1);
		
		JButton button_2 = new RButton("修改用户信息");
		button_2.setFont(new Font("黑体", Font.BOLD, 18));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UpdateUser();
			}
		});
		button_2.setBounds(0, 336, 156, 38);
		panel.add(button_2);
		
		JButton button_3 = new RButton("挂失/解除挂失");
		button_3.setFont(new Font("黑体", Font.BOLD, 17));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//挂失
				frame.dispose();
				new SelectUser(1);
				//解除挂失
				/*frame.dispose();
				new ReportLoss(3);*/
			}
		});
		button_3.setBounds(524, 208, 156, 38);
		panel.add(button_3);
		
		JButton button_4 = new RButton("冻结/解冻");
		button_4.setFont(new Font("黑体", Font.BOLD, 18));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectUser(1);
			}
		});
		button_4.setBounds(524, 273, 156, 38);
		panel.add(button_4);
		
		JButton button_5 = new RButton("明细查询");
		button_5.setFont(new Font("黑体", Font.BOLD, 18));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ACheckCardTrad();
			}
		});
		button_5.setBounds(524, 336, 156, 38);
		panel.add(button_5);
		
		JButton button_6 = new RButton("修改密码");
		button_6.setFont(new Font("黑体", Font.BOLD, 18));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ChangeAdminPwd();
			}
		});
		button_6.setBounds(524, 394, 156, 38);
		panel.add(button_6);
		
		JButton button_7 = new RButton("创建管理员");
		button_7.setFont(new Font("黑体", Font.BOLD, 18));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CreateAdmin();
			}
		});
		button_7.setBounds(524, 147, 156, 38);
		panel.add(button_7);
		
		JButton button_8 = new RButton("用户改密");
		button_8.setFont(new Font("黑体", Font.BOLD, 18));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectUser(2);
			}
		});
		button_8.setBounds(0, 396, 156, 35);
		panel.add(button_8);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setBounds(0, 0, 680, 499);
		lblBackground.setIcon(new ImageIcon(".\\2.jpg"));
		panel.add(lblBackground);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
