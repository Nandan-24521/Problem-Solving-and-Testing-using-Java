import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        
        return result;
    }
}
