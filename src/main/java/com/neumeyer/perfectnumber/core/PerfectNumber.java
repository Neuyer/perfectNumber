package com.neumeyer.perfectnumber.core;

import com.neumeyer.perfectnumber.core.exception.PerfectNumberException;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    /**
     * Checks if a number is a perfect number.
     * A perfect number is a positive integer that is equal to the sum of its proper positive divisors.
     *
     * @param number The number to check.
     * @return true if the number is a perfect number, false otherwise.
     */
    protected boolean isPerfect(int number) {
        if (number <= 1) {
            return false;
        }

        int sumOfDivisors = 1; // 1 is always a proper divisor

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
                if (i * i != number) {
                    sumOfDivisors += number / i;
                }
            }
        }
        return sumOfDivisors == number;
    }

    /**
     * Finds all perfect numbers within a given range (inclusive).
     *
     * @param numbers A list of numbers in the specified range.
     * @return A list of perfect numbers in the specified range.
     */
    public List<Integer> findPerfectNumbersInArray(List<Integer> numbers) {
        List<Integer> perfectNumbers = new ArrayList<>();

        if (numbers == null || numbers.isEmpty())
            return perfectNumbers;

        var start = numbers.getFirst();
        var end = numbers.getLast();

        if (start > end)
            throw new PerfectNumberException("Invalid range: start cannot be greater than end.");

        for (int i = Math.max(1, start); i <= end && i <= 1000000; i++) {
            System.out.println(i);
            if (isPerfect(i)) {
                perfectNumbers.add(i);
            }
        }

        return perfectNumbers;
    }

    public static PerfectNumber create() {
        return new PerfectNumber();
    }
}
