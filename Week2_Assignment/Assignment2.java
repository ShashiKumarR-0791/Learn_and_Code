import java.util.Scanner;

class ArrayProcessor {

    private long[] prefixSum;

    public ArrayProcessor(int[] array) {
        prefixSum = new long[array.length + 1];
        for (int i = 1; i <= array.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
    }

    public long getFloorOfMean(int left, int right) {
        long sum = prefixSum[right] - prefixSum[left - 1];
        return sum / (right - left + 1);
    }
}

class HandlerQuery {

    private Scanner scanner;

    public HandlerQuery() {
        scanner = new Scanner(System.in);
    }

    public int[] readArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public int[][] readQueries(int queryCount) {
        int[][] queries = new int[queryCount][2];
        for (int i = 0; i < queryCount; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        return queries;
    }

    public void close() {
        scanner.close();
    }
}

public class SubarrayMeanCalculator {
    public static void main(String[] args) {
        HandlerQuery queryHandler = new HandlerQuery();

        int n = queryHandler.scanner.nextInt();
        int q = queryHandler.scanner.nextInt();

        int[] array = queryHandler.readArray(n);
        ArrayProcessor processor = new ArrayProcessor(array);

        int[][] queries = queryHandler.readQueries(q);
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            System.out.println(processor.getFloorOfMean(left, right));
        }

        queryHandler.close();
    }
}
