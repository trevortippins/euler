#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=58
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-58/
 *********************************************************************/

Integer.metaClass.isPrime() { ->
    delegate.toBigInteger().isProbablePrime(100)
}

def (answer, primes, count, side) = [ 0, 0, 1, 3 ]

while (answer == 0) {

    def sqr = side * side
    primes += (1..3).findAll { (sqr - it * (side-1)).isPrime() }
		    .size()
    count += 4

    if (primes / count < 0.1) answer = side

    side += 2
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
