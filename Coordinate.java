
/**
 * Write a description of class Coordinate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coordinate
{
    private int x;
    private int y;

    /**
     * Constructor for objects of class Coordinate
     */
    public Coordinate()
    {
        x = 0;
        y = 0;
    }

    public Coordinate(int X, int Y)
    {
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
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setXY(int X, int Y)
    {
        x = X;
        y = Y;
    }    
}
