import sun.security.util.Length;

import java.util.*;


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();
//        Map<Integer, Set<String>> map = new HashMap<>();
        Set<String> res = new HashSet<>();
//        int init = 0;
//        for (char e :
//                s.substring(0, 10).toCharArray()) {
//            init ^= e;
//        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
//            init ^= s.charAt(i-1);
//            init ^= s.charAt(i+9);
//            if (map.get(init) != null)
//                if (map.get(init).contains(s.substring(i, i+10)))
//                    res.add(s.substring(i, i+10));
//                else
//                    map.get(init).add(s.substring(i, i+10));
//            else
//                map.put(init, new HashSet<>());
            if (set.contains(s.substring(i, i+10)))
                res.add(s.substring(i, i+10));
            else
                set.add(s.substring(i, i+10));

        }
        return new ArrayList<>(res);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
//    }
}