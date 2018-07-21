package osProject;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class pageReplace extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	static int full=0;
	static int numbers[];
    static int ref[]=new int[100000];
    static int frame[]=new int[100000];
    static int repptr=0;
    static int count=0;
    private JTextField textField_1;
    JCheckBox chckbxNewCheckBox,chckbxNewCheckBox_1;
    private JTextField textField_2;
    private JTextField textField_3;
    JLabel lblManulInput;
    JLabel lblNoinput;
    private static pageReplace instance = null;
	/**
	 * Launch the application.
	 */
	public  void getPagefaults(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageReplace frame =  pageReplace.getInstance();
					frame.setVisible(true);
					frame.setState(JFrame.NORMAL);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static int Pagerep(int element,int flag)
    {
        int temp;
        while(ref[repptr]!=0)
        {
            ref[repptr++]=0;
            if(repptr==flag)
            {
                repptr=0;
            }
        }
        temp=frame[repptr];
        frame[repptr]=element;
        ref[repptr]=1;

        return temp;
    }
	public static pageReplace getInstance()
    {
    	if(instance==null)
    	{
    		instance = new pageReplace();
    	}
    	return instance;
    }
	
    public static int pagefault(int element,int flag)
    {
        if(full!=flag)
        {
            ref[full]=1;
            frame[full++]=element;
        }
       
		return element;
    }
    public static int search(int element)
    {
        int i,flag;
        flag=0;
        if(full!=0)
        {
            for(i=0;i<full;i++)
            {
                if(element==frame[i])
                {
                    flag=1;
                    ref[i]=1;
                    break;
                }
            }
        }
        return flag;
    }
	private pageReplace() {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 461);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 new BufferedReader(new InputStreamReader(System.in));
			String cnames[]=new String[] {
					"column1", "column2", "column3", "column4", "column5", "column6", "column7", "column8", "column9"
				};
			Object a[][]= {
				{0, 0, 0,0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0,0,0, 0, 0, 0,0 ,0, 0},
			};
			
		 table = new JTable(a,cnames);
		 table.setBorder(new LineBorder(new Color(0, 0, 0)));
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
		 			},
		 	new String[] {
		 		"column1", "column2", "column3", "column4", "column5", "column6", "column7", "column8", "column9", "column10", "column11", "column12"
		 	}
		 ));
			
				table.setBounds(60, 174, 659, 208);
				contentPane.add(table);
							
				table.getModel().addTableModelListener(new TableModelListener() {

				      public void tableChanged(TableModelEvent e) {
				    //     System.out.println(e);
				      }
				    });
				
				
		Random rand = new Random();
			
		JButton btnFifo = new JButton("FIFO");
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ii,jj;
				for(ii=0;ii<13;ii++)
					for(jj=0;jj<12;jj++)
						table.setValueAt(0, ii,jj);
				int pt=0;
				int f=5,page=0,pgf=0,n = 0,chn=0;
				boolean flag;
				int pages[];
				f=Integer.parseInt(textField_3.getText());
					 
				int frame[]=new int[f];
				for(int i=0;i<f;i++)
					{
					frame[i]=-1;
					}
					if(chckbxNewCheckBox.isSelected())
					{
				n=rand.nextInt(11)+1;
				 pages=new int[100000];
				for(int j=0;j<n;j++)
				pages[j]=rand.nextInt(7);
					}
					else
					{
						n=Integer.parseInt(textField_2.getText());
						 pages=new int[100000];
						 

int j;
String sm[]=new String[10000];
sm=textField_1.getText().split(" ");

for(j=0;j<sm.length&&j<n;j++)
pages[j]=Integer.parseInt(sm[j]);
if(j!=sm.length)
{
	for(;j<sm.length&&j<n;j++)
		pages[j]=0;

}

					}
					do{
				int pg=0;
				for(pg=0;pg<n;pg++)
				{
				
				page=pages[pg];
				table.setValueAt(page, 0,chn);
				
				flag=true;
				for(int j=0;j<f;j++)
				{
				if(page==frame[j])
				{
				flag=false;
				 break;
				}
				}
				if(flag)
				{
				frame[pt]=page;
				pt++;
				if(pt==f)
				pt=0;
			//	System.out.print("frame :");
				for(int j=0;j<f;j++)
				{
					//System.out.print(frame[j]+"   ");
				table.setValueAt(frame[j], j+1,chn);
				
				}
			//	System.out.println();
				pgf++;
				}
				else
				{
				//System.out.print("frame :");
				for(int j=0;j<f;j++)
				{
					//System.out.print(frame[j]+"  ");
				table.setValueAt(frame[j], j+1,chn);
				
				}
				//System.out.println();
				}
				
				chn++;
				}
				}while(chn!=n);
			//	System.out.println("Page fault:"+pgf);
				textField.setText(pgf+"");
				
			}
		});
		btnFifo.setBounds(10, 11, 89, 23);
		contentPane.add(btnFifo);
		
		JButton btnLru = new JButton("LRU");
		btnLru.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//int pt=0;
				int f=5,page=0,pgf=0,n = 0,chn=0;
				boolean flag;
				int[] pages;

				int ii,jj;
				for(ii=0;ii<13;ii++)
					for(jj=0;jj<12;jj++)
						table.setValueAt(0, ii,jj);
				f=Integer.parseInt(textField_3.getText());
				int k=0;
				//System.out.println("enter no. of frames: ");
				int frame1[]=new int[f];
				int a[]=new int[f];
				int b[]=new int[f];
				for(int i=0;i<f;i++)
					{
					frame1[i]=-1;
					a[i]=-1;
					b[i]=-1;
					}
			//	System.out.println("enter the no of pages ");
 
				  pages=new int[10000];
				//System.out.println("enter the page no ");
				  if(chckbxNewCheckBox.isSelected())
					{
				n=rand.nextInt(12)+1;
				 pages=new int[n];
				
				for(int j=0;j<n;j++)
				pages[j]=rand.nextInt(7);
					}
					else
					{
						n=Integer.parseInt(textField_2.getText());
						 pages=new int[n];
						 f=Integer.parseInt(textField_3.getText());

int j;
String sm[]=new String[10000];
sm=textField_1.getText().split(" ");
System.out.println(sm+"hai");
for(j=0;j<sm.length&&j<n;j++)
pages[j]=Integer.parseInt(sm[j]);
if(j!=sm.length)
{
	for(;j<sm.length&&j<n;j++)
		pages[j]=0;

}

					}
				do{
				int pg=0;
				for(pg=0;pg<n;pg++)
				{
					 page=pages[pg];
					table.setValueAt(page, 0,chn);
					
					 flag=true;
					for(int j=0;j<f;j++)
						{
						if(page==frame1[j])
						{flag=false; break;}
						}
				
					for(int j=0;j<f && flag;j++)
						{
						if(frame1[j]==a[f-1])
						{k=j;
						 break;}
						}
				
					if(flag)
					{
					frame1[k]=page;
					for(int j=0;j<f;j++)
					{
					  table.setValueAt(frame1[j], j+1,chn);
					
					 }pgf++;
					}
					else
					{
					for(int j=0;j<f;j++)
					{
					 table.setValueAt(frame1[j], j+1,chn);					
					 }
					}
				int p=1;
				b[0]=page;
				for(int j=0;j<a.length;j++)
				{
					if(page!=a[j] && p<f)
					{
					b[p]=a[j];
					p++;
					}
				}
				for(int j=0;j<f;j++)
				{
				a[j]=b[j];
				}
				chn++;
				
				}
				}while(chn!=n);
				textField.setText(pgf+"");
			}
		});
		btnLru.setBounds(153, 11, 89, 23);
		contentPane.add(btnLru);
		
		JButton btnOptimal = new JButton("OPTIMAL");
		btnOptimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int ii,jj;
			for(ii=0;ii<13;ii++)
				for(jj=0;jj<12;jj++)
					table.setValueAt(0, ii,jj);
			    int frames, pointer = 0, hit =0,fault = 0,ref_len;
		        boolean isFull = false;
		        int buffer[];
		        int reference[];
		        int mem_layout[][];
		        frames =5;
		        frames=Integer.parseInt(textField_3.getText());
		        if(chckbxNewCheckBox.isSelected())
		    {
		        ref_len = rand.nextInt(11)+1;
		    }
		    else
		    {
		    	frames=Integer.parseInt(textField_3.getText());
		        ref_len =Integer.parseInt(textField_2.getText());
				    	
		    }
		    	reference = new int[ref_len];
		        mem_layout = new int[ref_len][frames];
		        buffer = new int[frames];
		        for(int j = 0; j < frames; j++)
		                buffer[j] = -1;
		        if(chckbxNewCheckBox.isSelected())
		        {
		        for(int i = 0; i < ref_len; i++)
		        {
		            reference[i] = rand.nextInt(8);
					table.setValueAt(reference[i], 0,i);
		        }
		        }
		        else
		        {
		        	String ss[]=new String[1000];
		        	ss=textField_1.getText().split(" ");
                    int i;
		        	for( i = 0; i < ref_len&&i<ss.length; i++)
			        {
			            reference[i] =Integer.parseInt(ss[i]) ;
						table.setValueAt(reference[i], 0,i);
			        }	
		        	if(i<ref_len)
		        	{
		            	for(; i < ref_len; i++)
				        {
				            reference[i] =0;
							table.setValueAt(reference[i], 0,i);
				        }	
			        		
		        	}
		        }
		        for(int i = 0; i < ref_len; i++)
		        {
		         int search = -1;
		         for(int j = 0; j < frames; j++)
		         {
		          if(buffer[j] == reference[i])
		          {
		           search = j;
		           hit = hit + 1;
		           break;
		          } 
		         }
		         if(search == -1)
		         {
		          if(isFull)
		          {
		           int index[] = new int[frames];
		           boolean index_flag[] = new boolean[frames];
		           for(int j = i + 1; j < ref_len; j++)
		           {
		            for(int k = 0; k < frames; k++)
		            {
		             if((reference[j] == buffer[k]) && (index_flag[k] == false))
		             {
		              index[k] = j;
		              index_flag[k] = true;
		              break;
		             }
		            }
		           }
		           int max = index[0];
		           pointer = 0;
		           if(max == 0)
		            max = 200;
		           for(int j = 0; j < frames; j++)
		           {
		            if(index[j] == 0)
		             index[j] = 200;
		            if(index[j] > max)
		            {
		             max = index[j];
		             pointer = j;
		            }
		           }
		          }
		          buffer[pointer] = reference[i];
		          fault++;
		          if(!isFull)
		          {
		           pointer++;
		              if(pointer == frames)
		              {
		               pointer = 0;
		               isFull = true;
		              }
		          }
		         }
		            for(int j = 0; j < frames; j++)
		                mem_layout[i][j] = buffer[j];
		        }
		        
		        for(int i = 0; i < frames; i++)
		        {
		            for(int j = 0; j < ref_len; j++)
		            {  
		            	//System.out.printf("%3d ",mem_layout[j][i]);
					table.setValueAt(mem_layout[j][i], i+1,j);
		            }
		           // System.out.println();
		        }
		        
		        textField.setText(""+fault);
		      //  System.out.println("The number of Hits: " + hit);
		       // System.out.println("Hit Ratio: " + (float)((float)hit/ref_len));
		        //System.out.println("The number of Faults: " + fault);
			}
		});
		btnOptimal.setBounds(299, 11, 100, 23);
		contentPane.add(btnOptimal);
		
		JButton btnSecond = new JButton("Second Chance");
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ii,jj;
				for(ii=0;ii<13;ii++)
					for(jj=0;jj<12;jj++)
						table.setValueAt(0, ii,jj);
				int n,frm=0;
				frm=Integer.parseInt(textField_3.getText());
				if(chckbxNewCheckBox.isSelected())
				{
			      n=rand.nextInt(8)+1;
				}
				else
				{
					n=Integer.parseInt(textField_2.getText());
                    frm=Integer.parseInt(textField_3.getText());;
				}
				     full=0;
				      numbers=new int[100];
				     ref=new int[100];
				     frame=new int[100];
				     repptr=0;
				     count=0;

						if(chckbxNewCheckBox.isSelected())
						{
			      for(int i=0 ; i<n ; i++)
			      {
			          numbers[i]=rand.nextInt(5);
			          table.setValueAt(numbers[i], 0,i);		              
			      }
						}
						else
						{
							String s[]=new String[10000];
							s=textField_1.getText().split(" ");
					int i;
					for( i=0 ;i<s.length&& i<n ; i++)
				      {
				          numbers[i]=Integer.parseInt(s[i]);
				          table.setValueAt(numbers[i], 0,i);			              
				      }
					for(;i<n;i++)
						numbers[i]=0;
						}
			                   
			      for(int i = 0; i<n ; i++ )
			      {
			          if(search(numbers[i])!=1)
			          {
			              pagefault(numbers[i],frm);
			              for(int j=0;j<full;j++)
			              count++;
			          }
			          for(int j=0;j<full;j++)
			          {
			        	  table.setValueAt(frame[j],j+1 ,i);
							
			          }
			      }
			      textField.setText(""+count);
				
			}
		});
		btnSecond.setBounds(432, 11, 160, 23);
		contentPane.add(btnSecond);
		
		textField = new JTextField();
		textField.setBounds(353, 391, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalPageFaults = new JLabel("Total Page Faults");
		lblTotalPageFaults.setBounds(191, 394, 120, 14);
		contentPane.add(lblTotalPageFaults);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(4, 174, 46, 14);
		contentPane.add(lblInput);
		
		JLabel lblFrame = new JLabel("Frame1");
		lblFrame.setBounds(4, 192, 52, 14);
		contentPane.add(lblFrame);
		
		JLabel lblFrame_1 = new JLabel("Frame2");
		lblFrame_1.setBounds(4, 208, 52, 14);
		contentPane.add(lblFrame_1);
		
		JLabel lblFrame_2 = new JLabel("Frame3");
		lblFrame_2.setBounds(4, 224, 52, 14);
		contentPane.add(lblFrame_2);
		
		JLabel label = new JLabel("");
		label.setBounds(78, 45, 46, 14);
		contentPane.add(label);
		
		 chckbxNewCheckBox = new JCheckBox("Random");
		chckbxNewCheckBox.setBounds(10, 66, 82, 23);
		contentPane.add(chckbxNewCheckBox);
		
		 chckbxNewCheckBox_1 = new JCheckBox("Manual");
		chckbxNewCheckBox_1.setBounds(10, 102, 85, 23);
		contentPane.add(chckbxNewCheckBox_1);

ActionListener actionListener = new ActionHandler();
		chckbxNewCheckBox.addActionListener(actionListener);
		chckbxNewCheckBox_1.addActionListener(actionListener);
		chckbxNewCheckBox.setSelected(true);
		textField_1 = new JTextField();
		textField_1.setBounds(191, 103, 344, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		 lblManulInput = new JLabel("Manul Input");
		lblManulInput.setBounds(192, 84, 68, 14);
		contentPane.add(lblManulInput);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 103, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		 lblNoinput = new JLabel("No.Input");
		lblNoinput.setBounds(112, 84, 68, 14);
		contentPane.add(lblNoinput);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 147, 46, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_2.setVisible(false);
    	textField_1.setVisible(false);
    	lblManulInput.setVisible(false);
    	lblNoinput.setVisible(false);       	
        textField_3.setText("3");
		JLabel lblFrames = new JLabel("Frames");
		lblFrames.setBounds(112, 128, 68, 20);
		contentPane.add(lblFrames);
		
		
	}	 
	
	class ActionHandler implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        JCheckBox checkbox = (JCheckBox) event.getSource();
	        if (checkbox ==chckbxNewCheckBox) {
	             boolean c1 = chckbxNewCheckBox.isSelected();
	            if(c1)
	            	{chckbxNewCheckBox.setSelected(true);
	            	chckbxNewCheckBox_1.setSelected(false);
	            	textField_2.setVisible(false);
	            	textField_1.setVisible(false);
	            	lblManulInput.setVisible(false);
	            	lblNoinput.setVisible(false);       	
	            	
	            	} else
	            	{chckbxNewCheckBox_1.setSelected(true);
	            	textField_2.setVisible(true);
	            	textField_1.setVisible(true);

	            	lblManulInput.setVisible(true);
	            	lblNoinput.setVisible(true);
	            	chckbxNewCheckBox.setSelected(false);
	            	}
	        } else if (checkbox ==chckbxNewCheckBox_1) {
	        	 boolean c1 = chckbxNewCheckBox_1.isSelected();
		            if(c1==false)
		            	{chckbxNewCheckBox.setSelected(true);
		            	chckbxNewCheckBox_1.setSelected(false); 	textField_2.setVisible(false);
		            	textField_1.setVisible(false);
		            	lblManulInput.setVisible(false);
		            	lblNoinput.setVisible(false);   } else
		            	{chckbxNewCheckBox_1.setSelected(true);
		            	chckbxNewCheckBox.setSelected(false);
		            	textField_2.setVisible(true);
		            	textField_1.setVisible(true);

		            	lblManulInput.setVisible(true);
		            	lblNoinput.setVisible(true);
		            	}  } 
	    }
	}

}
