class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j){
            while (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
            if (i >= j)
                break;
            else
                i++;
            while (i <= j && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
                if (i >= j)
                    break;
                else
                    j--;
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}