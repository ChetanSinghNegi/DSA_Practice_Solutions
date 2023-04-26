import java.util.*;
import java.lang.*;
import java.io.*;

class SearchInNearlySortedArray {
  public static void main(String[] args) throws IOException {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solve(num, k));
  }

  public static int solve(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int ele = arr[mid];
      int leftVal = mid - 1 >= 0 ? arr[mid - 1] : Integer.MIN_VALUE;
      int rightVal = mid + 1 < arr.length ? arr[mid + 1] : Integer.MIN_VALUE;
      if (ele == target) {
        return mid;
      }
      if (target == leftVal) {
        return mid - 1;
      }
      if (target == rightVal) {
        return mid + 1;
      }
      if (ele > target) {
        right = mid - 2;
      } else {
        left = mid + 2;
      }
    }
    return -1;
  }
}