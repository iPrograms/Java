
/**
 * @author Manzoor Ahmed
 *
 */

public class Seat{

	//seat number
	String seat_num;
	//seat price
	int seat_price;
	boolean isTaken = false;
	Person person;  //person who reserves the seat
	
	/**@param price, price of seat
	 * */
	public void setSeatPrice(int price){
		this.seat_price = price;
	}
	
	/**@param number, the seat number
	 * */
	public void setSeatNumber(String number){
		this.seat_num = number;
	}
	
	//get the seat number
	public String getSeatNumber(){
		return this.seat_num;
	}
	
	//get seat price
	public int getSeatPrice(){
		return this.seat_price;
	}
	
	/**@param p, person who reserves
	 **/
	public void reserverSeat(Person p){
		this.person =p;
	}
	//remove the person from the seat
	public void removePerson(){
		this.person = null;
	}
}
