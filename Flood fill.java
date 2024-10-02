//Flood fill problem: we have to reach at right bottom from top left position by considering all possible paths and print it. 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void move(int a[][], int n, int m,String ans, int r, int c){
        if(r == n-1 && c == m-1 ){
            System.out.println(ans);
            return ;
        }
        if(r == n || c == m || r < 0 || c < 0){
            return;
        }
        
        if(a[r][c] == 1 || a[r][c] == -1){
            return;
        }
            a[r][c] = -1;
            move(a,n,m,ans+"t",r-1,c);
            move(a,n,m,ans+"l",r,c-1);
            move(a,n,m,ans+"d",r+1,c);
            move(a,n,m,ans+"r",r,c+1);
            a[r][c] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input size of 2D array
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        //input array elements
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        move(a,n,m,"",0,0);
    }
}