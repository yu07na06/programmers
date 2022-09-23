class Solution {
    public boolean solution(int x) {
        int copyX = x;
        int sum = 0;
        while(x>0){
            sum += x%10;
            x/=10;
        }
        
        return copyX % sum == 0;
    }
}
