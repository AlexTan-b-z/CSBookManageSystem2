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

public class DeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField nameText;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUI frame = new DeleteUI();
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
	public DeleteUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("按编号删除:");
		label.setBounds(24, 62, 124, 21);
		contentPane.add(label);
		
		idText = new JTextField();
		idText.setBounds(163, 59, 96, 27);
		contentPane.add(idText);
		idText.setColumns(10);
		
		JLabel label_1 = new JLabel("或按书名删除:");
		label_1.setBounds(15, 104, 124, 21);
		contentPane.add(label_1);
		
		nameText = new JTextField();
		nameText.setBounds(163, 101, 96, 27);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = -1;
				String name = "";
				String choice = "删除";
				try{
					id = Integer.parseInt(idText.getText());
					System.out.println(id);
					Operator operator = new Operator();
					ReturnResult res = operator.deleteBook(id,name);
					if(res.judge.equals("success"))
					{
						System.out.println("id删除成功！");
						Success success = new Success(choice);
						success.setVisible(true);
						DeleteUI.this.dispose();
					}
					else
					{
						System.out.println("id删除失败！请检查您输入的是否正确！");
						Error error = new Error();
						error.setVisible(true);
						DeleteUI.this.dispose();
					}
				}catch (Exception e){
					name = nameText.getText();
					if(name.trim().equals(""))
					{
						Error error = new Error();
						error.setVisible(true);
						DeleteUI.this.dispose();
					}
					else
					{
						System.out.println(name);
						Operator operator = new Operator();
						ReturnResult res = operator.deleteBook(id,name);
						if(res.judge.equals("success"))
						{
							System.out.println("name删除成功！");
							Success success = new Success(choice);
							success.setVisible(true);
							DeleteUI.this.dispose();
						}
						else
						{
							System.out.println("name删除失败！请检查您输入的是否正确！");
							Error error = new Error();
							error.setVisible(true);
							DeleteUI.this.dispose();
						}
					}
				}
			}
		});
		submitButton.setBounds(257, 143, 123, 29);
		contentPane.add(submitButton);
		
		button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				DeleteUI.this.dispose();
			}
		});
		button.setBounds(28, 143, 123, 29);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5176\u4E2D\u4E4B\u4E00");
		label_2.setBounds(144, 15, 126, 21);
		contentPane.add(label_2);
	}
}
