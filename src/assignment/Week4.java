package assignment;

import java.util.HashMap;
import java.util.Map;

public class Week4 {
	

    // Function to find the maximums
    // absolute difference between
    // distinct elements in arr[]
    static int MaxAbsDiff(int[][] arr, int n)
    { 
        // HashMap to store each element
        // with their occurrence in array
        Map<Integer, Integer> map
            = new HashMap<>();
 
        // maxElement and minElement to
        // store maximum and minimum
        // distinct element in arr[]
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
 
        // Traverse arr[] and update each
        // element frequency in HashMap
        for (int i = 0; i < n; i++) {
            map.put(arr[i],
                    map.getOrDefault(arr[i], 0)
                        + 1);
        }
 
        // Traverse HashMap and check if
        // value of any key appears 1
        // then update maxElement and
        // minElement by that key
        for (Map.Entry<Integer, Integer> k :
             map.entrySet()) {
 
            if (k.getValue() == 1) {
                maxElement
                    = Math.max(maxElement,
                               k.getKey());
                minElement
                    = Math.min(minElement,
                               k.getKey());
            }
        }
 
        // Return absolute difference of
        // maxElement and minElement
        return Math.abs(maxElement
                        - minElement);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        // Given array arr[]
        int[][] arr = { {1,3,8,9},{8,7,2,6},{13,3,6,4},{13,1,5,3} };
        int n = arr.length;
 
        // Function Call
        System.out.println(MaxAbsDiff(arr, n));
    }

}
