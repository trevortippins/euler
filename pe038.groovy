#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=38
    http://keyzero.wordpress.com/2010/05/03/project-euler-problem-38/
 *********************************************************************/

def answer =
    (9876..9182).collect { it.toString() + (it*2).toString() }
                .findAll { it.toList().sort().join() == "123456789" }
                .max()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
