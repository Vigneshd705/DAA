package Greedy;// Java program for activity selection problem
// when input activities may not be sorted.
import java.util.*;

// A job has a start time, finish time and profit.
class Activity {
    int start, finish;

    // Constructor
    public Activity(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }
}
class GFG {
    static void printMaxActivities(Activity arr[], int n)
    {
        // Sort jobs according to finish time
        Arrays.sort(arr,Comparator.comparingInt((value -> value.finish)));
        System.out.println(
                "Following activities are selected :");

        int i = 0;
        System.out.print("(" + arr[i].start + ", "
                + arr[i].finish + ")");

        // Consider rest of the activities
        for (int j = 1; j < n; j++) {

            if (arr[j].start >= arr[i].finish) {
                System.out.print(", (" + arr[j].start + ", " + arr[j].finish + ")");
                i = j;
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {

        int n = 6;
        Activity arr[] = new Activity[n];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        // Function call
        printMaxActivities(arr, n);
    }
}

// This code is contributed by Dharanendra L V.
