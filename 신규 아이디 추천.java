class Solution {
    public String solution(String new_id) {
        // [1] 소문자 치환
        new_id = new_id.toLowerCase();

        // [2,3] 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거, 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("[^a-z\\d-_.]", "").replaceAll("[.]+", ".");

        // [4] 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // [5] 빈 문자열이라면, new_id에 "a"를 대입합니다.
        new_id = new_id.isEmpty()? "a" : new_id;

        // [6] 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다, 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        new_id = new_id.substring(0, new_id.length()>15?15:new_id.length()).replaceAll("^[.]|[.]$", "");

        // [7] 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        char lastChar = new_id.charAt(new_id.length()-1);
        return new_id.length() <= 2 ?
                (new_id+lastChar+lastChar).substring(0, 3)
                : new_id;
    }
}
