//We have to travel from left top cell to right bottom cell and have to print all possible paths by which we can travell and we can only go to either vertical or horizontal in each step.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void path(int n, int a, ArrayList<String> ans, String add, int i, int j){
            if(i == n  && j == a){
                ans.add(add);
            }
            if(i > n || j > a){
              return;
            }
        path(n,a,ans,add+"h",i,j+1);
        path(n,a,ans,add+"v",i+1,j);      
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           //number of rows
        int a = sc.nextInt();           //number of columns
        ArrayList<String> ans = new ArrayList<>();
        path(n,a,ans,"",1,1);
            System.out.println(ans);
    }
}