package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.Book;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ChangeUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField origintextField;
	private JTextField newtextField;
	private JTextField againtextField;


	/**
	 * Create the frame.
	 */
	public ChangeUserUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801\uFF1A");
		label.setBounds(27, 50, 126, 21);
		contentPane.add(label);
		
		origintextField = new JTextField();
		origintextField.setBounds(145, 47, 176, 27);
		contentPane.add(origintextField);
		origintextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		label_1.setBounds(27, 86, 126, 21);
		contentPane.add(label_1);
		
		newtextField = new JTextField();
		newtextField.setBounds(145, 83, 176, 27);
		contentPane.add(newtextField);
		newtextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		label_2.setBounds(30, 125, 111, 21);
		contentPane.add(label_2);
		
		againtextField = new JTextField();
		againtextField.setBounds(144, 120, 176, 27);
		contentPane.add(againtextField);
		againtextField.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		label_3.setBounds(103, 14, 191, 21);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operate = new Operator();
				int isout = 0;
				ArrayList<Book> books = operate.printBook(isout+"");
				ReaderUI menu = new ReaderUI(books,username);
				menu.setVisible(true);
				ChangeUserUI.this.dispose();
			}
		});
		button.setBounds(24, 194, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String originpwd = origintextField.getText();
				String newpwd = newtextField.getText();
				String againpwd = againtextField.getText();
				int status = 0;
				if(newpwd.equals(againpwd)){
					Operator operate = new Operator();
					boolean isSuccess = operate.login(username, originpwd, status);
					if(isSuccess){
						boolean isSuccess2 = operate.changeUser(username, againpwd);
						if (isSuccess2){
							label_3.setText("修改成功");
						}
					}else{
						label_3.setText("密码错误");
					}
				}else{
					label_3.setText("两次输入密码不一致");
				}
				
			}
		});
		button_1.setBounds(264, 194, 123, 29);
		contentPane.add(button_1);
	}
}
