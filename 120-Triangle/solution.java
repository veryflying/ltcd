public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(triangle.get(triangle.size()-1));
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                tmp.set(j, triangle.get(i).get(j) + Math.min(tmp.get(j), tmp.get(j+1)));
            }
        }
        return tmp.get(0);
    }
}