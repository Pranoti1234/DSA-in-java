//Check anagrams
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int flag = 1;
        if(a.length() != b.length()){
            flag = 0;
        }
        else{
            for(int i = 0; i < a.length(); i++){
                int count1 = 0;
                int count2 = 0;
                for(int j = 0; j < a.length(); j++){
                    if(a.charAt(i) == a.charAt(j)){
                        count1++;
                    }
                    if(a.charAt(i) == b.charAt(j)){
                        count2++;
                    } 
                }
                if(count1 != count2){
                    flag = 0;
                    break;
                }
            }
        }

       if(flag == 1)
           System.out.println("True");
        else
           System.out.println("False"); 
    }
}