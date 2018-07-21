package osProject;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class DiskSchedulerUI extends JFrame implements ActionListener{
	

	private JPanel inputPanel;
	//private JPanel graphPanel;
	private JPanel buttonPanel;
	private JComboBox<String> algorithms;

	int startingPoint = 53;

	String[] alogorithmNames = { "FCFS", "SSTF", "SCAN", "CSCAN", "LOOK","CLOOK" };
	String[] btns = { "NRequests", "Random Requests", "Draw Graph" };
	// private JButton button;
	private JButton button;

    //private JLabel head;
	int[] diskPosition;
	int selected;

	private JTextField[] inputField;
	private JScrollPane jScrollPane;

	public int numOfCyn = 38;

	public DiskSchedulerUI() {
		super("Disk Scheduling Algorithm Graph");
		setSize(new Dimension(450, 300));
		setLocationRelativeTo(null);
		setVisible(true);		
		setState(JFrame.NORMAL);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
		
	public void initComponents() 
	{

		inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder("I/O Request Information"));
		inputPanel.setPreferredSize(new Dimension(250, 200));
		//JLabel head;
		// inputPanel.setBackground(Color.yellow);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(150, 200));
		buttonPanel.setBorder(new TitledBorder("Buttons"));

		//head = new JLabel("Head Possition: ");

		add(inputPanel);
		add(buttonPanel);
		
		setButtonPanel();
	}

	public void setInputPanel() {
		inputPanel.removeAll();

		JPanel valuePanel = new JPanel();

		numOfCyn = Integer.parseInt(JOptionPane.showInputDialog(this,
				"Enter the number of I/O Requests: "));
		valuePanel.setLayout(new GridLayout(numOfCyn, 2, 10, 10));

		inputField = new JTextField[numOfCyn];

		for (int i = 0; i < inputField.length; i++) {
			JLabel label = new JLabel("Request " + (i + 1));
			label.setFont(new Font("Vardana", Font.BOLD, 14));

			inputField[i] = new JTextField(2);
			inputField[i].setHorizontalAlignment(JTextField.CENTER);

			valuePanel.add(label);
			valuePanel.add(inputField[i]);
		}

		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new java.awt.Dimension(200, 150));

		jScrollPane.setViewportView(valuePanel);
		jScrollPane.validate();
		inputPanel.add(jScrollPane);
		inputPanel.revalidate();
	}

	public void setButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());

		for (int i = 0; i < btns.length; i++) {
			button = new JButton(btns[i]);
			button.addActionListener(this);
	
			// button.setName(nameOfTheButtons[i]);
			buttonPanel.add(button);
		}

		algorithms = new JComboBox<>(alogorithmNames); //JComboBox is generic class
		buttonPanel.add(algorithms);
		buttonPanel.revalidate();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("NRequests")) {
			setInputPanel();
		} else if (e.getActionCommand().equals("Random Requests")) {
			for (int i = 0; i < numOfCyn; i++) {
				long random = (long) (Math.random() * 200 + 1);
				inputField[i].setText("" + random);
			}
		} else if (e.getActionCommand().equals("Draw Graph")) {
			selected = algorithms.getSelectedIndex();
			diskPosition = new int[numOfCyn + 1];

			for (int i = 0; i < numOfCyn; i++) {
				diskPosition[i + 1] = Integer.parseInt(inputField[i].getText());
			}
			startingPoint = Integer.parseInt(JOptionPane.showInputDialog(this,
					"Enter starting point: "));
			diskPosition[0] = startingPoint;


			if (selected == 0) {
				DiskGraphPanel.Draw(new DiskSchedulerGraph(diskPosition),"FCFS",startingPoint);
						
			} else if (selected == 1) {				 
				SSTF s = new SSTF();
				int[] sstf =s.getSSTF(diskPosition, startingPoint);
				int[] temp = new int[sstf.length - 1];
				for (int i = 0; i < sstf.length - 1; i++) {
					temp[i] = sstf[i];				
				}
				DiskSchedulerGraph dg = new DiskSchedulerGraph(temp);
				DiskGraphPanel.Draw(dg,"SSTF",startingPoint);	
				
			} 
			else if (selected == 2) {
				ScanDisk scan = new ScanDisk(diskPosition, startingPoint);				
				DiskGraphPanel.Draw(new DiskSchedulerGraph(scan.calculateScanDisk()),"Scan",startingPoint);
							
			} 
			else if (selected == 3) {
				CScanDisk cscan = new CScanDisk(diskPosition, startingPoint);				
				DiskGraphPanel.Draw(new DiskSchedulerGraph(cscan.calculateScanDisk()),"CScan",startingPoint);			
			
			}
			else if (selected == 4) {
				Look look = new Look(diskPosition, startingPoint);
				DiskGraphPanel.Draw(new DiskSchedulerGraph(look.calculate()),"Look",startingPoint);
			
			} 
			else if (selected == 5) {
				 Clook cl= new Clook(diskPosition, startingPoint);
				 DiskGraphPanel.Draw(new DiskSchedulerGraph(cl.calculate()),"Clook",startingPoint);					
			}
		}
	}
}
	

