/*
 * @author Manzoor Ahmed
 * CS 151
 * **/
public class FilterTester{

	/***************************************************
	 * @param String [] a, the whole input
	 * @param Fileter object which calls accept
	 * @return String[] three, the string with three chars
	 * **************************************************/
	public static String[] filter(String[] a, Filter f){
		
		String[] three = new String[a.length-1];
	
		for(int s=0;s!=a.length-1;s++){
			
			if(f.accept(a[s])==true){
				three[s]=a[s];
			}
		}
		return three;
	}
	
	public static void main(String[] args) {
    //instantiate Filter object
	    Filter fil = new Filter(){
			@Override
			public boolean accept(String x){
				if(x.length()-1 <=2){ //if lenght is <= 2
					return true;      //found
				}
				return false;
			}
		};
		
	//to hold input	
	String[] input = new String[10];
	
	input[0] ="abcd";
	input[1] ="abcdasdf";
	input[2] ="abcdsd";
	input[3] ="abc";
	input[4] ="xyd";
	input[5] ="and";
	input[6] ="aic";
	input[7] ="ad";
	input[8] ="d";
	input[9] ="c";
	
	//all strings with lenght <= 2
	String[] result = filter(input,fil);
	//print
	for(int st=0;st!=input.length-1;st++){
		System.out.println(result[st]);
	}
	}
}
