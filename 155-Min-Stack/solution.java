public class MinStack {

    int[] data;
    int i, min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new int[1000000];
        i = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        data[i++] = x;
        min = Math.min(x, min);
    }

    public void pop() {
        int t = data[--i];
        if (t == min){
            min = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0; j--) {
                min = Math.min(min, data[j]);
            }
        }
    }

    public int top() {
        return data[i-1];
    }

    public int getMin() {
        return min;
    }
}