package com.konceptsandcode.basicbroadcastreceivers;

public class ThreadUtils {
    public static long getThreadID() {
        return Thread.currentThread().getId();
    }

    public static String getThreadInfo() {
        Thread thread = Thread.currentThread();

        String threadName = thread.getName();
        String threadGroup = thread.getThreadGroup().getName();

        long threadId = thread.getId();
        long threadPriority = thread.getPriority();

        return "Thread name:" + threadName +
                " Thread Group:" + threadGroup +
                " Thread id:" + threadId +
                " Thread Priority:" + threadPriority;
    }

    public static void sleepForSecs(int secs) {
        try {
            Thread.sleep(secs * 1000);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}