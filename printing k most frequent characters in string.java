// In a given string printing k most frequent characters where k is input from user using concept of string and arraylist
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        // Create a Scanner object to read input from standard input
        Scanner sc = new Scanner(System.in);
        
        // Read the input string
        String s = sc.nextLine();
        
        // Read the integer k
        int k = sc.nextInt();
        
        // Array to count frequency of each letter ('a' to 'z')
        int[] a = new int[26];
        
        // Iterate over each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Ignore spaces
            if (ch != ' ') {
                // Calculate the index for the character and increment its count
                int index = ch - 'a';
                if(index >= 0 && index <= 25)
                    a[index]++;
            }
        }
        
        // List to store frequencies of characters that appear in the string
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Add frequencies to the list
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0) {
                arr.add(a[i]);
            }
        }
        
        // Sort the list of frequencies in ascending order
        Collections.sort(arr);
        
        // Start from the end of the list (highest frequency)
        int index = arr.size() - 1;
        
        // Print k most frequent characters
        while (k > 0) {
            int f = arr.get(index);
            for (int i = 0; i < 26; i++) {
                if (a[i] == f) {
                    char ch = (char) ('a' + i);
                    System.out.print(ch + " ");
                    a[i] = 0;
                    break;
                }
            }
            k--;
            index--;
        }
    }
}
