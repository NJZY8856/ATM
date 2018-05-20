package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import util.RButton;
import util.WindowSize;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen implements WindowSize{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
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
	public StartScreen() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(F_0, F_1, F_2, F_3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(78, 67, 233, -52);
		frame.getContentPane().add(tabbedPane);
		
		JButton btnNewButton = new RButton("用户登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserLogin();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton.setBounds(381, 305, 140, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new RButton("管理员登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new AdmnLogin();
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(171, 305, 140, 36);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(".\\1.jpg"));
		label_1.setBounds(P_0, P_1, P_2, P_3);
		frame.getContentPane().add(label_1);
		
		frame.setVisible(true);
	}
}
