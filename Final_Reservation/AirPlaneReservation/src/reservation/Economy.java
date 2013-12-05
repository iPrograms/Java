/**
 *Economy adds passenger(s) to user's given choice.
 *For instance, if user types w/W then we know the user wants a seat near the
 *window. Also, [A]isle and [C]enter other choices for seats.
 *
 */
package reservation;

import java.util.ArrayList;

/**
 * @author Manzoor Ahmed
 * August 30, 2010
 * Last mod: Sep 15, 2012
 * Economy.java
 */

public class Economy {

    // f, a are window seats.
    // c, d are aisle seats.
    // e, b are center seats.
    
    private Seat[] f;
    private Seat[] a;
    private Seat[] c;
    private Seat[] d;
    private Seat[] e ;
    private Seat[] b ;
    
    private WriteFile writefile = new WriteFile();
    private ReadFile readfile = new ReadFile();

    //,e,d,c,b,a;
    public Economy()
    {
         f = new Seat[20];
         a =new Seat[20];
         c = new Seat[20];
         d = new Seat[20];
         e = new Seat[20];
         b = new Seat[20];
    }
    
    /**only addFromfile uses this method
     *@param  passenger, passenger's name
     *@param row, user's choice of seat location
     *@return true, if passenger is added to the seat, false otherwise.
     */
    private void addPassenger(Passenger passenger,String row,int index,String resereved){
        // make seat for the passenger
        Seat seat = new Seat(passenger);       
                 
        if(row.equalsIgnoreCase("A"))
        {
            // check a aisle first
            if((a.length-1 >= 0) && (a.length-1 <=19) ){
                a[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                	a[index].isEmpty=false;             //seat already reserved
                }
                else{
                	a[index].isEmpty= true;
                }
            } //end a
        }
        if(row.equalsIgnoreCase("B"))
        {
            // check c aisle first
            if((b.length-1 >= 0) && (b.length-1 <=19) ){
                b[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                   b[index].isEmpty=false;             //seat already reserved
                }else{
                	b[index].isEmpty= true;
                }
            } //end b
        }
        if(row.equalsIgnoreCase("C"))
        {
            // check c aisle first
            if((c.length-1 >= 0) && (c.length-1 <=19) ){
                c[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                	c[index].isEmpty=false;             //seat already reserved
                }else{
                	c[index].isEmpty= true;
                }
            } //end c
        }
        if(row.equalsIgnoreCase("D"))
        {
            // check c aisle first
            if((d.length-1 >= 0) && (d.length-1 <=19) ){
                d[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                	d[index].isEmpty=false;             //seat already reserved
                }else{
                	d[index].isEmpty= true;
                }
            } //end a
        }
        if(row.equalsIgnoreCase("E"))
        {
            // check c aisle first
            if((e.length-1 >= 0) && (e.length-1 <=19) ){
                e[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                   e[index].isEmpty=false;             //seat already reserved
                }else{
                	e[index].isEmpty= true;
                }
            } //end e
        }
        if(row.equalsIgnoreCase("F"))
        {
            // check c aisle first
            if((f.length-1 >= 0) && (f.length-1 <=19) ){
                f[index] = seat;

                if(resereved.equalsIgnoreCase("YES")){
                	f[index].isEmpty=false;             //seat already reserved
                }else{
                	f[index].isEmpty= true;
                }
            } //end a
        }
    }//end method addPassenger

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
       
