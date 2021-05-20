package hust.soict.globalict.aims.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.utils.MyDate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyEvent;

public class Order extends JFrame{
//	private int qtyOrdered = 0;
	public MyDate dateOrdered;
	public List<Media> itemsOrdered = new ArrayList<Media>();

	public static int nbOrders = 0;
	public static List<Order> ListOrder = new ArrayList<>();
	public int currentOrder = 0;
	
	public JFrame createOrder;
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private JTextField textField;
	private JTextField TotalCostText;
	
	public static final int PREDEFINED_NUMBERS_ORDERED = 5;
	public static final float PREDEFINED_TOTAL_COST_ORDERED = 100f;
	public int luckyTime = 0;

	public Order() throws LimitExceededException {
		nbOrders ++;
		currentOrder = nbOrders;
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			try {
				UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ListOrder.add(this);
			dateOrdered = new MyDate(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonth().getValue(), java.time.LocalDate.now().getYear());
		}
		else {
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
		}
		createOrder = new JFrame();
		createOrder.setBackground(new Color(255, 255, 0));
		createOrder.getContentPane().setForeground(new Color(255, 255, 0));
		createOrder.setForeground(new Color(255, 255, 0));
		createOrder.getContentPane().setMaximumSize(new Dimension(2147483634, 2147483646));
		createOrder.getContentPane().setBackground(Color.DARK_GRAY);
		createOrder.setBounds(0, 0, 733, 449);
		createOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createOrder.getContentPane().setLayout(null);
		createOrder.setResizable(false);
		createOrder.setTitle("Create New Order");
		createOrder.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 733, 449);
		createOrder.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Order");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 35));
		lblNewLabel.setBounds(0, 5, 251, 77);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(33, 92, 69, 31);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		textField.setBounds(101, 92, 80, 31);
		textField.setText(String.valueOf(currentOrder));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(381, 10, 260, 31);
		panel.add(lblNewLabel_2);
		
		TotalCostText = new JTextField();
		TotalCostText.setText("0");
		TotalCostText.setHorizontalAlignment(SwingConstants.CENTER);
		TotalCostText.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		TotalCostText.setBounds(21, 243, 230, 96);
		panel.add(TotalCostText);
		TotalCostText.setColumns(10);
		
