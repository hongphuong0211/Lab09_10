package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.order.DisplayOrders;
import hust.soict.globalict.aims.order.Order;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces

import javax.swing.*;

public class Aims {
	private JButton btnCr;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnDis;
	public static JFrame frame;
	public static Scanner sc = new Scanner(System.in);
	public Aims() {
		initialize();
	};
	public void initialize() {
		try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 0));
		frame.getContentPane().setForeground(new Color(255, 255, 0));
		frame.setForeground(new Color(255, 255, 0));
		frame.getContentPane().setMaximumSize(new Dimension(2147483634, 2147483646));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 733, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Aims Menu");
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 729, 421);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	    
	    btnCr = new JButton("Create new Order");
	    btnCr.setFont(new Font("Cambria Math", Font.PLAIN, 17));
	    btnCr.setLocation(26, 189);
	    btnCr.setSize(300, 70);
	    panel.add(btnCr);
	    btnCr.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		Order.main();
	    		frame.setVisible(false);
	    	}
	    });
	    
	    btnAdd = new JButton("Add item to the Order");
	    btnAdd.setFont(new Font("Cambria Math", Font.PLAIN, 17));
	    btnAdd.setLocation(381, 189);
	    btnAdd.setSize(300, 70);
	    panel.add(btnAdd);
	    btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				Object[] option = new Object[Order.nbOrders];
//				for(int i = 0; i < Order.nbOrders; i++)
//					option[i] = i + 1;
				int optChoose = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose ID", "Confirm", JOptionPane.INFORMATION_MESSAGE));
				if(optChoose <= Order.ListOrder.size()) {
					Order.ListOrder.get(optChoose - 1).createOrder.setVisible(true);;
					frame.setVisible(false);
				}
				else JOptionPane.showMessageDialog(null, "Not have this order");
				
			}    	
	    });
	    
	    btnDel = new JButton("Delete order by id");
	    btnDel.setFont(new Font("Cambria Math", Font.PLAIN, 17));
	    btnDel.setLocation(26, 305);
	    btnDel.setSize(300, 70);
	    panel.add(btnDel);
	    btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int optChoose = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose ID", "Confirm", JOptionPane.INFORMATION_MESSAGE));
				if(optChoose <= Order.ListOrder.size()) {
					StringBuffer manual = new StringBuffer("Do you want to DELETE this Order?\n\n");
					manual.append(Order.ListOrder.get(optChoose - 1).prOrder());
					DisplayOrders.main(null);
					DisplayOrders.DisplayText(manual.toString());
					DisplayOrders.btnOK.setEnabled(true);
					frame.setVisible(false);
					DisplayOrders.btnOK.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							Order.ListOrder.remove(optChoose - 1);
							Order.nbOrders--;
							DisplayOrders.DisFrame.dispose();
							Aims.frame.setVisible(true);
						}
						
					});			
				}
				else JOptionPane.showMessageDialog(null, "Not have this order");
			}
	    	
	    });
	    
	    btnDis = new JButton("Display the items list of order");
	    btnDis.setFont(new Font("Cambria Math", Font.PLAIN, 17));
	    btnDis.setLocation(381, 305);
	    btnDis.setSize(300, 70);
	    panel.add(btnDis);
	    btnDis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuffer manual = new StringBuffer();
				for(int i = 0; i < Order.ListOrder.size(); i++) {
					manual.append(Order.ListOrder.get(i).prOrder());
				}
				DisplayOrders.main(null);
				DisplayOrders.DisplayText(manual.toString());
				frame.setVisible(false);
			}    	
	    });
	    
	    JLabel lblNewLabel = new JLabel("ORDER MANAGEMENT APPLICATION");
	    lblNewLabel.setBounds(0, 0, 729, 164);
	    panel.add(lblNewLabel);
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 26));
	    
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Aims window = new Aims();
					Aims.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}