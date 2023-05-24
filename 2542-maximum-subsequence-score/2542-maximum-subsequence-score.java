class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        Pair[] arr = new Pair[n];
        
        for(int i=0; i<n; i++){
            Pair p = new Pair(nums1[i], nums2[i]);
            arr[i] = p;
        }

        Arrays.sort(arr, (a,b) -> {
            return b.nums2 - a.nums2;
        });

        Queue<Integer> min = new PriorityQueue<>();

        long sum = 0;
        for(int i=0;i<k;i++){
            min.offer(arr[i].nums1);
            sum += arr[i].nums1;
        }

        long ans = Integer.MIN_VALUE;
        ans = Math.max(ans, (long)sum * arr[k-1].nums2);

        for(int i=k; i<n; i++){
            int x = min.poll();
            sum -= x;

            min.offer(arr[i].nums1);
            sum += arr[i].nums1;
            
            ans = Math.max(ans, sum * arr[i].nums2);
        }

        return ans;
    }
}

class Pair{
    int nums1;
    int nums2;
    Pair(int nums1, int nums2){
        this.nums1 = nums1;
        this.nums2 = nums2;
    }
}


// sum of the selected elements from nums1
// multiplied with
// minimum of the selected elements from nums2