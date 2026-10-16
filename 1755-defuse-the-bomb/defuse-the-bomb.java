class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int sum = 0;
        if (k == 0) {
            return res;
        }
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i % n];
            }
            res[0] = sum;
            for (int end = 1; end < n; end++) {
                sum -= code[end % n];
                sum += code[(end + k) % n];
                res[end] = sum;
            }
        } else {
            int absK = -k;
            for (int i = 1; i <= absK; i++) {
                sum += code[(n - i) % n];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                sum -= code[(i - 1 - absK + n) % n];
                sum += code[(i - 1 + n) % n];
                res[i] = sum;
            }
        }
        return res;
    }
}
