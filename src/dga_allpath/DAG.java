package dga_allpath;

import java.util.ArrayList;
import java.util.List;

public class DAG {
    public List<List<Integer>> all_paths(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, res, path,0, graph.length);
        return res;
    }

    void dfs(int[][] graph, List<List<Integer>> res, ArrayList<Integer> path, int cur, int n) {
        if (cur==n-1) {
            res.add(new ArrayList<>(path));
            return;  //使用return，终止本次递归
        }
        for(int next: graph[cur]) {
            path.add(next);
            dfs(graph, res, path, next, n);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        DAG d = new DAG();
        List<List<Integer>> res = d.all_paths(graph);
        System.out.println(res);
    }
}
