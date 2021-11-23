package com.orange_yishenggong.algorithm_notes.sort;

import java.util.Arrays;

public class Sort {
    int[] rawArr;
    public Sort(int[] arr){
        this.rawArr = arr;
    }


    public int[] deepCopy(int[] arr){
        int[] temp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    public int[] deepCopy(int[] arr,int begin,int end){
        if(begin==end){
            return new int[0];
        }
        int[] temp = new int[Math.min(arr.length,end)-begin];
        for(int i=begin;i<Math.min(end,arr.length);i++){
            temp[i-begin] = arr[i];
        }
        return temp;
    }

    public int[] builtInSort(){
        int[] arr = deepCopy(rawArr);
        Arrays.sort(arr);
        return arr;
    }

    //Time Complexity: O(N^2)
    //Stability: Yes
    //Notes for performance: The algorithm performs best when the array is partially ordered.
    public int[] bubbleSort(){
        int temp = 0;
        int[] arr = deepCopy(rawArr);
        for(int i=arr.length-1;i>0;i--){
            boolean swap = false;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        return arr;
    }

    //Time Complexity: O(N^2)
    //Stability: No.
    //Notes for performance: Always O(N^2);
    public int[] selectionSort(){
        int[] arr = deepCopy(rawArr);
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    //Time Complexity: O(N^2)
    //Stability: Yes
    //Notes for performance: Good performance when the length of array is small.(<50)
    public int[] insertionSort(){
        int[] arr = deepCopy(rawArr);
        for(int i=1;i<arr.length;i++){
            int val = arr[i];
            int pos = i;
            while(pos>0&&arr[pos-1]>val){
                arr[pos] = arr[pos-1];
                pos--;
            }
            arr[pos] = val;
        }
        return arr;
    }

    //Time Complexity: O(NlogN)
    //Stability: Yes
    //Notes for performance: Good performance when the length of array is small but it requires extra memory.
    public int[] mergeSort(){
        int[] arr = deepCopy(rawArr);
        mergeSortHelper(arr,0,arr.length-1);
        return arr;
    }
    private void mergeSortHelper(int[] arr,int left,int right){
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSortHelper(arr,left,mid);
            mergeSortHelper(arr,mid+1,right);
            merge(arr,mid,left,right);
        }
    }
    private void merge(int[] arr,int mid,int left,int right){
        int[] L = deepCopy(arr,left,mid+1);
        int[] R = deepCopy(arr,mid+1,right+1);
        int i=0;
        int j=0;
        int k=left;
        while(i<L.length&&j<R.length){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<L.length){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<R.length){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Time Complexity: O(NlogN)
    //Stability: No
    //Notes for performance: Good performance in most circumstances.
    public int[] quickSort(){
        int[] arr = deepCopy(rawArr);
        quickSortHelper(arr,0,arr.length-1);
        return arr;
    }
    private void quickSortHelper(int[] arr,int left,int right){
        if(left<right){
            int pivot = partition(arr,left,right);
            quickSortHelper(arr,left,pivot-1);
            quickSortHelper(arr,pivot+1,right);
        }
    }
    private int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        while(left<right){
            while(left<right&&arr[right]>=pivot){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arr[left]<=pivot){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    //to be continue: countSort, shellSort, bucketSort, radixSort
    //ref: https://zhuanlan.zhihu.com/p/42586566
}
