import java.io.*;

/**
 * @author Manzoor Ahmed
 *
 */

public class WriteFile{
	
	/**@param filename, the file name we want to write to
	 * @param id, the id to be written at the end of filename
	 * @exception IOException
	 * */
	public void writeToFile(String filename, String id){
		
		try{
			
			FileWriter writer = new FileWriter(filename,true);
			writer.write(id);
			writer.write("\n");
			writer.close();
		}
		catch(IOException ioe){
			ioe.getCause();
		}
	}
}