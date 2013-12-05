import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class CarShape implements MoveableShape {

	int x;
	int y;
	private int width;
	
	public CarShape(int x,int y, int width){
		this.x= x;
		this.y=y;
		this.width=width;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		
		Rectangle2D.Double body = new Rectangle2D.Double(x,y+width/6,width-1,width/6);
		
		Ellipse2D.Double frontTire = new Ellipse2D.Double(x+width/6,y+width/3,width/6,width/6);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(x+width *2/3,y+width/3,width/6,width/6);
		
		Point2D.Double r1 = new Point2D.Double(x+width/6,y+width/6);
		Point2D.Double r2 = new Point2D.Double(x+width/3,y);
		Point2D.Double r3 = new Point2D.Double(x+width*2/3,y);
		Point2D.Double r4 = new Point2D.Double(x+width*5/6,y+width/6);
		
		Line2D.Double frontWindshield = new Line2D.Double(r1,r2);
		Line2D.Double roofTop = new Line2D.Double(r2,r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3,r4);
		
		g2.fill(frontWindshield);
		g2.fill(frontTire);
		g2.fill(rearTire);
		g2.setColor(Color.red);
		g2.fill(body);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	
	}

	@Override
	public void translate(int dx, int dy) {
		
		x+=dx;
		y+=dy;	
	}
}
