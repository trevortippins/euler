#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=120
    http://keyzero.wordpress.com/2010/05/03/project-euler-problem-120/
 *********************************************************************/

def answer =
    (3..1000).sum { 2 * it * (it - 1).intdiv(2) }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
