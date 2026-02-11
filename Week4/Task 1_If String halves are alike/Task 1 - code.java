class Solution {

    public boolean halvesAreAlike(String s) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int halfLength = s.length() / 2;

        int vowelCountDifference = 0;

        for (int i = 0; i < halfLength; i++) {

            if (vowels.contains(s.charAt(i))) {
                vowelCountDifference++;
            }

            if (vowels.contains(s.charAt(i + halfLength))) {
                vowelCountDifference--;
            }
        }

        return vowelCountDifference == 0;
    }
}
