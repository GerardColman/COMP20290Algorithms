package Practical4;

import java.util.Random;

public class CreatInputs {
    public int[] createInput(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
