package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Operator;
import model.ReturnResult;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Success extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Success frame = new Success("haha");
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
	public Success(String choice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(choice+"³É¹¦£¡");
		label.setBounds(152, 69, 130, 21);
		contentPane.add(label);
		
		JButton button = new JButton("\u8FD4\u56DE\u83DC\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUI menu = new MenuUI();
				menu.setVisible(true);
				Success.this.dispose();
			}
		});
		button.setBounds(31, 142, 130, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u67E5\u770B\u6240\u6709\u56FE\u4E66");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operator operator = new Operator();
				ReturnResult res = operator.findAll();
				PrintUI menu = new PrintUI(res.result,"");
				menu.setVisible(true);
				Success.this.dispose();
			}
		});
		button_1.setBounds(219, 142, 141, 29);
		contentPane.add(button_1);
	}

}
