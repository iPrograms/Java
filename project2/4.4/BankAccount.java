
public class BankAccount implements Comparable<BankAccount> {

	private String person;
	private int account_number;
	private int savings;
	
	
	public BankAccount(String person, int acnum, int savings, int check){
		this.person = person;
		this.account_number = acnum;
		this.savings = savings;
	
	}
	
	@Override
	public int compareTo(BankAccount other) {
		// TODO Auto-generated method stub
		
		if(this.savings < other.savings){
			return -1;
		}
		if(this.savings > other.savings){
			return 1;
		}
		return 0;
	}
	
	public String toString(){
		String results = "";
		
		results+= this.person + "  "  + this.savings;
		
		return results;
	}
}
