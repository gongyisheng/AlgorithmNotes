package com.orange_yishenggong.algorithm_notes.math;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(N^0.25);
//Space Complexity: O(F);
//F:number of factors

public class PrimeFactorization {
    public static List<Integer> getPrimeFactors(int num){
        List<Integer> factorList = new ArrayList<>();
        for(int i=2;i*i<=num;i++){
            while(num%i==0){
                num /= i;
                factorList.add(i);
            }
        }
        if(num!=1) factorList.add(num);
        return factorList;
    }
}
