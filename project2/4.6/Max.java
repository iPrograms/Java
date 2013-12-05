import java.util.Comparator;
/*Manzoor Ahmed
 * **/
public class Max implements Comparator<String> {

	
	public int compare(String one, String two){
		if(one.length() < two.length()){
			return -1;
		}
		else if(one.length() > two.length()){
			return 1;
		}
		return 0;
	}
}
