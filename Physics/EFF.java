class EFF{

    public static void main(String[] args){
        Matter me = new Matter();

        while (me.IamFine){
            me.updateAcceleration();
            me.updatePosition();
            me.updateVelocity();

            if (me.IamFine){
                System.out.println(me);
            }
            me.updateEmotionalStatus();

        }
        System.out.println(me);
    } 
}