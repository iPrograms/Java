/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypkg;

/**
 *
 * @author Manzoor Ahmed
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Shape;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        frame.add(new JButton("Make the car smaller or bigger"),BorderLayout.NORTH);

        final JSlider slider = new JSlider(JSlider.HORIZONTAL);
        frame.add(slider,BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);

        final CarIcon car = new CarIcon(100,100,50,50);
        car.setPreferredSize(new Dimension(50,50));
        frame.add(car,BorderLayout.CENTER);
        slider.setValue(10);

        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
               car.update(100, 100,slider.getValue());
               car.validate();
               car.repaint();
            }
        });
    }
}
