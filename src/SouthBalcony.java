
public class SouthBalcony extends Balcony{

	Seat seats[];
	
	public SouthBalcony(){
		 seats = new Seat[50];
	}
	
	public void  createSouthSeats()
	{
		for(int i=0; i!=25; i++){
			
			String kk = Integer.toString(i);
			seats[i] = new Seat();
			seats[i].seat_price = 50;
			seats[i].seat_num = kk;
		}
		
		for(int i=25; i!=seats.length; i++){
			String mm = Integer.toString(i);
			seats[i] = new Seat();
			seats[i].seat_price = 55;
			seats[i].seat_num = mm;
		}
	}//end createSouthSeats
	
	public void printSouthSeats()
	{
		
		for(int start = 0; start != seats.length; start++){
			System.out.println("Seat Number: " +this.seats[start].getSeatNumber() + "----" + "Price:    $"+this.seats[start].getSeatPrice() );
		}
	}
	//give seat to the person
	public void setSouthPerson(Person person, int seatnumber){
		this.seats[seatnumber].person = person;
	}
	
	public boolean takenSeats(){
		for(int st=0;st!=seats.length;st++){
			if(seats[st].isTaken==false){
				return true;
			}
		}
		return true;
	}
	
}
