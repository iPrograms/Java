
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ChangeListener{
	
	static int startStones =3;
	
	public static void main(String[] args){

		int player1=0;  
		int player2=0;
		
		/**ALL LABELS */
		JButton undo = new JButton("UNDO");
		JButton start = new JButton("Start");
		JLabel defstones = new JLabel ("Enter 4 if you need four stones in each pit :  ");
		JLabel score = new JLabel("First Player     :    " + Integer.toString(player1)+"      ");
		JLabel score1 = new JLabel("Second Player   :    " + Integer.toString(player2)+"      ");
		JLabel message = new JLabel("Message        :    "+ Integer.toString(startStones));
		
	    final JFrame frame = new JFrame("Mancala game");
	    JPanel mainPanel = new JPanel();
	    JPanel stonePanel = new JPanel();
	     
	    //panels for each side of the mainPanel
	    final JPanel leftPanel = new JPanel();
	    final JPanel rightPanel = new JPanel();
	    final JPanel topPanel = new JPanel();
	    final JPanel downPanel = new JPanel();
	    JPanel centerPanel = new JPanel();
	    final JPanel centerInner = new JPanel(new FlowLayout());	    
	    
	    //set size of all panels
	    
	    leftPanel.setPreferredSize(new Dimension(150,frame.getHeight()-200));
	    rightPanel.setPreferredSize(new Dimension(150,frame.getHeight()-200));
	    topPanel.setPreferredSize(new Dimension(frame.getWidth(),130));
	    
	    //background color of the panels
	    leftPanel.setBackground(Color.black);
	    rightPanel.setBackground(Color.red);
	    topPanel.setBackground(Color.lightGray);
	    downPanel.setBackground(Color.gray);
	    centerPanel.setBackground(Color.orange);
	    centerInner.setBackground(Color.orange);  	    
	    mainPanel.setLayout(new BorderLayout());
	 
	    stonePanel.add(defstones);
	    
	    ////////////////////////// hide panels
	    topPanel.setVisible(false);
	    downPanel.setVisible(false);
	    leftPanel.setVisible(false);
	    rightPanel.setVisible(false);
	    
	    //add to top panel
	    topPanel.add(score);
	    topPanel.add(score1);
	    topPanel.add(message);
	    
	    //input for number of stones
	    final JTextField  input = new JTextField("max 4, min 3");
	    input.setSize(20, 30);
	    input.setBackground(Color.white);
	    
	    centerInner.add(defstones);
	    centerInner.add(input); 
	    centerInner.add(start);
	    
        ////////////////////////////////////////////////////
	    start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(event.getActionCommand()=="Start"){
					centerInner.setVisible(false);
					frame.remove(centerInner);
				     
					 if(!input.getText().trim().equals("4")){
						 startStones=3;
					 }
					 else{
						 startStones=4;
					 }
					 
					System.out.println(startStones);
					topPanel.setVisible(true);
					leftPanel.setVisible(true);
					rightPanel.setVisible(true);
					downPanel.setVisible(true);
					frame.repaint();
				}
				else if(event.getActionCommand()==null){
					startStones=3;
					System.out.println(startStones);
				}
				System.out.println("Select Stones");
			}
	    });
	    
	    centerPanel.add(centerInner);
	    
	    /////////////////////////////////////////////////////////
	    //
	    //  work needs to be done
	    //  add images  to centerPanel
	    //  add actionlistener to centerPanel
	    //
	    ////////////////////////////////////////////////////////
	    
	    
	    //mainPanel has the all the panels
	    mainPanel.add(centerPanel, BorderLayout.CENTER);
	    mainPanel.add(topPanel, BorderLayout.NORTH);
	    mainPanel.add(downPanel,BorderLayout.SOUTH);
	    mainPanel.add(leftPanel,BorderLayout.WEST);
	    mainPanel.add(rightPanel,BorderLayout.EAST);
		downPanel.add(undo,BorderLayout.WEST);
		
		mainPanel.setVisible(true);
		frame.add(stonePanel, BorderLayout.CENTER);
		frame.setSize(900,500);
		frame.setVisible(true);
		
		frame.add(mainPanel);
		
		frame.setContentPane(mainPanel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
		
	public void stateChanged(ChangeEvent changeevent)
    {
		this.repaint();
    }
		
	}

