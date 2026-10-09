import java.util.*;

class Solution {
    public int reverse(int x) {
        int nCopy =x;
        long rev = 0;
     x= Math.abs(x);
    while (x != 0) {
      int last = x % 10;
      rev = rev * 10 + last;
      x/= 10;
    }
    if (rev > Integer.MAX_VALUE|| rev<Integer.MIN_VALUE) return 0;
    return (nCopy< 0) ? (int)-rev : (int)rev;
    }
}
  