#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=179
    http://keyzero.wordpress.com/2010/04/10/project-euler-problem-179/
 *********************************************************************/

import com.keyzero.euler.Solution179

def answer = new Solution179().solve()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
