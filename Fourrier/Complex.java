public class Complex{
	private double real;
	private double imaginary;
	public Complex(double re, double im){real = re;imaginary = im;}

    public double getReal(){return real;}
    public double getImaginary(){return imaginary;}
    public void round(){
        real = Math.round(real*10e6)/10e6;
        imaginary = Math.round(imaginary*10e6)/10e6;
    }
	public Complex plus(Complex other){
		return new Complex(real+other.real, imaginary + other.imaginary);
    }

    public Complex minus(Complex other){
		return new Complex(real-other.real, imaginary - other.imaginary);
    }

    public Complex multiply(Complex other){
        //(a+bi)(c+di) = ac-bd+ adi+cbi
	    return new Complex(real*other.real-imaginary*other.imaginary, imaginary*other.real + real*other.imaginary); //Just do foil
    }

    public Complex reciprocal() {
        //1/a+bi *= a-bi/a-bi
        //a-bi/a^2+b^2
        //a = a/a^2+b^2
        //b = -b/a^2+b^2
        double div = real*real + imaginary*imaginary;
        return new Complex(real / div, -imaginary / div);
    }

    public Complex divides(Complex other) {
        return multiply(other.reciprocal());
    }
    //TODO: put in readme
    //https://algs4.cs.princeton.edu/99scientific/Complex.java.html (just for etexp and toString function)
    //returns e^complex
    public Complex etexp() {
        return new Complex(Math.exp(real) * Math.cos(imaginary), Math.exp(real) * Math.sin(imaginary));
    }
    public String toString() {
        if (imaginary == 0) return real + "";
        if (real == 0) return imaginary + "i";
        if (imaginary <  0) return "("+real + " - " + (-imaginary) + "i)";
        return "("+real + " + " + imaginary + "i)";
    }

    public static Complex rootOfUnity(int n, int k){
        double real = Math.cos(2 *Math.PI *k/n);
        double imaginary = Math.sin(2 *Math.PI *k/n);
        Complex rtn = new Complex(real,imaginary);
        rtn.round();
        return rtn;
    }

    public static Complex[] rootsOfUnity(int n){
        Complex[] retval = new Complex[n];
        for (int k = 0; k < n; k++){
            retval[k] = rootOfUnity(n,k);
        }
        return retval;
    }

    public Complex num(double o){
        double l = Math.pow(Math.sqrt(real*real+imaginary*imaginary),o);
        double a = Math.atan(imaginary/real)*o;
        if (real < 0 && o%2 !=0) l = -l;
        return new Complex(Math.cos(a)*l,Math.sin(a)*l);
    }

    public Complex exp(Complex o){


        if (o.imaginary ==0) return num(o.real);

        
        //Z = (a+bi)^(c+di)
        //ln(Z) = (c+di)* ln(a+bi)
        //So to make this simpler were going to move this to polar cordinates
        //|Z| = sqrt(a^2+b^2)
        //k = tan-1(b/a)
        //ln(Z) = (c+di)* (ln(|z|)+ik)
        //Z = e^((c+di)* (ln(|z|)+ik))


        double length = Math.sqrt(real*real+imaginary*imaginary);
        
        double a = Math.atan(imaginary/real);
        Complex lnz = o.multiply(new Complex(Math.log(length),a)); //Math.log is acutally ln
        Complex result = lnz.etexp();

        return result;
    }
}
