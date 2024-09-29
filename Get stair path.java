//Print all possible paths on stairs to reach at nth stair. You can currently at bottom. You can skip either 1,2 or 3 stairs not more than that.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void path(int s, int n, String ans, ArrayList<String> an){
        if(s >= n){
            if(s == n){
                an.add(ans);
            }
            return;
        }
        // either you can skip one, two or three steps ahead to reach at nth stair
        path(s+1,n,ans+"1",an);
        path(s+2,n,ans+"2",an);
        path(s+3,n,ans+"3",an);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> an = new ArrayList<>();
        path(0,n,"",an);
            System.out.println(an);
    }
}