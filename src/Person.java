
/**
 * @author Manzoor Ahmed
 *
 */
public class Person {

	private String id;
	
	public Person(){	
	}
	//default constructor
	public Person(String id){
		setid(id);
	}
	/**
	 * @return id the user id
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * @param theid user's id 
	 * @return ture if id is set, false otherwise.
	 */
	private boolean setid(String theid){
		this.id = theid;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.id.toString();
	}
}
