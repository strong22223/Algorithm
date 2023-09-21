package First_base;

import java.util.Arrays;

public class TwoSumFast {
    public static int cout(int[] arrays) {
        int cnt = 0;
        int length = arrays.length;
        Arrays.sort(arrays);
        for (int array : arrays) if (BinarySearch.rank(-array, arrays) > -1) cnt++;
        return cnt;
    }

    class Solution {
        static int rank(int key, int[] array) {
            int length = array.length;
            int left = 0;
            int right = length - 1;
            int mid = left + (right - left) / 2;
            while (left <= right) {
                int midNumber = array[mid];

                if (key < midNumber) right = mid - 1;
                else if (key > midNumber) left = mid + 1;
                else return mid;

                mid = left + (right - left) / 2;
            }
            return -1;
        }

        public static int[] twoSum(int[] nums, int target) {
            int[] poisitions = {0, 0};
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int poisition = rank(target - nums[i], Arrays.copyOfRange(nums, i + 1, nums.length));
                if (poisition > -1) {
                    poisitions[0] = i;
                    poisitions[1] = i + poisition + 1;
                    break;
                }
            }
            return poisitions;
        }

    }

    public static void main(String[] args) {
        int[] a = {3,2,4};
//        int cout = cout(a);
//        System.out.println(cout);
       Solution.twoSum(a,6);

    }
}
