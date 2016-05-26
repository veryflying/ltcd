class Solution {
    List<List<String>> r = new ArrayList<>();
    List<String> stk = new ArrayList<>();
    String gs;
    boolean isP(int i, int j){
        while (i < j){
            if (gs.charAt(i++) != gs.charAt(j--))
                return false;
        }
        return true;
    }
    List<List<String>> rec(int i, int j){
        List<List<String>> r = new ArrayList<>();
        if (i == j) {
            List t = new ArrayList<String>();
            t.add(String.valueOf(gs.charAt(j)));
            r.add(t);
            return r;
        }
        for (int k = i; k < j; k++) {
          if(isP(i, k)){
              for (List<String> e :
                      rec(k+1, j)) {
                  List<String> t = new ArrayList<>();
                  t.add(gs.substring(i, k+1));
                  t.addAll(e);
                  r.add(t);
              }
          }
        }
        if (isP(i, j)){
            List<String> t = new ArrayList<>();
            t.add(gs.substring(i, j+1));
            r.add(t);
        }
        return r;
    }
    public List<List<String>> partition(String s) {
        gs = s;
        return rec(0, s.length()-1);
    }
}
