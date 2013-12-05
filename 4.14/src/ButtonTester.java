import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*****************************
 * @author Manzoor Ahmed
 * CS151
 * *************************/
public class ButtonTester {

	public static void main(String[] args){
		
		final MyCircle circle = new MyCircle();//circle
		
		//frame width,height
		final int WIDTH = 700;
		final int HEIGHT = 700;
		//holds buttons
		JPanel buttonPanel = new JPanel();	
		
		JFrame frame = new JFrame("Circle");
		//set dim
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//create buttons
		final JButton b1 = new JButton("Red");
		final JButton b2 = new JButton("Green");
		final JButton b3 = new JButton("Blue");
		final JButton reset = new JButton("Reset");
		
		//text label for testing ActionListerners
		final JLabel l = new JLabel();
		
		frame.setLayout(new FlowLayout());
		//add buttons
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(reset);
		
		//make circle 200,200
		circle.setPreferredSize(new Dimension(700,700));
		//put buttons on top		
		frame.add(buttonPanel,BorderLayout.NORTH);
	
		frame.add(circle);
		//kill thread	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		//add action to b1
		b1.addActionListener(new 
				ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent event) {
							circle.setColor(Color.red);
							circle.repaint();
							
				}
		});
		
		//add actionlistener to b2
		b2.addActionListener(new 
			ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event){
				circle.setColor(Color.green);
				circle.repaint();
			}
		});
		//add action to b3
		b3.addActionListener(new 
				ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent event){
					circle.setColor(Color.blue);
					circle.repaint();
				}
			});
		
		//add action to reset
		reset.addActionListener(new 
				ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent event){
					circle.setColor(Color.black);
					circle.repaint();
				}
			});
	}	
}
