package reservation;
import java.io.*;
import java.lang.Thread.UncaughtExceptionHandler;
/**
 * @author Manzoor Ahmed
 *
 */

public class ReadFile {

        public ReadFile(){
            
        }
	/** @param filename, file name to read from
	 *  @exception Exception if file not found
	 * */
	public void readFromFile(String filename){
		try{
			 FileInputStream fstream = new FileInputStream(filename);
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 
			 String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine())!=null){
				  System.out.println(strLine);
			  }
			  in.close();
		}
		
		catch (Exception e){
			System.err.println("Something went werong! " +e.getMessage());
		}
	}
	
	/**@param filename, file name to read from for economy
	 * @return line[], the entire content of filename
	 * @exception IOException
	 * */
	public String [] readLine(String filename){
		String line[] = new String[20];
		try{
			FileInputStream fst = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fst);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			for(int i=0; i!= line.length-1;i++){
				line[i] = br.readLine();
			}
			
			br.close();
		}
		catch(IOException ex){
			ex.getLocalizedMessage();
		}
                catch(Throwable uh){
                     uh.getCause();
                }
		return line;
	}
	/**@param filename, file name to read from, for first class
	 * @return line[], the entire content of filename
	 * @exception IOException
	 * */
	public String [] readLine1(String filename){
		String line[] = new String[9];
		try{
			FileInputStream fst = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fst);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			for(int i=0; i!= line.length-1;i++){
				line[i] = br.readLine();
			}
			
			br.close();
		}
		catch(IOException ex){
			ex.getLocalizedMessage();
		}
                catch(Throwable uh){
                     uh.getCause();
                }
		return line;
	}
	
	
	
	
	/**@param input[], content of file
	 * @param match, the string we want to look for in input[]
	 * @return true if match found in input[], false otherwise
	 * @exception NullPointerException
	 * */
	public boolean doesInputMatch(String[] input, String match){
		try{
			for(int st=0;st!=input.length;st++){
				
				if(input[st].equals(match)){
					return true;
				}
			}
		}
		catch(NullPointerException nul){
			nul.getMessage();
		}
		return false;
	}
}
