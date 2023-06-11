class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

		generate(ans, new ArrayList<Integer>(), 1, n, k);
		
        return ans;
    }

    public void generate(List<List<Integer>> ans, List<Integer> temp, int si, int n, int k) {
		if(k==0) {
			ans.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=si; i<=n; i++) {
			temp.add(i);
			
            generate(ans, temp, i+1, n, k-1);

			temp.remove(temp.size()-1);
		}
	}
}