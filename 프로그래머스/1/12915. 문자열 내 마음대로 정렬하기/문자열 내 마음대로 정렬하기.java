import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> s1.charAt(n) == s2.charAt(n) ? s1.compareTo(s2) : Character.compare(s1.charAt(n), s2.charAt(n)));
        return strings;
    }
}