class Solution {
    public int minimumCardPickup(int[] cards) {
        int start=0;
        Map<Integer,Integer>freqMap=new HashMap<>();
        int minLength=Integer.MAX_VALUE;
        for(int end=0;end<cards.length;end++){
            int curr =cards[end];
            freqMap.put(curr,freqMap.getOrDefault(curr,0)+1);
            while(freqMap.get(curr)==2){
                minLength=Math.min(minLength,end-start+1);
                freqMap.put(cards[start],freqMap.get(cards[start])-1);start+=1;
            }
        }
        return minLength==Integer.MAX_VALUE?-1:minLength;
    }
}