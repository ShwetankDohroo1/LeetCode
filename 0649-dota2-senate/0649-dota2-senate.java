class Solution {
    public String predictPartyVictory(String s) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'R'){
                rad.offer(i);
            }
            else{
                dir.offer(i);
            }
        }
        while(!rad.isEmpty() && !dir.isEmpty()){
            int rIndex = rad.poll();
            int dIndex = dir.poll();
            if(rIndex < dIndex){
                rad.offer(rIndex+n);
            }
            else{
                dir.offer(dIndex + n);
            }
        }
        return rad.isEmpty() ? "Dire" : "Radiant";
    }
}