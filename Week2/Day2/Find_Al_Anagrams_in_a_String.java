class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) {
            target[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(target, window)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}