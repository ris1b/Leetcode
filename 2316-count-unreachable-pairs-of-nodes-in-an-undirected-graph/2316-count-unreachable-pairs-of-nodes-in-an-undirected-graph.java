class Solution {
    List<Integer>[] adj;
    long ans;
    long total;
    public long countPairs(int n, int[][] edges) {
        adj = new ArrayList[n+1];
        ans = 0;
        total = n;
        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] vis = new boolean[n+1];

        int total = 0;
        for (int i = 0; i < n; i++) {
        long c = 0;
            if (!vis[i]) {
                // c = dfs(i,vis);
                long count = dfs(i,vis);
                ans+= count* total;
                total += count;
            }
        }
        return ans;
    }

    private long dfs(int source, boolean vis[]) {
        if (vis[source]) {
            return 1;
        }
        vis[source] = true;
        int count = 1;
        for (int i=0; i<adj[source].size(); i++) {
            int child = adj[source].get(i);

            if (!vis[child]) {
                count += dfs(child, vis);
            }
            // count++;
        }
        // System.out.println(count);
        return count;
    }
}