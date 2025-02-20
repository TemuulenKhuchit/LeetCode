package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Medium853 {

    // Medium 853. Car Fleet
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int res = 0, t = n;
        while (--t > 0) {
            if (cars[t].time < cars[t - 1].time)
                res++;
            else cars[t - 1] = cars[t];
        }
        return res + (t == 0 ? 1 : 0);
    }
}

class Car {
    int position;
    double time;

    Car(int p, double t) {
        position = p;
        time = t;
    }
}