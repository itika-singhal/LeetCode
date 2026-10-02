class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
      Map<Character,Integer> mp = new HashMap<>();
      int l =0,maxL=0;
      for(int r=0;r<n;r++){
        char ch = s.charAt(r);
      
      if(mp.containsKey(ch)){
        l = Math.max(l,mp.get(ch)+1);
      }
      mp.put(ch,r);
      maxL = Math.max(maxL,r-l+1);
      }
      return maxL;
    }
}