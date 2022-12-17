class Matter{
    boolean IamFine = true;
    double position = 0;
    double velocity =0;
    double acceleration = 1;
    double force = 1;
    double mass = 2;


    public void updatePosition(){
        position+= velocity;
    }
    public void updateVelocity(){
        velocity += acceleration;
    }

    public void updateAcceleration(){
        acceleration = force/mass;
    }

    public String toString(){
        String status = "";

        if (IamFine) status = "I am fine"; else status = "I am not fine";
         return status+ ", (p:"+getPosition() + ",v:" + getVelocity() + ",a:" + getAcceleration()+")";
    }

    public String getPosition(){
        return Double.toString(position);
    }
    public String getVelocity(){
        return Double.toString(velocity);
    }
    public String getAcceleration(){
        return Double.toString(acceleration);
    }
    public void updateEmotionalStatus(){
        if (position >10){
            IamFine = false;
        }
    }
}