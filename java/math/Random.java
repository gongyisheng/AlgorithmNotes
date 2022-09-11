package com.orange_yishenggong.algorithm_notes.math;

public class Random {
    public int randomInt(int min,int max){
        return (int)(Math.random()*(max-min+1))+min;
    }
    public double randomDouble(double min,double max){
        return Math.random()*(max-min)+min;
    }
}
