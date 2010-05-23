#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=41
    http://keyzero.wordpress.com/2010/05/18/project-euler-problem-41/
 *********************************************************************/

// NOTE: This requires Groovy 1.7's permutation() method

def answer =
  (1..7).toList()
        .permutations()
        .collect { it.join().toBigInteger() }
        .findAll { it.isProbablePrime(100) }
        .max()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
