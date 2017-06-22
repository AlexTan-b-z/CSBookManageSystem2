package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Operator;
import model.User;

public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idtextField;

	
	/**
	 * Create the frame.
	 */
	public AdminUI(ArrayList<User> user) {
		
		String userui[][] = new String[user.size()][3];
		for(int i = 0; i < user.size(); i++){
			User person = user.get(i);
			userui[i][0] = person.uid;
			userui[i][1] = person.username;
			userui[i][2] = person.password;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5F53\u524D\u6240\u6709\u7BA1\u7406\u5458\u4E3A\uFF1A");
		label.setBounds(63, 15, 179, 21);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 33, 319, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			userui,
			new String[] {
				"\u7F16\u53F7", "\u53F7\u7801", "\u5BC6\u7801"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u5220\u9664\u7684\u7BA1\u7406\u5458\u7F16\u53F7(\",\"\u9694\u5F00):");
		label_1.setBounds(63, 149, 335, 21);
		contentPane.add(label_1);
		
		idtextField = new JTextField();
		idtextField.setBounds(63, 173, 319, 27);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				AdminUI.this.dispose();
			}
		});
		button.setBounds(63, 215, 123, 29);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("ËÎÌå", Font.BOLD | Font.ITALIC, 18));
		label_2.setForeground(Color.RED);
		label_2.setBounds(271, 0, 142, 21);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idStr = idtextField.getText();
				int status = 1;
				Operator operate = new Operator();
				boolean isSuccess = operate.deleteUser(idStr,status);
				if(isSuccess){
					label_2.setText("É¾³ý³É¹¦");
					Operator operator = new Operator();
					int Status = 1;
					ArrayList<User> user = operator.printUser(Status);
					AdminUI newui = new AdminUI(user);
					newui.setVisible(true);
					AdminUI.this.dispose();
				}else{
					label_2.setText("É¾³ýÊ§°Ü");
				}
			}
		});
		button_1.setBounds(259, 215, 123, 29);
		contentPane.add(button_1);
	}


}
