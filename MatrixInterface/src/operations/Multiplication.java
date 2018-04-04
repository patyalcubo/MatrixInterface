package operations;

import java.util.Scanner;

public class Multiplication {

    public static void main(String[] args) {

        int temp;

        Scanner reader = new Scanner(System.in);

        System.out.println("Matrix A has i cols and j rows, Matrix B has k cols and l rows");

        System.out.printf("Introduce i and j separated by an space: \r");
        int i = reader.nextInt();
        int j = reader.nextInt();
        System.out.printf("Introduce k and l separated by an space: \r");
        int k = reader.nextInt();
        int l = reader.nextInt();

        // matrix compatibility
        if (j == k) {
            System.out.println("Matrix can be done!");
        } else {
            System.out.println("Matrix multiplication CAAAAAAANT be done between matrix " + i + "," + j + " and matrix " + k + "," + l);
        }

        int[][] A = new int[i][j];
        int[][] B = new int[k][l];
        int[][] M = new int[i][l];

        for (int ii = 0; ii < i; ii++) {
            System.out.printf("Please introduce row values " + ii + ": \r");
            for (int jj = 0; jj < j; jj++) {
                //System.out.printf("Please introduce row values "+ii+","+jj+": \r");
                temp = reader.nextInt();
                A[ii][jj] = temp;
            }
        }

        for (int kk = 0; kk < k; kk++) {
            System.out.printf("Please introduce row values " + kk + ": \r");
            for (int ll = 0; ll < l; ll++) {
                //System.out.printf("Please introduce row values "+kk+","+ll+": \r");
                temp = reader.nextInt();
                B[kk][ll] = temp;
            }
        }

        int cnt = 0;

        for (int ll = 0; ll < l; ll++) {
            for (int ii = 0; ii < i; ii++) {
                for (int jj = 0; jj < j; jj++) {
                    M[ii][ll] += A[ii][jj] * B[jj][ll];
                }
                //System.out.printf(M[ii][ll]+" ");
            }
        }
        
        for (int ii=0; ii<i; ii++){
            for (int ll=0; ll<l; ll++){
                System.out.printf(M[ii][ll]+" ");
            }
            System.out.println("");
        }

    }
	
}
