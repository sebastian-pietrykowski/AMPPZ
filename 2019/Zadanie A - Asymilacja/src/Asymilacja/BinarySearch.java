package Asymilacja;

import java.util.ArrayList;

public class BinarySearch {

    public static int search(ArrayList<Integer> arr, int key) {
        return binarySearch(arr, 0, arr.size()-1, key);
    }

    private static int binarySearch(ArrayList<Integer> arr, int l, int r, int key) {
        int mid = -1;
        while(l <= r) {
            mid = l +(r-l)/2;
            if(arr.get(mid) == key)
                return mid;
            else if(arr.get(mid) < key)
                l = mid+1;
            else
                r = mid-1;
        }
        return mid;
    }
}
