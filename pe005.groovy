#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=5
    http://keyzero.wordpress.com/2009/11/07/project-euler-problem-5/
 *********************************************************************/

def answer =
    (2 ** 4) * (3 ** 2) * 5 * 7 * 11 * 13 * 17 * 19

/*********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
