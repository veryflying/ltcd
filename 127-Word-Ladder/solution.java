class Solution {
    boolean con(String a, String b){
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                c++;
            if (c >= 2)
                return false;
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(beginWord, 0);
        wordList.add(endWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add("#");
        while (true){
            String t = q.poll();
            if (t.equals("#"))
                if (q.size() == 0)
                    break;
                else {
                    q.offer("#");
                    continue;
                }
            for (int i = 0; i < t.length(); i++) {
                StringBuilder s = new StringBuilder(t);
                for (char j = 'a'; j < 'z'; j++) {
                    if (j == t.charAt(i))
                        continue;
                    s.setCharAt(i, j);
                    if (wordList.contains(s.toString())){
                        q.offer(s.toString());
                        wordList.remove(s.toString());
                        hm.put(s.toString(), hm.get(t)+1);
                        if (endWord.equals(s.toString()))
                            break;
                    }
                    s.setCharAt(i, t.charAt(i));
                }
            }
        }
        return hm.containsKey(endWord)? hm.get(endWord)+1: 0;
    }
}