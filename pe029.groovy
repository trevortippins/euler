#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=29
    http://keyzero.wordpress.com/2010/02/14/project-euler-problem-29/
 *********************************************************************/

def set = [] as Set

for (a in 2..100)
    for (b in 2..100)
        set << (a ** b)

def answer = set.size()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
