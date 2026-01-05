import java.util.*;

public class MaxCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);

            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the number of kids:");
        int n = obj.nextInt();
        int[] candies = new int[n];
        System.out.print("Enter the number of candies for each kid:");
        for (int i = 0; i < n; i++) {
            candies[i] = obj.nextInt();
        }
        System.out.print("Enter extra candies:");
        int extraCandies = obj.nextInt();
        MaxCandies sol = new MaxCandies();
        List<Boolean> result = sol.kidsWithCandies(candies, extraCandies);
        System.out.println("Result: " + result);
        obj.close();
    }
}
