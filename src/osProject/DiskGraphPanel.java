package osProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DiskGraphPanel extends JFrame{
	private JPanel graphPanel;
	private JLabel head;

	/**
	 * Launch the application.
	 */
	public static void Draw(DiskSchedulerGraph panel,String s,int pos) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiskGraphPanel frame = new DiskGraphPanel(panel,s,pos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setGraphPanel(DiskSchedulerGraph panel) {
		graphPanel.setLayout(new FlowLayout());
		graphPanel.removeAll();
		graphPanel.setPreferredSize(new Dimension(600, 400));

		graphPanel.add(panel);
System.out.println(panel+"fgxf");
		head.setFont(new Font("Vardana", Font.BOLD, 14));
		head.setForeground(Color.BLUE);
		head.setText("Algorithm: " 
				+ " ^_^ Head Starting point: ");
		graphPanel.add(head);
		graphPanel.repaint();
		graphPanel.revalidate();
	}


	public DiskGraphPanel(DiskSchedulerGraph panel,String s,int pos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		graphPanel = new JPanel();
		// graphPanel_.setBorder(new TitledBorder("Graph"));
		graphPanel.setPreferredSize(new Dimension(600, 400));
		graphPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		graphPanel.setLayout(new BorderLayout(0, 0));
		head = new JLabel("Head Possition: ");
		
		graphPanel.setLayout(new FlowLayout());
		graphPanel.removeAll();
		graphPanel.setPreferredSize(new Dimension(600, 400));
		head.setFont(new Font("Vardana", Font.BOLD, 14));
		head.setForeground(Color.BLUE);
		head.setText("Algorithm " 
				+ s+"--Head Starting point "+pos);
		graphPanel.add(head);		
		graphPanel.add(panel);
		setContentPane(graphPanel);		
		
	}

}
