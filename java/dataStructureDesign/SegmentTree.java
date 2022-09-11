package dataStructureDesign;

/** Segment Tree data structure
 * Used for range sum, range max/min, (range) update
 *
 */

class SegmentTree {
    int[] st_sum;
    int[] st_max;
    int[] st_min;
    int n;

    public SegmentTree(int[] nums) {
        this.n = nums.length;
        this.st_sum = new int[n*2];
        this.st_max = new int[n*2];
        this.st_min = new int[n*2];
        for(int i = 0; i < nums.length; i++){
            st_sum[i+n] = nums[i];
            st_max[i+n] = nums[i];
            st_min[i+n] = nums[i];
        }
        for(int i = n-1; i > 0; i--){
            st_sum[i] = st_sum[i*2] + st_sum[i*2+1];
            st_max[i] = Math.max(st_max[i*2], st_max[i*2+1]);
            st_min[i] = Math.max(st_min[i*2], st_min[i*2+1]);
        }
    }

    public void update(int index, int val) {
        int diff = val-st_sum[index+n];
        for(int i = index+n; i > 0; i = i/2){
            st_sum[i] += diff;
            st_max[i] = Math.max(st_max[i], val);
            st_min[i] = Math.min(st_min[i], val);
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(left += n, right += n; left <= right; left /= 2, right /= 2){
            if(left%2==1){
                sum += st_sum[left++];
            }
            if(right%2==0){
                sum += st_sum[right--];
            }
        }
        return sum;
    }

    public int maxRange(int left, int right) {
        int max = Integer.MIN_VALUE;
        for(left += n, right += n; left <= right; left /= 2, right /= 2){
            if(left%2==1){
                max = Math.max(max, st_sum[left++]);
            }
            if(right%2==0){
                max = Math.max(max, st_sum[right--]);
            }
        }
        return max;
    }

    public int minRange(int left, int right) {
        int min = Integer.MIN_VALUE;
        for(left += n, right += n; left <= right; left /= 2, right /= 2){
            if(left%2==1){
                min = Math.min(min, st_sum[left++]);
            }
            if(right%2==0){
                min = Math.min(min, st_sum[right--]);
            }
        }
        return min;
    }
}
