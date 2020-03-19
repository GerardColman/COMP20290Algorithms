package Practical1;

import java.util.Scanner;
import java.lang.System.*;

public class RussianPeasant {

    public static void main(String[] args){
        int x = 68;
        int y = 139;
        RussianPeasant RP = new RussianPeasant();
        final long startTime = System.nanoTime();
        RP.RussianMultiply(x, y);
        final long elapsedTime = System.nanoTime() - startTime;
        System.out.println(x + " * " + y + " = " + RP.RussianMultiply(x,y));
        System.out.println("Time Taken: " + elapsedTime);

    }

    public int RussianMultiply(int x, int y){
        int sum = 0;
        while(x >= 1){
            if(x % 2 == 0){
                x = x/2;
                y = y * 2;
            }
            if(x % 2 == 1){
                sum = sum + y;
                x = x/2;
                y = y * 2;
            }
        }
        return sum;
    }

}
