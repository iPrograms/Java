
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle2D.Double>{

	double x,y;
	double widht,height;
	
	@Override
	public int compare(Rectangle2D.Double arg0, Rectangle2D.Double  arg1) {
		//same
		if(arg0.x-arg1.x ==0){
			if(arg0.y-arg1.y ==0){
				if(arg0.width - arg1.width ==0){
					if(arg0.height - arg1.height==0){
						return 0;
					}
				}
			}
		}
		//triangl1 is > than triangle0 
		if(arg1.x-arg0.x > 0){
			if(arg1.y-arg0.y > 0){
				if(arg1.width-arg0.width > 0){
					if(arg1.height-arg0.height >0){
						return 1;
					}
				}
			}
		}
		//triangle0 is < as triangle 1
		
		if(arg0.x-arg1.x < 0){
			if(arg0.y-arg1.y < 0){
				if(arg0.width-arg1.width < 0){
					if(arg0.height-arg1.height < 0){
						return -1;
					}
				}
			}
		}
		
		return -1;
		
	}
	

	
}
