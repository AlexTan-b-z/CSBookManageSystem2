package ui;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.Book;
import model.User;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;


public class MenuUI extends JFrame {

	private JPanel contentPane;
	public static int choice;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
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
	public MenuUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("欢迎...");
		label.setBounds(145, 0, 81, 21);
		contentPane.add(label);
		
		JButton addButton = new JButton("增加图书");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUI addui = new AddUI();
				addui.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		addButton.setBounds(30, 36, 123, 29);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("删除图书");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUI delete = new DeleteUI();
				delete.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		deleteButton.setBounds(240, 36, 123, 29);
		contentPane.add(deleteButton);
		
		JButton button_1 = new JButton("修改图书");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeUI change = new ChangeUI();
				change.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_1.setBounds(30, 80, 123, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("查询图书");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindmenuUI findmenu = new FindmenuUI("");
				findmenu.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_2.setBounds(240, 80, 123, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("清空图书");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearUI clear = new ClearUI();
				clear.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_3.setBounds(30, 124, 123, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("退出系统");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operator operate = new Operator();
				operate.Exit();
				//LoginUI login = new LoginUI();
				//login.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_4.setBounds(240, 212, 123, 29);
		contentPane.add(button_4);
		
		JButton button = new JButton("\u6DFB\u52A0\u8BFB\u8005");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserUI user = new AddUserUI();
				user.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button.setBounds(240, 124, 123, 29);
		contentPane.add(button);
		
		JButton button_5 = new JButton("\u62C9\u9ED1\u8BFB\u8005");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operator operator = new Operator();
				int status = 0;
				ArrayList<User> user = operator.printUser(status);
				DeleteUserUI dlui = new  DeleteUserUI(user);
				dlui.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_5.setBounds(30, 168, 123, 29);
		contentPane.add(button_5);
		
		JFrame frame = new JFrame("请输入超级管理员密钥");
		frame.getContentPane().setLayout(null);
		frame.setBounds(10, 10, 350, 200);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u8D85\u7EA7\u7BA1\u7406\u5458\u5BC6\u94A5\uFF1A");
		label_1.setBounds(5, 20, 198, 21);
		frame.getContentPane().add(label_1);
		
		
		JButton button_6 = new JButton("\u7BA1\u7406\u5458\u7BA1\u7406");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(true);
			}
		});
		
		button_6.setBounds(240, 168, 123, 29);
		contentPane.add(button_6);
		
		JButton button_8 = new JButton("\u6240\u6709\u56FE\u4E66");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operate = new Operator();
				int isout = 0;
				ArrayList<Book> books = operate.printBook(isout+"");
				AllBookUI menu = new AllBookUI(books);
				menu.setVisible(true);
				MenuUI.this.dispose();
			}
		});
		button_8.setBounds(30, 212, 123, 29);
		contentPane.add(button_8);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
		label_2.setForeground(Color.RED);
		label_2.setBounds(100, 0, 171, 21);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(145, 20, 165, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(8);
		
		JButton button_7 = new JButton("\u63D0\u4EA4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = textField.getText();
				if(key.equals(Operator.clearKey+"")){
					frame.dispose();
					Operator operator = new Operator();
					int Status = 1;
					ArrayList<User> user = operator.printUser(Status);
					AdminUI admin = new AdminUI(user);
					admin.setVisible(true);
					MenuUI.this.dispose();
				}else{
					label_2.setText("密钥错误，访问拒绝");
				}
			}
		});
		button_7.setBounds(180, 100, 123, 29);
		frame.getContentPane().add(button_7);
		
		
		
	}
}
