
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collections;

public class RectangleTester {

	public static void main(String[] args){
		
		ArrayList<Rectangle2D.Double> rectangle = new ArrayList<Rectangle2D.Double>();
		
		Rectangle2D.Double rect = new Rectangle2D.Double(23,11,100,200);
		Rectangle2D.Double rect1 = new Rectangle2D.Double(2,20,100,300);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(12,31,100,600);
		Rectangle2D.Double rect3 = new Rectangle2D.Double(3,4,50,9800);
		Rectangle2D.Double rect4 = new Rectangle2D.Double(43,31,10,20);
		Rectangle2D.Double rect5 = new Rectangle2D.Double(9,10,100,120);
		
		rectangle.add(rect);rectangle.add(rect1);rectangle.add(rect2);rectangle.add(rect3);rectangle.add(rect4);rectangle.add(rect5);
		Collections.sort(rectangle, new RectangleComparator());
		
		for(int start =0; start != rectangle.size(); start++){
			System.out.print(rectangle.get(start).x + "," +rectangle.get(start).y +"\t Width: Height\t");
			System.out.print(rectangle.get(start).width + ":" +rectangle.get(start).height );
			System.out.println("");
		}
		
		
	}
}
