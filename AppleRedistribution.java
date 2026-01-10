import java.util.*;

public class AppleRedistribution {
    public int minBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int num : apple) {
            sum += num;
        }
        Arrays.sort(capacity);
        int count = 1;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (capacity[i] < sum) {
                count++;
            }
            if (sum <= 0) {
                break;
            }
            sum -= capacity[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter number of apple elements: ");
        int n = obj.nextInt();
        int[] apple = new int[n];
        System.out.println("Enter " + n + " integers for apple:");
        for (int i = 0; i < n; i++) {
            System.out.print("apple[" + i + "]: ");
            apple[i] = obj.nextInt();
        }

        System.out.print("Enter number of capacity elements: ");
        int m = obj.nextInt();
        int[] capacity = new int[m];
        System.out.println("Enter " + m + " integers for capacity:");
        for (int i = 0; i < m; i++) {
            System.out.print("capacity[" + i + "]: ");
            capacity[i] = obj.nextInt();
        }

        AppleRedistribution ar = new AppleRedistribution();
        int result = ar.minBoxes(apple, capacity);
        System.out.println("Minimum boxes required: " + result);

        obj.close();
    }

}