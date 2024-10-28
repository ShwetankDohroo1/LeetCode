class Solution {

    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> streakLengths = new HashMap<>();
        Arrays.sort(nums);
        for(int number:nums){
            int root = (int) Math.sqrt(number);
            if(root * root == number && streakLengths.containsKey(root)){
                streakLengths.put(number, streakLengths.get(root) + 1);
            } 
            else{
                streakLengths.put(number, 1);
            }
        }
        int longestStreak = 0;
        for(int streakLength : streakLengths.values()){
            longestStreak = Math.max(longestStreak, streakLength);
        }
        return longestStreak == 1 ? -1 : longestStreak;
    }
}