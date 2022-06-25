public class Main {
    static final int sNum = 3;
    static int answer = 0;

    public static void main(String[] args) {
        int[] num1 = new int[] {1,2,3,4};
        int[] num2 = new int[] {1,2,7,6,4};
        System.out.println(solution(num2));
    }

    public static int solution(int[] nums) {
        final int numLength = nums.length;

        boolean[] visited = new boolean[numLength]; // false로 초기화
        combination(nums, visited, 0, numLength, 0, 0);

        return answer;
    }

    /**
     * 경우의 수
     * - 백트래킹 사용
     * @param arr: 판별할 숫자 데이터_배열,
     *        visited: 판별할 숫자 선택 여부_배열,
     *        start: 시작 위치,
     *        length: 배열 길이
     *        depth: 경우의 수(깊이)
     *        sum: 판별한 숫자들의 합
     */
    public static void combination(int[] arr, boolean[] visited, int start, int length, int depth, int sum){
        if(depth == sNum){ // sNum=3, 서로 다른 3개를 고를 경우 return
            // true: 소수이므로 카운팅, false: 소수가 아니므로 카운팅하지 않음
            answer += (primeIdentification(sum))? 1: 0;
            return;
        }

        for(int i=start; i<length; i++) {
            visited[i] = true; // 판별할 숫자 선택 여부 표기
            combination(arr, visited, i + 1, length, depth + 1, sum + arr[i]);
            visited[i] = false; // 판별한 숫자 선택 여부 표기 취소
        }
    }

    /**
     * 소수 식별
     * - 제곱근까지만 판별
     * @return true: 소수
     *         false: 소수아님
     */
    public static boolean primeIdentification(int num){
        // num=25라면, i=2~5까지만 판별
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    // 불린 배열 출력 함수
    public static void printBoolean(boolean[] arr){
        for(boolean a : arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    // 정수 배열 출력 함수
    public static void printInt(int[] arr){
        for(int a : arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
