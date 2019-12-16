
class BinaryVsLinear
{

  private static int linearSearch(int key, int[] keys)
  {
    int count = 0;
    int len = keys.length;
    for(int i = 0; i < len; i++) {
      count+=1;
      if(key == keys[i])
        return count;
    }
    return count;
  }

  private static int binarySearch(int key, int[] keys)
  {
    int low = 0;
    int mid;
    int high = keys.length-1;
    int count = 0;
    while(true) {
      mid = (low+high) / 2;
      if (key < keys[mid]) {
        count += 1;
        high = mid - 1;
      }
      else if (key > keys[mid]) {
        count += 2;//When it get into else statement, it has implementd if statement once
        low = mid + 1;
      }
      else {
        count += 2;
        return count;
      }
    }
  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}
