package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Operator;
import model.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DeleteUserUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idtextField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DeleteUserUI(ArrayList<User> user) {
		
		String userui[][] = new String[user.size()][5];
		
		for(int i = 0; i < user.size(); i++){
			User person = user.get(i);
			userui[i][0] = i+1+"";
			userui[i][1] = person.borrowtime;
			userui[i][2] = person.uid;
			userui[i][3] = person.username;
			userui[i][4] = person.password;
			System.out.println(person.username);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u501F\u9605\u6392\u884C");
		label.setFont(new Font("ËÎÌå", Font.BOLD, 26));
		label.setBounds(126, 0, 167, 27);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 33, 398, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			userui,
			new String[] {
				"\u6392\u540D", "\u501F\u4E66\u6B21\u6570", "\u7F16\u53F7", "\u53F7\u7801", "\u5BC6\u7801"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u62C9\u9ED1\u7684\u7528\u6237\u7F16\u53F7(\",\"\u9694\u5F00):");
		label_1.setBounds(15, 160, 319, 21);
		contentPane.add(label_1);
		
		idtextField = new JTextField();
		idtextField.setBounds(329, 157, 84, 27);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				DeleteUserUI.this.dispose();
			}
		});
		button.setBounds(63, 215, 123, 29);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("ËÎÌå", Font.BOLD | Font.ITALIC, 18));
		label_2.setForeground(Color.RED);
		label_2.setBounds(290, 0, 123, 21);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idStr = idtextField.getText();
				int status = 0;
				Operator operate = new Operator();
				boolean isSuccess = operate.deleteUser(idStr,status);
				if(isSuccess){
					label_2.setText("É¾³ý³É¹¦");
					Operator operator = new Operator();
					int status1 = 0;
					ArrayList<User> user = operator.printUser(status1);
					DeleteUserUI newui = new DeleteUserUI(user);
					newui.setVisible(true);
					DeleteUserUI.this.dispose();
				}else{
					label_2.setText("É¾³ýÊ§°Ü");
				}
			}
		});
		button_1.setBounds(259, 215, 123, 29);
		contentPane.add(button_1);
	}
}
