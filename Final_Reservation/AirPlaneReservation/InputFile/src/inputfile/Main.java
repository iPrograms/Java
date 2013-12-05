/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inputfile;

/**
 *
 * @author shams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if(args.length<=0){
            System.out.println("No arguments");
        }
        for(int i=0;i!=args.length;i++){
            System.out.println(args[i]);
        }
    }

}
