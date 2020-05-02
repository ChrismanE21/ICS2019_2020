import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.lang.Math.*;

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
    public int[][] allPaths = new int [50][4];
    public int[] theGoal = new int [4];
    public int[] theStart = new int [4];
    public int pathNumber = 0;
    public int done = 0;
    public int safe = 0;
    public int[][] board = new int [10][10];
	public int[] threeBoard = {3,3,3,3,3,3,3,3,3,3};
	public int[] zeroBoard = {3,0,0,0,0,0,0,0,0,3};
    public int min = 1;
    public int max = 4;
    public int range = max - min + 1;
    public int[] start = {0,0};
    public int[] lastOne = {0,0};
    
    public void paint(Graphics g){
        //super.paint(g);
		Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,getWidth(),getHeight());
        paintAll(g2);
        if(done == 0){
			createBoard();
			done = 1;
		}
		createPlayer(g2,playerX-2,playerY-2,4,4);
	}	
	
	public void createPath(int x,int y,int w,int h){
		allPaths[pathNumber][0] = x;
		allPaths[pathNumber][1] = y;
		allPaths[pathNumber][2] = w;
		allPaths[pathNumber][3] = h;
		pathNumber += 1;
	}
	
	public void createGoal(int x,int y,int w,int h){
		theGoal[0] = x;
		theGoal[1] = y;
		theGoal[2] = w;
		theGoal[3] = h;
	}
	
	public void createStart(int x,int y,int w,int h){
		theStart[0] = x;
		theStart[1] = y;
		theStart[2] = w;
		theStart[3] = h;
	}
	
	public Graphics2D createPlayer(Graphics2D g2,int x,int y,int w,int h){
		g2.setColor(new Color(243,7,208));
		g2.fillRect(x,y,w,h);
		return g2;
	}
	
	public void paintAll (Graphics2D g2){
		g2.setColor(Color.WHITE);
		for (int i = 0; i < pathNumber; i++){
			g2.fillRect(allPaths[i][0],allPaths[i][1],allPaths[i][2],allPaths[i][3]);
				if(i == pathNumber - 1){
					createGoal(allPaths[i][0],allPaths[i][1],allPaths[i][2],allPaths[i][3]);
				}
		}
		g2.setColor(Color.RED);
		g2.fillRect(theGoal[0],theGoal[1],theGoal[2],theGoal[3]);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(theStart[0],theStart[1],theStart[2],theStart[3]);
	}
	
	public int getRandom(){
		return (int)(Math.random()*range)+ min; 
	}
	
	public void freshBoard(){
		for(int i=0; i<=9; i++){
			for(int j=0; j<=9; j++){
				if(i == 0 || i == 9){
					board[i][j] = threeBoard[j];
				}else{
					board[i][j] = zeroBoard[j];
				}
			}
		}
	}
	
	public void findStart(){
		start[0] = getRandom() + 1;
		start[1] = getRandom() + 1;
		board[start[0]][start[1]] = 1;
		}
	
	
	public void printBoard(){
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				System.out.print(board[i][j]);
			}
		System.out.println();
		}
	System.out.println();
	}
			
	
	public void createBoard(){//0 == blank, 1 == develpoing line, 2 == path, 3 == outline
		int movement = 1;//1 for up, 2 for left, 3 for down, 4 for right
		freshBoard();
		findStart();
		for(int move = 20; move >= 0;move--){ 
			for(int i = 1; i<=8; i++){
				for(int j = 1; j<=8; j++){
					if(board[i][j] == 1){
						lastOne[0] = i;
						lastOne[1] = j;
						movement = getRandom();
						System.out.println(movement);
						for(int giveUp = 0; giveUp <= 30; giveUp++){
							giveUp--;
							if(movement == 1 && board[i][j-1] == 0 && move != 1){//went up
								board[i][j] = move;
								board[i][j-1] = 1;
								createPath(i * 40 - 30, j * 40 - 60,20,40);
								i = 999;
								j = 999;
								giveUp = 999;
							}else if(movement == 2 && board[i-1][j] == 0 && move != 1){//went left
								board[i][j] = move;
								board[i-1][j] = 1;
								createPath(i * 40 - 60,j * 40 - 30,40,20);
								i = 999;
								j = 999;
								giveUp = 999;
							}else if(movement == 3 && board[i][j+1] == 0 && move != 1){//went down
								board[i][j] = move;
								board[i][j+1] = 1;
								createPath(i * 40 - 30,j * 40 - 30,20,40);
								i = 999;
								j = 999;
								giveUp = 999;
							}else if(movement == 4 && board[i+1][j] == 0 && move != 1){//went right
								board[i][j] = move;
								board[i+1][j] = 1;
								createPath(i * 40 - 30, j * 40 - 30,40,20);
								i = 999;
								j = 999;
								giveUp = 999;
							}else{
								movement = getRandom();
								giveUp++;
								if(giveUp == 30){
									System.out.println("Gaved Up!");
									move = 0;
								}
							}
						}
					}	
				}
			}
		}
		createStart(start[0] * 40 - 30, start[1] * 40 - 30, 20,20);
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
		
		if(x > theStart[0] && x < theStart[0] + theStart[2] && y > theStart[1] && y < theStart[1] + theStart[3]){
			alive = 1;
			safe = 0;
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
		
		for(int i=0;i<pathNumber;i++){
			if(x < allPaths[i][0] || x > allPaths[i][0] + allPaths[i][2] || y < allPaths[i][1] || y > allPaths[i][1] + allPaths[i][3]){
				safe ++;
			}
		}

		if(safe >= pathNumber){
			destoried = 1;
		}else{
			safe = 0;
		}
		
		if(x > theGoal[0] && x < theGoal[0] + theGoal[2] && y > theGoal[1] && y < theGoal[1] + theGoal[3] && destoried == 0){
			destoried = 1;
			done = 0;
			pathNumber = 0;
		}
	}
	
	
//   350,30,20,20
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
}
