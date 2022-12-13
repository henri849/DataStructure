class Convolution{

    static int[][] img = {
        {1,1,1,1,1},
        {0,1,1,1,1},
        {0,0,1,1,1},
        {0,0,0,1,1},
        {0,0,0,0,1}
    };
    static int[][] kernel = {
        {0,0,0},
        {-1,1,0},
        {0,0,0}
    };

    public static void main(String[] args){
        int[][] image = conv(img,kernel);
        for (int y = 0; y < image.length; y++){
            for (int x = 0; x < image.length; x++){
                System.out.print(image[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] conv(int[][] im , int[][] k){
        int[][] outp = new int[im.length-k.length+1][im[0].length-k[0].length+1];

        for (int y = (int)(k.length/2); y < im.length - (int)(k.length/2); y++){
            for (int x = (int)(k[0].length/2); x < im[0].length - (int)(k[0].length/2); x++){
                int dotp = 0;
                for (int kx = 0; kx < k[0].length; kx++){
                    for (int ky = 0; ky < k.length; ky++){
                        dotp += im[y+ky-(int)(k.length/2)][x+kx-(int)(k[0].length/2)] * k[ky][kx];
                    }
                }
                outp[y - (int)(k.length/2)][x -(int)(k[0].length/2)] = dotp;
            }
        }
        return outp;
    }

}