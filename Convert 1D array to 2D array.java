//Convert 1D array to 2D array assuming no. of elements enterted by user is same.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1[] = new int[n];
        
        for(int i = 0; i < n; i++){
            a1[i] = sc.nextInt();
        }
        
        int p = sc.nextInt();
        int q = sc.nextInt();
        int a2[][] = new int[p][q];
        int k = 0;
        
        for(int i = 0; i < p; i++){
            for(int j = 0; j < q; j++){
                    a2[i][j] = a1[k];
                    k++;      
            }
        }
        for(int i = 0; i < p; i++){
            for(int j = 0; j < q; j++){
                System.out.print(a2[i][j] + " ");
            }
            System.out.println();
        }
    }
}