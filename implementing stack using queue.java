import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //take no. of commands(push,pop,top,empty)
        int n = sc.nextInt();
        
        //consider two queues to perform stack operations
        Queue<Integer> q_push = new LinkedList<>();
        Queue<Integer> q_pop = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            String s = sc.next();
            if(s.equals("push")){
                int v = sc.nextInt();
                //if q_push is empty then directly add given value to q_push
                if(q_push.isEmpty()){
                    q_push.add(v);
                }
                //if not empty then firstly pop all values and store it in q_pop and then add given value and then add previous values one by one which are store in q_pop
                else{
                    while(!q_push.isEmpty()){
                      q_pop.add(q_push.poll());
                    }
                    q_push.add(v);
                    while(!q_pop.isEmpty()){
                        q_push.add(q_pop.poll());
                    }
                }
            }
            else if(s.equals("pop")){
                if(!q_push.isEmpty())           //check underflow condition and then pop
                System.out.println(q_push.poll());
            }
            else if(s.equals("top")){
                if(!q_push.isEmpty())           //check underflow condition and then print top element
                System.out.println(q_push.peek());
            }
            else if(s.equals("empty")){            //ckeck if it is empty or not
                System.out.println(q_push.isEmpty());
            }
           
        }
        
    }
}