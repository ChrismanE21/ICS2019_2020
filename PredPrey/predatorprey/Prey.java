package predatorprey;

public class Prey extends Animal{
	
	public boolean graze;
	
	
	public Prey(){
		super();
	}
	
	public Prey(int x, int y){
		super(x, y);
	}
	
	public void eat(){
		energy += 5;
	}
	
	public void checkReproduce(){
		if (energy > energyRepThresh-10)
			reproduce();
	}
	
	public void reproduce(){
		energy -= energyRepThresh-10;
		Prey a = new Prey(x, y);
		a.eco = this.eco;
		a.energy = 10;
		eco.birthList.add(a);
		System.out.println("birth to bunny");
	}
	
	public void act(){
		

		
		if (graze)
			eat();
		
		else{
			int dx =  (int) ( Math.random()*(1+1+1) ) -1;
			int dy =  (int) ( Math.random()*(1+1+1) ) -1;
			
			move(dx, dy);
			if (!(dx ==0 && dy ==0))
				energy --;
		}
			
		checkDeath();
		checkReproduce();
	}
	
	public void sayHi(){
		System.out.printf("%s says hi!\n", this);
	}
	
}



