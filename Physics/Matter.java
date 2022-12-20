class Matter{
    boolean IamFine = true;
    double position = 0;
    double velocity =0;
    double acceleration = 1;
    double force = 1;
    double mass = 2;
    String name  = "I";
    public Matter(){}
    public Matter(double _position){
        position = _position;
    }

    public void setName(String _name){
        name = _name;
    }
    public void newupdate(double dt){
        updateAcceleration();
        updateVelocityHalfway(dt);
        updatePosition(dt);
        updateAcceleration();
        updateVelocityHalfway(dt);
        System.out.println(this);
        updateEmotionalStatus();
    }

    public void update(double dt){
        updateAcceleration();
        updateVelocity(dt);
        updatePosition(dt);
        System.out.println(this);
        updateEmotionalStatus();
    }
    public void updatePosition(double dt){
        position+= velocity*dt;
    }
    public void updateVelocityHalfway(double dt){
        velocity += acceleration/2 *dt;
    }
    public void updateVelocity(double dt){
        velocity += acceleration*dt;
    }

    public void updateAcceleration(){
        acceleration = force/mass;
    }

    public String toString(){
        String status = "";
        if (name.equals("I")) name += " am"; else name+= " is";
        if (IamFine) status = name+ " fine"; else status = name+" not fine";
        name = name.substring(0,name.length()-3);// to remove the " is"
        return status+ ", (p: "+getPosition() + " ,v: " + getVelocity() + " ,a: " + getAcceleration()+" )";
    }

    public double getPosition(){
        return position;
    }
    public double getVelocity(){
        return velocity;
    }
    public double getAcceleration(){
        return acceleration;
    }
    public void updateEmotionalStatus(){
        if (position >10){
            IamFine = false;
        }
    }
}