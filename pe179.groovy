#!/usr/bin/env groovy

import groovy.transform.CompileStatic

def _ticks = System.nanoTime()

/**********************************************************************
    https://projecteuler.net/problem=179
    http://keyzero.wordpress.com/2010/04/10/project-euler-problem-179/
 *********************************************************************/

@CompileStatic
static int solve(int LIMIT) {

    int[] sieve = new int[LIMIT + 1]
    Arrays.fill(sieve, 2)    // don't worry about elements 0 & 1

    int SQRT_LIMIT = (int)Math.sqrt(LIMIT)

    for (int i = 2; i <= SQRT_LIMIT; i++) {

        int j = i * i
        sieve[j]--

        while (j <= LIMIT) {
            sieve[j] += 2
            j += i
        }
    }

    int answer = 0

    for (int i = 2; i < LIMIT; i++) {
        if (sieve[i] == sieve[i + 1]) answer++
    }

    return answer
}

def answer = solve(10_000_000)

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
