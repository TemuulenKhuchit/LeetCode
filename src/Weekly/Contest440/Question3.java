package Weekly.Contest440;

public class Question3 {

    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int[] baskets) {
            n = baskets.length;
            tree = new int[4 * n];
            build(baskets, 1, 0, n - 1);
        }

        private void build(int[] baskets, int node, int start, int end) {
            if (start == end)
                tree[node] = baskets[start];
            else {
                int mid = (start + end) / 2;
                build(baskets, 2 * node, start, mid);
                build(baskets, 2 * node + 1, mid + 1, end);
                tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
            }
        }

        public void update(int pos, int val) {
            update(1, 0, n - 1, pos, val);
        }

        private void update(int node, int start, int end, int pos, int val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (pos <= mid)
                    update(2 * node, start, mid, pos, val);
                else
                    update(2 * node + 1, mid + 1, end, pos, val);
                tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
            }
        }

        public int query(int required) {
            if (tree[1] < required) return -1;
            return query(1, 0, n - 1, required);
        }

        private int query(int node, int start, int end, int required) {
            if (start == end)
                return start;
            int mid = (start + end) / 2;
            if (tree[2 * node] >= required)
                return query(2 * node, start, mid, required);
            else
                return query(2 * node + 1, mid + 1, end, required);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        SegmentTree segTree = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = segTree.query(fruit);
            if (idx == -1)
                unplaced++;
            else
                segTree.update(idx, -1);
        }
        return unplaced;
    }
}
