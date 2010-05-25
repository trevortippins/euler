package com.keyzero.euler;

import java.util.Arrays;

public class Solution023 extends Solution {

  public String solve() {

    final int LO_VAL = 12;
    final int HI_VAL = 28123 + 1;

    final boolean[] isAbundant = new boolean[HI_VAL-LO_VAL+1];
    Arrays.fill(isAbundant, false);

    for (int i = LO_VAL; i <= HI_VAL-LO_VAL; i++) {
      int sum = 1;
      int sqrt = (int)Math.sqrt(i);
      for (int d = 2; d <= sqrt; d++) {
        if (i % d == 0) sum += d + i / d;
      }
      if (sqrt * sqrt == i) sum -= sqrt;
      isAbundant[i] = (sum > i);
    }

    final boolean[] nums = new boolean[HI_VAL];
    Arrays.fill(nums, false);

    for (int i = LO_VAL; i < isAbundant.length; i++) {
      if (isAbundant[i]) {
        for (int j = i; j  < isAbundant.length; j++) {
          if (isAbundant[j]) {
            int sum = i + j;
            if (sum >= HI_VAL) break;
            nums[sum] = true;
          }
        }
      }
    }

    int answer = 0;

    for (int i = 0; i < HI_VAL; i++) {
      if (!nums[i]) answer += i;
    }

    return String.valueOf(answer);
  }
}
