package hust.soict.globalict.aims.order;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces

import javax.naming.LimitExceededException;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;    // Using Swing components and containers

import hust.soict.globalict.aims.Aims;

public class DisplayOrders extends JFrame{
	public static JFrame DisFrame; 
	public static JTextArea textArea;
	public static JButton btnOK;
	
	public DisplayOrders() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		DisFrame = new JFrame();
		DisFrame.setBackground(new Color(255, 255, 0));
		DisFrame.getContentPane().setForeground(new Color(255, 255, 0));
		DisFrame.setForeground(new Color(255, 255, 0));
		DisFrame.getContentPane().setMaximumSize(new Dimension(2147483634, 2147483646));
		DisFrame.getContentPane().setBackground(Color.DARK_GRAY);
		DisFrame.setBounds(0, 0, 733, 449);
		DisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisFrame.getContentPane().setLayout(null);
		DisFrame.setResizable(false);
		DisFrame.setTitle("Aims Menu");
		DisFrame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 729, 421);
		DisFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 700, 350);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, 
		      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		btnCancel.setBounds(152, 364, 116, 47);
		panel.add(btnCancel);
		
		btnOK = new JButton("Yes");
		btnOK.setEnabled(false);
		btnOK.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		btnOK.setBounds(422, 364, 116, 47);
		panel.add(btnOK);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DisFrame.dispose();
				Aims.frame.setVisible(true);
			}
			
		});		
		
	}

	
	public static void DisplayText(String str) {
		textArea.setText(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayOrders s = new DisplayOrders();
		DisFrame.setVisible(true);
	}
}
