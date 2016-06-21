class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        char[] str = s.toCharArray();
        int p = 0;
        int i, j;
        i = j = s.length()-1;
        while (j >= 0){
            if (s.charAt(j) == ' '){
                if (i == j){
                    i = j = j - 1;
                }
                else {
                    for (int k = j + 1; k <= i; k++) {
                        str[p++] = s.charAt(k);
                    }
                    str[p++] = ' ';
                    i = j = j - 1;
                }
            }else {
                j--;
            }
        }
        if (i != -1)
            for (int k = j + 1; k <= i; k++) {
                str[p++] = s.charAt(k);
            }
        else
        p--;
        p = Math.max(p, 0);
        return String.valueOf(str).substring(0, p);
    }
}
