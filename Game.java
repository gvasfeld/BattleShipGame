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
        System.out.println("Beginning game: Water World");
        System.out.println();
        System.out.println("The board you will be shooting at is under PLAYER SHIPS board.");
        System.out.println();
        System.out.println("Move over PLAYER SHIPS Board in order to see both of the boards.");
        Board ComputerBoard = new Board("COMPUTER SHIPS",false);
        ComputerBoard.setBoardType("COMPUTER");
        Board PlayerBoard = new Board ("PLAYER SHIPS",false);
        PlayerBoard.setBoardType("PLAYER");
        ComputerBoard.setComputerShips();
        System.out.println();        
        System.out.println("INSTRUCTIONS");
        System.out.println();
        System.out.println("COMPUTER SHIPS board has been set and ships are invisible");
        System.out.println();
        System.out.println("1. Begin setting player ships by clicking squares on PLAYER SHIPS board.");
        System.out.println("You need to select 15 squares before you may begin firing.");
        System.out.println("Once fifteen ships are selected, you may no longer click on your own board.");
        System.out.println();
        System.out.println("2. Click on COMPUTER SHIPS board to start firing. ");
        System.out.println();
        System.out.println("Goal to win: Sink 15 computer ships before computer sinks all of yours!");
        System.out.println();
        System.out.println("NOTE: The game will allow you to shoot more than once in a row. DON'T CHEAT!");
        
        System.out.println();
        System.out.println("COLOR KEY");
        System.out.println();
        System.out.println("BLUE:   WATER");
        System.out.println("BLACK:  SHIP");
        System.out.println("RED:    MISFIRE");
        System.out.println("YELLOW: HIT");
        System.out.println();
        System.out.println("****READY TO PLAY****");
        System.out.println();
    }
}
