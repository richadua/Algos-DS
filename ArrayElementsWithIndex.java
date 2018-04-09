import java.util.*;

class ArrayElementsWithIndex {
    public static void main(String[] args) {
        int[] arr = new int[7];
        int rank = 1;
        Map<Integer, Integer> indexedMap = new TreeMap<Integer, Integer>();
        for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            indexedMap.put(arr[i], i);
        }
        
        for(Map.Entry<Integer,Integer> entry: indexedMap.entrySet())
            arr[entry.getValue()] = rank++;
        System.out.println(Arrays.toString(arr));
    }
}