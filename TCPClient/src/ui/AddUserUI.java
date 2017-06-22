package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField pwdtextField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddUserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(41, 39, 131, 21);
		contentPane.add(lblNewLabel);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(169, 36, 160, 27);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		label.setBounds(41, 75, 117, 21);
		contentPane.add(label);
		
		pwdtextField = new JTextField();
		pwdtextField.setBounds(169, 75, 160, 27);
		contentPane.add(pwdtextField);
		pwdtextField.setColumns(10);
		
		JLabel msg = new JLabel("");
		msg.setForeground(Color.RED);
		msg.setBounds(105, 0, 211, 21);
		contentPane.add(msg);
		
		JLabel label_1 = new JLabel("\u662F\u5426\u8D4B\u4E88\u7BA1\u7406\u5458\u6743\u9650\uFF1A");
		label_1.setBounds(41, 128, 189, 21);
		contentPane.add(label_1);
		
		JCheckBox yescheckBox = new JCheckBox("\u662F");
		yescheckBox.setBounds(244, 124, 51, 29);
		contentPane.add(yescheckBox);
		
		JCheckBox nocheckBox = new JCheckBox("\u5426");
		nocheckBox.setBounds(299, 124, 51, 29);
		contentPane.add(nocheckBox);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernametextField.getText();
				String password = pwdtextField.getText();
				int status = 0;
				if(username.equals("") || password.equals("")){
					msg.setText("请输入用户名和密码");
				}else{
					if(yescheckBox.isSelected()){
						status = 1;
					}
					Operator operate = new Operator();
					boolean isSuccess = operate.addUser(username, password, status);
					if(isSuccess){
						msg.setText("添加成功");
					}else{
						msg.setText("添加失败");
					}
				}
			}
		});
		button.setBounds(249, 182, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				AddUserUI.this.dispose();
			}
		});
		button_1.setBounds(35, 182, 123, 29);
		contentPane.add(button_1);
		
	}
}
