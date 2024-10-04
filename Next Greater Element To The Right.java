//Next Greater Element To The Right (Stack). if there is no greater element then print -1. 
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];  
        
        //input array elements
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        
        //storing next greater element in array b
        for(int i = n-1; i >= 0; i--){
            
            //pop the smaller elements from the stack if current element is greater than the top element
            while(!stk.isEmpty() && stk.peek() <= a[i]){
                stk.pop();
            }
            
            if(stk.isEmpty()){
                b[i] = -1;
            }
            else{
                b[i] = stk.peek();
            }
            
            //every element should compaire so push every element
            stk.push(a[i]);
                
        }
        
        //printing the output
        for(int i = 0; i < n; i++){
            System.out.println(b[i]);
        }
    }
}