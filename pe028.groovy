#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=28
    http://keyzero.wordpress.com/2010/02/14/project-euler-problem-28/
 *********************************************************************/

def ( answer, brval ) = [ 1, 3 ]

(1..500).each { ring ->
  answer += 4 * brval + 6 * (2 * ring)
  brval += 8 * ring + 2
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
