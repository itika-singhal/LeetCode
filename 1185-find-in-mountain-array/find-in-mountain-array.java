/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int mountainArray(MountainArray mountainArr) {
        int low = 1;
        int high = mountainArr.length() - 2; 
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            int midPrev = mountainArr.get(mid - 1);
            int midNext = mountainArr.get(mid + 1);
            
            if (midVal > midPrev && midVal > midNext) {
                return mid;
            } else if (midVal < midPrev) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int leftSearch(int peak, MountainArray mountainArr, int target) {
        int low = 0;
        int high = peak - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int rightSearch(int peak, MountainArray mountainArr, int target) {
        int low = peak + 1;
        int high = mountainArr.length() - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal > target) { 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = mountainArray(mountainArr);
  
        if (mountainArr.get(peak) == target) {
            return peak;
        }
        
        int left = leftSearch(peak, mountainArr, target);
        if (left != -1) {
            return left;
        }

        return rightSearch(peak, mountainArr, target);
    }
}
