package osProject;

import java.sql.*;
import java.awt.Image;
import java.awt.EventQueue;
import javax.swing.*;  
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class miniOSlogin
{
	private JFrame frame;
	sqlDB db;
	Connection connect=null;
	PreparedStatement stmt;
    ResultSet rset;
	private JTextField textField;
	private JPasswordField passwordField;
	static int loginCount;
		
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try 
				{
					miniOSlogin window = new miniOSlogin();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
   
	/**
	 * Create the application entry point
	 */
	public miniOSlogin()
	{
		//System.out.println(System.getProperty("java.class.path"));
		initialize();
		db = new sqlDB();
		connect = db.initconnection("Mysql");		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.getContentPane().setForeground(Color.YELLOW);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Bright", Font.PLAIN, 11));
		textField.setBounds(279, 70, 118, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBackground(new Color(240, 240, 240));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(175, 72, 81, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(175, 121, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnLogin = new JButton("Login");
		Image img=new ImageIcon(this.getClass().getClassLoader().getResource("ok.png")).getImage();					
		btnLogin.setIcon(new ImageIcon(img));		
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				 try
				 {
					 loginCount++;					 
					 String q="select * from oslogin where username=? and password=?";
					 stmt=connect.prepareStatement(q);
					 String uid = textField.getText();
					 stmt.setString(1,uid);
					 char[] passwd_entered = passwordField.getPassword();
					 String passwd = new String(passwd_entered);
					 stmt.setString(2,passwd);					 					 
					 rset=stmt.executeQuery();
					 int count=0;
					 while(rset.next())
					 {
						 count=count+1;
					 }
					 if (count==1)
					 {
						//miniDesktop md  = miniDesktop.getInstance();
					    miniDesktop.open(null);		
						db.closeall();
                        frame.dispose();
					 }
					 else
					 {
					    //Login failed for 3 times..
						 if(loginCount<3) {
						  JOptionPane.showMessageDialog(null, "User name or Password is incorrect");
						  textField.setText("");
						  passwordField.setText("");
						 }
						 else {
							    JOptionPane.showMessageDialog(null, "Authentication failed for 3 times. Please contact admin");						 
								 frame.dispose();
							 }													 
					 }									     
				 }catch(Exception e)
				 {
				      JOptionPane.showMessageDialog(null,e); 
				 }
				 finally
				    {		
					    try {
					     rset.close();
				         if(stmt != null)
				            stmt.close();				         
				       } catch (SQLException ex) {
				           ex.printStackTrace();
				       }

				    }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setBounds(249, 182, 109, 34);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 119, 118, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.ORANGE);
		Image img1=new ImageIcon(this.getClass().getClassLoader().getResource("login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(25, 70, 155, 146);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMiniOperatingSystem = new JLabel("Mini Operating System");
		lblMiniOperatingSystem.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 18));
		lblMiniOperatingSystem.setBounds(110, 11, 469, 48);
		frame.getContentPane().add(lblMiniOperatingSystem);		
     }
}


