
public class EastBalcony extends Balcony {

	Seat[] seats = new Seat[100];
	
	public void makeEastBalcony(){
	
		for(int i=0; i<=24;i++){
			
			seats[i] = new Seat();
			
			String m = Integer.toString(i);
			seats[i].setSeatNumber("ea"+m);
			seats[i].setSeatPrice(50);
		}
		
		for(int i=25; i!=100;i++){
					
			seats[i] = new Seat();
					
			String m = Integer.toString(i);
			seats[i].setSeatNumber("ea"+m);
			seats[i].setSeatPrice(55);
		}
	}
	
	public void printEastBalcony(){
		for(int i=0; i!=seats.length; i++)
		{
			System.out.println("Seat Number: " +this.seats[i].getSeatNumber() + "----" + "Price:    $"+this.seats[i].getSeatPrice());
		}
	}
}
