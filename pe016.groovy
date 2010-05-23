#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=16
    http://keyzero.wordpress.com/2010/02/04/project-euler-problem-16/
 *********************************************************************/

def answer =
    ((BigInteger)(2**1000)).toString().toList()*.toInteger().sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
