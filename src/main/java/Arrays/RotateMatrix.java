package Arrays;
import java.util.*;
import java.io.*;
/*
Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]

Output: [[7,4,1],[8,5,2],[9,6,3]]

Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

Example 2:

Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix

Approach 1:Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column
of the dummy matrix, take the second row of the matrix, and put it in the second last column of the matrix and so.
Time Compleity : O(N*N)
Space Complexity : O(N*N)

Solution 2: Optimized approach

Intuition: By observation, we see that the first column of the original matrix is the reverse of the first row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row, and since we are making changes in the matrix itself space complexity gets reduced to O(1).

Approach:

Step1: Transpose of the matrix. (transposing means changing columns to rows and rows to columns)

Step2: Reverse each row of the matrix.

Time Complexity: O(N*N) + O(N*N).One O(N*N) for transposing the matrix and the other for reversing the matrix.

Space Complexity: O(1).

 */
public class RotateMatrix {
    public static  void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // String str=br.readLine();
        int arr[][] =  {{1, 2, 3, 9}, {4, 5, 6, 10}, {7, 8, 9, 11},{17, 18, 19, 0}};
        System.out.println("Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void rotate(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<m;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }
        }

        for(int i=0;i<n;i++)
        {
            matrix[i]=reverse(m,matrix[i]);
        }



    }
    public static int[] reverse(int m,int ar[])
    {
        for(int i=0;i<m/2;i++)
        {
            int temp=ar[i];
            ar[i]=ar[m-i-1];
            ar[m-i-1]=temp;
        }

        return ar;
    }
}
