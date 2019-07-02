package com.wangtao.mylibrary.datastructure.heap.practice;

import android.support.annotation.NonNull;

import com.wangtao.mylibrary.datastructure.heap.HeapAny;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangtao
 * @Description: 堆应用(优先级队列)：定时器。
 * 小顶堆，存储任务，获取堆顶任务同当前时间比较，获取时间间隔T，等待T时间后再执行任务。
 * 而不是每过1秒扫描一次任务。
 * @date 2019/7/2 10:15
 */
public class Timer {
    private HeapAny<Task> heap;
    private int capacity;

    public Timer(int capacity) {
        this.capacity = capacity;
        heap = new HeapAny<>(capacity, true);
    }

    public boolean addTask(Task task) {
        //加入堆中
        return heap.insert(task);
    }

    /**
     * 这里只是模拟等待
     *
     * @throws InterruptedException
     */
    public void execute() throws InterruptedException {
        //从堆中取出堆顶元素
        while (true) {
            Task task = heap.pop();
            if (task == null) {
                break;
            }
            long now = System.currentTimeMillis();
            long pollTimeoutMillis = task.taskTime - now;
            if (pollTimeoutMillis > 0) {
                //等待
                Thread.sleep(pollTimeoutMillis);
            }
            task.run();
        }
    }


    /**
     * 任务
     */
    public static class Task implements Runnable, Comparable {

        public long taskTime;

        public Task(long taskTime) {
            this.taskTime = taskTime;
        }

        @Override
        public void run() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(taskTime);
            System.out.println("Task run ,time is :" + dateFormat.format(date));
        }

        @Override
        public int compareTo(@NonNull Object o) {
            /**
             * Task run ,time is :2019-07-02 11:44:22
             * Task run ,time is :2019-07-02 11:44:26
             * Task run ,time is :2019-07-02 11:44:31
             * Task run ,time is :2019-07-02 11:44:41
             */
            return taskTime - ((Task) o).taskTime > 0 ? 1 : -1;
        }
    }
}
