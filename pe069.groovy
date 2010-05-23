#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=69
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-69/
 *********************************************************************/

// def answer = 2 * 3 * 5 * 7 * 11 * 13 * 17

def primes = (2..30).findAll {
    it.toBigInteger().isProbablePrime(100)
}

def ( answer, p, i ) = [ 0, 1, 0 ]
while (p < 1000000) {
  ( answer, p ) = [ p, p * primes[i++] ]
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
