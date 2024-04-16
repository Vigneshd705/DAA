import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ProfitComparator implements Comparator<Bag> {
    public int compare(Bag item1, Bag item2) {
        return Double.compare(item2.profit, item1.profit);
    }
}

class Bag {
    double weight, profit;
    double profitPerUnit;

    public Bag(double weight, double profit) {
        this.weight = weight;
        this.profit = profit;
        this.profitPerUnit = profit / weight;
    }
}

public class FractionalKnapsack {
    double capacity;
    ArrayList<Bag> bags;

    FractionalKnapsack(int n) {
        bags = new ArrayList<Bag>(n);
    }

    double getMaxProfit() {
        Collections.sort(bags, new ProfitComparator());
        double maxProfit = 0;
        for (Bag bag : bags) {
            if (capacity >= bag.weight) {
                maxProfit += bag.profit;
                capacity -= bag.weight;
            } else {
                maxProfit += (capacity / bag.weight) * bag.profit;
                break;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of bags: ");
        int n = scan.nextInt();
        FractionalKnapsack knapsack = new FractionalKnapsack(n);

        System.out.println("Enter the capacity of the knapsack: ");
        knapsack.capacity = scan.nextDouble();

        System.out.println("Enter the weights and profits of bags: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Weight of bag " + (i + 1) + ": ");
            double weight = scan.nextDouble();
            System.out.println("Profit of bag " + (i + 1) + ": ");
            double profit = scan.nextDouble();
            knapsack.bags.add(new Bag(weight, profit));
        }

        double maxProfit = knapsack.getMaxProfit();
        System.out.println("Maximum profit that can be obtained: " + maxProfit);
        scan.close();
    }
}
