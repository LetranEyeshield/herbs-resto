import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RestoGui2 extends JFrame implements KeyListener, Printable {
	
		String title ="   HERBERT'S RESTO";
		
		JPanel breakfastPanel;
		
		JTextArea order_area;
		
		JScrollPane scroll;
		
		JTextField order_field, food_price, food_qty;
		double get_food_price, get_food_qty, total_food_price, get_total_food_price=0;
		double rounded_food_price;
		
		JComboBox foods;
		
		String food_names[] = {
			"",
			"Egg Muffin",
			"Pancake",
			"Sausage Egg",
			"Balaleet",
			"Machboos",
			"Thareed",
			"Beef Steak",
			"Chicken Meal",
			"Fish Fillet",
		};
		
		JButton place_order, get_order;
		
		JLabel total_price_label, cash_label, change_label;
		JTextField total_price_field, cash_field, change_field;
		
		double get_cash=0,get_total_price_field,get_change;
		
	    public RestoGui2(){
	        super("HERBERT'S RESTO");
	        setLayout(null);
	        setTitle();
	        //setBackground();
	        breakfastPanel();
	        lunchPanel();
	        dinnerPanel();
	        orderPanel();
	        

	    }

	   /* public void setBackground(){

	        ImageIcon icon = new ImageIcon("jammi.jpg");

	        JLabel background = new JLabel(icon);
	        background.setBounds(0,0,800,470);
	        // background.setBackground(new Color(0,0,255));
	        // background.setBackground(Color.LIGHT_GRAY);
	        background.setOpaque(true);
	        add(background);

	    }*/
	    
	    public void setTitle(){
	    	
	    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    	
	    	 int labelWidth = 400;
	    	 int w = this.getSize().width;
	    	 int xpos = (dim.width-w)/2-(labelWidth/2);
	    	
	    	JLabel titleLabel = new JLabel(title);
	    	titleLabel.setOpaque(true);
	    	titleLabel.setBackground(new Color(153,187,255));
	    	titleLabel.setFont(new Font("Tahoma",Font.BOLD,35));
	    	titleLabel.setBounds(xpos,20,labelWidth,50);
	    	add(titleLabel);
	    	
	    }
	    
	    public void breakfastPanel() {
	    	
	    	breakfastPanel = new JPanel();
	    	breakfastPanel.setLayout(null);
	    	breakfastPanel.setBounds(15,120,200,510);
	    	breakfastPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    	
	    	JLabel bfLabel = new JLabel("     BREAKFAST");
	    	bfLabel.setOpaque(true);
	    	bfLabel.setBackground(new Color(255,179,179));
	    	bfLabel.setFont(new Font("Tahoma",Font.BOLD,18));
	    	bfLabel.setBounds(20,10,150,20);
	    	
	    	JLabel egg_muffin_price_tag = new JLabel("    Egg Muffin: (P45)");
	    	egg_muffin_price_tag.setOpaque(true);
	    	egg_muffin_price_tag.setBackground(new Color(153,187,255));
	    	egg_muffin_price_tag.setBounds(35,60,120,20);
	    	
	    	JLabel egg_muffin_label = new JLabel(new ImageIcon("res/egg-muffin.jpg"));
	    	egg_muffin_label.setBounds(35,80,120,120);
	    	egg_muffin_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	
	    	JLabel pancake_price_tag = new JLabel("   Pancake: (P50.75)");
	    	pancake_price_tag.setOpaque(true);
	    	pancake_price_tag.setBackground(new Color(153,187,255));
	    	pancake_price_tag.setBounds(35,210,120,20);
	    	
	    	JLabel pancake_label = new JLabel(new ImageIcon("res/pancake.jpg"));
	    	pancake_label.setBounds(35,230,120,120);
	    	pancake_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	JLabel sausage_egg_price_tag = new JLabel("Sausage Egg:(P60.25)");
	    	sausage_egg_price_tag.setOpaque(true);
	    	sausage_egg_price_tag.setBackground(new Color(153,187,255));
	    	sausage_egg_price_tag.setBounds(33,360,125,20);
	    	
	    	JLabel sausage_egg_label = new JLabel(new ImageIcon("res/sausage-egg.jpg"));
	    	sausage_egg_label.setBounds(35,380,120,120);
	    	sausage_egg_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	breakfastPanel.add(bfLabel);
	    	
	    	breakfastPanel.add(egg_muffin_label);
	    	breakfastPanel.add(egg_muffin_price_tag);
	    	
	    	breakfastPanel.add(pancake_label);
	    	breakfastPanel.add(pancake_price_tag);
	    	
	    	breakfastPanel.add(sausage_egg_label);
	    	breakfastPanel.add(sausage_egg_price_tag);
	    	
	    	add(breakfastPanel);
	    	
	    }
	    
		 public void lunchPanel() {
			    	
			 JPanel lunchPanel = new JPanel();
			 lunchPanel.setLayout(null);
			 lunchPanel.setBounds(270,120,200,510);
			 lunchPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			 
			 JLabel lunchLabel = new JLabel("         LUNCH");
			 lunchLabel.setOpaque(true);
			 lunchLabel.setBackground(new Color(255,179,179));
			 lunchLabel.setFont(new Font("Tahoma",Font.BOLD,18));
			 lunchLabel.setBounds(20,10,150,20);
			 
			 JLabel balaleet_price_tag = new JLabel("      Balaleet: (P95)");
			 balaleet_price_tag.setOpaque(true);
			 balaleet_price_tag.setBackground(new Color(153,187,255));
			 balaleet_price_tag.setBounds(35,60,120,20);
			 
			 JLabel balaleet_label = new JLabel(new ImageIcon("res/balaleet.jpg"));
			 balaleet_label.setBounds(35,80,120,120);
			 balaleet_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			 
			 
			 JLabel machboos_price_tag = new JLabel("Machboos: (P115.45)");
			 machboos_price_tag.setOpaque(true);
			 machboos_price_tag.setBackground(new Color(153,187,255));
			 machboos_price_tag.setBounds(35,210,120,20);
		    	
			 JLabel machboos_label = new JLabel(new ImageIcon("res/machboos.jpg"));
			 machboos_label.setBounds(35,230,120,120);
			 machboos_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			 
			 JLabel thareed_price_tag = new JLabel("   Thareed:(P130.65)");
			 thareed_price_tag.setOpaque(true);
			 thareed_price_tag.setBackground(new Color(153,187,255));
			 thareed_price_tag.setBounds(35,360,120,20);

			 JLabel thareed_label = new JLabel(new ImageIcon("res/thareed.jpg"));
			 thareed_label.setBounds(35,380,120,120);
			 thareed_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

			 lunchPanel.add(lunchLabel);
			 
			 lunchPanel.add(balaleet_price_tag);
			 lunchPanel.add(balaleet_label);
			
			 lunchPanel.add(machboos_price_tag);
			 lunchPanel.add(machboos_label);
			
			 lunchPanel.add(thareed_price_tag);
			 lunchPanel.add(thareed_label);
			
			 
			 add(lunchPanel);
			    	
		}
		 
		 
		 public void dinnerPanel() {
		    	
		    JPanel dinnerPanel = new JPanel();
		    dinnerPanel.setLayout(null);
		    dinnerPanel.setBounds(520,120,200,510);
		    dinnerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		    
		    JLabel dinnerLabel = new JLabel("        DINNER");
		    dinnerLabel.setOpaque(true);
		    dinnerLabel.setBackground(new Color(255,179,179));
		    dinnerLabel.setFont(new Font("Tahoma",Font.BOLD,18));
		    dinnerLabel.setBounds(20,10,150,20);
		    
		    
		    JLabel beef_steak_price_tag = new JLabel("   Beef Steak: (P145)");
		    beef_steak_price_tag.setOpaque(true);
		    beef_steak_price_tag.setBackground(new Color(153,187,255));
		    beef_steak_price_tag.setBounds(35,60,120,20);
			 
		    JLabel beef_steak_label = new JLabel(new ImageIcon("res/beef-steak.jpg"));
		    beef_steak_label.setBounds(35,80,120,120);
		    beef_steak_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		    JLabel chicken_meal_price_tag = new JLabel("Chicken Meal: (P135.15)");
		    chicken_meal_price_tag.setOpaque(true);
		    chicken_meal_price_tag.setBackground(new Color(153,187,255));
		    chicken_meal_price_tag.setBounds(25,210,140,20);
			 
		    JLabel chicken_meal_label = new JLabel(new ImageIcon("res/chicken-meal.png"));
		    chicken_meal_label.setBounds(35,230,120,120);
		    chicken_meal_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		    
		    JLabel fish_fillet_price_tag = new JLabel("Fish Fillet:(P115.35)");
		    fish_fillet_price_tag.setOpaque(true);
		    fish_fillet_price_tag.setBackground(new Color(153,187,255));
		    fish_fillet_price_tag.setBounds(35,360,120,20);
		    
		    JLabel fish_fillet_label = new JLabel(new ImageIcon("res/fish-fillet.jpg"));
		    fish_fillet_label.setBounds(35,380,120,120);
		    fish_fillet_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		    
		    dinnerPanel.add(dinnerLabel);
		    
		    dinnerPanel.add(beef_steak_price_tag);
		    dinnerPanel.add(beef_steak_label);
		    
		    dinnerPanel.add(chicken_meal_price_tag);
		    dinnerPanel.add(chicken_meal_label);
		    
		    dinnerPanel.add(fish_fillet_price_tag);
		    dinnerPanel.add(fish_fillet_label);
		    
		    add(dinnerPanel);
		    	
	}
		 
		 
		 public void orderPanel(){
			 
			 JLabel order_label = new JLabel("Search Order: ");
			 order_label.setOpaque(true);
			 order_label.setBackground(Color.CYAN);
			 order_label.setBounds(740,120,90,20);
			 add(order_label);
			 
			 JLabel price_label = new JLabel("Price: ");
			 price_label.setOpaque(true);
			 price_label.setBackground(Color.CYAN);
			 price_label.setBounds(970,120,40,20);
			 add(price_label);
			 
			 
			 food_price = new JTextField();
			 food_price.setBounds(1015,120,50,22);
			 add(food_price);
			 
			 JLabel qty_label = new JLabel("QTY: ");
			 qty_label.setOpaque(true);
			 qty_label.setBackground(Color.CYAN);
			 qty_label.setBounds(1075,120,30,20);
			 add(qty_label);
			 
			 food_qty = new JTextField();
			 food_qty.setBounds(1115,120,40,22);
			 food_qty.setText("1");
			 food_qty.addKeyListener(this);
			 add(food_qty);
			 
			 
			 foods = new JComboBox(food_names);
			 foods.setBounds(840,120,120,22);
			 foods.setSelectedIndex(0);
			 foods.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					
					get_food_qty = Double.parseDouble(food_qty.getText().toString());
					
					 if(foods.getSelectedItem().equals("Egg Muffin")){
						 get_food_price = 45;
						 food_price.setText(""+get_food_price);
						 total_food_price+=(get_food_qty*get_food_price);
						 food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Pancake")) {
						get_food_price = 50.75;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Sausage Egg")) {
						get_food_price = 60.25;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Balaleet")) {
						get_food_price = 95;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Machboos")) {
						get_food_price = 115.45;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Thareed")) {
						get_food_price = 160.35;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Beef Steak")) {
						get_food_price = 145;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Chicken Meal")) {
						get_food_price = 135.15;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}else if(foods.getSelectedItem().equals("Fish Fillet")) {
						get_food_price = 115.35;
						food_price.setText(""+get_food_price);
						total_food_price+=(get_food_qty*get_food_price);
						food_qty.setText("1");
					}
					 
					
					
				}
			 });
			 add(foods);
			 
			 
			 place_order = new JButton("Add Order");
			 place_order.setBounds(1165,120,95,22);
			 place_order.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					Transaction();
					 try {
						 
						 
						 get_food_qty = Double.parseDouble(food_qty.getText().toString());
						 
						 if(foods.getSelectedItem().equals("Egg Muffin")){
								get_food_price = 45;
								food_price.setText(""+get_food_price);
								total_food_price = get_food_price *get_food_qty;
								food_price.setText(""+total_food_price);
								get_total_food_price+=total_food_price;
								get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
								total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Pancake")) {
							get_food_price = 50.75;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Sausage Egg")) {
							get_food_price = 60.25;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Balaleet")) {
							get_food_price = 95;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Machboos")) {
							get_food_price = 115.45;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Thareed")) {
							get_food_price = 160.35;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Beef Steak")) {
							get_food_price = 145;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Chicken Meal")) {
							get_food_price = 135.15;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}else if(foods.getSelectedItem().equals("Fish Fillet")) {
							get_food_price = 115.35;
							food_price.setText(""+get_food_price);
							total_food_price = get_food_price *get_food_qty;
							food_price.setText(""+total_food_price);
							get_total_food_price+=total_food_price;
							get_total_food_price = Math.round(get_total_food_price * 100.0) / 100.0;
							total_price_field.setText(""+get_total_food_price);
						}
						 
						 food_qty.setText("0");
						 food_price.setText("0");
						 foods.setSelectedIndex(0);
						 
					 }catch(Exception jam){
						 
					 }
				}
				 
			 });
			 add(place_order);
			 
			 total_price_label = new JLabel("Total Price: ");
			 total_price_label.setOpaque(true);
			 total_price_label.setBackground(Color.CYAN);
			 total_price_label.setBounds(1070,200,70,20);
			 add(total_price_label);
			 
			 total_price_field = new JTextField();
			 total_price_field.setBounds(1150,200,70,22);
			 add(total_price_field);
			 
			 cash_label = new JLabel("  Cash: ");
			 cash_label.setOpaque(true);
			 cash_label.setBackground(Color.CYAN);
			 cash_label.setBounds(1070,230,70,20);
			 add(cash_label);
			 
			 cash_field = new JTextField();
			 cash_field.setBounds(1150,230,70,22);
			 cash_field.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent jammi) {
					// TODO Auto-generated method stub
					GetChange();
				}

				@Override
				public void keyReleased(KeyEvent jammi) {
					// TODO Auto-generated method stub
					GetChange();
				}

				@Override
				public void keyTyped(KeyEvent jammi) {
					// TODO Auto-generated method stub
					
				}
				 
			 });
			 add(cash_field);
			 
			 change_label = new JLabel("  Change: ");
			 change_label.setOpaque(true);
			 change_label.setBackground(Color.CYAN);
			 change_label.setBounds(1070,260,70,20);
			 add(change_label);
			 
			 change_field = new JTextField();
			 change_field.setBounds(1150,260,70,22);
			 add(change_field);
			 
			 
			 /*String order_area_text = "         "
			 		+ "                         "
			 		
			 		+ "                       HERBERT'S RESTO"+"\n\n\n"
			 		+"================================================"+"\n"
			 		+"ITEM	QTY	PRICE"+"\n\n";*/
			 
			 String order_area_text = "          ==========================="+"\n"
					 					+"                 HERBERT'S RESTO"+"\n"
								 	 +"          ==========================="+"\n\n\n"
								 		+"ITEM	QTY	PRICE"+"\n\n";
			 
			 order_area=new JTextArea(order_area_text);
			 
			 //remarks.setToolTipText("Please use 'Enter Key' to use line break!");
			 order_area.setLineWrap(true);
			 order_area.setWrapStyleWord(true);
			 scroll=new JScrollPane(order_area);
			 scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			 //scrollRemarks.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			 scroll.setBounds(740,170,300,460);
			 add(scroll);
			 
			 
			 
			 JButton get_order = new JButton("OK");
			 get_order.setBounds(1070,300,150,30);
			 get_order.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					//printMe();
					try {
						get_cash = Double.parseDouble(cash_field.getText().toString());
						get_total_price_field = Double.parseDouble(total_price_field.getText().toString());
						get_change = get_cash - get_total_price_field;
						get_change =  Math.round(get_change * 100.0) / 100.0;
						change_field.setText(""+get_change);
						
						String append_transaction = "==========================="+"\n"
													+"Cash: "+get_cash+"\n"
													+"Total: "+get_total_price_field+"\n"
													+"Change: "+get_change+"\n\n\n"
													+"THANK YOU! COME AGAIN!";
						
						order_area.append(append_transaction);
						
						order_area.print();
						
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				 
			 });
			 add(get_order);
			 
			 JButton cancel_order = new JButton("Cancel Order");
			 cancel_order.setBounds(1070,340,150,30);
			 cancel_order.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					
					 String order_area_text = "          ==========================="+"\n"
			 					+"                 HERBERT'S RESTO"+"\n"
						 	 +"          ==========================="+"\n\n\n"
						 		+"ITEM	QTY	PRICE"+"\n\n";
					 
					 
					 get_total_food_price = 0;
					 total_price_field.setText("0");
					 cash_field.setText("0");
					 change_field.setText("0");
					 
					 food_qty.setText("0");
					 food_price.setText("0");
					 foods.setSelectedIndex(0);
					 
					 order_area.setText(order_area_text);
					
					
				}
				 
			 });
			 add(cancel_order);
			 
		}
		 
		 
		 public void Transaction() {
			 
			 
			 String get_transaction = foods.getSelectedItem().toString()+"	  "+food_qty.getText().toString()+"	"+food_price.getText().toString()
					 					+"\n"+" @ "+get_food_price+"\n";
			 
			 String show_transaction = order_area.getText().toString();
			 
			 show_transaction+=get_transaction+"\n";
			 
			 order_area.setText(show_transaction);
			 
			 /*JButton compute = new JButton("OK");
			 compute.setBounds(470,610,80,30);
			 compute.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					
						
						test=order_field.getText();
						
						String x = order_area.getText().toString();
						
						x+=test+"\n";
						
						order_area.setText(x);
						
				}
				 
			 });*/
			
			 
			 
		 }
		 
		 
		 public void getOrderPrice() {
			 
			 try {
				 
				 get_food_qty = Double.parseDouble(food_qty.getText().toString());
				 
				
				 if(foods.getSelectedItem().equals("Egg Muffin")){
						get_food_price = 45;
						food_price.setText(""+get_food_price);
						total_food_price = get_food_price *get_food_qty;
						rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
						food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Pancake")) {
					get_food_price = 50.75;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Sausage Egg")) {
					get_food_price = 60.25;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Balaleet")) {
					get_food_price = 95;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Machboos")) {
					get_food_price = 115.45;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Thareed")) {
					get_food_price = 160.35;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Beef Steak")) {
					get_food_price = 145;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Chicken Meal")) {
					get_food_price = 135.15;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}else if(foods.getSelectedItem().equals("Fish Fillet")) {
					get_food_price = 115.35;
					food_price.setText(""+get_food_price);
					total_food_price = get_food_price *get_food_qty;
					rounded_food_price = Math.round(total_food_price * 100.0) / 100.0;
					food_price.setText(""+rounded_food_price);
				}
				 
				
				 
			 }catch(Exception jammi){
				 
			 }
			 
			
		 }
		 
		 
		 public void GetChange() {
			 try {
					get_cash = Double.parseDouble(cash_field.getText().toString());
					get_total_price_field = Double.parseDouble(total_price_field.getText().toString());
					get_change = get_cash - get_total_price_field;
					get_change = Math.round(get_change * 100.0) / 100.0;
					change_field.setText(""+get_change);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 

		@Override
		public void keyPressed(KeyEvent jammi) {
			// TODO Auto-generated method stub
			
			getOrderPrice();
		}

		@Override
		public void keyReleased(KeyEvent jammi) {
			// TODO Auto-generated method stub
			getOrderPrice();
		}

		@Override
		public void keyTyped(KeyEvent jammi) {
			// TODO Auto-generated method stub
			//getOrderPrice();
		}

		
		
		@Override
		public int print(Graphics g, PageFormat pf, int page)
				throws PrinterException {
			// TODO Auto-generated method stub
			
			Image logo = Toolkit.getDefaultToolkit().getImage("res/jammi.jpg");
			
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			//DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:m:s");
			Date date = new Date(page, page, page);
			
			
			 if (page > 0) {  //We have only one page, and 'page' is zero-based 
		        return NO_SUCH_PAGE;
		    }

		    // User (0,0) is typically outside the imageable area, so we must
		    // * translate by the X and Y values in the PageFormat to avoid clipping
		     
		    Graphics2D g2d = (Graphics2D)g;
		    g2d.translate(pf.getImageableX(), pf.getImageableY());

		   
		    // Now we perform our rendering 
		    g.drawImage(logo, 270, 10, 60, 60, this);

		    g.setFont(new Font("Tahoma",Font.BOLD,11));
		    g.setColor(Color.RED);
		    g.drawString("yo", 140, 100);
		    
		    

		     //tell the caller that this page is part of the printed document 
		    return PAGE_EXISTS;

		}
		
		
		/*public void printMe(){ 
			
			  PrinterJob job = PrinterJob.getPrinterJob();
		       job.setPrintable(this);
		       boolean ok = job.printDialog();
		       if (ok) {
		           try {
		                job.print();
		           } catch (PrinterException morielKim) {
		            JOptionPane.showMessageDialog(null, morielKim.getMessage());
		           }
		       }
			
		}*/
		 

}
