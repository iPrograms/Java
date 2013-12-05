
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Comparator;
/***
 * Manzoor Ahmed
 * CS151
 * */

public class RectangleComparator implements Comparator<Rectangle2D.Double>{

	double x,y;   //x y cordinates of the Rectangle
	double widht,height;//width and height
	
	@Override 
	public int compare(Rectangle2D.Double arg0, Rectangle2D.Double  arg1) {
	    //if the same
		if(arg0.x-arg1.x ==0){
			
			if(arg0.y-arg1.y ==0){
				
				//if width is equal
				if(arg0.width - arg1.width ==0){
					
					if(arg0.height - arg1.height==0){
						return 0;
					}
					//if height is bigger
					if(arg0.height-arg1.height>0){
						return 1;
					}
					// if height is small
					if(arg0.height-arg1.height< 0){
						return -1;
					}
				}
				//if width is bigger
				else if(arg0.width-arg1.width >0){
					return 1;
				}
				else {
					return -1;
				}
			}
			//if y is less
			else if(arg0.y-arg1.y < 0){
				return 1;
			}
			else {
				return -1;
			}
		}
		//if x is greater
		else if(arg0.x-arg1.x > 0){
			return 1;
		}
		//if x is smaller
		else if(arg0.x-arg1.x< 0){
			return -1;
		}
	return -1;
	}
}
