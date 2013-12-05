import java.util.*;

public class ComparatorTester
{
   public static void main(String[] args)
   {
      ArrayList<Country> countries = new ArrayList<Country>();
      //create countries
      countries.add(new Country("Uruguay", 176220));
      countries.add(new Country("Russia", 514000));
      countries.add(new Country("China", 30510));
      countries.add(new Country("China1", 377510));
      countries.add(new Country("China2", 377510));
      countries.add(new Country("Canada", 377510));
      countries.add(new Country("Afghanistan", 377510));
      
      //compare by area
      Comparator<Country> byname = createComparetorByArea(false);
      
      //sort
      Collections.sort(countries,byname);
      
      System.out.println("\n\nSorted by Area");
      //print area
      for(int a=0; a!= countries.size(); a++){
    	  System.out.println(countries.get(a).getArea());
      }
      
      // compare by name
      Comparator<Country> byarea = createComparetorByName(false);
      
      //sort
      Collections.sort(countries,byarea);
      
      System.out.println("\nSorted by Name");
      for(int a=0; a!= countries.size(); a++){
    	  System.out.println(countries.get(a).getName());
      }
      
      Collections.sort(countries, new
         
         Comparator<Country>()
         {
            public int compare(Country country1, Country country2)
            {
              if(country1.getArea()==country2.getArea()){
            	  return 0;
              }
              else if(country1.getArea() > country2.getArea()){
            	  return 1;
              }
           return -1; 	  
            }
         });
   }
   
   /*
    * @param incr, sort in increasing or decreasig order
    * @return Comparator<Country>
    * 
    * **/

   public static Comparator<Country> createComparetorByArea(final boolean incr){
	   
	   Comparator<Country>  byarea= new Comparator<Country>(){
 		  @Override
 		  public  int compare(Country c1, Country c2){
 			  
 		 if(incr ==false){
 			  
	 			  if(c1.getArea() == c2.getArea()){
	 				  return 0;
	 			  }
	 			  else if(c1.getArea() > c2.getArea()){
	 				  return 1;
	 			  }
	 			  else{
	 				  return -1;
	 			  }
 			}
 		  
 		  else{
	 			 if(c1.getArea() == c2.getArea()){
					  return 0;
				  }
				  else if(c1.getArea() < c2.getArea()){
					  return 1;
				  }
				  else{
					  return -1;
				  }
 		  	}
		  }//end comp
		  
 	  }; 	 
 	  return byarea;
   }
     
public static Comparator<Country> createComparetorByName(final boolean incr){
	   
	   Comparator<Country>  byname= new Comparator<Country>(){
 		  @Override
 		  public  int compare(Country c1, Country c2){
 			  
 		 if(incr ==false){
 			  
	 			  if(c1.getName() == c2.getName()){
	 				  return 0;
	 			  }
	 			  else if(c1.getName().compareTo(c2.getName()) > 1 ){
	 				  return 1;
	 			  }
	 			  else{
	 				  return -1;
	 			  }
 			}
 		  
 		  else{
	 			 if(c1.getName() == c2.getName()){
					  return 0;
				  }
				  else if(c1.getName().compareTo(c2.getName()) > 0){
					  return -1;
				  }
				  else{
					  return 1;
				  }
 		  	}
		  }//end comp
 	  }; 	 
 	  return byname;
   }
}
   
