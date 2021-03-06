//Algorithm code from http://www.java2novice.com/java-sorting-algorithms/quick-sort/

public class QuickSortStrategy extends SortingStrategy{
  private int[] array;
  private int length;

  public QuickSortStrategy(int[] array, int n){
    this.array = array;
    this.length = n;
  }

  @Override
  public void sort(int[] inputArr, int length) {

    if (inputArr == null || inputArr.length == 0) {
      return;
    }
    quickSort(0, length - 1);
    for(int k=0; k<length; k++){
      System.out.print(inputArr[k]+" ");
    }
    System.out.println(" sorted with Quick Sort strategy");
  }

  private void quickSort(int lowerIndex, int higherIndex) {

    int i = lowerIndex;
    int j = higherIndex;
    // calculate pivot number, I am taking pivot as middle index number
    int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
    // Divide into two arrays
    while (i <= j) {
      /**
       * In each iteration, we will identify a number from left side which
       * is greater then the pivot value, and also we will identify a number
       * from right side which is less then the pivot value. Once the search
       * is done, then we exchange both numbers.
       */
      while (array[i] < pivot) {
        i++;
      }
      while (array[j] > pivot) {
        j--;
      }
      if (i <= j) {
        exchangeNumbers(i, j);
        //move index to next position on both sides
        i++;
        j--;
      }
    }
    // call quickSort() method recursively
    if (lowerIndex < j)
      quickSort(lowerIndex, j);
    if (i < higherIndex)
      quickSort(i, higherIndex);
  }

  private void exchangeNumbers(int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
