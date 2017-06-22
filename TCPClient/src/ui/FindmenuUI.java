package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.Book;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FindmenuUI extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FindmenuUI(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u5982\u4F55\u67E5\u627E\u56FE\u4E66\uFF1A");
		label.setBounds(94, 33, 216, 21);
		contentPane.add(label);
		
		JButton idButton = new JButton("编号");
		idButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IDfindUI menu = new IDfindUI(username);
				menu.setVisible(true);
				FindmenuUI.this.dispose();
			}
		});
		idButton.setBounds(134, 60, 107, 29);
		contentPane.add(idButton);
		
		JButton button = new JButton("书名");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NameFindUI menu = new NameFindUI(username);
				menu.setVisible(true);
				FindmenuUI.this.dispose();
			}
		});
		button.setBounds(134, 92, 107, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("作者");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AuthorFindUI menu = new AuthorFindUI(username);
				menu.setVisible(true);
				FindmenuUI.this.dispose();
			}
		});
		button_1.setBounds(134, 126, 107, 29);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("价格");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PriceFindUI menu = new PriceFindUI(username);
				menu.setVisible(true);
				FindmenuUI.this.dispose();
			}
		});
		button_3.setBounds(134, 159, 107, 29);
		contentPane.add(button_3);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(username.equals("")){
					MenuUI menu = new MenuUI();
					menu.setVisible(true);
					FindmenuUI.this.dispose();
				}else{
					Operator operate = new Operator();
					int isout = 0;
					ArrayList<Book> books = operate.printBook(isout+"");
					ReaderUI menu = new ReaderUI(books,username);
					menu.setVisible(true);
					FindmenuUI.this.dispose();
				}
				
			}
		});
		button_2.setBounds(134, 189, 107, 29);
		contentPane.add(button_2);
	}

}
