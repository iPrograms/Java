import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JFrame;

/******************************
 *@author Manzoor Ahmed
 * CS151
 * ******************************/

public class ClockIcon extends JPanel {
	
	double ciry;//y 
	double cirx;//x
	
	////////////////////
     private static Calendar now = Calendar.getInstance();  
	//get current hour,minute and seconds
	final static int hour = now.get(Calendar.HOUR);	
	final static int minute = now.get(Calendar.MINUTE);
	final static int second = now.get(Calendar.SECOND);
	
	
	@Override
	protected void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;	 	
		//draw circle 
		Ellipse2D.Double circle = new Ellipse2D.Double(100,100,130,130);
		
		cirx=circle.getCenterX();//x
		ciry=circle.getCenterY();//y
		//second hand x,y value
		double xs = (int) (Math.cos(second * Math.PI / 30 - Math.PI / 2) * 45 + cirx);
        double ys = (int) (Math.sin(second * Math.PI / 30 - Math.PI / 2) * 45 + ciry);
        //minute hand x,y value
        double xm = (int) (Math.cos(minute * Math.PI / 30 - Math.PI / 2) * 40 + cirx);
        double ym = (int) (Math.sin(minute * Math.PI / 30 - Math.PI / 2) * 40 + ciry);
        //hour hand x,y value
        double xh = (int) (Math.cos((hour*30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 30
                   + cirx);
        double yh = (int) (Math.sin((hour*30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 30
                   + ciry);
		
        //set background red
		g2.setPaint(Color.white);
		g2.fill(circle);
		g2.setPaint(Color.black);
		
		//draw minute hand
		g.drawLine((int)cirx, (int)ciry-1, (int) xm,(int) ym);
        g.drawLine((int)cirx-1, (int) ciry, (int)xm, (int)ym);
        
        //draw hour hand
        g.drawLine((int)cirx, (int)ciry-1, (int)xh, (int)yh);
        g.drawLine((int)cirx-1, (int)ciry, (int)xh, (int)yh);
        
        //draw second hand
        g.drawLine((int)cirx, (int)ciry, (int)xs, (int)ys);

	}
}
