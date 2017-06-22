package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.ReturnResult;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddUI extends JFrame {

	private JPanel contentPane;
	private JTextField booknameText;
	private JTextField authorText;
	private JTextField priceText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUI frame = new AddUI();
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
	public AddUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入您要增加的图书：");
		label.setBounds(105, 15, 211, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("书名：");
		label_1.setBounds(15, 50, 81, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("作者：");
		label_2.setBounds(15, 95, 81, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("价格：");
		label_3.setBounds(15, 137, 81, 21);
		contentPane.add(label_3);
		
		booknameText = new JTextField();
		booknameText.setBounds(115, 51, 162, 27);
		contentPane.add(booknameText);
		booknameText.setColumns(10);
		
		authorText = new JTextField();
		authorText.setColumns(10);
		authorText.setBounds(115, 92, 162, 27);
		contentPane.add(authorText);
		
		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setBounds(115, 134, 162, 27);
		contentPane.add(priceText);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String choice = "增加";
					String name = booknameText.getText();
					String author = authorText.getText();
					float price = Float.parseFloat(priceText.getText());
					Operator operator = new Operator();
					ReturnResult res = operator.addBook(name, author, price);
					
					if(res.judge.equals("success"))
					{
						Success success = new Success(choice);
						success.setVisible(true);
						AddUI.this.dispose();
					}
					else
					{
						Error error = new Error();
						error.setVisible(true);
						AddUI.this.dispose();
					}
				}catch (Exception e){
					Error error = new Error();
					error.setVisible(true);
					AddUI.this.dispose();
				}
				
			}
		});
		button.setBounds(268, 182, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				AddUI.this.dispose();
			}
		});
		button_1.setBounds(37, 182, 123, 29);
		contentPane.add(button_1);
	}
}
