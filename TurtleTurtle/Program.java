/*Eric Chrisman 
 * TurtleTurtle Project
 * This program asks the user for how many sides they would want in a polygon
 * Then the program prints the image
 */
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		System.out.println("Hello! This program draws polygons. Enter an integer number of sides for the polygon. Warning: big numbers take longer and may not fit the screen.");
		int PureCircle = 360;//This makes the program make the right shape and when to stop
		int Sides;//User's request
		int Angle;//How much bob turns
		Scanner sides = new Scanner(System.in);
		Sides = sides.nextInt();
		Angle = PureCircle / Sides;
		
		Turtle bob;
		bob = new Turtle();
			
		while(PureCircle > 0)
		{
			bob.speed(100);
			bob.forward(50);
			bob.left(Angle);
			PureCircle = PureCircle - Angle;
		}
		
		
		
	}
}
