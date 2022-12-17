class EFF{

    public static void main(String[] args){
        Matter me = new Matter();
        Matter you = new Matter();
        you.force = -me.force;
        while (me.IamFine){
            me.updateAcceleration();
            me.updatePosition();
            me.updateVelocity();
            System.out.println(me);
            me.updateEmotionalStatus();

            you.updateAcceleration();
            you.updatePosition();
            you.updateVelocity();
            System.out.println(you);
            you.updateEmotionalStatus();
        }
        System.out.println(me);
    } 
}