/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypkg;

/**
 *
 * @author Manzoor Ahmed
 */
public class MailSystemTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MailSystem system = new MailSystem(MAILBOX_COUNT);

      Telephone p1 = new Telephone();
      Telephone p2 = new Telephone();


      Connection c1 = new Connection(system, p1);
      Connection c2 = new Connection(system, p2);
      
      p1.run(c1);
      p2.run(c2);
    
    }
private static int MAILBOX_COUNT = 20;
}
