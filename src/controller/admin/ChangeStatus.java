package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import util.RButton;
import util.WindowSize;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.AdminDao;
import login.AdmnFunction;
import login.UserFunction;
import model.MoreInfo;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChangeStatus implements WindowSize{

	private JFrame frame;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeStatus window = new ChangeStatus(null, null, 0);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ChangeStatus(String card_id,String user_id,int i) {
		initialize(card_id,user_id,i);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(String card_id,String user_id,int i) {	
		System.out.println("ccc"+i);
		List list=new AdminDao().selectUserInfo(card_id,user_id);
		MoreInfo moreInfo=(MoreInfo) list.get(list.size()-1);
		String str[] = new String[6];
		str[0]=moreInfo.getId();
		str[1]=moreInfo.getName();
		str[2]=moreInfo.getCard_id();
		str[3]=String.valueOf(moreInfo.getMoneys());
		str[4]=String.valueOf(moreInfo.getType());
		str[5]=String.valueOf(moreInfo.getStatus());

	frame = new JFrame();
	frame.setBounds(F_0, F_1, F_2, F_3);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel label1 = new JLabel("请核实信息:");
	label1.setFont(new Font("黑体", Font.BOLD, 18));
	label1.setForeground(Color.white);
	label1.setBounds(30,90,150,35);
	frame.getContentPane().add(label1);
	label1.setVisible(false);
	
	JLabel label = new JLabel("卡号：");
	label.setFont(new Font("黑体", Font.BOLD, 18));
	label.setForeground(Color.white);
	label.setBounds(61, 145, 57, 35);
	frame.getContentPane().add(label);
	
	JLabel lblNewLabel = new JLabel(str[2]);
	lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
	lblNewLabel.setForeground(Color.white);
	lblNewLabel.setBounds(133, 145, 200, 35);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel label_3 = new JLabel("姓名：");
	label_3.setFont(new Font("黑体", Font.BOLD, 18));
	label_3.setForeground(Color.white);
	label_3.setBounds(61, 217, 57, 35);
	frame.getContentPane().add(label_3);
	
	JLabel label_2 = new JLabel(str[1]);
	label_2.setFont(new Font("黑体", Font.BOLD, 18));
	label_2.setForeground(Color.white);
	label_2.setBounds(133, 217, 200, 35);
	frame.getContentPane().add(label_2);
	
	JLabel label_1 = new JLabel("身份证号：");
	label_1.setFont(new Font("黑体", Font.BOLD, 18));
	label_1.setForeground(Color.white);
	label_1.setBounds(20, 290, 98, 35);
	frame.getContentPane().add(label_1);
	
	JLabel label_6 = new JLabel(str[0]);
	label_6.setFont(new Font("黑体", Font.BOLD, 18));
	label_6.setForeground(Color.white);
	label_6.setBounds(133, 290, 200, 35);
	frame.getContentPane().add(label_6);
	
	JLabel label_5 = new JLabel("余额：");
	label_5.setFont(new Font("黑体", Font.BOLD, 18));
	label_5.setForeground(Color.white);
	label_5.setBounds(385, 145, 57, 35);
	frame.getContentPane().add(label_5);
	
	JLabel label_4 = new JLabel(str[3]);
	label_4.setFont(new Font("黑体", Font.BOLD, 18));
	label_4.setForeground(Color.white);
	label_4.setBounds(452, 145, 172, 35);
	frame.getContentPane().add(label_4);
	
	JLabel label_7 = new JLabel("类型：");
	label_7.setFont(new Font("黑体", Font.BOLD, 18));
	label_7.setForeground(Color.white);
	label_7.setBounds(385, 217, 57, 35);
	frame.getContentPane().add(label_7);
	
	JLabel label_8 ;
	if(str[4].equals("1")){
		label_8 = new JLabel("信用卡");

	}else{
		label_8 = new JLabel("储蓄卡");
	}
	label_8.setFont(new Font("黑体", Font.BOLD, 18));
	label_8.setForeground(Color.white);
	label_8.setBounds(452, 217, 172, 35);
	frame.getContentPane().add(label_8);
	
	JLabel label_9 = new JLabel("状态：");
	label_9.setFont(new Font("黑体", Font.BOLD, 18));
	label_9.setForeground(Color.white);
	label_9.setBounds(385, 290, 57, 35);
	frame.getContentPane().add(label_9);
	
	String [] status= {"正常","挂失","冻结","销户"};
	int curr_index=Integer.parseInt(str[5])-1;
	JComboBox comboBox = new JComboBox(status);
	comboBox.setSelectedItem(status[curr_index]);
	comboBox.setFont(new Font("黑体", Font.BOLD, 18));
//	comboBox.setForeground(Color.white);
	comboBox.setBounds(451, 290, 74, 35);
	frame.getContentPane().add(comboBox);
	System.out.println("fjj");
	JButton button = new RButton("确定");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(i==1){
				if(status[curr_index]=="销户"){
					JOptionPane.showMessageDialog(frame.getContentPane(), "当前账户已被销户，不能进行其它操作", "系统信息", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					if(comboBox.getSelectedItem()==status[curr_index]){
						JOptionPane.showMessageDialog(frame.getContentPane(), "当前状态已是"+status[curr_index]+"状态", "系统信息", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						if(comboBox.getSelectedItem()=="正常"){
							new AdminDao().updateStatus(card_id, 1);
						}
						if(comboBox.getSelectedItem()=="挂失"){
							new AdminDao().updateStatus(card_id, 2);
						}
						if(comboBox.getSelectedItem()=="冻结"){
							new AdminDao().updateStatus(card_id, 3);
						}
						if(comboBox.getSelectedItem()=="销户"){
							new AdminDao().updateStatus(card_id, 4);
						}
						JOptionPane.showMessageDialog(frame.getContentPane(), "操作成功", "系统信息", JOptionPane.INFORMATION_MESSAGE);
						new AdmnFunction();
						frame.dispose();
					}
				}
			}
			if(i==2){
				System.out.println(i+"fff");
				//comboBox.disable();
				if(status[curr_index]=="销户"){
					JOptionPane.showMessageDialog(frame.getContentPane(), "当前账户已被销户，不能进行其它操作", "系统信息", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					new ChangeUserPwd(card_id);
					frame.dispose();
				}
			}
		}
	});
	button.setFont(new Font("黑体", Font.BOLD, 18));
	button.setBounds(F_2-149, 375, 133, 41);
	frame.getContentPane().add(button);
	
	JButton button_1 = new RButton("返回");
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new AdmnFunction();
		}
	});
	button_1.setFont(new Font("黑体", Font.BOLD, 18));
	button_1.setBounds(0, 375, 144, 41);
	frame.getContentPane().add(button_1);
	
	if(i==2){
		label1.setVisible(true);
	}
	
	JLabel lblBackground = new JLabel("background");
	lblBackground.setBackground(SystemColor.text);
	lblBackground.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
	lblBackground.setIcon(new ImageIcon(".\\5.jpg"));
	lblBackground.setBounds(0, 0, 670, 501);
	frame.getContentPane().add(lblBackground);
	
	frame.setVisible(true);
	}
	
}
