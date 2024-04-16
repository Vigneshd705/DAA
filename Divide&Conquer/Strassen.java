import java.util.*;

public class Strassen
{
	public int[][] multiply(int[][] A, int[][] B)
	{	 
		int n = A.length;
		int[][] R = new int[n][n];
		if (n == 1)
			R[0][0] = A[0][0]*B[0][0];
		else
		{
			int[][] A11 = new int[n/2][n/2];
			int[][] A12 = new int[n/2][n/2];
			int[][] A21 = new int[n/2][n/2];
			int[][] A22 = new int[n/2][n/2];
			int[][] B11 = new int[n/2][n/2];
			int[][] B12 = new int[n/2][n/2];
			int[][] B21 = new int[n/2][n/2];
			int[][] B22 = new int[n/2][n/2];

			split(A, A11, 0 , 0);
			split(A, A12, 0 , n/2);
			split(A, A21, n/2, 0);
			split(A, A22, n/2, n/2);

			split(B, B11, 0 , 0);
			split(B, B12, 0 , n/2);
			split(B, B21, n/2, 0);
			split(B, B22, n/2, n/2);

			int [][] M1 = multiply(add(A11, A22), add(B11, B22));
			int [][] M2 = multiply(add(A21, A22), B11);
			int [][] M3 = multiply(A11, sub(B12, B22));
			int [][] M4 = multiply(A22, sub(B21, B11));
			int [][] M5 = multiply(add(A11, A12), B22);
			int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
			int [][] M7 = multiply(sub(A12, A22), add(B21, B22));

			int [][] C11 = add(sub(add(M1, M4), M5), M7);
			int [][] C12 = add(M3, M5);
			int [][] C21 = add(M2, M4);
			int [][] C22 = add(sub(add(M1, M3), M2), M6);

			join(C11, R, 0 , 0);
			join(C12, R, 0 , n/2);
			join(C21, R, n/2, 0);
			join(C22, R, n/2, n/2);
		}
		return R;
	}
	public int[][] sub(int[][] A, int[][] B)
	{
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] - B[i][j];
		return C;
	}
	public int[][] add(int[][] A, int[][] B)
	{
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] + B[i][j];
		return C;
	}
	public void split(int[][] P, int[][] C, int iB, int jB) 
	{
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				C[i1][j1] = P[i2][j2];
	}
	public void join(int[][] C, int[][] P, int iB, int jB) 
	{
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				P[i2][j2] = C[i1][j1];
	} 


    public static void main(String[] args) {
        int matA[][] = new int[4][4];
        int matB[][] = new int[4][4];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the values of matA:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Value of index " + i + j + ":");
                matA[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter the values of matB:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Value of index " + i + j + ":");
                matB[i][j] = scan.nextInt();
            }
        }
        Strassen strassen = new Strassen();
        int R[][]=new int[matA.length][matA.length];
		System.out.println("Matrix A:");
		for(int i=0;i<matA.length;i++){
			System.out.print("[");
            for(int j=0;j<matA[i].length;j++){
                System.out.print(matA[i][j]+" ");
            }
            System.out.println("]");
        }
		System.out.println("Matrix B:");
		for(int i=0;i<matB.length;i++){
			System.out.print("[");
            for(int j=0;j<matB[i].length;j++){
                System.out.print(matB[i][j]+" ");
            }
            System.out.println("]");
        }
        R=strassen.multiply(matA, matB);
        System.out.println("Result;");
        for(int i=0;i<R.length;i++){
            System.out.print("[");
            for(int j=0;j<R[i].length;j++){
                System.out.print(R[i][j]+" ");
            }
            System.out.println("]");
        }
    }
}