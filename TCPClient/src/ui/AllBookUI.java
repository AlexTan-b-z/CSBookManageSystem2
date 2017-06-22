package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllBookUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public AllBookUI(ArrayList<Book> books) {
		
		String bookui[][] = new String[books.size()][7];
		for(int i=0; i < books.size();i++){
			Book book = books.get(i);
			bookui[i][0] = i+1+"";
			bookui[i][1] = book.readtime;
			bookui[i][2] = book.id;
			bookui[i][3] = book.bookname;
			bookui[i][4] = book.author;
			bookui[i][5] = book.price;
			if(book.isout.equals("null")){
				bookui[i][6] = "ÎÞ";
			}else{
				bookui[i][6] = book.isout;
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6240\u6709\u56FE\u4E66");
		label.setFont(new Font("ËÎÌå", Font.BOLD, 26));
		label.setBounds(140, 0, 116, 31);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 428, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			bookui,
			new String[] {
				"\u6392\u540D", "\u501F\u9605\u6B21\u6570", "\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u501F\u9605\u4EBA"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.getColumnModel().getColumn(5).setPreferredWidth(58);
		table.getColumnModel().getColumn(6).setPreferredWidth(66);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				AllBookUI.this.dispose();
			}
		});
		button.setBounds(15, 208, 87, 29);
		contentPane.add(button);
	}
}
