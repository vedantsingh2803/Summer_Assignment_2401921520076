class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (char ch : s1.toCharArray()) {
            target[ch - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(target, window)) {
                return true;
            }
        }

        return false;
    }
}