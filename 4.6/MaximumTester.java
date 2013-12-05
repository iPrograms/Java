
import java.util.*;
/*
 * @author Manzoor Ahmed
 * CS151
 * **/
public class MaximumTester {

	public static void main(String[] args) {
		//list to hold names
		ArrayList<String> list = new ArrayList<String>();
		
		String m1 = new String("mq");
		String m2 = new String("Igor Sorokin");
		String m3 = new String("Erik Macias");
		String m4 = new String("Taco bell");
		
		Comparator<String> comp = new Max();
		//add to list
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		//print the string with max chars
		System.out.println("Maximum String found :"+maximum(list,comp));
	}
	/*
	 * @param ArrayList<String> a, the array with string objects
	 * @param c, the Comprarator object to compare string with
	 * @return String with max chars
	 * **/
	public static String maximum(ArrayList<String> a, Comparator<String> c){
		Collections.sort(a,c);
		return a.get(a.size()-1);	
	}
}
