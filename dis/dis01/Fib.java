// Implement fib which takes in an integer n and returns the nth Fibonacci number
public class Fib {
// Fib: 0,1,1,2,3,5,8,13,21,....
  public static int fibonacci(int n) {
    int[] fib = new int[n+3];
    fib[0]=0;
    fib[1]=1;
    for (int idx=0, sum=0; idx<=n; idx+=1) {
      sum = fib[idx]+fib[idx+1];
      fib[idx+2]=sum;
      // System.out.println(fib[idx+2]);
    }
    return fib[n];
  }
  public static void main(String[] args) {
    int n=40;
    System.out.println(fibonacci(n));
  }
}