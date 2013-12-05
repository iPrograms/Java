/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mvctester;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/******************************************************
 *
 * @author Manzoor Ahmed
 * CS 151
 * October 11,2012
 *****************************************************/

public class MVCTester {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     final Model data = new Model();

     JButton add = new JButton("Add");
   
     final JTextArea output = new JTextArea();

     output.setBackground(Color.GRAY);
     output.setForeground(Color.white);

     output.setEditable(false);
     final JTextArea input = new JTextArea();


     JFrame frame = new JFrame();
   
     //add panels to frame
     frame.add(input,BorderLayout.NORTH);
     frame.add(output,BorderLayout.CENTER);
     frame.add(add,BorderLayout.SOUTH);   


     frame.setSize(300, 500);
     frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
     frame.setVisible(true);

     //changelistener
     ChangeListener listener = new
        ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                output.setText(data.toString(data)); 
            }
    };

    data.addChangeListener(listener);

    //action listener
    add.addActionListener(new ActionListener()
    {
            public void actionPerformed(ActionEvent e) {
                data.add(input.getText().trim());
                data.add("\n");
            }
    });
    }
}
