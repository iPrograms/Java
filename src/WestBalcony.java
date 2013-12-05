
public class WestBalcony extends Balcony {

	Seat[] seats = new Seat[100];
	
	public void makeBalconySeats(){
		super.makeSeats("west",50);
	}
	
	public void printWestBalconySeats(){
		super.printSeats();
	}
	
	public void showAvWestBalconySeats(){
		
		for(int beg =0;beg!=seats.length;beg++){
			if(seats[beg].isTaken==false){
				System.out.print("Avalible : Yes   " +seats[beg].seat_num);
			}
		}
	}
}
