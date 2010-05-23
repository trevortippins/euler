#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=20
    http://keyzero.wordpress.com/2010/02/08/project-euler-problem-20/
 *********************************************************************/

def answer =
    ((2..100).inject(1G) { p, n -> p * n })
             .toString().toList()*.toInteger().sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
