import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int idLength = id_list.length;
        int[] answer = new int[idLength];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < idLength; i++) {
            String n = id_list[i];
            map.put(n, new HashSet<>());
            idxMap.put(n, i);
        }

        for (String s : report) {
            String[] r = s.split(" ");
            map.get(r[1]).add(r[0]); // r[0] 신고한사람, r[1] 신고당한사람
        }

        for (int i = 0; i < idLength; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
