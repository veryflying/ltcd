class Solution {
    Map<Long, Integer> map = new HashMap<>();
    String solve(long numerator, long denominator){
        if (numerator == 0)
            return "0";
        List<Long> res = new ArrayList<>();
        long num = numerator, den = denominator;
        int pos = -1;
        map.put(num, ++pos);
        while (true) {
            int d = 1;
            while (num * Math.pow(10, d) < den) {
                res.add((long) 0);
                map.put((long)(num * Math.pow(10, d)), ++pos);
                d++;
            }
            num = (long) (num * Math.pow(10, d));
            long r = (long) (num % den);
            res.add((long) (num / den));
            if (map.containsKey(r))
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < map.get(r); i++) {
                    sb.append(String.valueOf(res.get(i)));
                }
                sb.append("(");
                for (int i = map.get(r); i <= pos; i++) {
                    sb.append(res.get(i));
                }
                sb.append(")");
                return sb.toString();
            }
            if (r == 0) {
                StringBuilder sb = new StringBuilder();
                for (long e :
                        res) {
                    sb.append(e);
                }
                return sb.toString();
            }
            map.put(r, ++pos);
            num = r;
//            pos++;
        }

    }
    public String fractionToDecimal(int numerator, int denominator) {
        String syb = "";
        if (numerator > 0)
            if (denominator < 0)
                syb = "-";
        if (numerator < 0)
            if (denominator > 0)
                syb = "-";
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        long p = 0;
        if (num > den) {
            p = num / den;
            num = num % den;
        }
        String s = solve(num, den);
        return syb + (s == "0"? String.valueOf(p): String.valueOf(p) + "." + s);
    }
}