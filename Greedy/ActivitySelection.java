import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class FinishTimeComparator implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.finish, a2.finish);
    }
}

public class ActivitySelection {
    ArrayList<Activity> activities;
    int count=0;
    ActivitySelection(int n) {
        activities = new ArrayList<>(n);
    }

    void selectActivities() {
        Collections.sort(activities, new FinishTimeComparator());
        System.out.println("Selected Activities:");
        System.out.println("Start\tFinish");
        int prevFinish = Integer.MIN_VALUE;
        for (Activity activity : activities) {
            if (activity.start >= prevFinish) {
                System.out.println(activity.start + "\t" + activity.finish);
                prevFinish = activity.finish;
                count++;
            }
        }
        System.out.println("Selected Activities: "+count);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of activities: ");
        int n = scan.nextInt();
        ActivitySelection activitySelection = new ActivitySelection(n);

        System.out.println("Enter the start and finish times of activities: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Activity " + (i + 1) + ": ");
            int start = scan.nextInt();
            int finish = scan.nextInt();
            activitySelection.activities.add(new Activity(start, finish));
        }

        activitySelection.selectActivities();
        scan.close();
    }
}
