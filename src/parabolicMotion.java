
public class parabolicMotion {
    private double x;
	private double y;
	private double initialX;
	private double initialY;
	private double angle;
	private double velocity;
	private double xVelocity;
	private double yVelocity;
	private double time;
	private double gravity;


    
    
    public void startingSetup(){
		x = 0;
		y = 0;
		initialX = x;
		initialY = y;
		angle = 45;
		velocity = 80;
		xVelocity = velocity * Math.cos(Math.toRadians(angle));
		yVelocity = velocity * Math.sin(Math.toRadians(angle));
		time = 0;
        gravity=9.8;
	}

	public double calculA(){
		return -4;
	}
	public double calculB(){
		return 0.5;

	}public double calculC(){
		return 1;
	}


    
    




}

