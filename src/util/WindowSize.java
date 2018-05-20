package util;
/**
 * 用户登录窗口JFrame大小常量定义
 * 用户登录窗口JPanel大小常量定义（同背景图大小）
 * @author Lanny
 */
public interface WindowSize {
	/*
	 *(JFrame).setBounds(F_0,F_1,F_2,F_3);
	 *(JPanel).setBounds(P_0,P_1,P_2,P_3);
	 *     (JLable).setBounds(P_0,P_1,P_2,P_3);
	 */
	//F_x为JFrame为大小参数
	final int F_0=100; 
	final int F_1=100;
	final int F_2=686;
	final int F_3=529;
	//P_x为JPanel大小参数
	final int P_0=0;
	final int P_1=0;
	final int P_2=680;
	final int P_3=499;
	
	/**
	 * Example
	 */
	/*
	 * class Panel2 extends JPanel implements WindowSize{
		public Panel2() {
			this.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(".\\1.jpg"));
			lblNewLabel.setBounds(P_0, P_1, P_2, P_3);
			add(lblNewLabel);
			
		}
	 */
}
