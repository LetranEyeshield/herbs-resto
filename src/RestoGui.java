import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RestoGui extends JFrame {
	
		String title ="   HERBERT'S RESTO";
		
		JCheckBox egg_muffin,
					pancake,
					sausage_egg,
					balaleet,
					machboos,
					thareed,
					beef_steak,
					chicken_meal,
					fish_fillet;
		
		JTextField egg_muffin_text,
					pancake_text,
					sausage_egg_text,
					balaleet_text,
					machboos_text,
					thareed_text,
					beef_steak_text,
					chicken_meal_text,
					fish_fillet_text;
		
		double get_quantity[] = new double[8];
		double get_item_price[] = new double[8];
		
		String show_quantity="", show_price="";
		

	    public RestoGui(){
	        super("HERBERT'S RESTO");
	        setLayout(null);
	        setTitle();
	        //setBackground();
	        breakfastPanel();
	        lunchPanel();
	        dinnerPanel();
	        
	        Transaction();

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
	    	
	    	JPanel breakfastPanel = new JPanel();
	    	breakfastPanel.setLayout(null);
	    	breakfastPanel.setBounds(15,120,400,460);
	    	breakfastPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    	
	    	JLabel bfLabel = new JLabel("     BREAKFAST");
	    	bfLabel.setOpaque(true);
	    	bfLabel.setBackground(new Color(255,179,179));
	    	bfLabel.setFont(new Font("Tahoma",Font.BOLD,18));
	    	bfLabel.setBounds(120,10,150,20);
	    	
	    	JLabel egg_muffin_label = new JLabel(new ImageIcon("res/egg-muffin.jpg"));
	    	egg_muffin_label.setBounds(10,60,120,120);
	    	egg_muffin_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	egg_muffin = new JCheckBox("Egg Muffin (P45) ");
	    	egg_muffin.setBounds(150,80,120,20);
	    	JLabel egg_muffin_qty = new JLabel(" QTY: ");
	    	egg_muffin_qty.setOpaque(true);
	    	egg_muffin_qty.setBackground(new Color(153,187,255));
	    	egg_muffin_qty.setBounds(160,120,40,20);
	    	egg_muffin_text = new JTextField("0");
	    	egg_muffin_text.setBounds(210,120,50,22);
	    	
	    	JLabel pancake_label = new JLabel(new ImageIcon("res/pancake.jpg"));
	    	pancake_label.setBounds(10,190,120,120);
	    	pancake_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	pancake = new JCheckBox("Pancake (P50.75) ");
	    	pancake.setBounds(150,210,130,20);
	    	JLabel pancake_qty = new JLabel(" QTY: ");
	    	pancake_qty.setOpaque(true);
	    	pancake_qty.setBackground(new Color(153,187,255));
	    	pancake_qty.setBounds(160,240,40,20);
	    	pancake_text = new JTextField("0");
	    	pancake_text.setBounds(210,240,50,22);

	    	
	    	JLabel sausage_egg_label = new JLabel(new ImageIcon("res/sausage-egg.jpg"));
	    	sausage_egg_label.setBounds(10,320,120,120);
	    	sausage_egg_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	    	
	    	sausage_egg = new JCheckBox("Sausage Egg (P60.25) ");
	    	sausage_egg.setBounds(150,340,160,20);
	    	JLabel sausage_egg_qty = new JLabel(" QTY: ");
	    	sausage_egg_qty.setOpaque(true);
	    	sausage_egg_qty.setBackground(new Color(153,187,255));
	    	sausage_egg_qty.setBounds(160,370,40,20);
	    	sausage_egg_text = new JTextField("0");
	    	sausage_egg_text.setBounds(210,370,50,22);
	    	
	    	
	    	breakfastPanel.add(bfLabel);
	    	breakfastPanel.add(egg_muffin_label);
	    	breakfastPanel.add(egg_muffin);
	    	breakfastPanel.add(egg_muffin_qty);
	    	breakfastPanel.add(egg_muffin_text);
	    	
	    	breakfastPanel.add(pancake_label);
	    	breakfastPanel.add(pancake);
	    	breakfastPanel.add(pancake_qty);
	    	breakfastPanel.add(pancake_text);
	    	
	    	breakfastPanel.add(sausage_egg_label);
	    	breakfastPanel.add(sausage_egg);
	    	breakfastPanel.add(sausage_egg_qty);
	    	breakfastPanel.add(sausage_egg_text);
	    	
	    	add(breakfastPanel);
	    	
	    }
	    
		 public void lunchPanel() {
			    	
			 JPanel lunchPanel = new JPanel();
			 lunchPanel.setLayout(null);
			 lunchPanel.setBounds(430,120,400,460);
			 lunchPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			 
			 JLabel lunchLabel = new JLabel("         LUNCH");
			 lunchLabel.setOpaque(true);
			 lunchLabel.setBackground(new Color(255,179,179));
			 lunchLabel.setFont(new Font("Tahoma",Font.BOLD,18));
			 lunchLabel.setBounds(120,10,150,20);
			 
			 JLabel balaleet_label = new JLabel(new ImageIcon("res/balaleet.jpg"));
			 balaleet_label.setBounds(10,60,120,120);
			 balaleet_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

			 balaleet = new JCheckBox("Balaleet (P95) ");
			 balaleet.setBounds(150,80,120,20);
			 JLabel balaleet_qty = new JLabel(" QTY: ");
			 balaleet_qty.setOpaque(true);
			 balaleet_qty.setBackground(new Color(153,187,255));
			 balaleet_qty.setBounds(160,120,40,20);
			 balaleet_text = new JTextField("0");
			 balaleet_text.setBounds(210,120,50,22);
			 
			 
			 JLabel machboos_label = new JLabel(new ImageIcon("res/machboos.jpg"));
			 machboos_label.setBounds(10,190,120,120);
			 machboos_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

			 machboos = new JCheckBox("Machboos (P115.45) ");
			 machboos.setBounds(150,210,150,20);
			 JLabel machboos_qty = new JLabel(" QTY: ");
			 machboos_qty.setOpaque(true);
			 machboos_qty.setBackground(new Color(153,187,255));
			 machboos_qty.setBounds(160,240,40,20);
			 machboos_text = new JTextField("0");
			 machboos_text.setBounds(210,240,50,22);
			 
			 JLabel thareed_label = new JLabel(new ImageIcon("res/thareed.jpg"));
			 thareed_label.setBounds(10,320,120,120);
			 thareed_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

			 thareed = new JCheckBox("Thareed (P130.65) ");
			 thareed.setBounds(150,340,160,20);
			 JLabel thareed_qty = new JLabel(" QTY: ");
			 thareed_qty.setOpaque(true);
			 thareed_qty.setBackground(new Color(153,187,255));
			 thareed_qty.setBounds(160,370,40,20);
			 thareed_text = new JTextField("0");
			 thareed_text.setBounds(210,370,50,22);

			 lunchPanel.add(lunchLabel);
			 
			 lunchPanel.add(balaleet_label);
			 lunchPanel.add(balaleet);
			 lunchPanel.add(balaleet_qty);
			 lunchPanel.add(balaleet_text);
			 
			 lunchPanel.add(machboos_label);
			 lunchPanel.add(machboos);
			 lunchPanel.add(machboos_qty);
			 lunchPanel.add(machboos_text);
			 
			 lunchPanel.add(thareed_label);
			 lunchPanel.add(thareed);
			 lunchPanel.add(thareed_qty);
			 lunchPanel.add(thareed_text);
			 
			 add(lunchPanel);
			    	
		}
		 
		 public void dinnerPanel() {
		    	
		    JPanel dinnerPanel = new JPanel();
		    dinnerPanel.setLayout(null);
		    dinnerPanel.setBounds(860,120,400,460);
		    dinnerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		    
		    JLabel dinnerLabel = new JLabel("        DINNER");
		    dinnerLabel.setOpaque(true);
		    dinnerLabel.setBackground(new Color(255,179,179));
		    dinnerLabel.setFont(new Font("Tahoma",Font.BOLD,18));
		    dinnerLabel.setBounds(120,10,150,20);
		    
		    JLabel beef_steak_label = new JLabel(new ImageIcon("res/beef-steak.jpg"));
		    beef_steak_label.setBounds(10,60,120,120);
		    beef_steak_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		    beef_steak = new JCheckBox("Beef Steak (P145) ");
		    beef_steak.setBounds(150,80,130,20);
		    JLabel beef_steak_qty = new JLabel(" QTY: ");
		    beef_steak_qty.setOpaque(true);
		    beef_steak_qty.setBackground(new Color(153,187,255));
		    beef_steak_qty.setBounds(160,120,40,20);
		    beef_steak_text = new JTextField("0");
		    beef_steak_text.setBounds(210,120,50,22);
		    
		    JLabel chicken_meal_label = new JLabel(new ImageIcon("res/chicken-meal.png"));
		    chicken_meal_label.setBounds(10,190,120,120);
		    chicken_meal_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		    chicken_meal = new JCheckBox("Chicken Meal (P135.15) ");
		    chicken_meal.setBounds(150,210,170,20);
		    JLabel chicken_meal_qty = new JLabel(" QTY: ");
		    chicken_meal_qty.setOpaque(true);
		    chicken_meal_qty.setBackground(new Color(153,187,255));
		    chicken_meal_qty.setBounds(160,240,40,20);
		    chicken_meal_text = new JTextField("0");
		    chicken_meal_text.setBounds(210,240,50,22);
		    
		    JLabel fish_fillet_label = new JLabel(new ImageIcon("res/fish-fillet.jpg"));
		    fish_fillet_label.setBounds(10,320,120,120);
		    fish_fillet_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		    fish_fillet = new JCheckBox("Fish Fillet (P115.35) ");
		    fish_fillet.setBounds(150,340,160,20);
		    JLabel fish_fillet_qty = new JLabel(" QTY: ");
		    fish_fillet_qty.setOpaque(true);
		    fish_fillet_qty.setBackground(new Color(153,187,255));
		    fish_fillet_qty.setBounds(160,370,40,20);
		    fish_fillet_text = new JTextField("0");
		    fish_fillet_text.setBounds(210,370,50,22);
		    
		    dinnerPanel.add(dinnerLabel);
		    
		    dinnerPanel.add(beef_steak_label);
		    dinnerPanel.add(beef_steak);
		    dinnerPanel.add(beef_steak_qty);
		    dinnerPanel.add(beef_steak_text);
		    
		    dinnerPanel.add(chicken_meal_label);
		    dinnerPanel.add(chicken_meal);
		    dinnerPanel.add(chicken_meal_qty);
		    dinnerPanel.add(chicken_meal_text);
		    
		    dinnerPanel.add(fish_fillet_label);
		    dinnerPanel.add(fish_fillet);
		    dinnerPanel.add(fish_fillet_qty);
		    dinnerPanel.add(fish_fillet_text);
		    
		    add(dinnerPanel);
		    	
		    }
		 
		 
		 public void Transaction() {
			 
			 JLabel cash_label = new JLabel("  Enter Cash: ");
			 cash_label.setOpaque(true);
			 cash_label.setBackground(Color.CYAN);
			 cash_label.setBounds(260,600,90,20);
			 
			 JTextField cash = new JTextField();
			 cash.setBounds(360,600,100,22);
			 
			 JLabel change_label = new JLabel("  Change: ");
			 change_label.setOpaque(true);
			 change_label.setBackground(Color.CYAN);
			 change_label.setBounds(260,630,90,20);
			 
			 JTextField change = new JTextField();
			 change.setBounds(360,630,100,22);
			 
			 JButton compute = new JButton("OK");
			 compute.setBounds(470,610,80,30);
			 compute.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent jammi) {
					// TODO Auto-generated method stub
					
					try {
						
						double get_cash = Double.parseDouble(cash.getText().toString());
						
						double 	egg_muffin_get_qty = Double.parseDouble(egg_muffin_text.getText().toString()),
								pancake_get_qty= Double.parseDouble(pancake_text.getText().toString()),
								sausage_egg_get_qty= Double.parseDouble(sausage_egg_text.getText().toString()),
								balaleet_get_qty= Double.parseDouble(balaleet_text.getText().toString()),
								machboos_get_qty= Double.parseDouble(machboos_text.getText().toString()),
								thareed_get_qty= Double.parseDouble(thareed_text.getText().toString()),
								beef_steak_get_qty= Double.parseDouble(beef_steak_text.getText().toString()),
								chicken_meal_get_qty= Double.parseDouble(chicken_meal_text.getText().toString()),
								fish_fillet_get_qty= Double.parseDouble(fish_fillet_text.getText().toString());
						
						double  egg_muffin_price=45,
								pancake_price=50.75,
								sausage_egg_price=60.25,
								balaleet_price=95,
								machboos_price=115.45,
								thareed_price=130.65,
								beef_steak_price=145,
								chicken_meal_price=135.15,
								fish_fillet_price=115.35;
						
						/*double  egg_muffin_price=1,
								pancake_price=1,
								sausage_egg_price=1,
								balaleet_price=1,
								machboos_price=1,
								thareed_price=1,
								beef_steak_price=1,
								chicken_meal_price=1,
								fish_fillet_price=1;*/
						
						double get_price=0;

					/*	if(egg_muffin.isSelected() && pancake.isSelected() && sausage_egg.isSelected() 
								&& balaleet.isSelected() && machboos.isSelected() && thareed.isSelected()
								&& beef_steak.isSelected() && chicken_meal.isSelected() && fish_fillet.isSelected()) {*/
					if(egg_muffin.isSelected()) {

						get_price += (egg_muffin_get_qty*egg_muffin_price);
						
						get_quantity[0] = egg_muffin_get_qty;
						
						get_item_price[0] = egg_muffin_price;

					}
					
					if(pancake.isSelected()) {

						get_price += (pancake_get_qty*pancake_price);
						get_quantity[1] = pancake_get_qty;
						get_item_price[1] = pancake_price;

					}
					
					if(sausage_egg.isSelected()) {

						get_price += (sausage_egg_get_qty*sausage_egg_price);

					}
					
					if(balaleet.isSelected()) {

						get_price += (balaleet_get_qty*balaleet_price);
								
					}
					
					if(machboos.isSelected()) {

						get_price += (machboos_get_qty*machboos_price);

					}
					
					if(thareed.isSelected()) {

						get_price += (thareed_get_qty*thareed_price);
						
					}
					
					if(beef_steak.isSelected()) {

						get_price += (beef_steak_get_qty*beef_steak_price);

					}
					
					if(chicken_meal.isSelected()) {

						get_price += (chicken_meal_get_qty*chicken_meal_price);

					}
					
					if(fish_fillet.isSelected()) {

						get_price += (fish_fillet_get_qty*fish_fillet_price);

					}
					
					
					show_quantity = Double.toString(get_quantity[0])+"\n"+Double.toString(get_quantity[1]);
					show_price = Double.toString(get_item_price[0])+"\n"+Double.toString(get_item_price[1]);
					
						
					//JOptionPane.showMessageDialog(null, "Quantity "+show_quantity+"\n\n"+"Price "+show_price);
					
					
					
					JOptionPane.showMessageDialog(null, "Price "+show_price);
						
						
					}catch(Exception moriel) {
						
						JOptionPane.showMessageDialog(null, "Aliwa!");
					}
					
					
					
					
					
				}
				 
			 });
			 
			 add(cash_label);
			 add(cash);
			 add(change_label);
			 add(change);
			 add(compute);
			 
			 
		 }
		 

}
