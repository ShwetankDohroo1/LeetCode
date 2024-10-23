class Solution{
    public boolean finding(int[] arr, int j, int t, int[] sides){
        if(j == arr.length){
            return sides[0] == t && sides[1] == t && sides[2] == t && sides[3] == t;
        }
        for(int i = 0;i < 4;i++){
            if(sides[i] + arr[j] <= t){
                sides[i] += arr[j];
                if(finding(arr,j+1,t,sides)){
                    return true;
                }
                sides[i] -= arr[j];
            }
            if(i>0 && sides[i] == sides[i-1]){
                continue;
            }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null|| matchsticks.length < 4 ){
            return false;
        }
        int sum = 0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        if(sum % 4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int t = sum/4;
        int[] sides = new int[4];
        if(matchsticks[0] > t){
            return false;
        }
        return finding(matchsticks, 0 , t, sides);
    }
    public void reverse(int[] arr){
        int a = 0, b = arr.length-1;
        while(a < b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }
}