class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {

                // Target lies in the sorted left half
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } 
                else {
                    start = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies in the sorted right half
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } 
                else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}