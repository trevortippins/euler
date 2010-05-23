#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=62
    http://keyzero.wordpress.com/2009/11/19/project-euler-problem-62/
 *********************************************************************/

def answer =
    (1..10000).collect { it ** 3 }
              .groupBy { it.toString().toList().sort().join("") }
              .findAll { it.value.size() == 5 }
              .collect { it.value }
              .flatten()
              .min()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
