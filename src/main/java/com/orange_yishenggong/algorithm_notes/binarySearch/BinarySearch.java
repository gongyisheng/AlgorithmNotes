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
            int mid = (left+right)/2;
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
            int mid = (left+right)/2;
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
        if (left >= list.length || list[left] != target) {
            return -1;
        }
        return left;
    }

    public int right_bound(int target){
        int left = 0;
        int right = list.length-1;
        while(left<=right){
            int mid = (left+right)/2;
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
        if (right < 0 || list[right] != target){
            return -1;
        }
        return right;
    }
}
