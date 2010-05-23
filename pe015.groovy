#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=15
    http://keyzero.wordpress.com/2010/01/29/project-euler-problem-15/
 *********************************************************************/

BigInteger answer =
    (21..40).inject(1G) { p, n -> p * n } / (2..20).inject(1G) { p, n -> p * n }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
