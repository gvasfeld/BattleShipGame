
/**
 * Write a description of class BoardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoardTester
{
    public static void main (String [] args)
    {
        Board ComputerBoard = new Board("COMPUTER SHIPS",true);
        ComputerBoard.setBoardType("COMPUTER");
        Board PlayerBoard = new Board ("PLAYER SHIPS",true);
        PlayerBoard.setBoardType("PLAYER");
        PlayerBoard.printBoardMap();
        ComputerBoard.setComputerShips();
        ComputerBoard.printBoardMap();
    }
}
