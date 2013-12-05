
import java.util.*;

public class MaximumTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		String m1 = new String("mq");
		String m2 = new String("Igor Sorokin");
		String m3 = new String("Erik Macias");
		String m4 = new String("Taco bell");
		
		Comparator<String> comp = new Max();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		System.out.println(maximum(list,comp));
	}
	
	public static String maximum(ArrayList<String> a, Comparator<String> c){
		Collections.sort(a,c);
		return a.get(a.size()-1);	
	}

}
