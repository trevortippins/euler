#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=23
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-23/
 *********************************************************************/

import com.keyzero.euler.Solution023

def answer = new Solution023().solve()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
