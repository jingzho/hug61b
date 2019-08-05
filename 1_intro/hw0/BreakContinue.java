public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    int len = a.length;
    for ( int i = 0; i < len; i += 1) {
      int sum = 0;
      if (a[i] < 0) {
        continue;
      }
      int innerloc;
      for ( innerloc=i; innerloc<=i+n; innerloc += 1) {
        if (innerloc >= len) {
          break;
        }
        sum += a[innerloc];
      }
      a[i]=sum;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}