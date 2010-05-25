#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=119
    http://keyzero.wordpress.com/2010/04/10/project-euler-problem-119/
 *********************************************************************/

def results = []

for (base in 2..200) {
    for (pow in 2..20) {
        def n = (base ** pow).toBigInteger()
        def sum = n.toString().toList().sum { it.toInteger() }
        if (sum == base) results << [ n, base, pow ]
        if (results.size() == 60) break
    }
}

results.sort { it[0] }

def answer = results[29][0]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
