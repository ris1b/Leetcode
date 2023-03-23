class Solution {
    public int makeConnected(int n, int[][] connections) {
        int [] parent = new int[n];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int c = 0;
        for(int arr[] : connections){
            if(!union(arr[0], arr[1], parent)){
                c++;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            int x = findRoot(i, parent);

            System.out.println(x + " ");
            set.add(x);
        }
        int ans = set.size()-1;
        if(ans > c) return -1;
        return ans;
    }


    public boolean union(int u, int v, int parent[]){
        int r1 = findRoot(u, parent);
        int r2 = findRoot(v, parent);

        if(r1 == r2) return false;

        parent[r1] = r2;

        return true;
    }

    public int findRoot(int node, int []parent){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findRoot(parent[node], parent);

        return parent[node];
    }
}