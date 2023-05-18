class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        // List<Integer> indegree = new ArrayList<>();
        int [] indegree = new int[n];

        for(List<Integer> l : edges){
            indegree[l.get(1)] += 1;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}