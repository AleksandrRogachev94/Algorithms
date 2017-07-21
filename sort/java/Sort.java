import java.util.*;

public class Sort {
  public static void main(String[] args) {

    Integer[] arr1 = {1,2,6};
    Integer[] arr2 = {4,5,9};

    System.out.println(Arrays.toString(Merge.merge2Arrays(arr1, arr2)));
    // int i, j;
    // boolean flDup;
    // Random rand = new Random();
    // Integer[] arr = new Integer[100];
    //
    // for(i = 0; i < arr.length; i++) {
    //   do {
    //     arr[i] = new Integer(rand.nextInt(arr.length));
    //     flDup = false;
    //     // for(j = 0; j < i; j++) {
    //     //   if(arr[j].equals(arr[i])) { flDup = true; break; }
    //     // }
    //   } while(flDup);
    // }
    //
    // System.out.println("Formed");

    // Stopwatch stopwatch = new Stopwatch();
    // Quick.sort(arr);
    // double time = stopwatch.elapsedTime();

    // int num, i;
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Enter N");
    // int N = scanner.nextInt();
    // Integer[] arr = new Integer[N];
    //
    // System.out.println("Enter elements");
    // for(i = 0; i < arr.length; i++) {
    //   num = scanner.nextInt();
    //   arr[i] = num;
    // }
    //
    // Shell.sort(arr);
    // System.out.println("------------> After Sorting:");
    // System.out.println(Selection.isSorted(arr));
    // for(i = 0; i < arr.length; i++) {
    //   System.out.format("%d\n", arr[i]);
    // }
    //
    // scanner.close();
    // System.out.println(time);
  }
}
