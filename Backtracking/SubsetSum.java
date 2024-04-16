import java.util.*;

public class SubsetSum {
    public static boolean subsetSum(int[] nums, int target) {
        return subsetSum(nums, target, 0, 0);
    }

    private static boolean subsetSum(int[] nums, int target, int index, int sum) {
        if (sum == target) {
            return true;
        }
        if (index == nums.length || sum > target) {
            return false;
        }

        // Include the current element in the subset
        if (subsetSum(nums, target, index + 1, sum + nums[index])) {
            System.out.println(nums[index]+" ");
            return true;
        }

        // Exclude the current element from the subset
        return subsetSum(nums, target, index + 1, sum);
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;

        if (subsetSum(nums, target)) {
            System.out.println("There exists a subset that sums up to the target.");
        } else {
            System.out.println("No subset sums up to the target.");
        }
    }
}
