package operations;

public class Addition {
	
	public static long[][] Add(long[][] A , long[][] B, boolean Rest) {

        System.out.println("Matrix A has i cols and j rows, Matrix B has k cols and l rows");

        int i = A.length;
        int j = A[0].length;
        
        int k = B.length;
        int l = B[0].length;
        
        // matrix compatibility
        if ((i == k) && (j == l)) {
            System.out.println("Matrix can be done!");
        } else {
            System.out.println("Matrix addition CAAAAAAANT be done between matrix " + i + "," + j + " and matrix " + k + "," + l);
            return null;
        }
        
        long[][] M = new long[i][j];
        
        for (int ii = 0; ii < i; ii++) {
            for (int jj = 0; jj < j; jj++) {
            	if (Rest){
            		M[ii][jj] = A[ii][jj] - B[ii][jj];            	
            	} else {
            		M[ii][jj] = A[ii][jj] + B[ii][jj];
            	}
            }
        }
    
        for (int ii=0; ii < i; ii++){
            for (int jj = 0; jj < j; jj++){
                System.out.printf(M[ii][jj]+" ");
            }
            System.out.println("");
        }
        
        return M;
		
	}
	
}
