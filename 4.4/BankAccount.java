/*
 * @author Manzoor Ahmed
 * CS 151
 * **/
public class BankAccount implements Comparable<BankAccount> {

	//instance var
	private String person;
	private int account_number;
	private int savings;
	
	/***************CONSTRUCTOR**********************************
	 * @param person, the account owner
	 * @param acnum, the account number
	 * @param savings, the savings account
	 * @param check, the checking account
	 * ****************************************************************/
	public BankAccount(String person, int acnum, int savings, int check){
		this.person = person;
		this.account_number = acnum;
		this.savings = savings;
	}
	
	@Override
	/*@param other, the BankAccount 
	 *@return -1 if savings is less
	 *@return 1 if savings is greater
	 *@return 0 if even
	 * **/
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
}//end
