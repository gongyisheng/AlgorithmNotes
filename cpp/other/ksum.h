#include <vector>

namespace ksum {
  // In [l, r], find n numbers add up to the target
    void nSum(const std::vector<int>& nums, long n, long target, int l, int r,
            std::vector<int>& path, std::vector<std::vector<int> >& ans) {
        if (r - l + 1 < n || target < nums[l] * n || target > nums[r] * n)
            return;
        if (n == 2) {
            // two sum
            while (l < r) {
                const int sum = nums[l] + nums[r];
                if (sum == target) {
                    path.push_back(nums[l]);
                    path.push_back(nums[r]);
                    ans.push_back(path);
                    path.pop_back();
                    path.pop_back();
                    ++l;
                    --r;
                    while (l < r && nums[l] == nums[l - 1])
                        ++l;
                    while (l < r && nums[r] == nums[r + 1])
                        --r;
                } else if (sum < target) {
                    ++l;
                } else {
                    --r;
                }
            }
            return;
        }
        
        for (int i = l; i <= r; ++i) {
            if (i > l && nums[i] == nums[i - 1])
                continue;
            path.push_back(nums[i]);
            nSum(nums, n - 1, target - nums[i], i + 1, r, path, ans);
            path.pop_back();
        }
    }
}
