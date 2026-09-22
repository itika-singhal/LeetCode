class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !dfs(graph, i, 1, color)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int currentColor, int[] color) {
        color[node] = currentColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(graph, neighbor, -currentColor, color)) {
                    return false;
                }
            } else if (color[neighbor] == currentColor) {
                return false;
            }
        }

        return true;
    }
}