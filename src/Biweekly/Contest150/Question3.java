package Biweekly.Contest150;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        Question3 sol = new Question3();

        int[][] squares1 = { {0, 0, 1}, {2, 2, 1} };
        double result1 = sol.findHorizontalLine(squares1);
        System.out.printf("Example 1 result: %.5f\n", result1);

        int[][] squares2 = { {0, 0, 2}, {1, 1, 1} };
        double result2 = sol.findHorizontalLine(squares2);
        System.out.printf("Example 2 result: %.5f\n", result2);

        int[][] squares3 = {
                {522261215,954313664,461744743},
                {628661372,718610752,21844764},
                {619734768,941310679,91724451},
                {352367502,656774918,591943726},
                {860247066,905800565,853111524},
                {817098516,868361139,817623995},
                {580894327,654069233,691552059},
                {182377086,256660052,911357},
                {151104008,908768329,890809906},
                {983970552,992192635,462847045}
        };
        double result3 = sol.findHorizontalLine(squares3);
        System.out.printf("Test case result: %.5f\n", result3);
    }

    public double findHorizontalLine(int[][] squares) {
        List<Event> events = new ArrayList<>();
        List<Integer> xsList = new ArrayList<>();
        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];
            int x2 = x + l, y2 = y + l;
            events.add(new Event(y, x, x2, 1));
            events.add(new Event(y2, x, x2, -1));
            xsList.add(x);
            xsList.add(x2);
        }
        Collections.sort(xsList);
        List<Integer> uniqueXsList = new ArrayList<>();
        for (int v : xsList) {
            if (uniqueXsList.isEmpty() || uniqueXsList.get(uniqueXsList.size()-1) != v)
                uniqueXsList.add(v);
        }
        int[] xs = new int[uniqueXsList.size()];
        for (int i = 0; i < uniqueXsList.size(); i++) {
            xs[i] = uniqueXsList.get(i);
        }

        events.sort(Comparator.comparingInt(a -> a.y));

        SegmentTree segTree = new SegmentTree(xs);
        List<Segment> segs = new ArrayList<>();

        double curY = events.get(0).y;
        int i = 0;
        int nEvents = events.size();
        while (i < nEvents) {
            double eventY = events.get(i).y;
            if (eventY > curY) {
                double unionX = segTree.query();
                segs.add(new Segment(curY, eventY, unionX));
                curY = eventY;
            }
            while (i < nEvents && events.get(i).y == eventY) {
                Event e = events.get(i);
                segTree.update(e.x1, e.x2, e.type);
                i++;
            }
        }

        double totalArea = 0.0;
        for (Segment s : segs) {
            totalArea += s.unionX * (s.end - s.start);
        }
        double target = totalArea / 2.0;
        double areaSoFar = 0.0;
        double ans = -1;
        for (Segment s : segs) {
            double segArea = s.unionX * (s.end - s.start);
            if (areaSoFar + segArea >= target) {
                if (s.unionX == 0) {
                    ans = s.start;
                } else {
                    double needed = target - areaSoFar;
                    double deltaY = needed / s.unionX;
                    ans = s.start + deltaY;
                }
                break;
            }
            areaSoFar += segArea;
        }
        if (ans < 0) {
            ans = segs.get(segs.size()-1).end;
        }
        return ans;
    }

    class Event {
        int y;
        int x1, x2;
        int type;
        public Event(int y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    class Segment {
        double start, end, unionX;
        public Segment(double start, double end, double unionX) {
            this.start = start;
            this.end = end;
            this.unionX = unionX;
        }
    }

    class SegmentTree {
        int[] xs;
        int n;
        int[] count;
        double[] covered;

        public SegmentTree(int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            int size = 4 * n;
            count = new int[size];
            covered = new double[size];
        }

        public void update(int L, int R, int delta) {
            int l = lowerBound(xs, L);
            int r = lowerBound(xs, R);
            update(1, 0, n - 1, l, r - 1, delta);
        }

        private void update(int idx, int left, int right, int ql, int qr, int delta) {
            if (ql > right || qr < left) return;
            if (ql <= left && right <= qr) {
                count[idx] += delta;
            } else {
                int mid = (left + right) / 2;
                update(idx * 2, left, mid, ql, qr, delta);
                update(idx * 2 + 1, mid + 1, right, ql, qr, delta);
            }
            if (count[idx] > 0) {
                covered[idx] = xs[right + 1] - xs[left];
            } else if (left == right) {
                covered[idx] = 0;
            } else {
                covered[idx] = covered[idx * 2] + covered[idx * 2 + 1];
            }
        }

        public double query() {
            return covered[1];
        }

        private int lowerBound(int[] arr, int val) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (arr[mid] < val) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
