import java.util.Arrays;
import java.util.Random;

public class BubbleSortExperiment {
 
    private static long comparisons = 0;
    private static long swaps = 0;

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
     
        comparisons = 0;
        swaps = 0;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++; 
                if (arr[j] > arr[j + 1]) {
                   
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++; // Count swap
                    swapped = true;
                }
            }
         
            if (!swapped) {
                break;
            }
        }
    }
    
  
    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
  
    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000); 
        }
        return arr;
    }
    
 
    public static int[] generateReverseArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }
    
  
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
   
    public static void runExperiment(int[] arr, String caseName) {
        int[] testArray = copyArray(arr);
        
        long startTime = System.nanoTime();
        bubbleSort(testArray);
        long endTime = System.nanoTime();
        
        double timeMs = (endTime - startTime) / 1_000_000.0; 
        
        System.out.printf("| %-15s | %-12d | %-17d | %-10d | %-10.3f |\n",
                caseName, arr.length, comparisons, swaps, timeMs);
    }
    
    
    public static void main(String[] args) {
       
        int[] sizes = {500, 1000, 2000};
        
       
        System.out.println("=================================================================================");
        System.out.println("| Case Type       | Size (n)    | Comparisons Made  | Swaps Made | Time (ms)  |");
        System.out.println("=================================================================================");
        
        for (int n : sizes) {
            System.out.println("------------------ Testing with n = " + n + " ------------------");
            
        
            int[] bestCaseArray = generateSortedArray(n);
            runExperiment(bestCaseArray, "Sorted (Best)");
            
           
            int[] avgCaseArray = generateRandomArray(n);
            runExperiment(avgCaseArray, "Random (Avg)");
            
            
            int[] worstCaseArray = generateReverseArray(n);
            runExperiment(worstCaseArray, "Reverse (Worst)");
        }
        
        System.out.println("=================================================================================");
        
      
        System.out.println("\n\nCSV Format for Spreadsheet:");
        System.out.println("Case Type,Size (n),Comparisons,Swaps,Time (ms)");
        for (int n : sizes) {
            int[] best = generateSortedArray(n);
            int[] avg = generateRandomArray(n);
            int[] worst = generateReverseArray(n);
            
           
            int[][] cases = {best, avg, worst};
            String[] caseNames = {"Sorted", "Random", "Reverse"};
            
            for (int i = 0; i < 3; i++) {
                int[] testArray = copyArray(cases[i]);
                long start = System.nanoTime();
                bubbleSort(testArray);
                long end = System.nanoTime();
                double timeMs = (end - start) / 1_000_000.0;
                
                System.out.printf("%s,%d,%d,%d,%.3f\n",
                        caseNames[i], n, comparisons, swaps, timeMs);
            }
        }
    }
}
