import javax.swing.JFrame;
import javax.swing.JComponent;
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
    private int BoardHeightPixels=100*5;
    private int BoardWidthPixels=100*5;
    private int BoxSizePixels=10*5;
    private int FrameHeight=BoardHeightPixels+39;
    private int FrameWidth=BoardWidthPixels+16;
    private JFrame Frame = new JFrame();
    private String[][] BoardMAP = new String[BoardWidth][BoardHeight]; /*0,1,S,s */

    public Board (String title, boolean visible, boolean editable)
    {
        Frame = new JFrame(title);             
        Frame.add(this);
        Frame.setSize(FrameWidth,FrameHeight);
        Frame.setVisible(visible);
        this.initBoardMap();
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    rectangleX=e.getX();
                    rectangleY=e.getY();
                    if (editable)
                    {
                        System.out.printf ("Executing mouseClicked method in Board class, X=%d, Y=%d\n", rectangleX, rectangleY); 
                        setrectangleXY (rectangleX, rectangleY, false);
                        Frame.repaint();
                    }
                    else if (!editable)
                    {
                        System.out.printf ("Executing mouseClicked method to FIRE in Board class, X=%d, Y=%d\n", rectangleX, rectangleY); 
                        setrectangleXY (rectangleX, rectangleY, true);
                        Frame.repaint();
                    }
                }       
            });
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
            if (BoardMAP[i][j]=="S") /*hit*/
                BoardMAP[i][j]="s";
            else                     /*miss*/
                BoardMAP[i][j]="1";
        }
        else
        {
            BoardMAP[i][j]="S";
        }
        this.printBoardMap();
    }

    private void initBoardMap()
    {
        System.out.print ("Executing initBoardMap method in Board class\n");
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                BoardMAP[i][j]="0";
                System.out.printf ("%s  ",BoardMAP[i][j]);
            }
            System.out.print ("\n");
        }
    }

    public void printBoardMap()
    {
        System.out.print ("Executing printBoardMap method in Board class\n");
        for(int i=0; i<BoardWidth; i++)
        {
            for(int j=0; j<BoardHeight; j++)
            {
                System.out.printf ("%s  ",BoardMAP[i][j]);
            }
            System.out.print ("\n");
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
                /*Ship is alive*/
                if (BoardMAP[i][j] == "S")
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                }
                /*Ships is sunk*/
                else if (BoardMAP[i][j] == "s")
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                    g.setColor(Color.RED);
                    g.drawLine(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                }
                /*Shot and Missed*/
                else if (BoardMAP[i][j] == "1")
                {
                    g.setColor(Color.RED);
                    g.fillRect(rectangleX,rectangleY,BoxSizePixels,BoxSizePixels);
                }
            }
        }
        System.out.print ("Executing paintComponent method in Board Class\n");
    }
}
