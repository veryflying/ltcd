
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;
        if (tokens.length == 1)
            return Integer.valueOf(tokens[0]);
        int p = tokens.length - 1, i = 0, r = 0;
        Set<String> op = new HashSet<>();
        op.add("*");
        op.add("+");
        op.add("-");
        op.add("/");
        String[] stk = new String[tokens.length];
        stk[i++] = tokens[p--];
        stk[i++] = tokens[p--];
        while (i > 1){
            if (op.contains(stk[i-1]) || op.contains(stk[i-2])){
                stk[i++] = tokens[p--];
            }
            else {
                String a = stk[--i], b = stk[--i];
                String opt = stk[--i];
                if (opt.equals("*")){
                    r = Integer.valueOf(a) * Integer.valueOf(b);
                }
                if (opt.equals("+")){
                    r = Integer.valueOf(a) + Integer.valueOf(b);
                }
                if (opt.equals("-")){
                    r = Integer.valueOf(a) - Integer.valueOf(b);
                }
                if (opt.equals("/")){
                    r = Integer.valueOf(a) / Integer.valueOf(b);
                }
                stk[i++] = String.valueOf(r);
            }
        }
        return Integer.valueOf(stk[0]);
    }
}
