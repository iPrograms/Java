
package reservation;

/**
 *
 * @author Manzoor Ahmed
 *
 */

import java.util.ArrayList;
public class First {

    private Seat[] a;
    private Seat[] b;
    private Seat[] c;
    private Seat[] d;
    
    private ReadFile readfile = new ReadFile();
    private WriteFile wfile = new WriteFile();
    
    public First(){
        a = new Seat[2]; //window row
        b = new Seat[2]; //aisle row

        c = new Seat[2]; //aisle row
        d = new Seat[2];//window row
    }

   /**read from first.txt file only, and set up data
    *@param  passenger, passenger of first class
    *@param preference , passenger's preferred seat
    *@return added, true if passenger added, and false  otherwise.
    */
    public boolean add(Passenger passenger, String preference,int index, String reserved){
        //passenger not added yet.
        boolean added = false;
        
        Seat seat = new Seat(passenger);
        
        //if window seat
        if(preference.equalsIgnoreCase("a")){
        	if(index==1 ){
                a[0] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	a[0].isEmpty=false;             //seat already reserved
                }
                else{
                	a[0].isEmpty= true;
                }
            } //end a
        	if(index==2 ){
                a[1] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	a[1].isEmpty=false;             //seat already reserved
                }
                else{
                	a[1].isEmpty= true;
                }
            } //end a
        }
        
        if(preference.equalsIgnoreCase("b")){
        	if(index==1 ){
                b[0] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	b[0].isEmpty=false;             //seat already reserved
                }
                else{
                	b[0].isEmpty= true;
                }
            } //end a
        	if(index==2 ){
                b[1] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	b[1].isEmpty=false;             //seat already reserved
                }
                else{
                	b[1].isEmpty= true;
                }
            } //end a
        }
        
        if(preference.equalsIgnoreCase("c")){
        	if(index==1 ){
                c[0] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	c[0].isEmpty=false;             //seat already reserved
                }
                else{
                	c[0].isEmpty= true;
                }
            } //end a
        	if(index==2 ){
                c[1] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	c[1].isEmpty=false;             //seat already reserved
                }
                else{
                	c[1].isEmpty= true;
                }
            } //end a
        }
        if(preference.equalsIgnoreCase("d")){
        	if(index==2 ){
                d[0] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	d[0].isEmpty=false;             //seat already reserved
                }
                else{
                	d[0].isEmpty= true;
                }
            } //end a
        	if(index==2 ){
                d[1] = seat;

                if(reserved.equalsIgnoreCase("YES")){
                	d[1].isEmpty=false;             //seat already reserved
                }
                else{
                	d[1].isEmpty= true;
                }
            } //end a
        }
            return added;  
    } //end addPassenger


    /*read from a given file, and store the information in rows
     * @param filename, the file to read information from
     * 
     * **/
    public void addFromFile(String filename){

        String[] line;   //each line from the file
        String[] info;   //line of given file
        
        int num;         //seat number
        String row;      //row name, exp A,B,C...F
        String yesno;    //String yes or no from the file
        String pass;     //passenger name
       
        line = readfile.readLine1(filename);

        for(int k=0;k<line.length-1;k++){

            if(line==null){
                break;
            }//if end of file
            else
            {
                info = line[k].split("\\s");
                num = Integer.parseInt(info[0]);
                row = info[1];
                yesno =info[2];
                pass = info[3];
               
                Passenger passenger = new Passenger(pass);

                if(row.toString().equalsIgnoreCase("A")){
                    add(passenger,"A",num,yesno);
                }
                if(row.toString().equalsIgnoreCase("B")){
                    add(passenger,"B",num,yesno);
                }
                if(row.toString().equalsIgnoreCase("C")){
                    add(passenger,"C",num,yesno);
                }
                if(row.toString().equalsIgnoreCase("D")){
                    add(passenger,"D",num,yesno);
                }
                
            }
       }//end for
    }
    /**add a single passenger to the desired seat
     *@param passenger, passenger who wants the seat
     *@param pref, seat location preference
     *@return true, if passenger added, false otherwise
     * */
    public boolean addSinglePassenger(Passenger passeger,String pref){
    	
    	boolean added=false;
    	Seat seat = new Seat(passeger);
    	
    	if(pref.equalsIgnoreCase("w")){     //window seats
    		
    		if(a[0].isEmpty==true){
    			
    			a[0]=seat;
    			a[0].isEmpty=false;
    			added=true;
    		}
    		else if(a[1].isEmpty==true){
    			a[1]=seat;
    			a[1].isEmpty=false;
    			added=true;
    		}
    		else if(d[0].isEmpty==true){
    			d[0]=seat;
    			d[0].isEmpty=false;
    			added=true;
    		}
    		else if(d[1].isEmpty==true){
    			d[1]=seat;
    			d[1].isEmpty=false;
    			added=true;
    		}   		
    	}//end w
    	
    	if(pref.equalsIgnoreCase("a")){   //aisle seat
    		
    		if(b[0].isEmpty==true){
    			
    			b[0]=seat;
    			b[0].isEmpty=false;
    			added=true;
    		}
    		else if(b[1].isEmpty==true){
    			b[1]=seat;
    			b[1].isEmpty=false;
    			added=true;
    		}
    		else if(c[0].isEmpty==true){
    			c[0]=seat;
    			c[0].isEmpty=false;
    			added=true;
    		}
    		else if(c[1].isEmpty==true){
    			c[1]=seat;
    			c[1].isEmpty=false;
    			added=true;
    		}
    	}
    	
    	return added;   	
    }//end addSinglePassenger
    /*updates the date to files
     *@param filename, the file to be updated
     * **/
    public void writeToFile(String filename){
    	
    	for(int i=0;i!=2;i++){
    		if(a[i].isEmpty==true){
    			wfile.updateFile(filename, i+1, 'A', "NO",a[i].pass.getName().toString());
    			wfile.updateFile("nvfirst.txt", i+1, 'A', "NO","noPas");
    		}
    		else{
    			wfile.updateFile(filename, i+1, 'A', "YES",a[i].pass.getName().toString());
    			wfile.updateFile("avfirst.txt", i+1, 'A', "YES",a[i].pass.getName().toString());
    		}
    	}
    	
    	for(int i=0;i!=2;i++){
    		if(b[i].isEmpty==true){
    			wfile.updateFile(filename, i+1, 'B', "NO",b[i].pass.getName().toString());
    			wfile.updateFile("nvfirst.txt", i+1, 'B', "NO","noPas");
    		}
    		else{
    			wfile.updateFile(filename, i+1, 'B', "YES",b[i].pass.getName().toString());
    			wfile.updateFile("avfirst.txt", i+1, 'B', "YES",b[i].pass.getName().toString());
    			
    		}
    	}
    	for(int i=0;i!=2;i++){
    		if(c[i].isEmpty==true){
    			wfile.updateFile(filename, i+1, 'C', "NO",c[i].pass.getName().toString());
    			wfile.updateFile("nvfirst.txt", i+1, 'C', "NO","noPas");
    			
    		}
    		else{
    			wfile.updateFile(filename, i+1, 'C', "YES",c[i].pass.getName().toString());
    			wfile.updateFile("avfirst.txt", i+1, 'C', "YES",c[i].pass.getName().toString());
    		}
    	}
    	
    	for(int i=0;i!=2;i++){
    		if(d[i].isEmpty==true){
    			wfile.updateFile(filename, i+1, 'D', "NO",d[i].pass.getName().toString());
    			wfile.updateFile("nvfirst.txt", i+1, 'D', "NO","noPas");
    		}
    		else{
    			wfile.updateFile(filename, i+1, 'D', "YES",d[i].pass.getName().toString());
    			wfile.updateFile("avfirst.txt", i+1, 'D', "YES",d[i].pass.getName().toString());
    		}
    	}
    		
    }
    /*findPerson find's passenger's seat number and row number
     * @param name, name of the passenger to search for
     * @return found, seat number and row number
     * **/
    private String[] findPerson(String name){
    	String[] found;
    	found= new String[2];
    	
    	//check each seat
    	for(int s=0;s!=2;s++){
    		if(a[s].pass.getName().equalsIgnoreCase(name)){
    			found[0]=Integer.toString(s);
    			found[1]="a";
    			break;
    		}
    		else if(b[s].pass.getName().equalsIgnoreCase(name)){
    			found[0]=Integer.toString(s);
    			found[1]="b";
    			break;
    		}
    		else if(c[s].pass.getName().equalsIgnoreCase(name)){
    			found[0]=Integer.toString(s);
    			found[1]="c";
    			break;
    		}
    		else if(d[s].pass.getName().equalsIgnoreCase(name)){
    			found[0]=Integer.toString(s);
    			found[1]="d";
    			break;
    		}
    	}//end for
    		
    	return found;
    }
    
    /*deletePerson deletes the passenger from a seat
     *@param name, passenger's name
     *@param true, if user is deleted from the seat, false otherwise.
     * **/
    public boolean deletePerson(String name){
    	boolean deleted=false;
    	
    	String person[] = findPerson(name);
    	
    	if(person[0]==null){
    		deleted=false;
    	}
    	else{
	    	int num = Integer.parseInt(person[0]);
	    	String seat = person[1];
	    	
	    	if(seat.equalsIgnoreCase("a")){
	    		a[num].pass.setName("noPas");
	    		a[num].isEmpty=true;
	    		deleted=true;
	    	}
	    	else if(seat.equalsIgnoreCase("b")){
	    		b[num].pass.setName("noPas");
	    		b[num].isEmpty=true;
	    		deleted=true;
	    	}
	    	else if(seat.equalsIgnoreCase("c")){
	    		c[num].pass.setName("noPas");
	    		c[num].isEmpty=true;
	    		deleted=true;
	    	}
	    	else if(seat.equalsIgnoreCase("d")){
	    		d[num].pass.setName("noPas");
	    		d[num].isEmpty=true;
	    		deleted=true;
	    	}
    	}
    	return deleted;
    }
    /*
     * cancel group reservation
     * @param gman, the group name for canceling the reservation
     * @return true if group existed and deleted, false otherwise.
     * **/
    public boolean deleteGroup(String gname){
    	boolean del = false;
    	
    	for(int s=0;s!=2;s++){
    		
    		if(a[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			a[s].pass.setName("noPas");   //has no passenger
    			a[s].isEmpty=true;            //seat is empty now
    			del=true;                    
    		}
    		if(b[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			b[s].pass.setName("noPas");
    			b[s].isEmpty=true;
    			del=true;
    		}
    		if(c[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			c[s].pass.setName("noPas");
    			c[s].isEmpty=true;
    			del=true;
    		}
    		if(d[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			d[s].pass.setName("noPas");
    			d[s].isEmpty=true;
    			del=true;
    		}
    	}

    	return del;
    }

    /*
     * getAllEmptySeats checks for all the empty seats
     * @return ArrayList<String[]>, name and seat numbers of seats
     * **/
   private ArrayList<String[]> getAllEmptySeats(){
    	//to hold list list of empty seats
    	ArrayList<String[]> list = new ArrayList<String[]>();
    	//for seat number and row.
    	
    	for(int ii=0;ii!=2;ii++){
    		
    		if(a[ii].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="a";
    			seatnum[1]=Integer.toString(ii);
    			list.add(ii, seatnum);
    		}
    		if(b[ii].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="b";
    			seatnum[1]=Integer.toString(ii);
    			list.add(seatnum);
    		}
    		if(c[ii].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="c";
    			seatnum[1]=Integer.toString(ii);
    			list.add(ii, seatnum);
    		}
    		if(d[ii].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="d";
    			seatnum[1]=Integer.toString(ii);
    			list.add(ii, seatnum);
    		}
    	}
    	return list;
    }
    

    /*
     * addGroup adds group of passengers seperated by ,
     * @param group, the group name
     * @return true, if group added, false otherwise.
     * **/
    public boolean addGroup(String group,String groupname){

       String[] members;	
       //to hold passengers
       boolean added = false;
       
       //get all empty seats
       ArrayList<String[]> info;
       info = getAllEmptySeats();
      
       if(group.contains(",")){

       members = group.split(",");  //names
       //need to know how many passenger
       int people = members.length;
       //to hold passengers
       Passenger[] passenger = new Passenger[people];
       
       if(people>info.size()){
    	   added=false;
       }
       // can add people
       if(people<info.size()){
    	   
       for(int p=0;p!=people;p++){
    	   passenger[p]= new Passenger(members[p].toString());
    	   passenger[p].setName(members[p]);  //set passenger's name
    	   passenger[p].setGroupName(groupname);
    	   
       }
       
       //get passenger and add to empty seat
       
       for(int start =0; start!=passenger.length;start++){
    	   
    	   String[] seatinfo = info.get(start);
    	   String row = seatinfo[0];
    	   int number = Integer.parseInt(seatinfo[1]);
    	   
    	   if(row.equalsIgnoreCase("a")){
    		   a[number]= new Seat(passenger[start]);
    		   a[number].isEmpty=false;
    		   added=true;
    	   }
    	   else if(row.equalsIgnoreCase("b")){
    		   b[number]= new Seat(passenger[start]);
    		   b[number].isEmpty=false;
    		   added=true;
    	   }
    	   else if(row.equalsIgnoreCase("c")){
    		   c[number]= new Seat(passenger[start]);
    		   c[number].isEmpty=false;
    		   added=true;
    	   }
    	   else if(row.equalsIgnoreCase("d")){
    		   d[number]= new Seat(passenger[start]);
    		   d[number].isEmpty=false;
    		   added=true;
    	   }
    	   else{
    		   added=false;
    	   }
       }//end for
       }
    }
      return added;
    }//end addGroup
}//end First