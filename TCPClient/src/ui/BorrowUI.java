package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Operator;
import model.Book;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public BorrowUI(ArrayList<Book> books, String username) {
		
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
		
		JLabel label = new JLabel("\u5F53\u524D\u53EF\u501F\u56FE\u4E66\uFF1A");
		label.setFont(new Font("ÀŒÃÂ", Font.BOLD, 28));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(103, 0, 210, 43);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 49, 398, 106);
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
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u501F\u9605\u7684\u56FE\u4E66\u7F16\u53F7(\",\"\u9694\u5F00):");
		label_1.setBounds(0, 159, 306, 21);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(308, 156, 105, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operate = new Operator();
				int isout = 0;
				ArrayList<Book> books = operate.printBook(isout+"");
				ReaderUI menu = new ReaderUI(books,username);
				menu.setVisible(true);
				BorrowUI.this.dispose();
			}
		});
		button.setBounds(15, 195, 123, 29);
		contentPane.add(button);
		
		JFrame frame = new JFrame("ΩË‘ƒ–≈œ¢");
		frame.getContentPane().setLayout(null);
		frame.setBounds(10, 10, 350, 200);
		
		JLabel label_2 = new JLabel("\u501F\u9605\u6210\u529F");
		label_2.setFont(new Font("ÀŒÃÂ", Font.BOLD, 26));
		label_2.setBounds(130, 5, 111, 34);
		frame.getContentPane().add(label_2);
		
		JButton button_2 = new JButton("\u786E\u5B9A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Operator operate = new Operator();
				int isout = 1;
				ArrayList<Book> books = operate.printBook(isout+"");
				BorrowUI menu = new BorrowUI(books,username);
				menu.setVisible(true);
				BorrowUI.this.dispose();
			}
		});
		button_2.setBounds(200, 100, 123, 29);
		frame.add(button_2);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idStr = textField.getText();
				Operator operate = new Operator();
				boolean isSuccess = operate.borrowBook(username, idStr);
				if(isSuccess){
					frame.setVisible(true);
				}else{
					label_2.setText("ΩË‘ƒ ß∞‹");
					frame.setVisible(true);
				}
			}
		});
		button_1.setBounds(290, 195, 123, 29);
		contentPane.add(button_1);
	}

}
