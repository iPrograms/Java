import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			System.out.println("");
			System.out.println("What type of user are you?");
			System.out.println("=================================================");
			System.out.println("USER TYPES               :  COMMAND");
			System.out.println("-------------------------------------------------");
			System.out.println("General User             :  General User");
			System.out.println("Administrator            :  Administrator");
			System.out.println("Quit reservation program :  q, Q, quit, exit");
			System.out.println("=================================================");
			
			
			String user = input.nextLine();
			
				if(user.toString().equalsIgnoreCase("Administrator")){
					System.out.println("admin");
				}
				////////////////////////General User/////////////////////
				else if(user.toString().equalsIgnoreCase("General User"))
				{
					
					Scanner input2 = new Scanner(System.in);  //for user type
					System.out.println("USER           : COMMAND");
					System.out.println("------------------------------");
					System.out.println("Exicting user  : ex user");
					System.out.println("New User       : new");
					System.out.println("");
					
					String userType = input2.nextLine().toString();
					
					if(userType.toString().equalsIgnoreCase("new"))
					{	
						System.out.println("Please type your new user id ");
						Scanner scan = new Scanner(System.in);
						String uid = scan.nextLine();
						
						WriteFile wfile = new WriteFile();
						wfile.writeToFile("id.txt",uid.toString());
						System.out.println("");
						System.out.println(uid+ " id is created!");
						System.out.println("You can make reservation now with your new id.");
						System.out.println("");
						continue;
					}
							
					if(userType.toString().equalsIgnoreCase("ex user")){
						
						while(true)
						{
						
							System.out.println("Please enter your id");
							System.out.println("Back menue  : q");
							
							Scanner testid = new Scanner(System.in);
							String exid = testid.nextLine().toString();
							
							ReadFile read = new ReadFile();
							String idfile[] = read.readLine("id.txt");
							
							if(read.doesInputMatch(idfile,exid)==true)
							{
								System.out.println("Welcome " + exid+ "!");
								System.out.println("------------------------------");
								System.out.println("SERVICES        : COMMAND ");
								System.out.println("-----------------------------");
								System.out.println("For reservation :      add");
								System.out.println("For exit        :      done");
								Scanner id = new Scanner(System.in);
								String first = id.nextLine();
								
								//add command
								 if(first.equalsIgnoreCase("add")){
									
									System.out.println("We have 6:30pm and 8:30pm show open");
									System.out.println("Reservation for 6:30pm :   630");
									System.out.println("Reservation for 8:30pm :   830");
									Scanner showinput = new Scanner(System.in);
									//get show time
									String show = showinput.nextLine().toString();
									
									//if the 630 show
									if(show.equals("630")){
										System.out.println("Avalible seats for the 6:30pm show");
										System.out.println();
										ReadFile show630 = new ReadFile();
										show630.readFromFile("630.txt");
										
										//System.out.println(userid.showAllUserId());
										break;
									}
									
									//if the 830 show
									if(show.equals("830")){
										System.out.println("Avalible seats for the 8:30pm show");
										System.out.println();
										ReadFile show830= new ReadFile();
										show830.readFromFile("830.txt");
										
										Scanner section = new Scanner(System.in);
										while(true){
											
											System.out.println("Please select desired section for reservation");
											System.out.println();
											System.out.println("----------------------------");
											System.out.println("SECTIONS          : COMMAND");
											System.out.println("----------------------------");
											System.out.println("Main Floor        : main ");
											System.out.println("West Main Floor   : wmain");
											System.out.println("East Main Floor:  : emain");
											System.out.println("Soutn Balcony     : south");
											System.out.println("East  Balcony     : east ");
											System.out.println("West  Balcony     : west");
											System.out.println("Back to prev menue: q");
											String usection = section.nextLine();
											
											if(usection.equalsIgnoreCase("main")){
												
											}
											if(usection.equalsIgnoreCase("south")){
												
											 Balcony balcony = new Balcony();
											 balcony.add("shams");
											 balcony.add("manzoor");
											 balcony.add("taco");
											 balcony.add("pizza");
											 balcony.add("almonds");
											 System.out.println(balcony.empty);
											 //balcony.printSeats();
											}
											if(usection.equalsIgnoreCase("east")){
												System.out.println("east");
											}
											if(usection.equalsIgnoreCase("west")){
												
											}
											if(usection.equalsIgnoreCase("q")){
												break;
											}
											
										}//end while
										
									}//830
									
								 }//if
				
							if(first.equalsIgnoreCase("done")){
								break;
							}

							if((first.equalsIgnoreCase("done")== false) ||( first.equalsIgnoreCase("add")==false)){
								continue;
							}
						}//end match
						
						if(exid.equalsIgnoreCase("q")){
							break;
						}
						if(read.doesInputMatch(idfile,exid)==false){
					    	System.out.println(exid+ " did not match!, Try again.");
					    	continue;
					    }
					    
					}	
				}//end while		
		}
			else if(user.equalsIgnoreCase("q") || user.equalsIgnoreCase("exit") || user.equalsIgnoreCase("quit")){
					System.out.println("Thank you for using our reservation system.");
					System.out.println("Good Bye!");
					System.out.println("-------------------------------------------");
					break;
		    }
			else
			{
				continue;
			}
			
		}//end while
	}//end main		
}//end class


