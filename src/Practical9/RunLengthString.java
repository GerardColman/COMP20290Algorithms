package Practical9;

import java.util.Scanner;
public class RunLengthString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        RunLengthString RL = new RunLengthString();
        System.out.println("Please enter string to be compressed");
            String input = "aaaabbbbbxxxyyyyy";
        String output = RL.RunLengthEncode(input);
        System.out.println("Compressed string is " + output);
    }
    String RunLengthEncode(String input){
        String output = "";
        for(int i = 1;i<input.length();i++){
            if(input.charAt(i) != input.charAt(i-1)){
                output = output + input.charAt(i-1) + i;
                input = input.substring(i); //Creates a new string without the previous letters
                i = 1;
            }
            if(i == input.length() - 1){
                output = output + input.charAt(i);
                output = output + input.length();
            }
        }
        return output;
    }
}
