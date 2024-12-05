class Solution {
    public boolean canChange(String start, String target) {
        List<int[]> startPosList = parseString(start);
        List<int[]> targetPosList = parseString(target);
        if(startPosList.size() != targetPosList.size()){
            return false;
        }
        for(int i=0;i<startPosList.size();i++){
            int[] startPos = startPosList.get(i);
            int[] targetPos = targetPosList.get(i);
            //if the types of characters (L or R) are different at any point, transformation is not possible
            if(startPos[0] != targetPos[0]){
                return false;
            }
            //if 'L' in start is to the right of 'L' in target, transformation is not possible as 'L' only moves left
            if(startPos[0] == 1 && startPos[1] < targetPos[1]){
                return false;
            }
            //if 'R' in start is to the left of 'R' in target, transformation is not possible as 'R' only moves right
            if(startPos[0] == 2 && startPos[1] > targetPos[1]){
                return false;
            }
        }
        return true;
    }
    private List<int[]> parseString(String s) {
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(currentChar == 'L'){
                result.add(new int[] {1, i});
            }
            else if(currentChar == 'R'){
                result.add(new int[] {2, i});
            }
        }
        return result;
    }
}