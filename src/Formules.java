public class Formules {

    // https://en.wikipedia.org/wiki/Projectile_motion

    private Inputs inputs;

    public Formules(Inputs i) {
        inputs = i;
    }

    public double getTotTime(){
        double t = 2*inputs.getValue(Inputs.velocityIdx)*Math.sin(Math.toRadians(inputs.getValue(Inputs.angleIdx)))/inputs.getValue(Inputs.gravityIdx);
        return t;
    }

    public double getX(double t){
        double x = inputs.getValue(Inputs.velocityIdx)*t*Math.cos(Math.toRadians(inputs.getValue(Inputs.angleIdx)));
        return x;
    }

    public double getY(double t){
        double y = inputs.getValue(Inputs.velocityIdx)*t*Math.sin(Math.toRadians(inputs.getValue(Inputs.angleIdx)))-(inputs.getValue(Inputs.gravityIdx)*Math.pow(t,2)/2);
        return y;
    }

    public double getMaxX(){
        double mX = Math.pow(inputs.getValue(Inputs.velocityIdx),2) * //
                    Math.sin(2*Math.toRadians(inputs.getValue(Inputs.angleIdx))) / //
                    inputs.getValue(Inputs.gravityIdx); 
        return mX;
    }

    public double getMaxY(){
        double mY = Math.pow(inputs.getValue(Inputs.velocityIdx),2) * //
                    Math.pow(Math.sin(Math.toRadians(inputs.getValue(Inputs.angleIdx))),2) / //
                    (2*inputs.getValue(Inputs.gravityIdx)); 
        return mY;
    }
}