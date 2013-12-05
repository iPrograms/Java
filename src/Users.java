import java.util.ArrayList;

public class Users {

	ArrayList<String> users; 
	
	public Users(){
		users = new ArrayList<String>();
		
	}
	
	//create user id, true if user id, false other wise
	public boolean addUserId(String myid){
		if(users.add(myid)){
			return true;
		}
		return false;
	}
	
	//check if user id matches
	public boolean doesUserIdmatches(String userid){
		
		for(int s =0; s!=users.size();s++)
		{
			if(users.equals(userid))
			{
				return true;
			}
		}
		return false;
	}
	
	public String showAllUserId(){
		String allusers ="";
		
		for(int u=0; u!=users.size();u++){
			allusers+= users.get(u).toString();
			allusers+="\n";
		}
		return allusers.toString();
	}
}
	
