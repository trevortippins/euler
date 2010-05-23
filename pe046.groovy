#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=46
    http://keyzero.wordpress.com/2010/05/18/project-euler-problem-46/
 *********************************************************************/

def LIMIT = 9999
def SQRT_LIMIT = (int)Math.sqrt(LIMIT)

def primes =
    (1..LIMIT).findAll { it.toBigInteger().isProbablePrime(100) }
def nums =
    (3..LIMIT).findAll { (it & 1) == 1 }
def tsqr =
    (0..SQRT_LIMIT.intdiv(2)).collect { 2 * it * it }

def answer =
    nums.findAll { i ->
        tsqr.every { !primes.contains(i - it) } }.min()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
