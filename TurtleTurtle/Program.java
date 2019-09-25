/*Eric Chrisman 
 * TurtleTurtle Project
 * This program asks the user for how many sides they would want in a polygon
 * Then the program prints the image
 */
import java.util.Scanner;//for user input of sides

public class Program
{
	public static void main(String[] args)
	{
		System.out.println("Hello! This program draws polygons. Enter an integer number of sides for the polygon. Warning: big numbers take longer and may not fit the screen.");
		
		double PureCircle = 360;//This makes the program make the right shape and when to stop
		double Sides;//User's request
	    double Angle;//How much bob turns
	    
		Scanner sides = new Scanner(System.in);
		Sides = sides.nextInt();
		
		Angle = PureCircle / Sides;
		
		Turtle bob;
		bob = new Turtle();
		moveTurtle(PureCircle, Sides, Angle, bob);
	}
	
	public static void moveTurtle(double PureCircle,double Sides,double Angle,Turtle bob){
		bob.forward(30);//Controls bob
		bob.left(Angle);
		
		PureCircle = PureCircle - Angle;//Math that controls how much bob turns to complete the shape
		Sides--;
		
		if(Sides > 0){//This is a extremation to stop bob from going continuously going
			moveTurtle(PureCircle, Sides, Angle, bob);
		}
	}
}
	

