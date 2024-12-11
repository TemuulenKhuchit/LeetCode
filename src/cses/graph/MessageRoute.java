package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MessageRoute {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS to find shortest path from 1 to n
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == n) {
                break;
            }
            for (int neigh : graph[cur]) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    parent[neigh] = cur;
                    q.offer(neigh);
                }
            }
        }

        if (!visited[n]) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            // Reconstruct the path
            List<Integer> path = new ArrayList<>();
            for (int v = n; v != -1; v = parent[v]) {
                path.add(v);
            }
            Collections.reverse(path);

            System.out.println(path.size());
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

}
