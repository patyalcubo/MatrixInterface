package operations;

public class Multiplication {

    public static long[][] Multiplicate(long[][] A , long[][] B) {

        //System.out.println("Matrix A has i cols and j rows, Matrix B has k cols and l rows");

        int i = A.length;
        int j = A[0].length;
        
        int k = B.length;
        int l = B[0].length;
        
        // matrix compatibility
        if (j == k) {
            //System.out.println("Matrix can be done!");
        } else {
            //System.out.println("Matrix multiplication CAAAAAAANT be done between matrix " + i + "," + j + " and matrix " + k + "," + l);
            return null;
        }
        
        long[][] M = new long[i][l];
        
        for (int ll = 0; ll < l; ll++) {
            for (int ii = 0; ii < i; ii++) {
                for (int jj = 0; jj < j; jj++) {
                    M[ii][ll] += A[ii][jj] * B[jj][ll];
                }
            }
            //System.out.println();
        }
        
        for (int ii=0; ii<i; ii++){
            for (int ll=0; ll<l; ll++){
                //System.out.printf(M[ii][ll]+" ");
            }
            //System.out.println("");
        }
        
        return M;

    }
	
}
