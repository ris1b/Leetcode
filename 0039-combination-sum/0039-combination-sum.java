class Solution {

    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        

        ans = new ArrayList<>();
        generate(0, candidates.length, new ArrayList<>(), candidates, 0, target);

        return ans;
    }

    public void generate(int pos, int n, List<Integer> temp, int[] candidates, int sum, int x){

        if(pos == n || sum >= x) {
            if(!ans.contains(temp) && sum == x)
                ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(candidates[pos]);
        sum += candidates[pos];

        generate(pos, n, temp, candidates, sum, x);

        temp.remove(temp.size() - 1);
        sum -= candidates[pos];

        generate(pos+1, n, temp, candidates, sum, x);
    }
}