package math;

public class BitManipulation {
    public void swapValue(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
    }
    //Find the right most one in an number
    public int findRightOne(int num){
        return num&((~num)+1);
    }
    //Find out the only element with even count in the array
    public int findOneEvenCountElement(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
        return eor;
    }
    //Find out the only two elements with even count in the array
    public int[] findTwoEvenCountElement(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
        int leftOne = findRightOne(eor);
        int n1 = 0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]&leftOne)!=0){
                n1 ^= arr[i];
            }
        }
        return new int[]{n1,eor^n1};
    }
}
