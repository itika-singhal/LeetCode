class MyCalendarTwo {
TreeMap<Integer,Integer> timeline ;
    public MyCalendarTwo() {
        timeline =new TreeMap<>();
        
    }
    
    public boolean book(int startTime, int endTime) {
        timeline.put(startTime,timeline.getOrDefault(startTime,0)+1);
         timeline.put(endTime,timeline.getOrDefault(endTime,0)-1);

         int activeBooking =0;
         for(int values:timeline.values()){
            activeBooking+=values;

            if(activeBooking>2){
                timeline.put(startTime,timeline.get(startTime)-1);
                timeline.put(endTime,timeline.get(endTime)+1);
                return false;
                
            }
         }
         return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */