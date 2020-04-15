import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Program
{
	public static void main(String[] args)
    {
		JFrame frame = new JFrame("Tightrope");
        MyPanel panel=new MyPanel();
        panel.setPreferredSize(new Dimension(400,400));
		frame.add(panel);
        panel.addMouseMotionListener(panel);
        panel.addMouseListener(panel);
        frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyPanel extends JPanel implements MouseMotionListener, MouseListener
{
    public int x=0;
    public int y=0;
    public int w=10;
    public int playerX = -10;
    public int playerY = -10;
    public int level = 1;//level ID number
    public int alive = 0;//Player has purple box
    public int destoried = 0;//Players hits a wall
    
    public void paint(Graphics g)
    {
        //super.paint(g);
		Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,getWidth(),getHeight());
        
        if(level == 1){
			g2.setColor(Color.BLACK);
			g2.fillRect(0,380,400,20);
			g2.fillRect(380,0,20,400);
			g2.fillRect(0,0,20,400);
			g2.fillRect(0,0,400,20);
			
			g2.fillRect(0,0,200,200);
			g2.fillRect(100,220,300,180);
			g2.fillRect(220,60,180,340);
			
			g2.setColor(Color.RED);
			g2.fillRect(350,30,20,20);
			
			g2.setColor(Color.BLUE);
			g2.fillRect(50,330,20,20);
			
			g2.setColor(new Color(243,7,208));
			g2.fillRect(playerX-5,playerY-5,10,10);
		}
        
	}	
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
		if(alive == 1 && destoried == 1){
			alive = 0;
			destoried = 0;
		}
		
		x=e.getX();
		y=e.getY();
		
		if(level == 1 && x >= 50 && x <= 70 && y >= 320 && y <= 340){
			alive = 1;
		}
		
		if(alive == 1){
			playerX=e.getX();
			playerY=e.getY();
			repaint();
		}else{
			playerX = -100;
			playerY = -100;
			repaint();
		}
		
		if(level == 1 && x-5 < 20 || x > 100 && y > 220 || y > 380 || y < 200 && x < 200 || y > 60 && x > 220 || y < 20 || x > 370){
			destoried = 1;
		}
		if(level == 1 && x >= 350 && x <= 370 && y >= 30 && y <= 50){
			destoried = 1;
		}
	}
//   350,30,20,20
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
}
