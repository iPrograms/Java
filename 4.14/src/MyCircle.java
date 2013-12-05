import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyCircle extends JPanel {

	Color color = Color.black;
	Ellipse2D.Double circle = new Ellipse2D.Double(250, 250,250, 250);
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponents(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(color);
		g2.fill(circle);
	}

	public void setColor(Color color) {
		this.color = color;
		
		
	}
}
