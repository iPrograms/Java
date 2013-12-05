
package reservation;
/**
 *
 * @author Manzoor Ahmed
 * CS 151 
 * TU/TH 9:00AM
 * start date: 09-7-2012
 * end   date: 09-18-2012  
 * ReservationSystem.java takes additional input input.txt file to read from.
 */
import java.util.*;
import java.io.*;
public class ReservationSystem {

    public static void main(String[] args) {
        
       String filen = args[0].toString();

    	   WriteFile writefile = new WriteFile();
    	   try{
    	   File makefile = new File(filen);
    	   makefile.createNewFile();
    	   }
    	   catch(IOException ex){
    		   ex.getMessage();
    	   }
	       Economy economy = new Economy();
	       First   first  = new First();
	       
	       //get data from the file, and added to the seat
	       economy.addFromFile("a.txt");
	       economy.addFromFile("b.txt");
	       economy.addFromFile("c.txt");
	       economy.addFromFile("d.txt");
	       economy.addFromFile("e.txt");
	       economy.addFromFile("f.txt");
	       first.addFromFile("first.txt");
	   
	        while(true){
	
	        //prompt
	        System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations, Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
	        Scanner input = new Scanner(System.in);
	
	        String a = input.nextLine(); //get choice
	
	                if((a.equalsIgnoreCase("G")) || (a.equalsIgnoreCase("Group"))){
	
	                  System.out.print("Group name  :");
	                  Scanner gn = new Scanner(System.in);
	                  String gname = gn.nextLine().toString();// name
	
	                  String groupname;
	                  
	                  while(true)
	                  {
	                        System.out.print("Names       : ");
	                        Scanner g = new Scanner(System.in);
	                        groupname = g.nextLine();           //group people
	
	                        if(groupname.endsWith(",")){
	                            System.out.println("Please provide names seperated by ,.");
	                            continue;
	                        }
	                        if(!groupname.contains(",")){
	                            System.out.println("Please seperate names by ,.");
	                            continue;
	                        }
	                        break;
	                    }//end while
	
	                    String gservice;
	                    Scanner ser;
	
	                    while(true){
	
	                        System.out.print("Service Class: Economy, First. ");
	                        ser = new Scanner(System.in);
	                        gservice = ser.next();
	
	                        if(gservice.equalsIgnoreCase("first")){
	                           
	                        	//add group to first class
	                        	boolean added = first.addGroup(groupname,gname);
	                        	if(added ==true){
	                        		writefile.emptyFile("first.txt");
	                        		writefile.emptyFile("avfirst.txt");
	    		                	writefile.emptyFile("nvfirst.txt");
	    		                	
	                        		System.out.println("Group" + groupname + " added! ");
	                        		first.writeToFile("first.txt");
	                        	}
	                        	else{
	                        		System.out.println("Not enough seat to add all group memebers.");
	                        	}
	                        	break;
	                        }
	                        else if(gservice.equalsIgnoreCase("economy")){
	                            
	                        	//add group to economy class
	                        	boolean m =economy.addGroup(groupname,gname);
	                        	if(m==true){
	                        		//update files
	                        		writefile.emptyFile("a.txt");
	    		                	writefile.emptyFile("b.txt");
	    		                	writefile.emptyFile("c.txt");
	    		                	writefile.emptyFile("d.txt");
	    		                	writefile.emptyFile("e.txt");
	    		                	writefile.emptyFile("f.txt");
	    		                	writefile.emptyFile("input.txt");
	    		                	//economy
	    		                	writefile.emptyFile("economy.txt");
	    		                	writefile.emptyFile("avalabil.txt");
	    		                	writefile.emptyFile("manifest.txt");
	    		                		
	    		                	economy.writeToFile();
	    		                	
	    		                	System.out.println("Group " + gname +" has been added!");
	                        	}
	                        	else{
	                        		System.out.println("Not enough seats to add group.");
	                        	}
	                        	break;
	                        }
	                        else{
	                            System.out.println("Invalid input. Please type first or economy");
	                            continue;
	                        }
	                    }//end while

	                }//end G
	
	                else if((a.equalsIgnoreCase("C")) || (a.equalsIgnoreCase("Cancel"))){
	                    System.out.println("individual or a group cancelation?");
	                  while(true){  
	                    System.out.println("[I]ndividual    [G]roup");
	                    Scanner inp = new Scanner(System.in);
	                    //input
	                    String indgroup = inp.nextLine();
	                    
	                    if(indgroup.equalsIgnoreCase("I") || indgroup.equalsIgnoreCase("Individual")){
	                    	System.out.print("Name    :");
	                    	Scanner individual = new Scanner(System.in);
	                    	String indName = individual.nextLine();//get name
	                    	
	                    	//try deleting person from first class
	                    	boolean k = first.deletePerson(indName);
	                    	
	                    	if(k==true){
	                    		System.out.println("Your reservation has been canceled!");
	                    	}
	                    	//person not in first class, then try economy
	                    	else if(k==false){
	                    		boolean m = economy.deletePerson(indName);
	                    		//not in economy section
	                    		if(m==false){
	                    			System.out.println("Person does not exists!");
	                    		}
	                    		
	                    		if(m==true){
	                    			System.out.println("Your reservation has been canceled!");
	                    		}
	                    	}
	                    	//update files
	                    	writefile.emptyFile("a.txt");
		                	writefile.emptyFile("b.txt");
		                	writefile.emptyFile("c.txt");
		                	writefile.emptyFile("d.txt");
		                	writefile.emptyFile("e.txt");
		                	writefile.emptyFile("f.txt");
		                	writefile.emptyFile("economy.txt");
		                	writefile.emptyFile("avalabil.txt");
		                	writefile.emptyFile("manifest.txt");
		                	writefile.emptyFile("first.txt");
		                	writefile.emptyFile("avfirst.txt");
		                	writefile.emptyFile("nvfirst.txt");
		                	economy.writeToFile();
		                	first.writeToFile("first.txt");
	                    	break;
	                    }
	                    
	                    if(indgroup.equalsIgnoreCase("G") || indgroup.equalsIgnoreCase("Group")){
	                    	System.out.print("Group name:  ");
	                    	Scanner gr = new Scanner(System.in);// get group name
	                    	String gro = gr.nextLine();
	                    	
	                    	//delete from first class
	                    	boolean gdel = first.deleteGroup(gro);
	                    	if(gdel ==true){
	                    		System.out.println("Group reservation found in First section");
	                    		System.out.println("All passengers with group name ' "+gro +" ' deleted!");
	                    		writefile.emptyFile("avfirst.txt");
	 	                        writefile.emptyFile("nvfirst.txt");
	 	                        writefile.emptyFile("first.txt");
	 	                        first.writeToFile("first.txt");
	                    		System.out.println("Reservation for "+gro +" has been canceled!");
	                    		break;
	                    	}
	                    	
	                    	//try deleting from economy
	                    	else if(gdel==false){
	                    		boolean isdel = economy.deleteGroup(gro);
	                    		
	                    		if(isdel==true){
	                    			//update info
	                    			System.out.println("Group reservation found in Economy section."  );
	                    			System.out.println("All passengers with group name ' "+gro +" ' deleted!");
	                    			writefile.emptyFile("a.txt");
	    		                	writefile.emptyFile("b.txt");
	    		                	writefile.emptyFile("c.txt");
	    		                	writefile.emptyFile("d.txt");
	    		                	writefile.emptyFile("e.txt");
	    		                	writefile.emptyFile("f.txt");
	    		                	
	    		                	writefile.emptyFile("economy.txt");
	    		                	writefile.emptyFile("avalabil.txt");
	    		                	writefile.emptyFile("manifest.txt");
	    		                	writefile.emptyFile("first.txt");
	    		                	writefile.emptyFile("avfirst.txt");
	    		                	writefile.emptyFile("nvfirst.txt");
	    		                	
	    		                	first.writeToFile("first.txt");
	    		                	economy.writeToFile();
	                    		}
	                    		else{
		                    		System.out.println("Group " + gro +" does not exists!");
		                    	}
		                    	break;
	                    	}
	                    	
	                    }
	                    continue;
	                  }//end while
	                }
	                
	                else if(a.equalsIgnoreCase("P") || a.equalsIgnoreCase("Passenger")){
	
	                    Scanner in = new Scanner(System.in);
	                    Scanner se = new Scanner(System.in);
	                    Scanner sea = new Scanner(System.in);
	                    String service;
	                    String prefrence;
	                    System.out.print("Name            :");
	                    String name = in.nextLine();
	
	                    while(true){
	
	                        System.out.print("Service Class   :");
	                        service = se.nextLine();
	
	                        if(service.equalsIgnoreCase("First")){
	                            break;
	                        }
	                        if(service.equalsIgnoreCase("Economy")){
	                            break;
	                        }
	                        System.out.println("Please type valid class, Economy or First.");
	                        continue;
	                    }
	
	                    while(true){
	                         System.out.print("Seat Preference :");
	                         prefrence = sea.nextLine();
	
	                         if(prefrence.equalsIgnoreCase("C")){
	                             break;
	                         }
	                         if(prefrence.equalsIgnoreCase("W")){
	                             break;
	                         }
	                         if(prefrence.equalsIgnoreCase("A")){
	                             break;
	                         }
	                         System.out.println("Invalid seat refrence.");
	                         System.out.println("W = Window,  C = Center, A = Asile.");
	                        continue;
	                    }//end while
	
	                    Passenger passenger = new Passenger(name,service);
	                    Seat pseat = new Seat(passenger);
	                    
	                    if(service.equalsIgnoreCase("first")){
	                        
	                        boolean aa = first.addSinglePassenger(passenger, prefrence);
	                        //update information
	                        writefile.emptyFile("avfirst.txt");
	                        writefile.emptyFile("nvfirst.txt");
	                        writefile.emptyFile("first.txt");
	                        first.writeToFile("first.txt");
	                        
	                        if(aa==true){
	                        System.out.println(">> Passenger "+ name+ " added!");}
	                        else{
	                        	System.out.println("First class has no empty seats. Try economy section.");
	                        }
	                    }
	                    //if economy
	                    if(service.equalsIgnoreCase("economy")){
	                        
	                        boolean added = economy.addSinglePassenger(passenger,prefrence);
	                        
	                        if(added==true){
	                        	System.out.println("\n");
	                        	System.out.println(">> Passenger " + passenger.getName()+" added.");
	                        	//erase content
	                        	writefile.emptyFile("economy.txt");
	                        	writefile.emptyFile("a.txt");
	                        	writefile.emptyFile("b.txt");
	                        	writefile.emptyFile("c.txt");
	                        	writefile.emptyFile("d.txt");
	                        	writefile.emptyFile("e.txt");
	                        	writefile.emptyFile("f.txt");
	                        	writefile.emptyFile("avfirst.txt");
	                        	writefile.emptyFile("manifest.txt");
	                        	writefile.emptyFile("avalabil.txt");
	                        	//update files
	                        	economy.writeToFile();
	                        	
	                        	System.out.println("\n");
	                        }
	                        else{
	                        	System.out.println("Can't add passenger. Economy section is full.");
	                        }
	                    }
	                   
	                }//end p
	                //if Availability
	                else if((a.equalsIgnoreCase("A")) || (a.equalsIgnoreCase("Availability"))){
	                	System.out.println("\n");
	                	System.out.println("ECONOMY CLASS AVAILABLE SEAT(S)");
	                	System.out.println("*********************************");
	                    System.out.println("Seat#  ROW  RESERVED   EMPTY   ");
	                    System.out.println("*********************************");
	                    writefile.readFromFile("avalabil.txt");
	                    System.out.println("*********************************");
	                    System.out.println("FIRST CLASS AVILABLE SEAT(S)");
	                    System.out.println("********************************");
	                    writefile.readFromFile("nvfirst.txt");
	                    System.out.println("\n");
	                    continue;
	                }
	                //show taken seats
	                else if(a.equalsIgnoreCase("M") || a.equalsIgnoreCase("Manifest")){
	                    System.out.println("\n");
	                    System.out.println("ECONOMY CLASS                   ");
	                	System.out.println("*********************************");
	                    System.out.println("Seat#  ROW  RESERVED    PASSENGER ");
	                    System.out.println("*********************************");
	                    writefile.readFromFile("manifest.txt");
	                    System.out.println("FIRST CLASS");
	                    writefile.readFromFile("avfirst.txt");
	                    System.out.println("\n");
	                    continue;
	                }
	                //if q
	                else if(a.equalsIgnoreCase("Q") || a.equalsIgnoreCase("Quit")){
	                     
	                    economy.writeToFile();
	                  //empty files content
	                	writefile.emptyFile("a.txt");
	                	writefile.emptyFile("b.txt");
	                	writefile.emptyFile("c.txt");
	                	writefile.emptyFile("d.txt");
	                	writefile.emptyFile("e.txt");
	                	writefile.emptyFile("f.txt");
	                	writefile.emptyFile("economy.txt");
	                	writefile.emptyFile("avalabil.txt");
	                	writefile.emptyFile("manifest.txt");
	                	writefile.emptyFile("first.txt");
	                	writefile.emptyFile("avfirst.txt");
	                	writefile.emptyFile("nvfirst.txt");
	                	economy.writeToFile();
	                	first.writeToFile("first.txt");
	                    System.out.println("Thank you for using our reservation system.");
	                    break;
	                }
	                continue;
	            }//end first while
	     
    }//end main
}//end Main
