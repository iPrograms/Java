package reservation;
import java.io.*;


/**
 * @author Manzoor Ahmed
 *
 */

public class WriteFile{
	
        public WriteFile(){
            
        }

    public void updateFile(String filename,int k,char row,String reserved,String passenger){

		try{
			FileWriter writer = new FileWriter(filename,true);
			String number = Integer.toString(k);
            writer.write(number);
            writer.write("\t");
            writer.write(row);
            writer.write("\t");
            writer.write(reserved);
            writer.write("\t");
            writer.write(passenger);
            writer.write("\t");
            writer.write("");
            writer.write("\n");
            writer.close();             
		}
		catch(IOException ioe){
			ioe.getCause();
		}
        catch(NullPointerException poin){
                    poin.getCause();
        }
	}
	
    public void emptyFile(String filename){
    	try{
    		FileOutputStream erasor = new FileOutputStream(filename);
    		erasor.write((new String()).getBytes());
    		erasor.close();
    	}
    	
		catch(IOException fnf){
			fnf.getCause();
		}
    }
	
    public void readFromFile(String filename){
    	try{
    		File readfrom = new File(filename);
    		FileReader reader = new FileReader(readfrom);
    		BufferedReader bufreader = new BufferedReader(reader);
    		String line =null;
    		
    		while((line = bufreader.readLine())!=null){
    			System.out.println(line);
    			System.out.println("------------------------------------------------------------------------------");
    		}
    		bufreader.close();
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
	public void writeToFile(String seatnumber, String reserved,String passenger){

		try{
			FileWriter writer = new FileWriter("economy.txt",true);

                  for(int i=0;i!=20;i++){
                        String k = Integer.toString(i+1);
                        
                        writer.write(k+"\t"+seatnumber);
			writer.write("\t");
                        writer.write(reserved);
                        writer.write("\t");
                        writer.write(passenger);
                        writer.write("\t");
                        writer.write("********");
                        writer.write("\n");
                    }
                    writer.close();
		}
		catch(IOException ioe){
			ioe.getCause();
		}
                catch(NullPointerException poin){
                    poin.getCause();
                }
	}
}