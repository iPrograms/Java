
public class Balcony {
	
	private Seat[] seats;               //seats for the balcony
	 int empty =0;
	
	Balcony(){
		seats = new Seat[100];
	}
	
	public boolean makeSeats(String s, int price){
		
		for(int i=0; i!=100;i++){
			
			Seat seat = new Seat();
			seats[i] = seat;
			
			String m = Integer.toString(i);
			seats[i].setSeatNumber(s+m);
			seats[i].setSeatPrice(price);
		}
		return true;
	}
	
	public void setCustSeatPrice(int price,int price1,String s, Seat se[]){
			
		int seatsize = se.length;
		
			for(int i=0; i<=se.length;i++){
				
				if(seatsize <= 24){
					
					String k = Integer.toString(i);
					se[i] = new Seat();
					se[i].setSeatNumber(s+k);
					se[i].setSeatPrice(price);	
				}
				else{
					String k = Integer.toString(i);
					se[i] = new Seat();
					se[i].setSeatNumber(s+k);
					se[i].setSeatPrice(price1);	
				}
			}
	}
	
	public boolean add(String id){
		
		seats[empty] = new Seat();			                     //seat for person
		seats[empty].person = new Person(id);                    //the person
		seats[empty].setSeatNumber("b"+Integer.toString(empty)); //seat number
		seats[empty].isTaken = true;                             //seat is taken
		
		if(empty<=24){
			seats[empty].seat_price = 50;
		}
		else{
			seats[empty].seat_price = 55;
		}
		empty++; // next empty seat
		return true;
	}
	//show seats
	public void printSeats(){
		for(int i=0; i!=seats.length; i++){
			System.out.println("Seat Number: " +seats[i].getSeatNumber() + "----" + "Price:    $"+this.seats[i].getSeatPrice() );
		}
	}
	
	public void printCustomSeats(Seat seats[], int size){
		for(int i=0; i<=size; i++){
			System.out.println("Seat Number: "+this.seats[i].getSeatNumber() + "----" + "Price:    $"+this.seats[i].getSeatPrice() );
		}
	}
	
	public void printCustomSeats(Seat seats[]){
		for(int i=0; i<=100; i++){
			System.out.println("Seat Number: "+this.seats[i].getSeatNumber() + "----" + "Price:    $"+this.seats[i].getSeatPrice() );
		}
	}
}
