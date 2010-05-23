#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=25
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-25/
 *********************************************************************/

def (fib1, fib2, answer) = [ 1G, 2G, 3 ]

while (fib2.toString().size() < 1000) {
    (fib1, fib2, answer) = [ fib2, fib1+fib2, answer+1 ]
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
