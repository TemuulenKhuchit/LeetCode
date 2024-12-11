package cses.graph;

import java.io.*;
import java.util.*;

public class BuildingRoads {
    static class UnionFind {
        int[] parent, size;

        UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]]; // Path compression
                a = parent[a];
            }
            return a;
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            // Union by size
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            uf.union(a, b);
        }

        // Find all distinct leaders
        HashSet<Integer> leaders = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            leaders.add(uf.find(i));
        }

        int c = leaders.size(); // Number of connected components
        int needed = c - 1;

        StringBuilder sb = new StringBuilder();
        sb.append(needed).append('\n');

        if (needed > 0) {
            // Extract leaders in an array
            Integer[] comps = leaders.toArray(new Integer[0]);
            // Connect them in a chain
            for (int i = 1; i < comps.length; i++) {
                sb.append(comps[i - 1]).append(' ').append(comps[i]).append('\n');
            }
        }

        System.out.print(sb);
    }
}
