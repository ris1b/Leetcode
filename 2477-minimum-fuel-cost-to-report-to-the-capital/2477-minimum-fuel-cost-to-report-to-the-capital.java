class Solution {
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<roads.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        dfs(0,-1,adj,seats);
        return ans;
    }
    public int dfs(int node,int parent,List<List<Integer>> adj,int seats){
        int people=1;
        for(int adjnode:adj.get(node)){
            if(adjnode==parent) continue;
            people+=dfs(adjnode,node,adj,seats);
        }
        if(node!=0){
            ans+=Math.ceil((double)people/seats);
        }
        return people;
    }
}

// minimum number of liters of fuel to reach the capital city

//Note: 
/*
This graph does not have any cycles
Target = Node 0
Every node needs a path to connect it to Node 0

This is a connected graph and there are no cycles-> SO PATH EXISTS.

Calc_fuel = we have to get the path length from every node to the root

Instead of going from Leaf to root,
Try going from Root to the Leaf nodes as the Path would still be same.

*/