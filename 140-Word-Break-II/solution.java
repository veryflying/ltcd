public class Solution {
    public boolean wordBreakt(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
    Map<Integer, List<String>> table = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (!wordBreakt(s, wordDict))
            return new ArrayList<>();
        table.put(0, Arrays.asList(""));
        for (int i = 1; i <= s.length(); i++) {
            List<String> r = new ArrayList<>();
            if (wordDict.contains(s.substring(0,i)))
                r.add(s.substring(0,i));
            for (int j = 1; j < i; j++) {
                if (wordDict.contains(s.substring(j,i))){
                    for (String e :
                            table.get(j)) {
                        r.add(e+" "+s.substring(j,i));
                    }
                }
            }
            table.put(i, r);
        }
        return table.get(s.length());
    }
}