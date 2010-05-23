#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=57
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-57/
 *********************************************************************/

def ( num, denom, answer ) = [ 3G, 2G, 0 ]

1000.times {
    ( num, denom ) = [ num + 2 * denom, num + denom ]
    if (num.toString().length() > denom.toString().length()) answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
