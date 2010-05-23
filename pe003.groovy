#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=3
    http://keyzero.wordpress.com/2009/11/05/project-euler-problem-3/
**********************************************************************/

def n = 600851475143L
def (answer, i) = [ 0, 2G ]

while (n > 1) {
    if (i.isProbablePrime(100) && (n % i == 0)) {
        ( n, answer ) = [ n.intdiv(i), i ]
    }
    i++
}

/*********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
