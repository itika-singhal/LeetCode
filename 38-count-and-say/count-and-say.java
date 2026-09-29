class Solution {
    public String countAndSay(int n) {
        StringBuilder currentString = new StringBuilder("1");
        
        
        while (--n > 0) {
            StringBuilder nextSequence = new StringBuilder();
            
            for (int i = 0; i < currentString.length(); i++) {
                int count = 1;
                while (i + 1 < currentString.length() && currentString.charAt(i) == currentString.charAt(i + 1)) {
                    count++;
                    i++;
                }
                
                nextSequence.append(count).append(currentString.charAt(i));
            }
        
            currentString = nextSequence;
        }
        
        return currentString.toString();
    }
}
