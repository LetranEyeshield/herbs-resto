import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JTextField username;

	JPasswordField password;

	JLabel labelUser, labelPass;
	
	JButton login;
	
	
	public Login() {
		super(" HERBS RESTO ");
		setLayout(null);
		
		setObjects();
		setBackground();
		
		
	}
	
	public void setBackground(){

        ImageIcon icon = new ImageIcon("login.jpg");

        JLabel background = new JLabel(icon);
        background.setBounds(0,0,400,250);
        // background.setBackground(new Color(0,0,255));
        // background.setBackground(Color.LIGHT_GRAY);
        background.setOpaque(true);
        add(background);

    }
	
	
	public void setObjects(){
		
		labelUser = new JLabel("     Username ");
		labelUser.setBounds(50,80,100,20);
		labelUser.setOpaque(true);
		labelUser.setBackground(Color.CYAN);
		labelUser.setForeground(Color.black);
		add(labelUser);
		
		labelPass = new JLabel("     Password ");
		labelPass.setBounds(50,110,100,20);
		labelPass.setOpaque(true);
		labelPass.setBackground(Color.CYAN);
		labelPass.setForeground(Color.black);
		add(labelPass);

		username = new JTextField();
		username.setBounds(160,80,100,20);
		add(username);
		
		password = new JPasswordField();
		password.setBounds(160,110,100,20);
		password.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent morielKim) {
				// TODO Auto-generated method stub
				Validate();
			}
			
		});
		 add(password);
		 
		 
		login = new JButton("Log In");
		login.setBounds(160,140,80,30);
		login.addActionListener(this);
		add(login);

	}
	
	
public void Validate(){
		
		String User = username.getText().toString();
		String Pass = password.getText().toString();
		String query;
		
		if (User.equals("") || Pass.equals("")){
			
			 JOptionPane.showMessageDialog(null,"Fill All Fields!"," HERBS RESTO",JOptionPane.ERROR_MESSAGE);
			 
		
		}else{
			
			query = "SELECT * FROM users WHERE username = "+"\""+username.getText().toString()+"\""
					+" AND password = "+"\""+password.getText().toString()+"\"";
			 

			try{

				//set natin ang pag access sa mysql driver
				String driver = "org.gjt.mm.mysql.Driver";

				//set natin ang host, port, at database natin

				String url = "jdbc:mysql://localhost:3306/herbs_resto";

				//access natin ang java mysql driver library na ating inimport para magamit
				Class.forName(driver);

				//set natin ung user at pass ng sql appz, server, host or kung anong tawag jan natin, mine is xammp 

				String user = "root";
				String pass = "";

				//create na natin ung connection para sating database 
				Connection conn = DriverManager.getConnection(url,user,pass);


				 java.sql.Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(query);
				 
					
					if(rs.first()){
						
						JOptionPane.showMessageDialog(null, "OK");
						
					 }else{
						 
						 JOptionPane.showMessageDialog(null,"Invalid Username/Password Combination!"," HERBS RESTO",JOptionPane.ERROR_MESSAGE);
						 
						
					}
					 
							
					conn.close();

					}catch (Exception jammi){

						JOptionPane.showMessageDialog(null,"ERROR!!!\n"+"PLEASE CONTACT DATABASE ADMIN\n\n"+jammi.getMessage()," HERBS RESTO",JOptionPane.ERROR_MESSAGE);
							 

					} 
			
		}
}
	

	@Override
	public void actionPerformed(ActionEvent jammi) {
		// TODO Auto-generated method stub
		Validate();
	}

}
