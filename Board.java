import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board extends JComponent
{
    private int rectangleX=0;
    private int rectangleY=0; 
    private int BoardHeight=10;
    private int BoardWidth=10;
    private int MaxCells=BoardHeight*BoardWidth;
    private int BoardHeightPixels=100*5;
    private int BoardWidthPixels=100*5;
    private int BoxSizePixels=10*5;
    private int FrameHeight=BoardHeightPixels+22;
    private int FrameWidth=BoardWidthPixels;
    private int MaxShips=15;
    private JFrame Frame = new JFrame();
    private String[][] BoardMAP = new String[BoardWidth][BoardHeight]; /*0,m,S,s */
    private String BoardType=""; //PLAYER or COMPUTER

    public Board (String title)
    {
        Frame = new JFrame(title);             
        Frame.add(this);
        Frame.setSize(FrameWidth,FrameHeight);
        Frame.setVisible(true);
        initBoardMap();
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    rectangleX=e.getX();
                    rectangleY=e.getY();
                    if (BoardType.equals ("PLAYER"))
                    {      
                        //System.out.println("Executing mouseClicked method in Board class, X="+rectangleX+", Y="+rectangleY+" for "+getBoardType()+" object");
                        if (returnTotalShipNum()==MaxShips)
                        {
                            firePlayerShips();
                            if (returnAliveShipNum()< 1)
                            {
                                //System.out.println("Executing printBoardMap method in Board class , COMPUTER WINS, GAME OVER");
                                String temp="GAME OVER, COMPUTER WINS ";
                                JOptionPane.showMessageDialog(Frame, temp);
                            }
                        }
                        else if(returnAliveShipNum()<MaxShips )
                        {     
                            setrectangleXY (rectangleX, rectangleY, false);                            
                            //System.out.println("Player's number of ships: " + returnAliveShipNum() + ",  Max is: " + MaxShips);
                            if (returnAliveShipNum()< 1)
                            {
                                //System.out.println("Executing printBoardMap method in Board class , COMPUTER WINS, GAME OVER");
                                String temp="GAME OVER, COMPUTER WINS ";
                                JOptionPane.showMessageDialog(Frame, temp);
                            }                     
                        }

                        //System.out.println("Executing mouseClicked method in Board class,adjusted X="+rectangleX+", Y="+rectangleY+" for "+getBoardType()+" object");
                        Frame.repaint();   
                    }
                    else if (BoardType.equals ("COMPUTER"))
                    {                
                        //System.out.println("Executing mouseClicked method to FIRE in Board class, X="+rectangleX+", Y="+rectangleY+" for "+getBoardType()+" object");
                        setrectangleXY (rectangleX, rectangleY, true);
                        if (returnAliveShipNum()<1)
                        {
                            //System.out.println("Executing printBoardMap method in Board class , PLAYER WINS, GAME OVER");
                            String temp="GAME OVER, PLAYER WINS";
                            JOptionPane.showMessageDialog(Frame, temp);
                        }
                        //shootPlayer();
                        Frame.repaint();
                    }   
                    printBoardMap();
                }
            });
    }

    public void setBoardType(String boardtype)
    {
        BoardType=boardtype;

    }

    public String getBoardType()
    {
        return BoardType;
    }

    private void setrectangleXY (int x, int y, boolean fire)
    {
        int i=0;
        int j=0;
        if (x>=0 & x<=50)
        {
            rectangleX=0;
            j=0;
        }
        else if (x>50 & x<=100)
        {
            rectangleX=50;
            j=1;
        }
        else if (x>100 & x<=150)
        {
            rectangleX=100;
            j=2;
        }
        else if (x>150 & x<=200)
        {
            rectangleX=150;
            j=3;
        }
        else if (x>200 & x<=250)
        {
            rectangleX=200;
            j=4;
        }
        else if (x>250 & x<=300)
        {
            rectangleX=250;
            j=5;
        }
        else if (x>300 & x<=350)
        {
            rectangleX=300;
            j=6;
        }
        else if (x>350 & x<=400)
        {
            rectangleX=350;
            j=7;
        }
        else if (x>400 & x<=450)
        {
            rectangleX=400;
            j=8;
        }
        else if (x>450 & x<=500)
        {
            rectangleX=450;
            j=9;
        }

        if (y>=0 & y<=50)
        {
            rectangleY=0;
            i=0;
        }
        else if (y>50 & y<=100)
        {
            rectangleY=50;
            i=1;
        }
        else if (y>100 & y<=150)
        {
            rectangleY=100;
            i=2;
        }
        else if (y>150 & y<=200)
        {
            rectangleY=150;
            i=3;
        }
        else if (y>200 & y<=250)
        {
            rectangleY=200;
            i=4;
        }
        else if (y>250 & y<=300)
        {
            rectangleY=250;
            i=5;
        }
        else if (y>300 & y<=350)
        {
            rectangleY=300;
            i=6;
        }
        else if (y>350 & y<=400)
        {
            rectangleY=350;
            i=7;
        }
        else if (y>400 & y<=450)
        {
            rectangleY=400;
            i=8;
        }
        else if (y>450 & y<=500)
        {
            rectangleY=450;
            i=9;
        }
        if (fire){
            if (BoardMAP[i][j]=="S")
            { /*hit*/
                System.out.println ("Sorry " + getBoardType()+", You've been hit!!, at posX="+j+", posY="+i);
                BoardMAP[i][j]="s";
            }
            else if (BoardMAP[i][j] != "s")                    /*miss*/
                BoardMAP[i][j]="m";
        }
        else
        {
            BoardMAP[i][j]="S";
        }
        //printBoardMap();
    }

    public int returnAliveShipNum()
    {
        int shipNum = 0;
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                if(BoardMAP[i][j].equals("S"))
                {
                    shipNum++;
                }
            }
        }
        return shipNum;
    }

    public int returnTotalShipNum()
    {
        int shipNum = 0;
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                if((BoardMAP[i][j].equals("S")) || (BoardMAP[i][j].equals("s")))
                {
                    shipNum++;
                }
            }
        }
        return shipNum;
    }

    public int returnSunkedShipNum()
    {
        int shipNum = 0;
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                if(BoardMAP[i][j].equals("s"))
                {
                    shipNum++;
                }
            }
        }
        return shipNum;
    }

    private void initBoardMap()
    {
        //System.out.println ("Executing initBoardMap method in Board class for " + getBoardType() + " object");
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                BoardMAP[i][j]="0";
                //System.out.print(BoardMAP[i][j] + "  ");
            }
            //System.out.println();
        }
    }

    public void printBoardMap()
    {
        System.out.println("Executing printBoardMap method in Board class for "+getBoardType()+" object");
        System.out.println("ALIVE:"+ returnAliveShipNum()+", SUNK: " + returnSunkedShipNum()+", TOTAL: "+ returnTotalShipNum()+", MAX alowed: " + MaxShips);
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                System.out.print(BoardMAP[i][j] + "  ");
            }
            System.out.println();
        }
        if (returnTotalShipNum()==MaxShips)
        {
            System.out.println("******READY TO SHOOT********");
        }
        else
        {
            System.out.println("****************************");
        }
    }


    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,BoardHeightPixels,BoardWidthPixels);
        g.setColor(Color.BLACK);
        for(int i=0; i<BoardHeightPixels; i+=BoxSizePixels)
        {
            g.drawLine(0,i,BoardHeightPixels,i);
        }
        for(int i=0; i<BoardWidthPixels; i+=BoxSizePixels)
        {
            g.drawLine(i,0,i,BoardWidthPixels);
        }

        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                /*Set rectangleX and rectangleY for every box*/
                if (j==0)
                {
                    rectangleX=0;
                }
                else if (j==1)
                {
                    rectangleX=50;
                }
                else if (j==2)
                {
                    rectangleX=100;
                }
                else if (j==3)
                {
                    rectangleX=150;
                }
                else if (j==4)
                {
                    rectangleX=200;
                }
                else if (j==5)
                {
                    rectangleX=250;
                }
                else if (j==6)
                {
                    rectangleX=300;
                }
                else if (j==7)
                {
                    rectangleX=350;
                }
                else if (j==8)
                {
                    rectangleX=400;
                }
                else if (j==9)
                {
                    rectangleX=450;
                    j=9;
                }
                if (i==0)
                {
                    rectangleY=0;
                }
                else if (i==1)
                {
                    rectangleY=50;
                }
                else if (i==2)
                {
                    rectangleY=100;
                }
                else if (i==3)
                {
                    rectangleY=150;
                }
                else if (i==4)
                {
                    rectangleY=200;
                }
                else if (i==5)
                {
                    rectangleY=250;
                }
                else if (i==6)
                {
                    rectangleY=300;
                }
                else if (i==7)
                {
                    rectangleY=350;
                }
                else if (i==8)
                {
                    rectangleY=400;
                }
                else if (i==9)
                {
                    rectangleY=450;
                    i=9;
                }

                /*Alive*/
                if (BoardMAP[i][j] == "S")
                {
                    if (BoardType.equals ("PLAYER"))
                    {
                        g.setColor(Color.BLACK);
                        g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                        g.setColor(Color.WHITE);
                        g.drawRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                    }
                }

                /*Successfull hit*/
                else if (BoardMAP[i][j] == "s")
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                    //g.setColor(Color.RED);
                    //g.drawLine(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                    //Draws yellow circles when hit
                    g.setColor(Color.YELLOW);
                    g.fillOval(rectangleX+5,rectangleY+5,BoxSizePixels-10,BoxSizePixels-10);
                    g.setColor(Color.RED);
                    g.drawOval(rectangleX+5,rectangleY+5,BoxSizePixels-10,BoxSizePixels-10);
                    g.setColor(Color.WHITE);
                    g.drawRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                }
                /*Shot and Missed*/
                else if (BoardMAP[i][j] == "m")
                {
                    g.setColor(Color.RED);
                    g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                    g.setColor(Color.WHITE);
                    g.drawRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                }
            }
        }
        //System.out.println("Executing paintComponent method in Board Class\n");
    }

    public void setComputerShips()
    {
        //figure out how t get random ships all over the board
        int random = 0;
        int shipNum = 0;
        int cellnum=0;
        Coordinate[] Cells = new Coordinate [MaxCells];
        for(int x=0; x<BoardWidth; x++)
        {
            for(int y=0; y<BoardHeight; y++)
            {
                if (cellnum<MaxCells)
                {
                    //System.out.println("Cellnum: " + cellnum + ", x=" + x + ",y=" + y); 
                    Cells[cellnum] = new Coordinate (x, y);
                    cellnum++;
                }
            }
        }
        while(shipNum<MaxShips)
        {
            random = (int)(Math.random() * MaxCells);
            //System.out.println("Executing setComputerShips method in Board Class, random cell is: "+random+" out of "+MaxCells);
            if(BoardMAP[Cells[random].getX()][Cells[random].getY()].equals("0"))
            {
                BoardMAP[Cells[random].getX()][Cells[random].getY()]="S";
                shipNum++;            
            }
            else
            {
                //System.out.println("Executing setComputerShips method in Board Class, handling collision, there is already a ship at position: "+ random);
            }
        }
    }

    public void firePlayerShips()
    {
        //figure out how t get random ships all over the board
        int random = 0;
        int shipNum = 0;
        int cellnum=0;
        Coordinate[] Cells = new Coordinate [MaxCells];
        for(int x=0; x<BoardWidth; x++)
        {
            for(int y=0; y<BoardHeight; y++)
            {
                if (cellnum<MaxCells)
                {
                    //System.out.println("Cellnum: " + cellnum + ", x=" + x + ",y=" + y); 
                    Cells[cellnum] = new Coordinate (x, y);
                    cellnum++;
                }
            }
        }
        random = (int)(Math.random() * MaxCells);
        //System.out.println("Executing firePlayerShipsmethod in Board Class, cell is: "+random);
        if(BoardMAP[Cells[random].getX()][Cells[random].getY()].equals("S"))
        {
            BoardMAP[Cells[random].getX()][Cells[random].getY()]="s";
            System.out.println("Executing firePlayerShipsmethod in Board Class, successfull hit, cell is: "+random+ ", posX="+Cells[random].getY()+", posY="+Cells[random].getX());           
        }
        else if(BoardMAP[Cells[random].getX()][Cells[random].getY()].equals("s"))
        {
            System.out.println("Executing firePlayerShipsmethod in Board Class, already shot here and sunk, retrying using recursion, cell is: "+random+ ", posX="+Cells[random].getY()+", posY="+Cells[random].getX());
            firePlayerShips();
        }
        else if(BoardMAP[Cells[random].getX()][Cells[random].getY()].equals("m"))
        {
            System.out.println("Executing firePlayerShipsmethod in Board Class, already shoot here and missed, retrying using recursion, cell is: "+random+ ", posX="+Cells[random].getY()+", posY="+Cells[random].getX());
            firePlayerShips();
        }
        else if(BoardMAP[Cells[random].getX()][Cells[random].getY()].equals("0"))
        {
            BoardMAP[Cells[random].getX()][Cells[random].getY()]="m";
            System.out.println("Executing firePlayerShipsmethod in Board Class, missed, cell is: "+random+ ", posX="+Cells[random].getY()+", posY="+Cells[random].getX());    
        }
        //rectangleX=Cells[random].getX();
        //rectangleY=Cells[random].getY();        
    }
}
