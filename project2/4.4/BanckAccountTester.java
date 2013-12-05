
import java.util.*;
public class BanckAccountTester {

	/**
	 * @param args
	 */
	
	public static void printArray(ArrayList<BankAccount> array){
	
		for(int a =0; a!= array.size();a++){
			System.out.println(array.get(a).toString());
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
			
		list.add(new BankAccount("manzoor",920078,12000,50));
		list.add(new BankAccount("tester",23323,6767,60));
		list.add(new BankAccount("rich,guy",898899,1900000,908999));
		list.add(new BankAccount("poor,guy",878788,10,3));
		list.add(new BankAccount("Igor",954744,96,45));
		list.add(new BankAccount("Erick",2323,1000000,10));
		list.add(new BankAccount("Sam",898339,500,90));
		list.add(new BankAccount("Dick",878788,0,100));
		
		Collections.sort(list);
		
		printArray(list);
	}
	
	
	
}
