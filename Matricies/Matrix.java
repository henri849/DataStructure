class Matrix{
    int[][] m;

    public static void main(String[] args){
        int pass = 0; int fail = 0;
        if (Matrix.dotProduct(new int[] {1,2,3},new int[] {4,5,6}) == 32)pass++; else fail++;
        Matrix ma = new Matrix(3,3);
        ma.add(1,1,1);
        ma.add(0,1,-4);
        if (ma.get(1,1) == 1)pass++; else fail++;
        if (ma.get(0,1) == -4)pass++; else fail++;
        int[] c1 = ma.getColumn(1);
        if (c1[0] == -4 && c1[1] == 1 && c1[2] ==0)pass++; else fail++;
        ma.add(0,0,10);
        ma.add(0,2,-5);
        int[] r1 = ma.getRow(0);
        if (r1[0] == 10 && r1[1] == -4 && r1[2] ==-5)pass++; else fail++;

        Matrix m2 = new Matrix(2,3);
        Matrix m3 = new Matrix(3,2);
        m2.setRow(new int[] {1,2,3},0);
        if (m2.get(0,0) == 1 && m2.get(0,1) == 2 && m2.get(0,2) == 3)pass++; else fail++;
        m2.setRow(new int[] {4,5,6},1);
        m3.setColumn(new int[] {7,9,11},0);
        if (m3.get(0,0) == 7 && m3.get(1,0) == 9 && m3.get(2,0) == 11)pass++; else fail++;
        m3.setColumn(new int[] {8,10,12},1);
        Matrix m4 = Matrix.multiply(m2,m3);
        if (m4.get(0,0) == 58 && m4.get(0,1) == 64 && m4.get(1,0) == 139 && m4.get(1,1) == 154)pass++; else fail++;

        Matrix m5 = Matrix.multiply(m2,new Matrix(new int[] {1,2,3}));
        if (m5.get(0,0) == 14 && m5.get(1,0) == 32) pass++; else fail++;

        System.out.println("pass:"+pass + ", fail:" + fail);
    }

    public Matrix(int r, int c){
        m = new int[r][c];
    }
    public void setRow(int a[], int r){
        for (int i = 0; i < this.columns(); i++){
            m[r][i] = a[i];
        }
    }
    public void setColumn(int a[], int c){
        for (int i = 0; i < this.rows(); i++){
            m[i][c] = a[i];
        }
    }
    public Matrix(int[] a){
        m = new int[a.length][1];
        for (int i = 0; i< a.length;i++){
            m[i][0] = a[i];
        }
    }

    public static Matrix multiply(Matrix a, Matrix b){
        Matrix rtn = new Matrix(a.rows(),b.columns());
        for (int r = 0; r < a.rows(); r++){
            for (int c = 0; c < b.columns(); c++){
                rtn.add(r,c,Matrix.dotProduct(a.getRow(r),b.getColumn(c)));
            }
        }
        return rtn;
    }
    public String toString(){
        String rtn = "";
        for (int r = 0; r < this.rows(); r++){
            rtn += "{";
            for (int c = 0; c < this.columns(); c++){
                rtn += m[r][c] +",";
            }
            rtn = rtn.substring(0,rtn.length()-1) + "}\n";
        }
        return rtn;
    }


    public void add(int r, int c, int v){
        m[r][c] = v;
    }
    public int get(int r, int c){
        return m[r][c];
    }

    public static int dotProduct(int[] a, int[] b){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i] * b[i];
        }
        return sum;
    }
    public int[] getRow(int idx){return m[idx];}
    public int[] getColumn(int idx){
        int[] rtn = new int[this.rows()];
        for (int i = 0; i< this.rows(); i++){
            rtn[i] = m[i][idx];
        }
        return rtn;
    }

    public int rows(){return m.length;}
    public int columns(){return m[0].length;}
}