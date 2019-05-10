
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
        Board ComputerBoard = new Board("COMPUTER SHIPS");
        ComputerBoard.setBoardType("COMPUTER");
        System.out.println(ComputerBoard.getBoardType());
        Board PlayerBoard = new Board ("PLAYER SHIPS");
        PlayerBoard.setBoardType("PLAYER");
        System.out.println(PlayerBoard.getBoardType());
        PlayerBoard.printBoardMap();
        ComputerBoard.setComputerShips();
        ComputerBoard.printBoardMap();   

        System.out.print("\nEnd Executing main method in Game Class\n");
    }
}
