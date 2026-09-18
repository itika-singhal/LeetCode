class Solution {
    public char repeatedCharacter(String s) {
        int [] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a']==2)
            return s.charAt(i);
        }
        return ' ';
    }
}