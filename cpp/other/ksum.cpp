#include <vector>
#include <algorithm>
#include <iostream>
#include "ksum.h"

std::vector<std::vector<int> > fourSum(std::vector<int>& nums, int target) {
  std::vector<std::vector<int> > ans;
  std::vector<int> path;

  std::sort(begin(nums), end(nums));
  ksum::nSum(nums, 4, target, 0, nums.size() - 1, path, ans);
  return ans;
}

void print(std::vector<std::vector<int> >& ans) {
    for(int i=0; i<ans.size(); i++){
        std::vector<int>& v = ans[i]; 
        for(int i=0;i<v.size();i++){
            std::cout << v[i] << " ";
        }
        std::cout << std::endl;
    }
}

int main(){
    int arr[] = { 1, 2, 3, 4, 5, 5, 0, 0 };
    std::vector<int> vec(std::begin(arr), std::end(arr));
    std::vector<std::vector<int> > ans = fourSum(vec, 10);
    print(ans);
    return 0;
}
