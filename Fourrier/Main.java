public class Main{

    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        int caught = 0;
        int lost = 0;
        

        //Complex class testing
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);
        if (a.getReal() == 5 && a.getImaginary() == 6) pass ++;else fail++;
        if (b.getReal() == -3 && b.getImaginary() == 4) pass ++;else fail++;
        Complex add = b.plus(a);
        if (add.getReal() == 2 && add.getImaginary() == 10) pass ++;else fail++;
        Complex sub = a.minus(b);
        if (sub.getReal() == 8 && sub.getImaginary() == 2) pass ++;else fail++;
        Complex mul = a.multiply(b);
        if (mul.getReal() == -39 && mul.getImaginary() == 2) pass ++;else fail++;
        Complex div = a.divides(b);
        if (div.getReal() == 0.36 && div.getImaginary() == -1.52) pass ++;else fail++;
        Complex ex = a.etexp();
        if (Math.round(ex.getReal()) == 143 && Math.round(ex.getImaginary()) == -41) pass ++;else fail++;
        Complex exp = a.exp(b);
        if (Math.round(exp.getReal()*Math.pow(10,6)) == 49 && Math.round(exp.getImaginary()*Math.pow(10,6)) == -40) pass ++;else fail++;


        //Polynomial Class testing
        Complex[] coeff = {new Complex(7,0),new Complex(2,0),new Complex(32,0),new Complex(3,1),new Complex(8,0)};
        Polynomial pol = new Polynomial(coeff);
        if (pol.toString().equals("8.0x^4 + (3.0 + 1.0i)x^3 + 32.0x^2 + 2.0x + 7.0")) pass ++;else fail++;

        Polynomial pol2 = new Polynomial(new Complex[]{new Complex(7,0),new Complex(2,0),new Complex(32,0)});
        Complex ev = pol2.evaluate(new Complex(2,0));
        if (ev.getReal() == 139) pass ++;else fail++;


        if (new Complex(-1,0).exp(new Complex(3,0)).getReal() == -1)pass ++;else fail++;
        if (new Complex(3,0).exp(new Complex(3,0)).getReal() == 27)pass ++;else fail++;
        if (new Complex(-3,0).exp(new Complex(2,0)).getReal() == 9)pass ++;else fail++;
        if (new Complex(-1,0).exp(new Complex(-1,0)).getReal() == -1)pass ++;else fail++;

        Complex[] ft = Polynomial.Fourrier(new Complex[]{new Complex(0,0),new Complex(0,0),new Complex(0,0),new Complex(1,0)});
        for (int i =0; i < ft.length; i++){
            System.out.println(i+"::: " + ft[i]);
        }

        // double[] res = Polynomial.synth_div(new double[]{2,0,0}, new double[]{2,0,0});

        // for (int i = 0; i < res.length; i++){
        //     System.out.println("divs:: " + res[i]);
        // }

        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);
    }
}