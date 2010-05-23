#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=47
    http://keyzero.wordpress.com/2010/04/24/project-euler-problem-47/
 *********************************************************************/

def (f, i) = [ [0] * 1e6, 2 ]

while ((0..3).any { f[i-it] != 4 }) {
  if (f[i] == 0) (i+i).step(f.size(),i) { f[it]++ }
  i++
}

def answer = i - 3

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
