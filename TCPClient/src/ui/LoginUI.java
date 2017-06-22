package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.Book;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField pwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		String msg = "";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(59, 0, 300, 43);
		contentPane.add(label);
		
		usernameField = new JTextField();
		usernameField.setBounds(183, 58, 153, 27);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		label_1.setBounds(47, 61, 135, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_2.setBounds(47, 97, 135, 21);
		contentPane.add(label_2);
		
		pwdField = new JTextField();
		pwdField.setBounds(183, 94, 153, 27);
		contentPane.add(pwdField);
		pwdField.setColumns(10);
		
		JLabel label_3 = new JLabel(msg);
		label_3.setForeground(Color.RED);
		label_3.setFont(label_3.getFont().deriveFont(label_3.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		label_3.setBackground(Color.RED);
		label_3.setBounds(59, 146, 277, 21);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u8BFB\u8005\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameField.getText();
				String password = pwdField.getText();
				int status = 0;
				if(username.equals("") || password.equals("")){
					label_3.setText("请填写用户名和密码");
				}else{
					String isS = login(username,password,status);
					label_3.setText(isS);
					if(isS.equals("登陆成功")){
						Operator operate = new Operator();
						int isout = 0;
						ArrayList<Book> books = operate.printBook(isout+"");
						ReaderUI menu = new ReaderUI(books,username);
						menu.setVisible(true);
						LoginUI.this.dispose();
					}
				}
			}
		});
		button.setBounds(47, 200, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7BA1\u7406\u5458\u767B\u9646");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = pwdField.getText();
				int status = 1;
				if(username.equals("") || password.equals("")){
					label_3.setText("请填写用户名和密码");
				}else{
					String isS = login(username,password,status);
					label_3.setText(isS);
					if(isS.equals("登陆成功")){
						MenuUI menu = new MenuUI();
						menu.setVisible(true);
						LoginUI.this.dispose();
					}
				}
			}
		});
		button_1.setBounds(236, 200, 123, 29);
		contentPane.add(button_1);
	}
	
	public String login(String username,String password,int status){
		String rs;
		Operator operate = new Operator();
		boolean isSuccess = operate.login(username, password, status);
		if(isSuccess){
			rs = "登陆成功";
		}else{
			rs = "登陆失败，用户名或密码错误";
		}
		return rs;
	}
}
