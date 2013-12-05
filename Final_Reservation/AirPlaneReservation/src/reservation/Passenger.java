
package reservation;

/**
 *
 * @author manzoor ahmed
 */
public class Passenger {

   private String name="noPas";
   private String groupname;
   private String serviceClass;

    /**
     *passenger with NO group
     * @param fname, first name of the passenger
     * @param lastname, last name of the passenger
     */
    public Passenger( String name){
        this.name = name;
        this.groupname="nogroup";
    }

    /**
     *passenger with group
     * @param fname, first name of the passenger
     * @param lastname, last name of the passenger
     * @param gn, passenger's group name
     */
    public Passenger(String fn,String service){
        this.name = fn;
        this.groupname =service;
    }

    /**
     *
     * @return name,passenger name
     */
    public String getName(){
        return this.name.toString();
    }

    public String getGroupName(){
        return this.groupname;
    }

    public void setGroupName(String groupname){
        this.groupname = groupname;
    }

    public void setServiceClass(String service){
        this.serviceClass = service;
    }
    public String getServiceClass(){
        return this.serviceClass;
    }
    public void setName(String name){
    	this.name=name;
    }
   
    @Override
    public String toString(){
        return "Name: " +this.name +"\n"+
               "Gruop Name: " +this.groupname+"\n";
    }
}
