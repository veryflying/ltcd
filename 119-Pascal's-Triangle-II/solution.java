class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<Integer>();
        Long t = 1L;
        r.add(t.intValue());
        for (int i = 1; i <= rowIndex/2; i++) {
            t = t*(rowIndex-i+1)/i;
            r.add(t.intValue());
        }
        for (int i = rowIndex/2+1; i <= rowIndex; i++){
            r.add(r.get(rowIndex-i));
        }
        return r;
    }
}