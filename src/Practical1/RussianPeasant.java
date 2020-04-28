package Practical1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.System.*;

public class RussianPeasant {

    public static void main(String[] args) throws IOException {
        int x = 0;
        int y = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("timings.txt"));
        writer.write("X * Y | elapsed time" + "\n");
        for(x = 0;x<1000;x++){
            RussianPeasant RP = new RussianPeasant();
            final long startTime = System.nanoTime();
            RP.RussianMultiply(x, y);
            final long elapsedTime = System.nanoTime() - startTime;
            System.out.print(x + " * " + y + " = " + RP.RussianMultiply(x,y));
            System.out.println(" | " + elapsedTime);
            writer.write(x + "*" + y + " | " + elapsedTime + "\n");
            y++;
        }
        writer.close();
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
