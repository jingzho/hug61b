public class MaxNum {
   public static int max(int[] m) {
      // int len = m.length;
      int max = 0;
      // while (len > 0) {
      //    if (max < m[len-1]) {
      //       max = m[len-1];
      //    }
      //    len = len - 1;
      // }
      for (int len=m.length; len > 0; len -= 1) {
         if (max < m[len-1]) {
            max = m[len-1];
         }
      }
      return max;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
      System.out.println(max(numbers));
   }
}