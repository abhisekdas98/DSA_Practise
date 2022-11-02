package Arrays;
import java.util.*;
import java.io.*;
public class NextPermutation {
/*
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically
next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order
(i.e., sorted in ascending order).

Example 1 :

Input format: Arr[] = {1,3,2}

Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}.
So, the next permutation just after {1,3,2} is {2,1,3}.
Example 2:

Input format: Arr[] = {3,2,1}

Output: Arr[] = {1,2,3}

Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the
topmost permutation.

Approach :

Step 1: Linearly traverse array from backward such that ith index value of the array is less than (i+1)th
index value. Store that index in a variable.

Step 2: If the index value received from step 1 is less than 0. This means the given input array is the largest
lexicographical permutation. Hence, we will reverse the input array to get the minimum or starting permutation.
 Linearly traverse array from backward. Find an index that has a value greater than the previously found index.
 Store index is another variable.

Step 3: Swap values present in indices found in the above two steps.

Step 4: Reverse array from index+1 where the index is found at step 1 till the end of the array.

Time Complexity: For the first iteration backward, the second interaction backward and reversal at the end takes
O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(N).

Space Complexity: Since no extra storage is required. Thus, its complexity is O(1).

 */
    public static  void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // String str=br.readLine();
        int arr[] = {1,3,4,2,5};

        for(int i=0;i<arr.length;i++)
         System.out.print(arr[i]+" ");

        System.out.println();

           nextPermutation(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");





    }
    public static void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--;
        if(i >= 0) {
            int j = A.length - 1;
            while(A[j] <= A[i]) j--;
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);


    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
