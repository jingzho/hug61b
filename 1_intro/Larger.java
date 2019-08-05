public class Larger {
  public static int LargerNum(int x, int y) {
    if (x>y) {
      return x;
    }
    return y;
  }
  public static void main(String[] args) {
    System.out.println(LargerNum(1,10));
  }
}