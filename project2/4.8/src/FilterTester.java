
public class FilterTester{

	/**
	 * @param args
	 */
	
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
			
			public boolean accept(String x){
				if(x.length()-1 <=2){
					return true;
				}
				return false;
			}
		};
		
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
	
	String[] result = filter(input,fil);
	for(int st=0;st!=result.length-1;st++){
		System.out.println(result[st]);
	}
	}
}
