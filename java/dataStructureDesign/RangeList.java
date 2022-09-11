package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.Map;
import java.util.TreeMap;

public class RangeList {
    TreeMap<Integer,Integer> map;
    public RangeList(){
        map = new TreeMap<>();
    }

    public void add(int lower,int upper){
        Map.Entry<Integer,Integer> left = map.floorEntry(lower);
        Map.Entry<Integer,Integer> right = map.floorEntry(upper);
        if(left!=null&&left.getValue()>=lower){
            lower = left.getKey();
        }
        if(right!=null&&right.getValue()>upper){
            upper = right.getValue();
        }
        map.put(lower,upper);
        map.subMap(lower,false,upper,true).clear();
    }

    public void remove(int lower,int upper){
        Map.Entry<Integer,Integer> left = map.floorEntry(lower);
        Map.Entry<Integer,Integer> right = map.floorEntry(upper);
        if(left!=null&&left.getValue()>lower){
            map.put(left.getKey(),lower);
        }
        if(right!=null&&right.getValue()>upper){
            map.put(upper,right.getValue());
        }
        map.subMap(lower,true,upper,false).clear();
    }
    public String print(){
        StringBuilder sb = new StringBuilder();
        for(Integer key:map.keySet()){
            sb.append("[");
            sb.append(key);
            sb.append(",");
            sb.append(map.get(key));
            sb.append(")");
            sb.append(",");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
