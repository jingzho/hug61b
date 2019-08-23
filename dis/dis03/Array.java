public class Array{
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
      newArr[j+1] = arr[j];
    }
    return newArr;
  }

  public static void main(String[] args) {
    int[] x = new int[]{1, 2, 3, 4, 5};
    insert(x, 10, 3);
    insert(x, 100, 10);
  }
}