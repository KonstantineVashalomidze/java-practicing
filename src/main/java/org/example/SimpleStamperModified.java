package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is representation of drawing, it draws rectangles on mouse coordinates
 * when dragged, if shift+mouseButton is clicked then everything will be cleared.
 * there will be two figures available for drawing with mouseButton1 an mouseButton3.
 * @author Konstantine Vashalomidze
 */
public class SimpleStamperModified
    extends JFrame
{
    private Toolkit toolkit = Toolkit.getDefaultToolkit(); // Tools from os
    public final static int WIDTH = 500, HEIGHT = 400; // Width and Height of the window

    public SimpleStamperModified()
    {
        DrawingArea drawingArea = new DrawingArea(); // Creating Drawing Area
        getContentPane().add(drawingArea); // Add drawing area to content pane. Drawing area will be filled.




        setSize(WIDTH, HEIGHT); // set width and height
        // Center the window in the middle of the screen
        setLocation((toolkit.getScreenSize().width - WIDTH) / 2,
                (toolkit.getScreenSize().height - HEIGHT) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when x on the window is pressed
        setVisible(true);
    } // end of SimpleStamperModified()


    public static void main(String[] args) {
        EventQueue.invokeLater(SimpleStamperModified::new);
    } // end of main()


    /**
     * Drawing will happen on this panel.
     */
    private class DrawingArea
        extends JPanel
        implements MouseMotionListener
    {
        public DrawingArea()
        {
            setBackground(Color.ORANGE);
            addMouseMotionListener(this);
        } // end of DrawingArea()


        @Override
        public void mouseDragged(MouseEvent e)
        {

            int x = e.getX();  // x-coordinate where user clicked.
            int y = e.getY();  // y-coordinate where user clicked.
            Graphics g = getGraphics();  // Graphics context for drawing directly.

            if (e.isShiftDown())
            {
                // The user was holding down the Shift key.  Just repaint the panel.
                // Since this class does not define a paintComponent() method, the
                // method from the superclass, JPanel, is called.  That method simply
                // fills the panel with its background color, which is black.  The
                // effect is to clear the panel.
                repaint();
                return;
            }
            if (SwingUtilities.isLeftMouseButton(e))
            // if left button
            {
                // User right-clicked at the point (x,y). Draw a blue oval centered
                // at the point (x,y). (A black outline around the oval will make it
                // more distinct when shapes overlap.)
                g.setColor(Color.BLUE);  // Blue interior.
                g.fillOval( x - 30, y - 15, 60, 30 );
                g.setColor(Color.BLACK); // Black outline.
                g.drawOval( x - 30, y - 15, 60, 30 );
            }
            else if (SwingUtilities.isRightMouseButton(e))
            // if right button
            {
                // User left-clicked (or middle-clicked) at (x,y).
                // Draw a red rectangle centered at (x,y).
                g.setColor(Color.RED);   // Red interior.
                g.fillRect( x - 30, y - 15, 60, 30 );
                g.setColor(Color.BLACK); // Black outline.
                g.drawRect( x - 30, y - 15, 60, 30 );
            }
            g.dispose();  // We are finished with the graphics context, so dispose of it.

        } // end of mouseDragged()


        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }



}
