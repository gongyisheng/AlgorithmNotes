package com.orange_yishenggong.algorithm_notes.binarySearch;

public class BinarySearch {
    private int[] list;

    public BinarySearch(int[] list){
        this.list = list;
    }
    public int search(int target){
        int left = 0;
        int right = list.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==list[mid]){
                return mid;
            }
            else if(target>list[mid]){
                left = mid+1;
            }
            else if(target<list[mid]){
                right = mid-1;
            }
        }
        return -1;
    }

    public int left_bound(int target){
        int left = 0;
        int right = list.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==list[mid]){
                //To find the left bound. Set the right one to mid-1 if we find target is equal to list[mid]
                right = mid-1;
            }
            else if(target>list[mid]){
                left = mid+1;
            }
            else if(target<list[mid]){
                right = mid-1;
            }
        }
        //out of range case
        //If you want to output the min number larger than target, remove list[left] != target restriction.
        //(T)[X,...]
        if (left >= list.length || list[left] != target) {
            System.out.println(left);
            return -1;
        }
        return left;
    }

    public int right_bound(int target){
        int left = 0;
        int right = list.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==list[mid]){
                //To find the left bound. Set the right one to mid-1 if we find target is equal to list[mid]
                left = mid+1;
            }
            else if(target>list[mid]){
                left = mid+1;
            }
            else if(target<list[mid]){
                right = mid-1;
            }
        }
        //out of range cases
        //If you want to output the max number less than target, remove list[right] != target restriction.
        //[...,X](T)
        if (right < 0 || list[right] != target){
            return -1;
        }
        return right;
    }

    //unordered list with distinct neighbor numbers
    public int getLocalMin(){
        if(list==null||list.length==0){
            return -1;
        }
        if(list.length==1||list[0]<list[1]){
            return 0;
        }
        if(list[list.length-1]<list[list.length-2]){
            return list.length-1;
        }
        int left = 1;
        int right = list.length-2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(list[mid]>list[mid-1]){
                right = mid-1;
            }
            else if(list[mid]>list[mid+1]){
                left = mid+1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}
