public class TriangleDrawer {
  public static void drawTriangle(int N) {
     int row = 1;
     int col = 0;
     while (row < N) {
        while (col<row){
           System.out.print("*");
              col = col + 1;
        }
        System.out.println(" ");
        row = row + 1;
        col = 0;
     }
    
  }
  public static void main(String[] args) {
     drawTriangle(10);
  }
}