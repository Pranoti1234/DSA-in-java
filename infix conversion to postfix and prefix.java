// conversion of infix to postfix and prefix
import java.io.*;
import java.util.*;

public class Solution {
    public static int priority(char ch){
        if(ch == '*' || ch == '/')
           return 2;
        else if(ch == '+' || ch == '-')
           return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = "";
        Stack<Character> stk = new Stack<>();

	//conversion of infix to postfix
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

	//check if it is character or digit then add to string name as 'ans'
            if((ch >= 97 && ch <= 123) || (ch >= 48 && ch <= 57)){
                ans += ch;
            }

	//if it is opening bracket then push it into stack
            else if(ch == '('){
                stk.push(ch);
            }

	//if it is closing bracket then pop until we hit opening bracket and add the popped character to ans
            else if(ch == ')'){
                
                while(!(stk.isEmpty()) && stk.peek() != '('){
                   
                ans += stk.pop();
                 }
		//pop the opening bracket
                    if(!(stk.isEmpty()))
                    stk.pop();
            }

	//if it is operator then you can only push it to stack if stack is empty or at top opening bracket is there or top contains less    	priority operator
	// if the stack contains higher priority operator at top then pop it add to ans and then push current operator
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if(!(stk.isEmpty()) && stk.peek() == '('){
                    stk.push(ch);
                }
                else if(stk.isEmpty()){
                    stk.push(ch);
                }
                else {
                    if(priority(ch)>priority(stk.peek())){
                    stk.push(ch);
                }
                else{
                    ans += stk.pop();
                    stk.push(ch);
                }
                }
            }
            
        }

	//if some operators are remaining then pop them one by one add to ans
        while(!stk.isEmpty()){
            ans += stk.pop();
        }

	//printing the final postfix expression
        System.out.println(ans);
        


        String ans2 = ""; 			//for storing prefix expression

	//start conversion for right to left
        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);

	    //check if it a character or digit then add it to ans2
            if((ch >= 97 && ch <= 123) || (ch >= 48 && ch <= 57)){
                ans2 += ch;
	     }

	    // if closing bracket then push it
            else if(ch == ')')
                stk.push(ch);

	   // if opening bracket then pop until we hit closing bracket and add the popped character to ans2

            else if(ch == '('){
                
                while(!(stk.isEmpty()) && stk.peek() != ')'){
                   
                ans2 += stk.pop();
                 }

		//pop the closing bracket
                if(!(stk.isEmpty()))
                    stk.pop();
            }

	//if it is operator then you can only push it to stack if stack is empty or at top closing bracket is there or top contains less 	or equal priority operator
	// if the stack contains higher priority operator at top then pop it add to ans and then push current operator

            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if(!(stk.isEmpty()) && stk.peek() == ')'){
                    stk.push(ch);
                }
                else if(stk.isEmpty()){
                    stk.push(ch);
                }
                else {
                    if(priority(ch)>=priority(stk.peek())){
                    stk.push(ch);
                }
                else{
                    ans2 += stk.pop();
                    stk.push(ch);
                }
                }
            }
            
        }
	////if some operators are remaining in the stack then pop them one by one add to ans

        while(!stk.isEmpty()){
            ans2 += stk.pop();
        }
	
	//reverse a string 
        StringBuilder s1 = new StringBuilder(ans2);
        s1.reverse();

	//Print the final prefix conversion
        System.out.println(s1);
        
        
        
    }
}