import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int part(int s, int e , int[] a){
        int pivot = a[s];
        int count = 0;
        //count no. of elements smaller than pivot
        for(int i = s+1; i <= e; i++){
            if(a[i] < pivot){
                count++;
            }
        }
        //swap pivot to it's respevtive position
        int temp1 = a[s];
        a[s] = a[s+count];
        a[s+count] = temp1;
        
        //swap element smaller than pivot towads left and greater than pivot towads right
        int i = s;
        int j = s+count+1;
        while(i < s+count && j <= e){
            if(a[i] < pivot)
                i++;
            else if(a[j] >= pivot)
                j++;
            else{
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return s+count;
    }
    
    
    public static void sort(int s, int a[], int e){
        if(s < e){
            int pivot = part(s,e,a);
            sort(s,a,pivot-1);
            sort(pivot+1,a,e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sort(0,a,n-1);
        
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}