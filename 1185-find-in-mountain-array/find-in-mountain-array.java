class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        int start = 0;
        int end = n - 1;

        // Find peak
        while(start < end) {

            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        int peak = end;

        // Search increasing side
        start = 0;
        int leftEnd = peak;

        while(start <= leftEnd) {

            int mid = start + (leftEnd - start) / 2;

            if(mountainArr.get(mid) > target) {
                leftEnd = mid - 1;
            }
            else if(mountainArr.get(mid) < target) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }

        // Search decreasing side
        start = peak + 1;
        end = n - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) > target) {
                start = mid + 1;
            }
            else if(mountainArr.get(mid) < target) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }
}