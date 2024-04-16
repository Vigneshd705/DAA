package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class FractionalKnapsack {
    double fractionalKnapsack(int capacity, Item[] arr, int n) {
        //Arrays.sort(arr, (a, b) -> Double.compare(b.value / (double) b.weight, a.value / (double) a.weight));
       // Arrays.sort(arr, Comparator.comparingDouble(a -> (a.value / (double) a.weight)));

        Arrays.sort(arr,Comparator.comparingDouble((o) -> -(o.value / (double) o.weight)));
        /*whether this sortd by ascending or descending order of values/weight*/
        double totalValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (capacity - arr[i].weight >= 0) {
                capacity = capacity - arr[i].weight;
                totalValue += arr[i].value;
            } else {
                double fraction = ((double) capacity / (double) arr[i].weight);
                totalValue += (arr[i].value * fraction);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        Item[] arr = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = new Item(values[i], weights[i]);
        }
        FractionalKnapsack fk = new FractionalKnapsack();
        double maxValue = fk.fractionalKnapsack(capacity, arr, values.length);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
