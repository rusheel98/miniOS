package osProject;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class miniDesktop implements ActionListener{
	
	private JFrame frame;
	private JButton Btn1, Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,Btn10;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private JLabel clock;
    private static miniDesktop instance = null;	
    
    public static miniDesktop getInstance()
    {
    	if(instance==null)
    	{
    		instance = new miniDesktop();
    	}
    	return instance;
    }    
private miniDesktop()
{
	Btn1 = new JButton("Terminal");
	Image img1=new ImageIcon(this.getClass().getClassLoader().getResource("terminal.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);					
	Btn1.setIcon(new ImageIcon(img1));	
	Btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{
			 Terminal term = Terminal.getInstance();
	         term.open(0, 0, 500, 500);
			}
			else
			{
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				 Terminal term = Terminal.getInstance();
		         term.open(0, 0, 500, 500);
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
			}		
		  }
	});
	
	Btn2 = new JButton("Editor");
	Image img2=new ImageIcon(this.getClass(
			).getClassLoader().getResource("editor.jpg")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);					
	Btn2.setIcon(new ImageIcon(img2));	
	Btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{
			TextEditor te = TextEditor.getInstance();
			te.openEditor(null);
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				TextEditor te = TextEditor.getInstance();
				te.openEditor(null);
			}
		}
	});
	
	Btn3 = new JButton("Disk");
	Image img3=new ImageIcon(this.getClass().getClassLoader().getResource("disk.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);						
	Btn3.setIcon(new ImageIcon(img3));	
	
	Btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {  
			try
			{
				Frame[] allFrames = Frame.getFrames();
				int fcount=0;
				for(Frame fr : allFrames){
					if(fr.isShowing()==true)
						fcount++;
				}
				if(fcount==1)
				{
			   DiskScheduler d = new  DiskScheduler(); 
			   d.Schedule(null);
				}
				else
				{
					//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
					int c=0;
					for(Frame fr : allFrames) {
						if(fr.isShowing()==true && c!=0)
						{						
							fr.setState(JFrame.ICONIFIED);					
						}	
						else if(fr.isShowing()==true && c==0)
						{
							fr.setState(JFrame.NORMAL);
							c++;
						}
						
					}
					 DiskScheduler d = new  DiskScheduler(); 
					 d.Schedule(null);
				}				
			}
			catch(ClassNotFoundException |InstantiationException | IllegalAccessException|
					UnsupportedLookAndFeelException e )
			{
				e.printStackTrace();
			}
			   
		}
	});
	
	Btn4 = new JButton("Page");
	Image img4=new ImageIcon(this.getClass().getClassLoader().getResource("page.jpg")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);
	Btn4.setIcon(new ImageIcon(img4));	
	Btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{
			pageReplace pr = pageReplace.getInstance();
    	    pr.getPagefaults(null);
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				pageReplace pr = pageReplace.getInstance();
	    	    pr.getPagefaults(null);
				
			}
		}
	});
	
	Btn5 = new JButton("Exit");
	Image img5=new ImageIcon(this.getClass().getClassLoader().getResource("logout.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);			
	Btn5.setIcon(new ImageIcon(img5));	
	
	Btn5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
	 	frame.dispose();
		}
	});
	
	Btn6 = new JButton("Game");
	Image img6=new ImageIcon(this.getClass().getClassLoader().getResource("game.jpg")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);			
	Btn6.setIcon(new ImageIcon(img6));	
	
	Btn6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{		
			 puzzleGame.getInstance();
		    }
			else
			{
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				puzzleGame.getInstance();				
			}
		}		
	});	
	
	Btn7 = new JButton("File Browser");
	Image img7=new ImageIcon(this.getClass().getClassLoader().getResource("filebrowser.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);					
	Btn7.setIcon(new ImageIcon(img7));
	
	Btn7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("Hi ");
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{	
			fileBrowser f = fileBrowser.getInstance();
			f.open("File Browser");
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				fileBrowser f = fileBrowser.getInstance();
				f.open("File Browser");
			}
		}
	});
	
	Btn8 = new JButton("Calendar");
	Image img8=new ImageIcon(this.getClass().getClassLoader().getResource("calendar.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);				
	Btn8.setIcon(new ImageIcon(img8));
	
	Btn8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{	
				Cal c = Cal.getInstance();
				c.openCalendar(null);
			}
			else
			{
			//	JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				Cal cl = Cal.getInstance();
				cl.openCalendar(null);
			}
		}
	});
	
	Btn9 = new JButton("Browser");
	Image img9=new ImageIcon(this.getClass().getClassLoader().getResource("browser.png")).getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);											
	Btn9.setIcon(new ImageIcon(img9));
	
	Btn9.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames)
			{
				if(fr.isShowing()==true)
					fcount = fcount+1;
			}
			int c=0;
			for(Frame fr : allFrames) {
				if(fr.isShowing()==true && c!=0)
				{						
					fr.setState(JFrame.ICONIFIED);					
				}	
				else if(fr.isShowing()==true && c==0)
				{
					fr.setState(JFrame.NORMAL);
					c++;
				}
				
			}
			
			//minibrowser mb =new minibrowser();
			minibrowser.main(null);			
		}
	});	
	
	Btn10 = new JButton("Calculator");
	Image img10=new ImageIcon(this.getClass().getClassLoader().getResource("calculator.png")).getImage().getScaledInstance(90, 50, Image.SCALE_DEFAULT);											
	Btn10.setIcon(new ImageIcon(img10));
	
	Btn10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Frame[] allFrames = Frame.getFrames();
			int fcount=0;
			for(Frame fr : allFrames){
				if(fr.isShowing()==true)
					fcount++;
			}
			if(fcount==1)
			{	
				Calculator c = Calculator.getInstance();
				c.open(null);
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"Another application is running. Please close it and try again!");
				int c=0;
				for(Frame fr : allFrames) {
					if(fr.isShowing()==true && c!=0)
					{						
						fr.setState(JFrame.ICONIFIED);					
					}	
					else if(fr.isShowing()==true && c==0)
					{
						fr.setState(JFrame.NORMAL);
						c++;
					}
					
				}
				Calculator cl = Calculator.getInstance();
				cl.open(null);
			}
		}
	});	
	
		 	    
	frame = new JFrame();	
    frame.setTitle("mini Desktop");
    frame.setSize(600,400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLayout(new BorderLayout());
    frame.setLayout(null);
    frame.setResizable(false);
     
  
    ImageIcon bg_img=new ImageIcon(this.getClass().getClassLoader().getResource("desktop.png"));					
	frame.setContentPane(new JLabel(bg_img));    
	    
    frame.add(Btn1);
    frame.add(Btn2);
    frame.add(Btn3);
    frame.add(Btn4);
    frame.add(Btn5);
    frame.add(Btn6);
    frame.add(Btn7);
    frame.add(Btn8);
    frame.add(Btn9);
    frame.add(Btn10);
    
    clock = new JLabel();
    frame.add(clock);
    updateClock();
    new Timer(1000, this).start();
      
    Btn1.setBounds(15,10,50,50);
    Btn2.setBounds(15,80,50,50);
    Btn3.setBounds(15,150,50,50);
    Btn4.setBounds(15,220,50,50);
    Btn10.setBounds(15,290,50,50);
    
    Btn6.setBounds(530,10,50,50);
    Btn7.setBounds(530,90,50,50);
    Btn8.setBounds(530,160,50,50);
    Btn9.setBounds(530,230,50,50);
    Btn5.setBounds(530,300,50,50);
    clock.setBounds(15,360,150,30);    
    
    frame.setSize(599,399);  
    
   }
   @Override
   public void actionPerformed(ActionEvent e) {
   updateClock();
   }
   private void updateClock() {
      clock.setText(dateFormat.format(Calendar.getInstance().getTime()));
   }
  
    public static void open(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				miniDesktop window;
				try {
					if(instance==null)
					{
					window = new miniDesktop();
					window.frame.setVisible(true);
					}
					else {
						window = miniDesktop.getInstance();
						window.frame.setVisible(true);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  
   
} 
