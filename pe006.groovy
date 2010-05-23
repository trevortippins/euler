#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=6
    http://keyzero.wordpress.com/2010/01/06/project-euler-problem-6/
 *********************************************************************/

def answer =
    (1..100).sum() ** 2 - (1..100).sum { it * it }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