		JLabel TotalCostLabel = new JLabel("Total Cost");
		TotalCostLabel.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		TotalCostLabel.setBounds(21, 191, 121, 42);
		panel.add(TotalCostLabel);
		
		
		JButton OKButton = new JButton("OK");
		OKButton.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		OKButton.setBounds(83, 362, 98, 46);
		panel.add(OKButton);
		OKButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(luckyTime == 0 && itemsOrdered.size() >= PREDEFINED_NUMBERS_ORDERED && ListOrder.get(currentOrder - 1).totalCost() > PREDEFINED_TOTAL_COST_ORDERED) {
					int opt = JOptionPane.showConfirmDialog(null, "Do you want to use 1 lucky time?");
					if(opt == 0) ListOrder.get(currentOrder - 1).getALuckyItem();
				}else {
					createOrder.setVisible(false);
					Aims.frame.setVisible(true);
				}
			}
			
		});
		
		JPanel Menu = new JPanel();
		Menu.setBackground(Color.WHITE);
		Menu.setBounds(292, 45, 441, 375);
		panel.add(Menu);
		Menu.setLayout(null);
		
		JButton ID2Button = new JButton("0");
		ID2Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID2Button.setBounds(390, 34, 41, 24);
		Menu.add(ID2Button);
		
		JButton ID1Button = new JButton("0");
		ID1Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID1Button.setBounds(390, 5, 41, 24);
		Menu.add(ID1Button);
		
		JButton ID3Button = new JButton("0");
		ID3Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID3Button.setBounds(390, 63, 41, 24);
		Menu.add(ID3Button);
		
		JButton ID4Button = new JButton("0");
		ID4Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID4Button.setBounds(390, 92, 41, 24);
		Menu.add(ID4Button);
		
		JButton ID5Button = new JButton("0");
		ID5Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID5Button.setBounds(390, 121, 41, 24);
		Menu.add(ID5Button);
		
		JButton ID6Button = new JButton("0");
		ID6Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID6Button.setBounds(390, 150, 41, 24);
		Menu.add(ID6Button);
		
		JButton ID7Button = new JButton("0");
		ID7Button.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		ID7Button.setBounds(390, 184, 41, 24);
		Menu.add(ID7Button);
		
		JCheckBoxMenuItem ID1 = new JCheckBoxMenuItem("1. DVD: The Lion King, Animation, 19.95$, 84, Roger Allers");
		ID1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		ID1.setBounds(6, 5, 384, 24);
		Menu.add(ID1);
		ID1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DigitalVideoDisc test = new DigitalVideoDisc(12011, "The Lion King", "Animation", 19.95f, 84, "Roger Allers");
				if(ID1.isSelected()) {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to play DVD?");
					if(option == 0) {
						JOptionPane.showMessageDialog(null, "Playing DVD: " + test.getTitle() + "\nDVD length: " + test.getLength());
						try {
							test.play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(test);
							ID1Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID1.setSelected(false);
				}
				else {
					ListOrder.get(currentOrder - 1).removeMedia(12011);
					ID1Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID1Button.setText(String.valueOf(Integer.parseInt(ID1Button.getText()) + 1));
					try {
						ListOrder.get(currentOrder - 1).addMedia(new DigitalVideoDisc(12011, "The Lion King", "Animation", 19.95f, 84, "Roger Allers"));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID1.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID2 = new JCheckBoxMenuItem("2. DVD: Star Wars, Science Fiction, 24.95$, 124, Geogre Lucas");
		ID2.setBounds(6, 34, 384, 24);
		Menu.add(ID2);
		ID2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DigitalVideoDisc test = new DigitalVideoDisc(23111, "Star Wars", "Science Fiction", 24.95f, 124, "Geogre Lucas");
				if(ID2.isSelected()) {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to play DVD?");
					if(option == 0) {
					JOptionPane.showMessageDialog(null, "Playing DVD: " + test.getTitle() + "\nDVD length: " + test.getLength());
						try {
							test.play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(test);
							ID2Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID2.setSelected(false);
						
				}else {
					ListOrder.get(currentOrder - 1).removeMedia(23111);
					ID2Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID2Button.setText(String.valueOf(Integer.parseInt(ID2Button.getText()) + 1));
					try {
						ListOrder.get(currentOrder - 1).addMedia(new DigitalVideoDisc(23111, "Star Wars", "Science Fiction", 24.95f, 124, "Geogre Lucas"));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID2.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID3 = new JCheckBoxMenuItem("3. DVD: Aladdin, Animation, 18.99$, 90, John Musker");
		ID3.setBounds(6, 63, 384, 24);
		Menu.add(ID3);
		ID3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DigitalVideoDisc test = new DigitalVideoDisc(10311, "Aladdin", "Animation", 18.99f, 90, "John Musker");
				if(ID3.isSelected()) {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to play DVD?");
					if(option == 0) {
					JOptionPane.showMessageDialog(null, "Playing DVD: " + test.getTitle() + "\nDVD length: " + test.getLength());
						try {
							test.play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(test);
							ID3Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID3.setSelected(false);
				}else {
					ListOrder.get(currentOrder - 1).removeMedia(10311);
					ID3Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID3Button.setText(String.valueOf(Integer.parseInt(ID3Button.getText()) + 1));
					try {
						ListOrder.get(currentOrder - 1).addMedia(new DigitalVideoDisc(10311, "Aladdin", "Animation", 18.99f, 90, "John Musker"));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID3.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID4 = new JCheckBoxMenuItem("4. Book: Cinderella, Fairy Tale, 20.15$, Chloe Pekkis");
		ID4.setBounds(6, 92, 384, 24);
		Menu.add(ID4);
		ID4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List <String> authors = new ArrayList<String>();
				authors.add("Chloe Pekkis");
				if(ID4.isSelected())
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(new Book(86332, "Cinderella", "Fairy Tale", 20.15f, authors));
							ID4Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID4.setSelected(false);
				else {
					ListOrder.get(currentOrder - 1).removeMedia(new Book(86332, "Cinderella", "Fairy Tale", 20.15f, authors));
					ID4Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID4Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID4Button.setText(String.valueOf(Integer.parseInt(ID4Button.getText()) + 1));
					List <String> authors = new ArrayList<String>();
					authors.add("Chloe Pekkis");
					try {
						ListOrder.get(currentOrder - 1).addMedia(new Book(86332, "Cinderella", "Fairy Tale", 20.15f, authors));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID4.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID5 = new JCheckBoxMenuItem("5. Book: Rapunzel, Fairy Tale, 15.20$, Jerry Mahoney");
		ID5.setBounds(6, 121, 384, 24);
		Menu.add(ID5);
		ID5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List <String> authors = new ArrayList<String>();
				authors.add("Jerry Mahoney");
				if(ID5.isSelected())
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(new Book(71232, "Rapunzel", "Fairy Tale", 15.20f, authors));
							ID5Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID5.setSelected(false);
				else {
					ListOrder.get(currentOrder - 1).removeMedia(new Book(71232, "Rapunzel", "Fairy Tale", 15.20f, authors));
					ID5Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID5Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID5Button.setText(String.valueOf(Integer.parseInt(ID5Button.getText()) + 1));
					List <String> authors = new ArrayList<String>();
					authors.add("Jerry Mahoney");
					try {
						ListOrder.get(currentOrder - 1).addMedia(new Book(71232, "Rapunzel", "Fairy Tale", 15.20f, authors));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID5.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID6 = new JCheckBoxMenuItem("6. CD: Thriller, Pop, 99.20$, Michael Jackson, Wanna Be Startin' Somethin");
		ID6.setBounds(6, 150, 384, 24);
		Menu.add(ID6);
		ID6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList <Track> trackList = new ArrayList<Track>();
				trackList.add(new Track("Wanna Be Starlin' Somethin", 362));
				trackList.add(new Track("Baby Be Mine", 260));
				CompactDisc test = new CompactDisc(74544, "Thriller", "Pop", 99.20f, "Michael Jackson", trackList);
				if(ID6.isSelected()) {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to play CD?");
					if(option == 0) {
					JOptionPane.showMessageDialog(null, "Playing DVD: " + test.getTitle() + "\nCD length: " + test.getLength());
						try {
							test.play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(test);
							ID6Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID6.setSelected(false);
				}else {
					ListOrder.get(currentOrder - 1).removeMedia(new CompactDisc(74544, "Thriller", "Pop", 99.20f, "Michael Jackson", trackList));
					ID6Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID6Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID6Button.setText(String.valueOf(Integer.parseInt(ID6Button.getText()) + 1));
					ArrayList <Track> trackList = new ArrayList<Track>();
					trackList.add(new Track("Wanna Be Starlin' Somethin", 362));
					trackList.add(new Track("Baby Be Mine", 260));
					try {
						ListOrder.get(currentOrder - 1).addMedia(new CompactDisc(74544, "Thriller", "Pop", 99.20f, "Michael Jackson", trackList));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID6.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		
		JCheckBoxMenuItem ID7 = new JCheckBoxMenuItem("7. CD: The Poll Winners, Jazz, 34.50$, Barney Kessel, Jordu");
		ID7.setBounds(6, 184, 384, 24);
		Menu.add(ID7);
		
		
		ID7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList <Track> trackList = new ArrayList<Track>();
				trackList.add(new Track("Jordu", 207));
				trackList.add(new Track("Satin Doll", 390));
				trackList.add(new Track("Mean To Me", 388));
				CompactDisc test = new CompactDisc(12742, "The Poll Winners", "Jazz", 34.50f, "Barney Kessel", trackList);
				if(ID7.isSelected()) {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to play CD?");
					if(option == 0) {
					JOptionPane.showMessageDialog(null, "Playing DVD: " + test.getTitle() + "\nCD length: " + test.getLength());
						try {
							test.play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
						try {
							ListOrder.get(currentOrder - 1).addMedia(test);
							ID7Button.setText("1");
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else ID7.setSelected(false);
				}else {
					ListOrder.get(currentOrder - 1).removeMedia(new CompactDisc(74544, "Thriller", "Pop", 99.20f, "Michael Jackson", trackList));
					ID7Button.setText("0");
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
		ID7Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
					ID7Button.setText(String.valueOf(Integer.parseInt(ID7Button.getText()) + 1));
					ArrayList <Track> trackList = new ArrayList<Track>();
					trackList.add(new Track("Jordu", 207));
					trackList.add(new Track("Satin Doll", 390));
					trackList.add(new Track("Mean To Me", 388));
					try {
						ListOrder.get(currentOrder - 1).addMedia(new CompactDisc(12742, "The Poll Winners", "Jazz", 34.50f, "Barney Kessel", trackList));
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ID7.setSelected(true);
				}
				TotalCostText.setText(String.valueOf(ListOrder.get(currentOrder - 1).totalCost()));
			}
			
		});
	}

//	public int getQtyOrdered() {
//		return qtyOrdered;
//	}
//
//	public void setQtyOrdered(int qtyOrdered) {
//		this.qtyOrdered = qtyOrdered;
//	}
//	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

//	public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
//		if(nbOrders <= MAX_LIMITTED_ORDERS)
//		for(int j = 0; j < disc.length; j++) {
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc[j];
//						this.qtyOrdered ++;
//						System.out.println("The disc has been added");
//						break;
//					}
//				}
//		}
//		
//	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			if(this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) 
				throw new LimitExceededException("ERROR: The number of items has reached its limit!");
			else
				itemsOrdered.add(media);
		}
		else {
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
		}			
	}
		
	public void removeMedia(Media media) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getTitle().equals(media.getTitle()) && itemsOrdered.get(i).getCategory().equals(media.getCategory()) && itemsOrdered.get(i).getCost() == media.getCost()) {
				itemsOrdered.remove(i);
				i--;
			}
		}
	}
	
	public void removeMedia(int id) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				itemsOrdered.remove(i);
				i--;
			}
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
//		if(nbOrders <= MAX_LIMITTED_ORDERS) {
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full, the discs can't be ordered");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc1;
//						this.qtyOrdered ++;
//						System.out.println("The first disc has been added");
//						break;
//					}
//				}
//			if(this.qtyOrdered == MAX_NUMBERS_ORDERED) 
//				System.out.println("The order is almost full, the second disc can't be ordered");
//			else
//				for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
//					if(itemsOrdered[i] == null) {
//						itemsOrdered[i] = disc2;
//						this.qtyOrdered ++;
//						System.out.println("The second disc has been added");
//						break;
//					}
//				}
//		}
//	}
	
	public float totalCost() {
		float sumCost = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
//			if(itemsOrdered.get(i) != null) {
				sumCost += itemsOrdered.get(i).getCost();
//			}
		}
		return sumCost;
	}
	
	public void printOrder() {
		int j = 1;
		System.out.println("***********************Order***********************");
		System.out.println("Date: "); this.dateOrdered.print();
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) != null) {
				System.out.println(j + ". Media - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getCost() + "$");
				j++;
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public StringBuffer prOrder() {
		StringBuffer s = new StringBuffer("***********************Order***********************\n");
		s.append("ID: "+ this.currentOrder + "\n");
		s.append("Ordered Items:\n");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) != null) {
				s.append(i+1 + ". Media - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getCost() + "$\n");
			}
		}
		s.append("Total cost: " + this.totalCost());
		s.append("\n***************************************************\n");
		return s;
	}
	
	public void getALuckyItem() {
		luckyTime++;
		Random lucky = new Random();
		int i = 0;
		do {
			i = lucky.nextInt(this.itemsOrdered.size());
		}while(itemsOrdered.get(i).getCost() > 0.3*totalCost());
		if(itemsOrdered.get(i) instanceof Book) {
			itemsOrdered.set(i, new Book(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((Book) itemsOrdered.get(i)).getAuthors()));
		}else if(itemsOrdered.get(i) instanceof DigitalVideoDisc) {
			itemsOrdered.set(i, new DigitalVideoDisc(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((DigitalVideoDisc) itemsOrdered.get(i)).getLength(), ((DigitalVideoDisc) itemsOrdered.get(i)).getDirector()));
		}else if(itemsOrdered.get(i) instanceof CompactDisc) {
			itemsOrdered.set(i, new CompactDisc(itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), 0, ((CompactDisc) itemsOrdered.get(i)).getArtist(), ((CompactDisc) itemsOrdered.get(i)).getTracks()));
		}	
		StringBuffer manual = new StringBuffer("Lucky Item: " + itemsOrdered.get(i).getTitle() + "\n");
		manual.append(Order.ListOrder.get(currentOrder - 1).prOrder());
		DisplayOrders.main(null);
		DisplayOrders.DisplayText(manual.toString());	
		createOrder.setVisible(false);
	}

	public static void main() {
		// TODO Auto-generated method stub
		Order test = null;
		try {
			test = new Order();
			test.createOrder.setVisible(true);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
