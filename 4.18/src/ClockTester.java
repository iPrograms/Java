
import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * @author Manzoor Ahmed
 * CS151
 * **/
public class ClockTester {

	public static void main(String[] args){
				
		final ClockIcon clock = new ClockIcon();
		clock.setPreferredSize(new Dimension(300,300));
		JFrame frame = new JFrame("My Clock");
		frame.add(clock);
		
		frame.setPreferredSize(new Dimension(400,400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		/**DONT NEED TO ADD LISTENERS
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				now.setTimeInMillis(System.currentTimeMillis());	
				    clock.second(second);
					clock.repaint();		
			}
		};
			
		ActionListener listener1 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				now.setTimeInMillis(System.currentTimeMillis());
					clock.minute(minute);
					clock.repaint();
			}
		};
			
		ActionListener listener2 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				    now.setTimeInMillis(System.currentTimeMillis());
					clock.minute(hour);
					clock.repaint();
			}
		};
		
		Timer t = new Timer(10000,listener);
		t.start();
		
		Timer t1 = new Timer(60000,listener1);
		t1.start();
		
		Timer t2 = new Timer(3600000,listener2);
		t2.start();
		**/
	}
}