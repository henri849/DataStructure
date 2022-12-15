public class Polynomial{
	private Complex[] coeffs;
    public Polynomial(Complex[] _coeffs){
        //kx^k
        coeffs = _coeffs;
    }
    public Complex evaluate(Complex x){
		Complex retval = new Complex(0,0);
	    for (int k = 0; k < coeffs.length; k++){ // k is the exponent
	        retval = retval.plus(x.exp(new Complex(k,0)).multiply(coeffs[k]));
            // loop through all monomials and sum x^k * coeff[k]
        }
        return retval;
    }

    public Complex evaluateOdd(Complex x){
		Complex[] co = new Complex[(int)Math.floor(coeffs.length/2)];
	    for (int k = 0; k < (int)Math.floor(coeffs.length/2); k++){ // k is the exponent
	        co[k] = coeffs[1+k*2];
        }
        return new Polynomial(co).evaluate(x);
    }
    public Complex evaluateEven(Complex x){
        Complex[] co = new Complex[(int)Math.ceil(coeffs.length/2)];
        for (int k = 0; k < (int)Math.ceil(coeffs.length/2); k++){ // k is the exponent
	        co[k] = coeffs[k*2];
        }
        return new Polynomial(co).evaluate(x);
    }

    public static Complex[] fft(Complex[] x) throws IllegalArgumentException {// radix 2 Cooley-Tukey FFT from https://introcs.cs.princeton.edu/java/97data/FFT.java.html
        //this effectively takes in x as the coeffs of the polynomial and evaluates it at the roots of unity (number coreponds to degree +1 of coeefs)

        int l = x.length;
        // recursion catching
        if (l == 1) return new Complex[] { x[0] };
        if (l % 2 != 0) {
            throw new IllegalArgumentException("l is not a power of 2");
        }
        // compute FFT of even terms

        Complex[] even = new Complex[l/2];
        for (int k = 0; k < l/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] evenFFT = fft(even);

        // compute FFT of odd terms
        Complex[] odd = even;  // reuse the array
        for (int k = 0; k < l/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] oddFFT = fft(odd);

        // combine
        Complex[] y = new Complex[l];
        for (int k = 0; k < l/2; k++) {
            double kth = -2 * k * Math.PI / l;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = evenFFT[k].plus(wk.multiply(oddFFT[k]));
            y[k + l/2] = evenFFT[k].minus(wk.multiply(oddFFT[k]));
            y[k].round();
            y[k + l/2].round();
        }
        return y;
    }




    // public static double[][] synth_div(double[] num, double[] den){
    //     double[] retval = num.clone();
    //     double norm = den[0];
    //     for (int i =0; i < num.length-den.length+1; i++){
    //         retval[i] /= norm;
    //         double c = retval[i];
    //         if (c != 0){
    //             for (int j = 1; j< den.length;j++){
    //                 retval[i+j] -= den[j]*c;
    //             }
    //         }
    //     }
    //     double separator = 1 - den.length;
    //     double[][] ret = new double[Math.max(retval.length+separator,abs(separator))][2];
    //     //for (int i = 1; i > abs(separator); i--){
    //     //     retval[retval.length]
    //     // }
    //     return retval;
    // }


    public Complex[] evaluateAll(Complex[] x){
		Complex[] retval = new Complex[x.length];
	    for (int k = 0; k < x.length; k++){
	        retval[k] = evaluate(x[k]);
            retval[k].round();
        }
        return retval;
    }

    public static Complex[] Fourrier(Complex[] t){
        Polynomial tc = new Polynomial(t);    
        // System.out.println(tc);
        return tc.evaluateAll(Complex.rootsOfUnity(t.length));
    }

    public String toString(){
        String rt = "";
        for (int i = coeffs.length-1; i >= 0; i--){
            String co  = "";
            if (coeffs[i].toString() != "0"){
                co = coeffs[i].toString();
            }
            if (i == 0){
                rt += co;
            }else if (i == 1){
                rt += co+ "x"+ " + ";
            }else{
                rt += co+ "x^"+ i + " + ";
            }
        }
        return rt;
    }
}
