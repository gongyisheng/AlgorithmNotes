package com.orange_yishenggong.algorithm_notes.math;

//Time Complexity: O(logN)
//Space Complexity: O(1)

public class GCD {
    public static int getIntegerGCD(int n1,int n2){
        if(n1==0) return n2;
        if(n2==0) return n1;
        if(n1<n2) return getIntegerGCD(n2,n1);
        if(n1%n2==0) return n2;
        return getIntegerGCD(n2,n1%n2);
    }
    public static String getStringGCD(String s1,String s2){
        if(s1.isEmpty()) return s2;
        if(s2.isEmpty()) return s1;
        if(s1.length()<s2.length()) return getStringGCD(s2,s1);
        if(s1.startsWith(s2)) return getStringGCD(s1.substring(s2.length()),s2);
        return "";
    }
}
