#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=76
    http://keyzero.wordpress.com/2010/09/04/project-euler-problem-76/
 *********************************************************************/

def ( total, coins ) = [ 100, (1..<100) ]

def nways = [1] + [0]*total

coins.each { coin ->
  coin.upto(total) { nways[it] += nways[it - coin] }
}

def answer = nways[total]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