        line = readfile.readLine(filename);

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
                    addPassenger(passenger,"A",k,yesno);
                }
                if(row.toString().equalsIgnoreCase("B")){
                    addPassenger(passenger,"B",k,yesno);
                }
                if(row.toString().equalsIgnoreCase("C")){
                    addPassenger(passenger,"C",k,yesno);
                }
                if(row.toString().equalsIgnoreCase("D")){
                    addPassenger(passenger,"D",k,yesno);
                }
                if(row.toString().equalsIgnoreCase("E")){
                    addPassenger(passenger,"E",k,yesno);
                }
                if(row.toString().equalsIgnoreCase("F")){
                    addPassenger(passenger,"F",k,yesno);
                }
            }
       }//end for
    }
    
    /*this method adds a single user
     * @param pass, the passenger who is making the reservation
     * @param row, row the section the seat to be reserved
     * @return true, if user is added, false otherwise. 
     * **/
    public boolean addSinglePassenger(Passenger pass,String row){
    	
    	Seat pasSeat = new Seat(pass);
    	
    	if(row.equalsIgnoreCase("W")){
    		
    		int pos = getEmptySeat("A");
    		
    		if(pos!=-1){			   //row a has seat
    			a[pos] = pasSeat;      //reserve seat
    			a[pos].isEmpty=false;  //not empty
    			return true;           //passenger added
    		}
    		
    		if(pos==-1){                       //row a has no seat    
    			
    			int a = getEmptySeat("F");    //check row f for seat
    			
    			if(a!=-1){                    //row f has a seat
    				f[a]=pasSeat;             //reserve seat
    				f[a].isEmpty=false;       //seat is not empty
    				return true;              //passenger added 
    			}                             
    			if(a==-1){                    //row f has no seat
    				return false;             //no window seat.  
    			}
    		}
    	}
    	
    	else if(row.equalsIgnoreCase("C")){
    		
    		int pos = getEmptySeat("E");
    		
    		if(pos!=-1){			   //row e has a seat
    			e[pos] = pasSeat;      //reserve seat
    			e[pos].isEmpty=false;  //not empty
    			return true;           //passenger added
    		}
    		
    		if(pos==-1){                       //row e has no seat    
    			
    			int a = getEmptySeat("B");    //check row b for seat
    			
    			if(a!=-1){                    //row b has a seat
    				b[a]=pasSeat;             //reserve seat
    				b[a].isEmpty=false;       //seat is not empty
    				return true;              //passenger added 
    			}                             
    			if(a==-1){                    //row b has no seat
    				return false;             //no window seat.  
    			}
    		}
    	}
    	else if(row.equalsIgnoreCase("A")){
    		int pos = getEmptySeat("C");
    		
    		if(pos!=-1){			   //row c has a seat
    			c[pos] = pasSeat;      //reserve seat
    			c[pos].isEmpty=false;  //not empty
    			return true;           //passenger added
    		}
    		
    		if(pos==-1){                       //row c has no seat    
    			
    			int a = getEmptySeat("D");    //check row d  for seat
    			
    			if(a!=-1){                    //row d has a seat
    				d[a]=pasSeat;             //reserve seat
    				d[a].isEmpty=false;       //seat is not empty
    				return true;              //passenger added 
    			}                             
    			if(a==-1){                    //row d has no seat
    				return false;             //no window seat.  
    			}
    		}
    	}
    	return false;
    }
    
    
    /**@param filenmae, the file to be updated
     * @param row, name of the row, a,b,c,d,e,f
     * */
    public void writeToFile(){
    	
    	//write a seat information
        for(int start =0; start !=a.length-1;start++){
           
        	if(a[start].isEmpty==true){
                
        		writefile.updateFile("a.txt",start+1,'A',"NO",a[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'A',"NO",a[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'A',"NO",a[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("a.txt",start+1,'A',"YES",a[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'A',"YES",a[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'A',"YES",a[start].pass.getName().toString());
            }
        }
      //write b seat information
        for(int start =0; start !=a.length-1;start++){
           
        	if(b[start].isEmpty==true){
                
        		writefile.updateFile("b.txt",start+1,'B',"NO",b[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'B',"NO",b[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'B',"NO",b[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("b.txt",start+1,'B',"YES",b[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'B',"YES",b[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'B',"YES",b[start].pass.getName().toString());
            }
        }
      //write c seat information
        for(int start =0; start !=c.length-1;start++){
           
        	if(c[start].isEmpty==true){
                
        		writefile.updateFile("c.txt",start+1,'C',"NO",c[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'C',"NO",c[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'C',"NO",c[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("c.txt",start+1,'C',"YES",c[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'C',"YES",c[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'C',"YES",c[start].pass.getName().toString());
            }
        }
        
      //write d seat information
        for(int start =0; start !=d.length-1;start++){
           
        	if(d[start].isEmpty==true){
                
        		writefile.updateFile("d.txt",start+1,'D',"NO",d[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'D',"NO",d[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'D',"NO",d[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("d.txt",start+1,'D',"YES",d[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'D',"YES",d[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'D',"YES",d[start].pass.getName().toString());
            }
        }
      //write e seat information
        for(int start =0; start !=e.length-1;start++){
           
        	if(e[start].isEmpty==true){
                
        		writefile.updateFile("e.txt",start+1,'E',"NO",e[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'E',"NO",e[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'E',"NO",e[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("e.txt",start+1,'E',"YES",e[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'E',"YES",e[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'E',"YES",e[start].pass.getName().toString());
            }
        }
      //write f seat information
        for(int start =0; start !=a.length-1;start++){
           
        	if(f[start].isEmpty==true){
                
        		writefile.updateFile("f.txt",start+1,'F',"NO",f[start].pass.getName().toString());
        		writefile.updateFile("economy.txt",start+1,'F',"NO",f[start].pass.getName().toString());
        		writefile.updateFile("avalabil.txt",start+1,'F',"NO",f[start].pass.getName().toString());
            }
        	else
            {
            	writefile.updateFile("f.txt",start+1,'F',"YES",f[start].pass.getName().toString());
            	writefile.updateFile("economy.txt",start+1,'F',"YES",f[start].pass.getName().toString());
            	writefile.updateFile("manifest.txt",start+1,'F',"YES",f[start].pass.getName().toString());
            }
        }
    }
    
    /*
     *@param row, for given row, the empty seat we are searching for.
     * **/
    private int getEmptySeat(String row){
    	
    	int index = -1;
    	
    	if(row.equalsIgnoreCase("A")){
    		
    		for(int ro=0;ro!=a.length-1;ro++){
    			if(a[ro].isEmpty==true){
    				index =ro;
    				return index;
    			}
    		}
    	}
    	else if(row.equalsIgnoreCase("B")){
    		for(int ro=0;ro!=b.length-1;ro++){
    			if(b[ro].isEmpty==true){
    				index= ro;
    				return index;
    			}
    		}
    	}
    	else if(row.equalsIgnoreCase("C")){
    		for(int ro=0;ro!=c.length-1;ro++){
    			if(c[ro].isEmpty==true){
    				index= ro;
    				return index;
    			}
    		}
    	}
    	else if(row.equalsIgnoreCase("D")){
    		for(int ro=0;ro!=d.length-1;ro++){
    			if(d[ro].isEmpty==true){
    				index= ro;
    				return index;
    			}
    		}
    	}
    	else if(row.equalsIgnoreCase("E")){
    		for(int ro=0;ro!=e.length-1;ro++){
    			if(e[ro].isEmpty==true){
    				index =ro;
    				return index;
    			}
    		}
    	}
    	else{
    		for(int ro=0;ro!=f.length-1;ro++){
    			if(f[ro].isEmpty==true){
    				index= ro;
    				return index;
    			}
    		}
    	}
    	return index;
    	
    }
    
    private String[] findPerson(String name){
    	String info[] = new String[2];
    	//search in a row
    	for(int start =0;start !=a.length-1;start++){
    		
    		if(a[start].pass.getName().equalsIgnoreCase(name)){
    			info[0]= Integer.toString(start);
    			info[1]="a";
    			break;
    		}	
    	}
    	//search in b row
		for(int start =0;start !=b.length-1;start++){
		    		
		    if(b[start].pass.getName().equalsIgnoreCase(name)){
		    	info[0]= Integer.toString(start);
		    	info[1]="b";
		    	break;
		    }	
		 }
		//search in c row
		for(int start =0;start !=c.length-1;start++){
		    		
		    if(c[start].pass.getName().equalsIgnoreCase(name)){
		    	info[0]= Integer.toString(start);
		    	info[1]="c";
		    	break;
		    }	
		 }
		//search in d row
		for(int start =0;start !=d.length-1;start++){
		    		
		    if(d[start].pass.getName().equalsIgnoreCase(name)){
		    	info[0]= Integer.toString(start);
		    	info[1]="d";
		    	break;
		    }	
		 }
		//search in e row
		for(int start =0;start !=e.length-1;start++){
		    		
		    if(e[start].pass.getName().equalsIgnoreCase(name)){
		    	info[0]= Integer.toString(start);
		    	info[1]="e";
		    	break;
		    }	
		 }
		//search in f row
		for(int start =0;start !=f.length-1;start++){
		    		
		    if(f[start].pass.getName().equalsIgnoreCase(name)){
		    	info[0]= Integer.toString(start);
		    	info[1]="f";
		    	break;
		    }	
		 }
    	return info;//get seat and row info
    }
    
    /*
     * delete only a single passenger
     * @param name, name of the passenger
     * @return true if passenger deleted, otherwise false.
     * **/
    public boolean deletePerson(String name){
    	boolean deleted=false;
    	
    	String[] info = findPerson(name);
    	//don't have seat number info, therefore not found
    	if(info[0]==null){
    		deleted=false;
    	}
    	//found passenger
    	else{
    		
    		int number = Integer.parseInt(info[0]);
    		String row = info[1];
    		
    		if(row.equalsIgnoreCase("a")){
    			a[number].pass.setName("noPas");
    			a[number].isEmpty=true;
    			deleted=true;
    		}
    		else if(row.equalsIgnoreCase("b")){
    			b[number].pass.setName("noPas");
    			b[number].isEmpty=true;
    			deleted=true;
    		}
    		else if(row.equalsIgnoreCase("c")){
    			c[number].pass.setName("noPas");
    			c[number].isEmpty=true;
    			deleted=true;
    		}
    		else if(row.equalsIgnoreCase("d")){
    			d[number].pass.setName("noPas");
    			d[number].isEmpty=true;
    			deleted=true;
    		}
    		else if(row.equalsIgnoreCase("e")){
    			e[number].pass.setName("noPas");
    			e[number].isEmpty=true;
    			deleted=true;
    		}
    		else if(row.equalsIgnoreCase("f")){
    			f[number].pass.setName("noPas");
    			f[number].isEmpty=true;
    			deleted=true;
    		}
    		else{
    			deleted=false;
    		}
    	}
    	return deleted;
    }
////////////ADD GROUP
    /*
     * getAllEmptySeats checks for all the empty seats
     * @return ArrayList<String[]>, name and seat numbers of seats
     * **/
   private ArrayList<String[]> getAllEmptySeats(){
    	//to hold list list of empty seats
    	ArrayList<String[]> list = new ArrayList<String[]>();
    	//for seat number and row.
    	
    	for(int index=0;index!=19;index++){
    		
    		if(a[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="a";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    		if(b[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="b";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    		if(c[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="c";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    		if(d[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="d";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    		if(e[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="e";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    		if(f[index].isEmpty==true){
    			String[] seatnum = new String[2];
    			seatnum[0]="f";
    			seatnum[1]=Integer.toString(index);
    			list.add(seatnum);
    		}
    	}
    	return list;
    }
    
    /*
     * addGroup adds group of passengers separated by ,
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
       int people = members.length-1;
       //to hold passengers
       Passenger[] passenger = new Passenger[people];
       
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
    	  if(row.equalsIgnoreCase("b")){
    		   b[number]= new Seat(passenger[start]);
    		   b[number].isEmpty=false;
    		   added=true;
    	   }
    	    if(row.equalsIgnoreCase("c")){
    		   c[number]= new Seat(passenger[start]);
    		   c[number].isEmpty=false;
    		   added=true;
    	   }
    	  if(row.equalsIgnoreCase("d")){
    		   d[number]= new Seat(passenger[start]);
    		   d[number].isEmpty=false;
    		   added=true;
    	   }
    	    if(row.equalsIgnoreCase("e")){
    		   e[number]= new Seat(passenger[start]);
    		   e[number].isEmpty=false;
    		   added=true;
    	   }
    	   if(row.equalsIgnoreCase("f")){
    		   f[number]= new Seat(passenger[start]);
    		   f[number].isEmpty=false;
    		   added=true;
    	   }

       }//end for
    }
      return added;
    }//end addGroup
    
    /*
     * cancel group reservation
     * @param gman, the group name for canceling the reservation
     * @return true if group existed and deleted, false otherwise.
     * **/
    public boolean deleteGroup(String gname){
    	boolean del = false;
    	
    	for(int s=0;s!=19;s++){
    		
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
    		if(e[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			e[s].pass.setName("noPas");
    			e[s].isEmpty=true;
    			del=true;
    		}
    		if(f[s].pass.getGroupName().toString().equalsIgnoreCase(gname)){
    			f[s].pass.setName("noPas");
    			f[s].isEmpty=true;
    			del=true;
    		}
    	}
    	return del;
    }

}//end Economy