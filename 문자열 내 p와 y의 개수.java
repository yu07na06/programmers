class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        int pCnt = 0;
        int yCnt = 0;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if('p' == c){
                pCnt++;
            }else if('y' == c){
                yCnt++;
            }
        }
        return (pCnt == yCnt)? true : false;
    }
}
