package osProject;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

import java.io.*;

public class fileBrowser extends JPanel 
{
	private static final long serialVersionUID = 1L;

	  JTree tree;
	  DefaultMutableTreeNode root;
	  private static fileBrowser instance = null;
	  JButton b1, b2, b3;
	  fileBrowser panel; 
	  
	  private fileBrowser() {
	    root = new DefaultMutableTreeNode("root", true);
	    getList(root, new File("/home/rusheel/"));
	    setLayout(new BorderLayout());
	    tree = new JTree(root);
	    tree.setRootVisible(false);
	    add(new JScrollPane((JTree)tree),"Center");
	    }
	  
	  public Dimension getPreferredSize(){
	    return new Dimension(200, 120);
	    }
	  public static fileBrowser getInstance()
	    {
	    	if(instance==null)
	    	{
	    		instance = new fileBrowser();
	    	}
	    	return instance;
	    }
	  
	  public void getList(DefaultMutableTreeNode node, File f) {
	     if(!f.isDirectory()) {
	         // We keep only JAVA source file for display in this HowTo
	        // if (f.getName().endsWith("java")) {
	           // System.out.println("FILE  -  " + f.getName());
	            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
	            node.add(child);
	         //   }
	         }
	     else {
	         //System.out.println("DIRECTORY  -  " + f.getName());
	         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
	         node.add(child);
	         File fList[] = f.listFiles();
	         for(int i = 0; i  < fList.length; i++)
	             getList(child, fList[i]);
	         }
	    }
    
	public  void open(String s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame(s);
				    fileBrowser panel = fileBrowser.getInstance();
				    frame.getContentPane().add(panel,"Center");
				    frame.setSize(400,400);
				    frame.setVisible(true);
				    frame.setState(JFrame.NORMAL);
				    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

