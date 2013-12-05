/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mvctester;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Manzoor Ahmed
 */
public class Model {

   public ArrayList<String> data;
   public ArrayList<ChangeListener> listeners;

   public Model(){
       data = new ArrayList<String>();
       listeners = new ArrayList<ChangeListener>();
   }

    public void add(String text){
        
        data.add(text);

        ChangeEvent listener = new ChangeEvent(this);

        for(ChangeListener l: listeners){
            l.stateChanged(listener);
        }
    }

   public void addChangeListener(ChangeListener c)
   {
      listeners.add(c);
   }

    public int getDataSize(){
        return data.size();
    }

    /**
     *
     * @param data
     * @return
     */

    public String toString(Model data){
        String result = "";
        for(int i=0;i!= data.data.size()-1;i++){
            result+= data.data.get(i).toString();
        }
    return result;
 }




























/**
    public Iterator<String> getItems(){
        return new Iterator<String>(){
            private int current =0;
            public boolean hasNext() {
                return current < data.size();
            }

            public String next() {
                return data.get(current++);
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    public String format(DataFormatter formatter){
        String r =  formatter.formatHeader();
        Iterator<String> iter = getItems();
        while(iter.hasNext()){
            r+=formatter.formatFooter();
        }
        return r+=formatter.formatFooter();
    }**/
}
