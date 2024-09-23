import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();
        int a1[][] = new int[m1][n1];
        
        for(int i = 0; i < m1; i++){
            for(int j = 0; j < n1; j++){
                a1[i][j] = sc.nextInt();
            }
        }
        
        int m2 = sc.nextInt();
        int n2 = sc.nextInt();
        int a2[][] = new int[m2][n2];
        int a3[][] = new int[m1][n2];
        
        for(int i = 0; i < m2; i++){
            for(int j = 0; j < n2; j++){
                a2[i][j] = sc.nextInt();
            }
        }
         
        
        if(m2 != n1){
            System.out.println("Invalid input");
        }
        else{
            for(int i = 0; i < m1; i++){
                for(int j = 0; j < n1; j++){
                    for(int k = 0; k < n2; k++){
                        a3[i][k] += a1[i][j] * a2[j][k];
                    }
                }
            }
            for(int i = 0; i < m1; i++){
                for(int j = 0; j < n2; j++){
                    System.out.print(a3[i][j] + " ");
                }
                System.out.println();
            }
            
        }
         
    }
}