package LeetCode.Uncategorized;

import java.util.ArrayList;
import java.util.List;

public class Medium1352 {
    List<Integer> prefixProduct;
    int size = 0;

    public Medium1352() {
        init();
    }

    public void add(int num) {
        if (num == 0)
            init();
        else {
            this.prefixProduct.add(this.prefixProduct.get(size) * num);
            this.size++;
        }
    }

    public int getProduct(int k) {
        if (k > this.size)
            return 0;
        return this.prefixProduct.get(this.size) / this.prefixProduct.get(this.size - k);
    }

    private void init() {
        this.prefixProduct = new ArrayList<>();
        this.prefixProduct.add(1);
        this.size = 0;
    }
}
