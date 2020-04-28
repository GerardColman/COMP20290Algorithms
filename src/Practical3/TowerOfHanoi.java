package Practical3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TowerOfHanoi {
    public static void main(String[] args) throws IOException {
        TowerOfHanoi TOH = new TowerOfHanoi();
        FibonacciRecursion fib = new FibonacciRecursion();
        BufferedWriter writer = new BufferedWriter(new FileWriter("timings.txt"));
        writer.write("Number" + "\n");
        for(int i = 1;i<=100;i++){
            float startTime = System.currentTimeMillis();
            fib.Fibonacci(i);
            float finalTime = System.currentTimeMillis() - startTime;
            System.out.println("Number: " + i + " | " + "Time: " + finalTime);
            writer.write(i + "\n");
        }

    }
    static void TowerOfHanoi(int disks, String src, String dest, String aux) {
        if (disks == 1) {
            //System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        TowerOfHanoi(disks-1, src, aux, dest);
        //System.out.println("Move disk " + disks + " " + src + " to " + dest);
        TowerOfHanoi(disks-1, aux, dest, src);
    }
}