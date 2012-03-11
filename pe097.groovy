#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=97
    http://keyzero.wordpress.com/2010/09/05/project-euler-problem-97/
 *********************************************************************/

def PREC = 10G ** 10
def answer =
    (2G.modPow(7830457G, PREC) * 28433G + 1G).mod(PREC)

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
