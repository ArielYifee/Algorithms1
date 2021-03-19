package LCS;

public class LCS {
    public static String lcs(String s1, String s2) { // n^2
        int n = s1.length();
        int m = s2.length();
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {f[i][0] = 0;} // set column to 0
        for (int j = 0; j < m+1; j++) {f[0][j] = 0;} // set raw to 0

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) f[i][j] = 1 + f[i-1][j-1]; // if there is another common word add 1 to the matrix
                else f[i][j] = Math.max(f[i][j-1], f[i-1][j]); // set the max
            }
        }
        // build ans
        int i = n, j = m;
        String ans = "";
        while(f[i][j] != 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                ans = s1.charAt(i-1) + ans;
                i--; j--;
            }
            else {
                if(f[i][j-1] > f[i-1][j]) j--;
                else i--;
            }
        }
//        return f[n][m]; // size of LCS
        return ans;
    }

    public static void main(String[] args) {
        String s = "dasmoksfnsfi";
        String ss = "dijsfoindisof";
        System.out.println(lcs(ss,s));
    }
}
