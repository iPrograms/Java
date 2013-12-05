import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class CarTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final MoveableShape shape
            = new CarShape(0, 0, CAR_WIDTH);

      ShapeIcon icon = new ShapeIcon(shape,
            ICON_WIDTH, ICON_HEIGHT);

       final ShapeIcon[] cars = new ShapeIcon[10];
      
      
      for(int i=0; i!=cars.length;i++){
    	  cars[i] = new ShapeIcon(shape,ICON_WIDTH,ICON_HEIGHT);
      }
      
      final JLabel label = new JLabel(icon);
      final JLabel label2 = new JLabel(cars[0]);
      final JLabel label3 = new JLabel(cars[1]);
     
      label.setBackground(Color.red);
      frame.setLayout(new FlowLayout());
      frame.add(label);
      frame.add(label2);
      frame.add(label3);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                    shape.translate(1, 0);
                    label.repaint(); 
            }
         });
      t.start();
      
      Timer t1 = new Timer(DELAY, new
    	         ActionListener()
    	         {
    	            public void actionPerformed(ActionEvent event)
    	            {
    	                    shape.translate(1, 0);
    	                    label2.repaint(); 
    	            }
    	         });
    	      t1.start();
    	      
    	      Timer t3 = new Timer(DELAY, new
    	    	         ActionListener()
    	    	         {
    	    	            public void actionPerformed(ActionEvent event)
    	    	            {
    	    	                    shape.translate(1, 0);
    	    	                    label3.repaint(); 
    	    	            }
    	    	         });
    	    	      t3.start();
   }

   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
