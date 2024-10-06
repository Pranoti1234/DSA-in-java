//Infix Evaluation
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int priority(char c){
        if(c == '*' || c == '/')
            return 3;
        else if(c == '+' || c == '-')
            return 2;
        return 0;
    }
    
   public static int evaluate(int a, int b, char c){
       int result = 0;
                    switch(c){
                        case '+' : return b+a;
                        case '-' : return b-a;
                        case '*' : return b*a;
                        case '/' : return b/a;
                    }
       return 0;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> operator = new Stack<>();
        Stack<Integer> value = new Stack<>();
        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int digit = s.charAt(i) - '0';
                value.push(digit);
            } 
            else if(ch == '('){
                operator.push(ch);
            }
            else if(ch == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    int a = value.pop();
                    int b = value.pop();
                    char c = operator.pop();
                    value.push(evaluate(a,b,c)); 
                }
                if (!operator.isEmpty()) {
                    operator.pop(); // Pop the '('
                }
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if(operator.isEmpty() || operator.peek() == '('){
                    operator.push(ch);
                }
                else if(!operator.isEmpty() && priority(operator.peek()) < priority(ch)){
                    operator.push(ch);
                }
                else{
                    while(!operator.isEmpty() && priority(operator.peek()) >= priority(ch)){
                    int a = value.pop();
                    int b = value.pop();
                    char c = operator.pop();
                    result = evaluate(a,b,c);
                    value.push(result);
                    }
                    operator.push(ch);
                }   
            }
        }
        while(!operator.isEmpty()){
            int a = value.pop();
            int b = value.pop();
            char c = operator.pop();
            result = evaluate(a,b,c);
            value.push(result);
        }
        
        result = value.peek();
        System.out.println(result);
        
    }
}