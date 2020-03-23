package Practical6;

public class Substring {

    public static void main(String[] args) {
        Substring sub = new Substring();
        String txt = "KASAOAAMMXKESTYMBSMEORSYQMNIARVPMEDXVGAVNUYEHNUPEPZIDOMERTSGBGUSHQTUJQNRZAUFACLPRQWUOIDYRAPNQBNXSPHW";
        String pat = "DYRA";

        long startTime = System.currentTimeMillis();
        System.out.println("Brute Force: Match at index " + sub.BruteSearch(txt, pat));
        long time = System.currentTimeMillis() - startTime;
        System.out.println("Time = " + time);

        startTime = System.nanoTime();
        sub.KMPSearch(pat, txt);
        time = System.nanoTime() - startTime;
        System.out.println("Time = " + time);
    }

    public int BruteSearch(String txt, String pat) {
        int txtLen = txt.length();
        int patLen = pat.length();
        int result = -1;
        int j = 0;
        for (int i = 0; i < txtLen; i++) {
            if (txt.charAt(i) == pat.charAt(j) && j != patLen-1) {
                j++;
            }
            if(txt.charAt(i) == pat.charAt(j) && j==patLen-1){
                result = i-j;
            }
        }
        return result;
    }

    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // prefix suffix values for pattern
        int lps[] = new int[M];


        // Preprocess the pattern (calculate lps[]array)
        computeLPSArray(pat, M, lps);

        int i = 0; //txt index
        int j = 0; // index for pat[]
        while (i < N) {
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if(j==M){
                System.out.println("KMP: Match at index "  + (i-j));
                j = lps[j-1];
            }

            else if(i<N && pat.charAt(j) != txt.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i=i+1;
                }
            }
        }
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}