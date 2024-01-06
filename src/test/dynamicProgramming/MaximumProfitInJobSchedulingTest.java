package test.dynamicProgramming;


import main.dynamicProgramming.MaximumProfitInJobScheduling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProfitInJobSchedulingTest {

    private final MaximumProfitInJobScheduling scheduler = new MaximumProfitInJobScheduling();

    @Test
    public void testEmptyJobList() {
        assertEquals(0, scheduler.jobScheduling(new int[]{}, new int[]{}, new int[]{}),
                "No jobs should result in zero profit.");
    }

    @Test
    public void testSingleJob() {
        assertEquals(50, scheduler.jobScheduling(new int[]{1}, new int[]{3}, new int[]{50}),
                "Single job should result in its own profit.");
    }

    @Test
    public void testNonOverlappingJobs() {
        assertEquals(150, scheduler.jobScheduling(new int[]{1, 3, 6}, new int[]{3, 5, 9}, new int[]{50, 50, 50}),
                "All non-overlapping jobs should be included for maximum profit.");
    }

    @Test
    public void testOverlappingJobs() {
        assertEquals(120, scheduler.jobScheduling(new int[]{1, 2, 3, 4}, new int[]{3, 5, 10, 6}, new int[]{20, 50, 100, 70}),
                "Should choose the most profitable non-overlapping jobs.");
    }

    @Test
    public void testJobsWithSameEndTime() {
        assertEquals(150, scheduler.jobScheduling(new int[]{1, 2, 3}, new int[]{5, 5, 5}, new int[]{50, 100, 150}),
                "Should choose the job with the highest profit when end times are the same.");
    }

    @Test
    public void testComplexJobScheduling() {
        assertEquals(250, scheduler.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 5, 10, 6}, new int[]{50, 20, 100, 200}),
                "Complex job scheduling should yield the correct maximum profit.");
    }
}


