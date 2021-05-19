package practice.algorithm.utils;

public class StopWatch {
    private static long startTime = 0;
    public static void play() {
        StopWatch.startTime = System.nanoTime();
    }
    public static void stop() { System.out.println("속도(ns):" + (System.nanoTime() - StopWatch.startTime)); }
}