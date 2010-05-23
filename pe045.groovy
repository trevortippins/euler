#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=45
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-45/
 *********************************************************************/

def ( tri, penta, hexa ) = [ [], [], [] ]

for (n in 144L..<100000L) {
  tri   << (n * (n + 1)).intdiv(2)
  penta << (n * (3 * n - 1)).intdiv(2)
  hexa  <<  n * (2 * n - 1)
}

def answer =
    (tri.intersect(penta).intersect(hexa))[0]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
