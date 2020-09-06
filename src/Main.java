import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
			/*RestoGui rg = new RestoGui();
	        rg .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //rg.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        rg.setSize(screenSize.width,720);
	        rg.getContentPane().setBackground(new Color(255,179,179));
	        rg .setVisible(true);
	        rg .setResizable(false);*/
	        
	        RestoGui2 rg2 = new RestoGui2();
	        rg2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //rg2.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        rg2.setSize(screenSize.width,720);
	        rg2.getContentPane().setBackground(new Color(255,179,179));
	        rg2.setVisible(true);
	        rg2.setResizable(false);
	        
	        System.out.print(screenSize);
		
		
			/*Login L = new Login();
			L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			L.setSize(400,250);
			L.setVisible(true);
			L.setLocation(430,180);
			L.setResizable(false);*/
		
		
		
	}

}
