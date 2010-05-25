#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=85
    http://keyzero.wordpress.com/2010/05/14/project-euler-problem-85/
 *********************************************************************/

def ( mindiff, answer ) = [ Integer.MAX_VALUE, 0 ]

def sums = (0..100).collect { (it * it + it) / 2 }

for (i in 1..100) {
  for (j in i..100) {
    def n = sums[i] * sums[j] - 2000000
    if ( Math.abs(n) < mindiff )
        ( mindiff, answer, x, y ) = [ Math.abs(n), i * j ]
    if (n > 0) break
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
