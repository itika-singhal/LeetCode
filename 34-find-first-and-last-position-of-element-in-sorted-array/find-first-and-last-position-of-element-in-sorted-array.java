class Solution {
    public int[] searchRange(int[] arr, int target) {
  int[] ans = {-1, -1};
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                ans[0] = m;
                r = m - 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        l = 0; r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                ans[1] = m;
                l = m + 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
}
}