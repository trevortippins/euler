#!/usr/bin/env groovy

import groovy.transform.CompileStatic

def _ticks = System.nanoTime()

/**********************************************************************
 https://projecteuler.net/problem=87
 https://keyzero.wordpress.com/2010/05/14/project-euler-problem-87/
 *********************************************************************/

@CompileStatic
def getPrimes(int max_N) {
    def isPrime = new boolean[max_N]
    Arrays.fill(isPrime, true)
    isPrime[1] = false
    int sqrt_N = (int)Math.sqrt(max_N)

    for (i in 2..sqrt_N) {
        if (isPrime[i]) {
            int j = i * i
            while (j < max_N) {
                isPrime[j] = false
                j += i
            }
        }
    }
    return isPrime
}

def LIMIT = 50_000_000
def powers = [ 2:[], 3:[], 4:[] ]
def LIMIT_SQRT = (int)Math.sqrt(LIMIT)
def primes = getPrimes(LIMIT)

for (i in 2..LIMIT_SQRT) {
    if (primes[i]) {
        for (p in 2..4) {
            def n = i ** p
            if (n < LIMIT) powers[p] << n
        }
    }
}

def numbers = [] as Set

powers[2].each { p2 ->
    powers[3].findAll { (p2 + it) < LIMIT }.each { p3 ->
        powers[4].findAll { (p2 + p3 + it) < LIMIT }.each { p4 ->
            numbers << (p2 + p3 + p4)
        }
    }
}

def answer = numbers.size()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"





