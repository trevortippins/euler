#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=2
    http://keyzero.wordpress.com/2009/10/16/project-euler-problem-2/
 *********************************************************************/

def (x, y, answer) = [ 1, 1, 0 ]

while (y < 4000000) {
  answer += (x + y)
  (x, y) = [ x + 2*y, 2*x + 3*y ]
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
