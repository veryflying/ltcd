class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length){
            if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))
                return 1;
            else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))
                return -1;
            i++;
        }
        if (i == v1.length)
        {
            while (i < v2.length){
                if (Integer.valueOf(v2[i]) != 0)
                    return -1;
                i++;
            }
        }
        else
        {
            while (i < v1.length){
                if (Integer.valueOf(v1[i]) != 0)
                    return 1;
                i++;
            }
        }
        return 0;
    }
}
