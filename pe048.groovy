#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=48
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-48/
 *********************************************************************/

def answer =
    (1G..1000G).sum { it.modPow(it, 10**10) }.toString()[-10..-1]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
