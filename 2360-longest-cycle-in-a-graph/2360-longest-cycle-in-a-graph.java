class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int [] deg = new int[n];
        boolean vis [] = new boolean[n];

        // in degree
        for(int i=0; i<n; i++){
            int x = edges[i];
            
            if(x == -1) continue;
            deg[x] += 1;
        }

        // for(int i : deg){
        //     System.out.println(i);
        // }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            int x = deg[i];
            if(x == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int x = q.poll();

            vis[x] = true;
            if(edges[x] == -1) continue;
            deg[edges[x]]--;

            if(deg[edges[x]] == 0){
                q.offer(edges[x]);
            }
        }

        int longest = -1;
        for(int i=0; i<n; i++){

            // check all those who are not visited yet ie. 2,3,4
            if(!vis[i]){
                int nodes = 1;

                int neigh = edges[i];
                vis[i] = true;
                while(neigh != i){
                    vis[neigh] = true;
                    neigh = edges[neigh];
                    nodes++;
                    // i++;
                }
                longest = Math.max(longest, nodes);
            }

        }

        return longest;

    }
}














