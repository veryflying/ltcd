import javax.jws.Oneway;
import java.util.*;

class Comp implements Comparator{
    @Override
    public int compare(Object a, Object b){
        String sa = String.valueOf(a), sb = String.valueOf(b);
        if (sa.equals(sb))
            return 0;
        int i = 0;
        for (; i < sa.length() && i < sb.length(); i++) {
            if (sa.charAt(i) > sb.charAt(i))
                return -1;
            if (sa.charAt(i) < sb.charAt(i))
                return 1;
        }
        if (sa.length() > sb.length()){
            return compare(sa.substring(i), sb);
        }
        else
            return compare(sa, sb.substring(i));
    }
}

public class Solution {
    public String largestNumber(int[] nums) {
        Integer r[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            r[i] = nums[i];
        }
        String s = "";
        Arrays.sort(r, new Comp());
        if (r[0].equals(0))
            return "0";
        for (Object e :
                r) {
            s += String.valueOf(e);
        }
        return s;
    }
}