import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matchesPattern(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean matchesPattern(String word, String pattern) {
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
