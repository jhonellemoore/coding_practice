class Solution {
    public int lengthOfLongestSubstring(String s) {
        //int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() == 0){
            return 0;
        }

        for (int left = 0; left < s.length(); left++){
            map.clear();
            right = left;
            while (right < s.length() && !map.containsKey(s.charAt(right))){
                longest = Math.max(right - left + 1, longest);
                map.put(s.charAt(right), 1);
                right++;
            }
        }

        return longest;
    }
}
