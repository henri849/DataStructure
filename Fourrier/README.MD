Fourrier Transform\
Authors:\
    Henri\

Acknowledgments:\ 
    Mr.Kuszmaul\
    https://introcs.cs.princeton.edu/java/97data/FFT.java.html\


List of methods:\
___Polynomial:\
______Polynomial(Complex[] _coeffs)\
______Complex evaluate(Complex x)\
______Complex evaluateOdd(Complex x)\
______Complex evaluateEven(Complex x)\
______Complex[] fft(Complex[] x) throws IllegalArgumentException\
______Complex[] evaluateAll(Complex[] x)\
______static Complex[] Fourrier(Complex[] t)\
______static double[][] synth_div(double[] num, double[] den) (seperating the first part of the answer and remainder is still tricky)\
______String toString()\
___Complex:\
______Complex(double re, double im)\
______double getReal()\
______double getImaginary()\
______void round()\
______Complex plus(Complex other)\
______Complex minus(Complex other)\
______Complex multiply(Complex other)\
______Complex reciprocal()\
______Complex divides(Complex other)\
______Complex etexp() (e^complex)\
______String toString()\
______static Complex rootOfUnity(int n, int k)\
______static Complex[] rootsOfUnity(int n)\
______Complex num(double o) (raises self to integer o)\
______Complex exp(Complex o) (raises self to complex number o, I have top function bc I would get strange results with negative numbers)\