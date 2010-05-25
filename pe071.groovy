#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=71
    http://keyzero.wordpress.com/2010/04/09/project-euler-problem-71/
 *********************************************************************/

def ( answer, c ) = [ 2, 5 ]
def ( b, d ) = [ 3, 7 ]

while (c + d <= 1000000) {
    answer += b
    c += d
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
