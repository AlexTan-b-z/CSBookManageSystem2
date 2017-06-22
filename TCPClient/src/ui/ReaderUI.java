package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Operator;
import model.Book;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReaderUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ReaderUI(ArrayList<Book> books, String username) {
		
		String bookui[][] = new String[books.size()][5];
		for(int i=0; i < books.size();i++){
			Book book = books.get(i);
			bookui[i][0] = book.readtime;
			bookui[i][1] = book.id;
			bookui[i][2] = book.bookname;
			bookui[i][3] = book.author;
			bookui[i][4] = book.price;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u60A8\uFF1A" + username);
		label.setBounds(97, 0, 219, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u4E66\u5E93\u9605\u8BFB\u6392\u884C\uFF1A");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("ËÎÌו", Font.BOLD, 18));
		label_1.setBounds(97, 25, 171, 21);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 49, 398, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			bookui,
			new String[] {
				"\u501F\u9605\u6B21\u6570", "\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u501F\u9605\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operate = new Operator();
				int isout = 1;
				ArrayList<Book> books = operate.printBook(isout+"");
				BorrowUI menu = new BorrowUI(books,username);
				menu.setVisible(true);
				ReaderUI.this.dispose();
			}
		});
		button.setBounds(15, 179, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u56FE\u4E66");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindmenuUI findmenu = new FindmenuUI(username);
				findmenu.setVisible(true);
				ReaderUI.this.dispose();
			}
		});
		button_1.setBounds(153, 179, 123, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5F52\u8FD8\u56FE\u4E66");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operate = new Operator();
				ArrayList<Book> books = operate.printBook(username);
				ReturnBookUI menu = new ReturnBookUI(books,username);
				menu.setVisible(true);
				ReaderUI.this.dispose();
			}
		});
		button_2.setBounds(290, 179, 123, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeUserUI changeuser = new ChangeUserUI(username);
				changeuser.setVisible(true);
				ReaderUI.this.dispose();
			}
		});
		button_3.setBounds(15, 215, 152, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operator operate = new Operator();
				operate.Exit();
				ReaderUI.this.dispose();
			}
		});
		button_4.setBounds(261, 215, 152, 29);
		contentPane.add(button_4);
	}
}
