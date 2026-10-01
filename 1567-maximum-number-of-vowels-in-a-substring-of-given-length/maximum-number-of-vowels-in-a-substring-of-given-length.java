class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, vowels = 0, maxVowel = 0;
        for (int end = 0; end < s.length(); end++) {
            if (isVowel(s.charAt(end))) {
                vowels += 1;
            }
            if (end >= k - 1) {
                maxVowel = Math.max(maxVowel, vowels);

                
                if (isVowel(s.charAt(start))) {
                    vowels -= 1;
                }
                start += 1;
            }
        }
        return maxVowel;   
    }
    
    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}
