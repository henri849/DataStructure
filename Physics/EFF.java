class EFF{
    public static void main(String[] args){
        Matter a = new Matter(10.0);
        Matter b = new Matter();
        Matter c = new Matter(20.0);

        a.setName("Henri");
        double dt = 0.1;
        while (a.IamFine){
            //newton pair forces across multiple objects
            a.force = computeForce(a,b);
            a.force += computeForce(a,c);

            b.force = computeForce(b,a);
            b.force += computeForce(b,c);
            
            c.force = computeForce(c,a);
            c.force += computeForce(c,b);

            a.update(dt);
            b.update(dt);
            c.update(dt);
        }
        System.out.println(a);
    } 

    public static double computeForce(Matter a, Matter b){
        return b.getPosition()-a.getPosition();
    }
}