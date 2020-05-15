package predatorprey;

import java.util.Collections;
import java.util.ArrayList;
import java.util.ArrayList.*;

public class Predator extends Animal{
	
	public boolean graze;
	public int rechargeEat = 10; // how long it takes to eat again
	public int rechargeBirth = 10; //how long it takes for birth
	
	
	public Predator(){
		super();
	}
	
	public Predator(int x, int y){
		super(x, y);
	}
	
	public void eat(){
		ArrayList<Animal> targets;
		targets = eco.getAdjacentPrey(x, y);
		
		
		if ( targets.isEmpty() || rechargeEat > 0){
			int dx =  (int) ( Math.random()*(1+1+1) ) -1;
			int dy =  (int) ( Math.random()*(1+1+1) ) -1;
			move(dx, dy);
			if (!(dx ==0 && dy ==0)){
				energy --;
				}
			rechargeEat --;
			
		} else {
			Collections.shuffle(targets);
			Animal p = targets.get(0);
			energy = energy + p.energy;
			p.energy = 0;
			targets.clear();
			System.out.println("NOM");
			// at least 1 prey
			rechargeEat = 3;
		}
		
		
		// 	check to see if Prey is adjacent
		//		???
		//	If one or more adjacent prey animals
		//		Select 1
		//			???
		//		That Prey target dies
		//			target.die()
		//		Predator energy increases
		//			energy += SomeAmount
		
	}
	
	public void checkReproduce(){
		if (energy > energyRepThresh && rechargeBirth <= 0){
			reproduce();
		}else{
			rechargeBirth --;
		}
	}
	
	public void reproduce(){
		energy -= energyRepThresh-15;
		Predator a = new Predator(x, y);
		a.eco = this.eco;
		a.energy = 5;
		eco.birthList.add(a);
		System.out.println("birth to wolf");
		rechargeBirth = 3;
	}
	
	public void act(){
		
		eat();
			
		checkDeath();
		checkReproduce();
		energy = energy - 1;
	}
	
	public void sayHi(){
		System.out.printf("%s says hi!\n", this);
	}
	
}



