import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> baguni = new Stack<Integer>(); // 바구니
        final int N = board.length; // 크레인 크기
        int M = moves.length; // 총 바구니에 들어가는 죠르디의 개수

        for(int m: moves){
            for(int i=0; i<N; i++) {
                // 작동 위치에 해당하는 크레인 데이터를 위에서부터 확인
                if(board[i][m-1]>0){
                    baguni.push(board[i][m-1]); // 바구니에 죠르디 넣음
                    board[i][m-1]=0; // 해당 위치 크레인 비우기
                    matchBaguni(baguni); // 바구니 안에 이웃한 같은 죠르디가 있다면, 터트리기
                    break;
                }

                // 크레인의 마지막 바닥까지 탐색해도,
                // 죠르디가 없다면, 바구니에 담지 못했다는 의미이므로
                // 총 바구니에 들어갔었던(?) 죠르디의 개수를 -1 줄임
                if(i==N-1) M-=1;
            }
        }
        // 총 바구니에 들어간 죠르디의 개수 - 바구니에 남아있는 죠르디 개수 = 터트린 죠르디 개수
        return M - baguni.size();
    }

    /**
     * 죠르디 터트리기
     * - 바구니의 TOP, TOP-1에 위치한 죠르디가 같다면, 터트리기
     * @param baguni: stack.push로 들어오는 죠르디
     * */
    public static void matchBaguni(Stack<Integer> baguni){
        int prevIdx = baguni.size()-2;
        
        // 바구니에 들어있는 죠르디 개수가 1이라면, prevIdx = -1 이므로 확인할 필요없음
        if(prevIdx < 0) return;
        if(baguni.peek() == baguni.get(prevIdx)){ // TOP, TOP-1 위치에 같은 죠르디인지 확인
            // 터트리기
            baguni.pop(); // 펑!
            baguni.pop(); // 펑!
        }
    }
}
