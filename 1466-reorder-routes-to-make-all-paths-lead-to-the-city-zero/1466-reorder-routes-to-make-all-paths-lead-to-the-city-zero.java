class Pair{
    boolean isForward;
    int u;
    Pair(int u, boolean isForward){
        this.u = u;
        this.isForward = isForward;
    }

}
class Solution {
    List<Pair>[] adj;
    int ans;
    public int minReorder(int n, int[][] connections) {
        adj = new ArrayList[n];
        ans = 0;
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }


        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            adj[u].add(new Pair(v,true));
            adj[v].add(new Pair(u,false));
        }
        boolean vis[] = new boolean[n];
        return dfs(0, vis);
    }

    public int dfs(int src, boolean [] vis){
        if(vis[src]) return 0;

        vis[src] = true;
        int change = 0;
        for(int i=0; i<adj[src].size(); i++){
            Pair p = adj[src].get(i);
            if(!vis[p.u]){
                int x = 0;
                if(p.isForward){
                    x = 1;
                }
                change += dfs(p.u,vis) + x;
            }
        }
        return change;
    }
}

















