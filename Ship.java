import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Ship here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ship extends JComponent
{
    private static int rectangleX=0;
    private static int rectangleY=0;
    public Ship()
    {
    }

    public Ship(int PositionX, int PositionY)
    {
        rectangleX=PositionX;
        rectangleY=PositionY;
    }
    
    public void paintComponent(Graphics g)
    {
        System.out.print ("Executing painComponent method in Ship Class\n");
        g.setColor(Color.BLACK);
        g.fillRect(rectangleX,rectangleY,50,50);
    }
}
