import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
   A class for testing an implementation of the Observer pattern.
*/
public class ObserverTester
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(new Double(33.0));
      data.add(new Double(44.0));
      data.add(new Double(22.0));
      data.add(new Double(22.0));

      final DataModel model = new DataModel(data);
      final TextFrame frame = new TextFrame(model);

      final BarFrame barFrame = new BarFrame(model);

   barFrame.addMouseListener(new MouseAdapter()
   {
       @Override
       public void mousePressed(MouseEvent e){

               double x = e.getX();
               double y=  e.getY();

               double whichBar= (y/(double)(barFrame.getHeight()))*(model.data.size());
               System.out.println((int)whichBar +" Bar clicked");
               double max = model.getMax();
               double value = (x/(double)barFrame.getWidth()) * max;

               if(whichBar >0&& whichBar < 1.35){
                    model.update(0, value);
                }

               else if(whichBar >1.35&& whichBar < 2.2){
                    model.update(1, value);
               }
               else if(whichBar >2.2&& whichBar < 3.0){
                    model.update(2, value);
                }
               else{
                    model.update(3, value);
                }
               
               for(int a=0;a!=model.data.size();a++){
                   String k = model.data.get(a).toString();
                   frame.fieldList[a].setText(k);
               }
               frame.repaint();
      }
   });
     model.attach(barFrame);
   }
}
