//next greater element towards left(stack). if not present then print -1.
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int b[] = new int[n];     //to store output
        
        //storing next greater element towards left in array b
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && stk.peek() <= a[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                b[i] = -1;
            }
            else{
                b[i] = stk.peek();
            }
            stk.push(a[i]);
        }
        
        //printing the output
        for(int i = 0; i < n; i++){
            System.out.println(b[i]);
        }
    }
}