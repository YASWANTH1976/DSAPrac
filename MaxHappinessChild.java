import java.util.*;

public class MaxHappinessChild {
    public long maxHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        Stack<Integer> stack = new Stack<>();
        for (int num : happiness) {
            stack.add(num);
        }
        long max = 0;
        int i = 0;
        while (k-- != 0 && !stack.isEmpty()) {
            int curr = stack.pop();
            if ((curr - i) > 0) {
                max += (curr - i);
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of children: ");
        int n = sc.nextInt();

        int[] happiness = new int[n];
        System.out.println("Enter happiness values:");
        for (int i = 0; i < n; i++) {
            System.out.print("Happiness[" + i + "]: ");
            happiness[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        MaxHappinessChild obj = new MaxHappinessChild();
        long result = obj.maxHappinessSum(happiness, k);
        System.out.println("Maximum Happiness Sum: " + result);

        sc.close();
    }
}
