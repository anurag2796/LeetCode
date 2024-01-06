package main.dynamicProgramming;

import java.util.*;

public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length == 0)
            return 0;

        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        // Sort the jobs by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0); // Initialize with a dummy job with 0 profit
        for (int[] job : jobs) {
            // Find the largest profit we can have before the start of this job
            int curProfit = dp.floorEntry(job[0]).getValue() + job[2];
            // If this is better than the last job we can take, add or update it in the map
            if (curProfit > dp.lastEntry().getValue()) {
                dp.put(job[1], curProfit);
            }
        }
        return dp.lastEntry().getValue();
    }
}
