package org.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This program is a simple demo of using a JLabel, some JSliders, and some buttons
 * and laying them out in a GridLayout.  This class contains a main() routine,
 * so that it can also be run as a stand-alone application.
 *  */
public class SliderAndButtonDemo extends JPanel implements ActionListener, ChangeListener {


    /**
     * The main() routine simply opens a window that shows a panel of type
     * SliderAndButtonDemo.  Note that the main() routine uses the pack()
     * method of the JFrame, so that the size of the panel will be
     * equal to its preferred size.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Slider and Button Demo");
        SliderAndButtonDemo content = new SliderAndButtonDemo();
        window.setContentPane(content);
        window.pack();
        window.setLocation(100,100);
        window.setResizable(false);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);
    }


    //---------------------------------------------------------------------

    /* Declare some controls as global variables so that they can be used
     * in the event-handling methods.  Note that the buttons don't have to
     * be global.
     */

    private JLabel displayLabel;   // label displaying "Hello World
    private JSlider bgColorSlider; // controls background color of label
    private JSlider fgColorSlider; // controls foreground color of label


    /**
     * The constructor creates components, sets up listening, and adds
     * the components to the panel.
     */
    public SliderAndButtonDemo() {

        setBorder(BorderFactory.createEmptyBorder(6,6,6,6));

        /* Create the display label, with properties to match the
               values of the sliders and with a BOLD font. */

        displayLabel = new JLabel("Hello World!", JLabel.CENTER);
        displayLabel.setOpaque(true);
        displayLabel.setBackground( new Color(100,100,100) );
        displayLabel.setForeground( Color.RED );
        displayLabel.setFont( new Font("Serif", Font.BOLD, 30) );
        displayLabel.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));

        /* Create the sliders, and set up the panel to listen for
           ChangeEvents that are generated by the sliders. */

        bgColorSlider = new JSlider(0,255,100);
        bgColorSlider.addChangeListener(this);

        fgColorSlider = new JSlider(0,100,0);
        fgColorSlider.addChangeListener(this);

        /* Create three buttons to control the font style, and set up the
           panel to listen for ActionEvents from the buttons. */

        JButton plainButton = new JButton("Plain Font");
        plainButton.addActionListener(this);
        JButton italicButton = new JButton("Italic Font");
        italicButton.addActionListener(this);
        JButton boldButton = new JButton("Bold Font");
        boldButton.addActionListener(this);


        /* Set the layout for the panel, and add the six components.
               Use a GridLayout with 3 rows and 2 columns, and with
               5 pixels between components. */

        setLayout(new GridLayout(3,2,5,5));
        add(displayLabel);
        add(plainButton);
        add(bgColorSlider);
        add(italicButton);
        add(fgColorSlider);
        add(boldButton);

    } // end constructor

    /**
     * This method will be called when the user  clicks one of the buttons.
     * The method just changes the label's font to the style specified by
     * the button.
     */
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (cmd.equals("Plain Font")) {
            displayLabel.setFont( new Font("Serif", Font.PLAIN, 30) );
        }
        else if (cmd.equals("Italic Font")) {
            displayLabel.setFont( new Font("Serif", Font.ITALIC, 30) );
        }
        else if (cmd.equals("Bold Font")) {
            displayLabel.setFont( new Font("Serif", Font.BOLD, 30) );
        }
    }

    /**
     * This method is called when the value is changed on either of the
     * sliders.  It sets the foreground or background color of the label
     * to match the value on the slider that has changed.
     */
    public void stateChanged(ChangeEvent evt) {
        if (evt.getSource() == bgColorSlider) {
            int bgVal = bgColorSlider.getValue();
            displayLabel.setBackground( new Color(bgVal,bgVal,bgVal) );
            // NOTE:  The background color is a shade of gray,
            //        determined by the setting on the slider.
        }
        else {
            float hue = fgColorSlider.getValue()/100.0f;
            displayLabel.setForeground( Color.getHSBColor(hue, 1.0f, 1.0f) );
            // Note:  The foreground color ranges through all the colors
            // of the spectrum.
        }
    }


} // end class SliderAndButtonDemo
