#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=56
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-56/
 *********************************************************************/

BigInteger.metaClass.digitSum() { ->
  delegate.toString()*.toInteger().sum()
}

def answer =
    ([(90G..99G).toList()]*2).combinations()
                             .collect { it[0].pow(it[1]).digitSum() }
                             .max()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
