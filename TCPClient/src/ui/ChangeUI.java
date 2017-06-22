package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.ReturnResult;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeUI extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField changeText;
	private JButton button_1;
	private JLabel label_2;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeUI frame = new ChangeUI();
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
	public ChangeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入您要修改的书的编号：");
		label.setBounds(15, 15, 243, 21);
		contentPane.add(label);
		
		idText = new JTextField();
		idText.setBounds(249, 12, 62, 27);
		contentPane.add(idText);
		idText.setColumns(10);
		
		changeText = new JTextField();
		changeText.setBounds(249, 115, 96, 27);
		contentPane.add(changeText);
		changeText.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String choice = "修改";
				int id = -1;
				String name = "";
				String change = changeText.getText();
				Operator operator = new Operator();
				if(change.equals(""))
				{
					Error error = new Error();
					error.setVisible(true);
					ChangeUI.this.dispose();
				}
				else
				{
					try{
						id = Integer.parseInt(idText.getText());
						System.out.println(id+" "+change);
						ReturnResult res = operator.changeBook(id,name,change);
						if(res.judge.equals("success"))
						{
							System.out.println("修改成功！");
							Success success = new Success(choice);
							success.setVisible(true);
							ChangeUI.this.dispose();
						}
						else
						{
							System.out.println("修改失败！");
							Error error = new Error();
							error.setVisible(true);
							ChangeUI.this.dispose();
						}
					}catch (Exception e){
						name = nameText.getText();
						System.out.println(name+" "+change);
						ReturnResult res = operator.changeBook(id,name,change);
						if(res.judge.equals("success"))
						{
							System.out.println("修改成功！");
							Success success = new Success(choice);
							success.setVisible(true);
							ChangeUI.this.dispose();
						}
						else
						{
							System.out.println("修改失败！");
							Error error = new Error();
							error.setVisible(true);
							ChangeUI.this.dispose();
						}
					}
				}
				
			}
		});
		button.setBounds(279, 200, 123, 29);
		contentPane.add(button);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				ChangeUI.this.dispose();
			}
		});
		button_1.setBounds(15, 200, 123, 29);
		contentPane.add(button_1);
		
		label_2 = new JLabel("\u6216\u4E66\u540D");
		label_2.setBounds(177, 52, 81, 21);
		contentPane.add(label_2);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(249, 49, 62, 27);
		contentPane.add(nameText);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u4FEE\u6539\u4E3A\u4EC0\u4E48\u4E66\u540D\uFF1A");
		label_1.setBounds(15, 118, 266, 21);
		contentPane.add(label_1);
	}
}
