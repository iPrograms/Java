
package reservation;

/**
 * @author Manzoor Ahmed
 */
public class Seat {

       public boolean isEmpty = true;
       public  Passenger pass;

       public Seat(){

       }
       public Seat(Passenger pass){
         add(pass);
       }


       private void add(Passenger p){
           this.pass =p;
       }
       public void setPerson(Passenger p){
           this.pass=p;
       }
       public void seatIstaken(){
           this.isEmpty = false;
       }

    @Override
       public String toString(){
           return "Passenger name :  " +this.pass.getName();
       }
}
