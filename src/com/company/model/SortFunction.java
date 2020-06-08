package com.company.model;

import com.company.controller.Controller;
import com.company.view.MainFrame;
import com.company.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class SortFunction implements Runnable {
    public static final int FUNCTION_ID = 1;
    private static final int STRAP_DIGIT = 10;
    private int n; //длина массивов
    private int k; //количество сортируемых массивов
    private Controller controller;
    private Lock lock;
    private List<Point> data;
    private MainFrame frame;
    private int sleepTime;
    private int peakLimit;


    public SortFunction(int n, int k, Lock lock, MainFrame frame) {
        this.n = n;
        this.k = k;
        this.lock = lock;
        data = new ArrayList<>();
        this.frame = frame;
        sleepTime = 500;
        peakLimit = 2000;
    }

    @Override
    public void run() {
        for (int currentSize = 2; currentSize < n; currentSize++) {
            int commonTime = 0;
            for (int currentArrayCount = 1; currentArrayCount < k; currentArrayCount++) {
                commonTime += sortTime(generateRandomArray(currentSize));
            }
            int averageTime = commonTime / k;
            lock.lock();
            try {
                Point point = new Point(currentSize, averageTime);
                frame.getGraphic().addValue(FUNCTION_ID, point);
                frame.getMainPointsTable().addValue(point);
                frame.getGraphic().repaint();
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                currentSize = n;
            }
        }
    }


    private int[] bitonicsort(int[] arr) {
        return arr;
    }

    private long sortTime(int[] arrayToSort) {
        long startTime = System.nanoTime() / STRAP_DIGIT;

        bitonicsort(arrayToSort);
        long endTime = System.nanoTime() / STRAP_DIGIT;
        long result = endTime - startTime;
        if (result > peakLimit) {
            result = sortTime(arrayToSort);
        }
        return result;
    }

    private int[] generateRandomArray(int currentArraySize) {
        int[] result = new int[currentArraySize];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(currentArraySize);
        }
        return result;
    }
}
