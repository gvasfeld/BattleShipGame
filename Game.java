import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game extends JComponent
{
    public static void main(String [] args)
    {
        System.out.print ("\nBeginExecuting main method in Game Class\n");
        Board ComputerBoard = new Board("COMPUTER SHIPS", true, false);
        Board PlayerBoard = new Board ("PLAYER SHIPS", true, true);
        ComputerBoard.printBoardMap();
        PlayerBoard.printBoardMap();
        System.out.print ("\nEnd Executing main method in Game Class\n");
    }
}
