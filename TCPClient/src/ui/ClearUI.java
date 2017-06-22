package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.ReturnResult;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClearUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField keyText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClearUI frame = new ClearUI();
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
	public ClearUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u6E05\u7A7A\u5BC6\u7801\uFF1A");
		label.setBounds(41, 70, 155, 21);
		contentPane.add(label);
		
		keyText = new JPasswordField();
		keyText.setBounds(180, 67, 137, 27);
		contentPane.add(keyText);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int key = Integer.parseInt(keyText.getText());
					if(key == Operator.clearKey)
					{
						String choice = "清空";
						Operator operator = new Operator();
						ReturnResult res = operator.Clear();
						if(res.judge.equals("success"))
						{
							System.out.println("清空成功！");
							Success success = new Success(choice);
							success.setVisible(true);
							ClearUI.this.dispose();
						}
						else
						{
							System.out.println("清空失败！");
							Error error = new Error();
							error.setVisible(true);
							ClearUI.this.dispose();
						}
					}
					else
					{
						System.out.println("您没有权限执行此操作！");
						Error error = new Error();
						error.setVisible(true);
						ClearUI.this.dispose();
					}
				}catch (Exception f){
					Error error = new Error();
					error.setVisible(true);
					ClearUI.this.dispose();
				}
				
			}
		});
		button.setBounds(277, 166, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				ClearUI.this.dispose();
			}
		});
		button_1.setBounds(41, 166, 123, 29);
		contentPane.add(button_1);
	}
}
