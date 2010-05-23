#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=30
    http://keyzero.wordpress.com/2010/02/14/project-euler-problem-30/
 *********************************************************************/

def p5 = [:]
0.upto(9) { p5[it.toString()] = it ** 5 }

def answer =
    (2..(6*p5["9"])).findAll { n->
        n.toString().toList().sum { p5[it] } == n
    }.sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
