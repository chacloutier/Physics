
public class parabolicMotion {
    private double x=100;
	private double y=100;
	private double initialX=x;
	private double initialY=y;
	private double angle =45;
	private double velocity = 20;
	private double xVelocity =velocity * Math.cos(Math.toRadians(angle));
	private double yVelocity= velocity * Math.sin(Math.toRadians(angle));
	private double time;
	private double gravity= 9.8;
	/*	x = 0;
		y = 0;
		initialX = x;
		initialY = y;
		angle = 45;
		velocity = 80;
		xVelocity = velocity * Math.cos(Math.toRadians(angle));
		yVelocity = velocity * Math.sin(Math.toRadians(angle));
		time = 0;
        gravity= 9.8;
	*/
	public double calculTime(){
		double time=2*velocity*Math.sin(Math.toRadians(angle))/gravity;
		this.time=time;
		return time;
	}

	public double calculA(){
		double a;
		return -4;
	}
	public double calculB(){
		double b=(velocity*velocity*Math.pow(Math.sin(Math.toRadians(angle)), 2))/(2*gravity);
		return b;

	}
	public double calculC(){
		double c=initialY+yVelocity*calculTime()/2+gravity/2*Math.pow((calculTime()/2),2);
		return c;
	}
	public double getTime(){
		return time;
	}
	


    
    




}

