class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        boolean vis[]=new boolean[n];
        createGraph(edges,graph);
        return validPathUtil(n, edges, source, destination, graph, vis);
    }
    public boolean validPathUtil(int n, int[][] edges, int source, int destination,ArrayList<Edge>[] graph,boolean[] vis){
        if(source==destination){
            return true;
        }
        vis[source]=true;
        for(int i=0;i<graph[source].size();i++){
            Edge e=graph[source].get(i);
            if(!vis[e.dest]){
                if(validPathUtil(n,edges,e.dest,destination,graph,vis)){
                return true;
                }
            }
        }
        return false;
    }
    public void createGraph(int[][] edges,ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            Edge e=new Edge(src,dest);
            graph[src].add(e);
            graph[dest].add(new Edge(dest, src));
        }
    }
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
}
