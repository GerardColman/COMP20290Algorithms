package Practical4;

/*
All the output times are in nano seconds because if milliseconds were used then all of the 10 values would be 0
 */
public class Sorting {
    public static void main(String[] args){
        Sorting sort = new Sorting();
        CreatInputs CI = new CreatInputs();
        int[] s10 = CI.createInput(10);
        int[] s1000 = CI.createInput(1000);
        int[] s100000 = CI.createInput(100000);
        int[] i10 = s10;
        int[] i1000 = s1000;
        int[] i100000 = s100000;
        int[] st10 = s10;
        int[] st1000 = s1000;
        int[] st100000 = s100000;
        long[] SelectionOut = new long[3];
        long[] InsertionOut = new long[3];
        long[] StalinOut = new long[3];

        /*Timing Seletion Sort*/
        long startTime = System.nanoTime();
        s10 = sort.SelectionSort(s10);
        SelectionOut[0] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        s1000 = sort.SelectionSort(s1000);
        SelectionOut[1] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        s100000 = sort.SelectionSort(s100000);
        SelectionOut[2] = System.nanoTime() - startTime;

        /*Timing Insertion Sort*/
        startTime = System.nanoTime();
        i10 = sort.InsertionSort(s10);
        InsertionOut[0] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        i1000 = sort.InsertionSort(s1000);
        InsertionOut[1] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        i100000 = sort.InsertionSort(s100000);
        InsertionOut[2] = System.nanoTime() - startTime;

        /*Timing Stalin Sort*/
        startTime = System.nanoTime();
        st10 = sort.StalinSort(s10);
        StalinOut[0] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        st1000 = sort.StalinSort(s1000);
        StalinOut[1] = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        st100000 = sort.StalinSort(s100000);
        StalinOut[2] = System.nanoTime() - startTime;

        /*Outputting Results*/
        System.out.println("Selection Sort Times: ");
        System.out.println("10: " + SelectionOut[0] + " 1000: " + SelectionOut[1] + " 100000: " + SelectionOut[2]);
        System.out.println("Insertion Sort Times: ");
        System.out.println("10: " + InsertionOut[0] + " 1000: " + InsertionOut[1] + " 100000: " + InsertionOut[2]);
        System.out.println("Stalin Sort Times: ");
        System.out.println("10: " + StalinOut[0] + " 1000: " + StalinOut[1] + " 100000: " + StalinOut[2]);
    }
    public int[] SelectionSort(int[] arr){
        int temp;
        int minIndex;
        for(int i = 0;i<arr.length - 1;i++){
            minIndex = i;
            for(int j = i + 1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
    public int[] InsertionSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
    public int[] StalinSort(int[] arr){
        int i = 0;
        int j = 0;
        int temp;
        for(j = i+1;j<arr.length;j++) {
            if (arr[j] < arr[i]) {
                arr[j] = 0;
            } else {
                i = j;
            }
        }
        return arr;
    }
}
