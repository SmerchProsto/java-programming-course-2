package com.company.Series;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorIntegers implements Iterator<Integer> {
    private int[] nums;
    private int currPos;

    public IteratorIntegers(int[] nums) {
        this.nums = nums;
        currPos = 0;
    }

    @Override
    public boolean hasNext() {
        return currPos < nums.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int next = nums[currPos];
        currPos++;

        return next;
    }
}
