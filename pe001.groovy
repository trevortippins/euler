#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=1
    http://keyzero.wordpress.com/2009/10/15/project-euler-problem-1/
 *********************************************************************/

def answer =
    (1..<1000).findAll { (it % 3 == 0) || (it % 5 == 0) }.sum()

/*********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
