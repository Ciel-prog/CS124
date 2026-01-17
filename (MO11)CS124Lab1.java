
import java.util.Arrays;

public class CS124Lab1 {
    

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
   
    public static int nestedLoops(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000};
        
        System.out.println("CS124 Lab 1 - Runtime Measurements");
        System.out.println("n\tLinear Search (ms)\tNested Loops (ms)");
        System.out.println("---------------------------------------------");
        
        for (int n : sizes) {
           
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            
        
            long startTime = System.nanoTime();
            linearSearch(arr, -1);
            long linearTime = System.nanoTime() - startTime;
            double linearMs = linearTime / 1_000_000.0;
            
            
            startTime = System.nanoTime();
            nestedLoops(n);
            long quadTime = System.nanoTime() - startTime;
            double quadMs = quadTime / 1_000_000.0;
            
            System.out.printf("%d\t%.3f\t\t\t%.3f%n", n, linearMs, quadMs);
        }
    }
}
