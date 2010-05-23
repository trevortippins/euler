#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=53
    http://keyzero.wordpress.com/2010/05/19/project-euler-problem-53/
 *********************************************************************/

def MAXNUM = 100
def LIMIT = Math.log10(1e6)

def fact = new double[MAXNUM+1]
(0..1).each { fact[it] = Math.log10(1) }

for (i in 2..MAXNUM) {
  fact[i] = Math.log10(i) + fact[i-1]
}

def answer =
    (1..MAXNUM).sum { n ->
        (1..<n).findAll { r -> fact[n] - (fact[r] + fact[n-r]) > LIMIT }
               .size()
    }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
