import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
/**
 * Write a description of class Game here.
 * Spin-off of the classic game of Battleship named WaterWorld!
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game extends JComponent
{
    public static void main(String [] args)
    {
        //Players fire depends on computers fire and vice versa
        System.out.print ("\nBeginExecuting main method in Game Class\n");
        Board ComputerBoard = new Board("COMPUTER SHIPS", true);
        ComputerBoard.setBoardType("COMPUTER");
        Board PlayerBoard = new Board ("PLAYER SHIPS", true);
        PlayerBoard.setBoardType("PLAYER");
        ComputerBoard.printBoardMap();        
        PlayerBoard.printBoardMap();
        ComputerBoard.setComputerShips();
        ComputerBoard.printBoardMap();   

        System.out.print("\nEnd Executing main method in Game Class\n");
    }
}
