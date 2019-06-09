package tank01_1;

import java.util.HashSet;

/**
 * @Auther: qiucy
 * @Date: 2019-06-06 10:47
 * @Description:
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 示例 1:
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

 */
public class Test {
    //540
    public int singleNonDuplicate(int[] nums) {
        int right  = nums.length,left = 0;
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < right; i=i+2) {

        }
        return 0;
    }
    public int singleNonDuplicate2(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
    public static int singleNonDuplicate3(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) end = mid;
            else start = mid + 2;
        }
        return nums[start];
    }
}
