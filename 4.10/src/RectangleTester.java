
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**************
 * Manzoor Ahmed
 * CS151
 * *************/
public class RectangleTester {

	public static void main(String[] args){
		//holds Rectangle2D.Double 
		ArrayList<Rectangle2D.Double> rectangle = new ArrayList<Rectangle2D.Double>();
		
		//create Rectangle2D
		Rectangle2D.Double rect = new Rectangle2D.Double(23,11,100,200);
		Rectangle2D.Double rect1 = new Rectangle2D.Double(2,20,100,300);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(12,31,100,600);
		Rectangle2D.Double rect3 = new Rectangle2D.Double(3,4,50,9800);
		Rectangle2D.Double rect4 = new Rectangle2D.Double(43,31,10,20);
		Rectangle2D.Double rect5 = new Rectangle2D.Double(9,20,100,120);
		Rectangle2D.Double rect6 = new Rectangle2D.Double(323,46,50,9800);
		Rectangle2D.Double rect7 = new Rectangle2D.Double(433,61,10,20);
		Rectangle2D.Double rect8 = new Rectangle2D.Double(92,50,100,120);
		//add to the rectangle
		rectangle.add(rect);
		rectangle.add(rect1);
		rectangle.add(rect2);
		rectangle.add(rect3);
		rectangle.add(rect4);
		rectangle.add(rect5);
		rectangle.add(rect6);
		rectangle.add(rect7);
		rectangle.add(rect8);
		
		Comparator<Rectangle2D.Double>  comp = new RectangleComparator();
		//sort
		Collections.sort(rectangle, comp);
		//print
		for(int start =0; start != rectangle.size(); start++){
			System.out.println(rectangle.get(start).toString());
		}
	}
}
