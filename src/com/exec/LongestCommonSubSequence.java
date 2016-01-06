package com.exec;

public class LongestCommonSubSequence {

    public static void main(String[] args) {

    	String str1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";  
        String str2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        int[][] cache = new int[len1+1][len2+1];
        int[][] direction= new int[len1+1][len2+1];
                
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    cache[i][j]=cache[i-1][j-1]+1;
                    direction[i][j]=1;  
                }
                else if (cache[i-1][j]>=cache[i][j-1]) {
                    cache[i][j]=cache[i-1][j];
                    direction[i][j] = 2;  
                }
                else {
                    cache[i][j]=cache[i][j-1];     
                    direction[i][j]=3;   
                }
            }
        }
        
        String longestCommonSubseq = "";
        int i=len1;
        int j=len2;
        while (i!=0 && j!=0) {
            if (direction[i][j] ==1) {   
                longestCommonSubseq =str1.charAt(i-1) + longestCommonSubseq;
                i = i - 1;
                j = j - 1;
            }
            if (direction[i][j] == 2) {  
                i = i - 1;
            }
            if (direction[i][j] == 3) {  
                j = j - 1;
            }
        }
        
        System.out.println("Str1: " + str1);
        System.out.println("Str2: " + str2);
        System.out.println("LCS is: " + longestCommonSubseq);
        /* Test:: 
         * Str1: ACCGGTCGAGTGCGCGGAAGCCGGCCGAA 
         * Str2: GTCGTTCGGAATGCCGTTGCTCTGTAAA 
         * LCS : GTCGTCGGAAGCCGGCCGAA  
         */    
    }
    
   
}
