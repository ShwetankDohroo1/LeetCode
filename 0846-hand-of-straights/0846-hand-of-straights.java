class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!= 0){
            return false;
        }
        Map<Integer, Integer> mp = new TreeMap<>();
        for(int i:hand){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int key:mp.keySet()){
            int count = mp.get(key);
            if(count > 0){
                for(int i=0;i<groupSize;i++){
                    int current = key + i;
                    if(mp.getOrDefault(current, 0) < count){
                        return false;
                    }
                    mp.put(current, mp.get(current) - count);
                }
            }
        }

        return true;
    }
}