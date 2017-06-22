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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PriceFindUI extends JFrame {

	private JPanel contentPane;
	private JTextField minpriceText;
	private JTextField maxpriceText;

	/**
	 * Create the frame.
	 */
	public PriceFindUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u4EF7\u683C\u533A\u95F4\uFF1A");
		label.setBounds(50, 28, 274, 21);
		contentPane.add(label);
		
		minpriceText = new JTextField();
		minpriceText.setBounds(36, 64, 96, 27);
		contentPane.add(minpriceText);
		minpriceText.setColumns(10);
		
		maxpriceText = new JTextField();
		maxpriceText.setColumns(10);
		maxpriceText.setBounds(217, 64, 96, 27);
		contentPane.add(maxpriceText);
		
		JLabel label_1 = new JLabel("\u81F3");
		label_1.setBounds(160, 67, 81, 21);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = null;
				int id = -1;
				String author = null;
				String dimname = null;
				float minprice = 0;
				float maxprice = -1;
				Operator operator = new Operator();
				try{
					minprice = Float.parseFloat(minpriceText.getText());
					maxprice = Float.parseFloat(maxpriceText.getText());
					ReturnResult res = operator.selectBook(id, name, dimname, author, minprice, maxprice);
					PrintUI menu = new PrintUI(res.result,username);
					menu.setVisible(true);
					PriceFindUI.this.dispose();
				}catch (Exception e){
					Error error = new Error();
					error.setVisible(true);
					PriceFindUI.this.dispose();
				}
			}
		});
		button.setBounds(245, 156, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindmenuUI menu = new FindmenuUI(username);
				menu.setVisible(true);
				PriceFindUI.this.dispose();
			}
		});
		button_1.setBounds(15, 156, 123, 29);
		contentPane.add(button_1);
	}

}
