public class Array{

  /** 
   * inserts an int item into an int[] arr at the given position
   * @return the resulting array
   * 
   * e.g. if x = [5, 9, 14, 15], item = 6, and position = 2, then the method should return [5, 9, 6, 14, 15]. 
   * If position is past the end of the array, insert item at the end of the array 
   */
  public static int[] insert(int[] arr, int item, int position) {
    // create a new array with size + 1
    int[] newArr = new int[arr.length + 1];
    position = Math.min(arr.length, position);
    // copy the part of array from first to the insert position 
    for (int i = 0; i < position; i += 1) {
      newArr[i] = arr[i];
    }
    newArr[position] = item;
    // copy the rest of the items 
    for (int j = position; j < arr.length; j += 1 ) {
      newArr[j + 1] = arr[j];
    }
    return newArr;
  }

  /** 
   * Destructively reverses the items in arr
   * e.g. calling reverse on an array [1, 2, 3] should change the array to be [3, 2, 1]
   */
  public static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i += 1) {
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[length - 1 - i] = temp;
    }
  }

  /** 
   * a non-destructive method replicate(int[] arr) that replaces the number at index i with arr[i] copies of itself. 
   * e.g. replicate([3, 2, 1]) would return [3, 3, 3, 2, 2, 1]. 
   * For this question assume that all elements of the array are positive. 
   */
  public static int[] replicate(int[] arr) {
    int position = 0;
    for (i = 0; i < arr.length; i += 1) {
      replicaTimes = arr[i];
      for (j = 0; j < replicaTimes; j += 1) {
        int[] replicaArr = new int[];
        replicaArr[position + j] = replicaTimes;
        position = replicaTimes;
      }
    }
    return replicaArr;
  }

  public static void main(String[] args) {
    int[] x = new int[]{1, 2, 4, 5};
    x = insert(x, 3, 3);
    x = insert(x, 6, 10);
    reverse(x);
    replicate(x);
  }
}