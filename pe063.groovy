#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=63
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-63/
 *********************************************************************/

def answer =
    (1..9).sum { (int)(1 / ( 1 - Math.log10(it))) }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
