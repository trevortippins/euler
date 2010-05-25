package com.keyzero.euler;

import java.util.Arrays;

public class Solution179 extends Solution {

  public String solve() {

    final int LIMIT = 10000000;
    int[] sieve = new int[LIMIT+1];
    Arrays.fill(sieve, 2);  // don't worry about elements 0 & 1

    for (int i = 2; i <= (int)Math.sqrt(LIMIT); i++) {

      int j = i * i;
      sieve[j]--;

      while (j <= LIMIT) {
        sieve[j] += 2;
        j += i;
      }
    }

    int answer = 0;

    for (int i = 2; i < LIMIT; i++) {
      if (sieve[i] == sieve[i+1]) answer++;
    }

    return String.valueOf(answer);
  }
}
