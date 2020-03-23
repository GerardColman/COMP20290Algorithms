package Practical6;

public class Substring {

    public static void main(String[] args) {
        Substring sub = new Substring();
        //System.out.println(sub.BruteSearch("hello", "ll"));
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        sub.KMPSearch(pat, txt);
    }

    public int BruteSearch(String txt, String pat) {
        int txtLen = txt.length();
        int patLen = pat.length();
        int result = -1;
        String subString = "";
        for (int i = 0; i < txtLen - patLen; i++) {
            subString = txt.substring(i, i + patLen);
            if (subString.equals(pat)) {
                result = i;
                break;
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
                System.out.println("Match at: "  + i);
                i++;
            }

            else if(i<N && pat.charAt(j) != txt.charAt(i)){
                i = i+j;
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