
/**
 * Write a description of class Coordinate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coordinate
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Coordinate
     */
    public Coordinate()
    {
        // init instance variables
        x = 0;
        y = 0;
    }

    public Coordinate(int X, int Y)
    {
        // initialise instance variables
        x = X;
        y = Y;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getX()
    {
        // put your code here
        return x;
    }
    public int getY()
    {
        // put your code here
        return y;
    }
    public void setXY(int X, int Y)
    {
        x = X;
        y = Y;
    }    
    public void printX()
    {
         System.out.println("Executing printX method in Coordinate Class: " + x);
    }
}
