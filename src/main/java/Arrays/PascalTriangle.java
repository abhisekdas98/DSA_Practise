package Arrays;
import java.util.*;
import java.io.*;
/*
Intuition: When you see the image above, you get a pretty good idea of what you are supposed to do here.
Think about the image as a matrix now where each line is basically a row in the matrix. So, first things
first, if you are at the edge of the matrix, the value is 1, that’s for sure. Now, what about the inner elements?
Well, any inner element is obtained by doing the sum of the 2 values present in the row just above it, i.e., if
the element is at index (i, j), then matrix[i][j] can be obtained by doing matrix[i – 1][j – 1] + matrix[i – 1][j].

 */
public class PascalTriangle {
    public static  void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      //  String str=br.readLine();
        int n = 5;

        List<List<Integer>> ll=generate(n);

        for(int i=0;i<ll.size();i++)
        System.out.println(ll.get(i));

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return res;
    }
}
