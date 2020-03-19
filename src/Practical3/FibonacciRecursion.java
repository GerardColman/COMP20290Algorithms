package Practical3;

public class FibonacciRecursion {
    public int Fibonacci(int n){
        if(n <= 2) {
            return n;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
}
