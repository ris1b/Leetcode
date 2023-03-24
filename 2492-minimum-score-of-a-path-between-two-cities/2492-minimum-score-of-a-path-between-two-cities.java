class Pair{
    int city;
    int score;
    public Pair(int city,int score){
        this.city = city;
        this.score = score;
    }
}

class Solution {
    List<Pair>[] adj;
    int min;
    public int minScore(int n, int[][] roads) {
        adj = new ArrayList[n+1];
        min = Integer.MAX_VALUE;
        
        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int score = roads[i][2];

            adj[u].add(new Pair(v,score));
            adj[v].add(new Pair(u,score));
        }
        boolean[] vis = new boolean[n+1];
        dfs(1,vis);

        return min;
    }

    private void dfs(int source, boolean vis[]) {
        if (vis[source]) {
            return;
        }

        vis[source] = true;

        for (int i=0; i<adj[source].size(); i++) {
            Pair p = adj[source].get(i);
            int dist = p.score;
            int child = p.city;
            min = Math.min(min, dist);

            if (!vis[child]) {
                dfs(child, vis);
            }
            
        }
    }    
}