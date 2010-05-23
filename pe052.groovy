#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=52
    http://keyzero.wordpress.com/2010/04/30/project-euler-problem-52/
 *********************************************************************/

def ( i, answer ) = [ 1, 0 ]

while (answer == 0) {

  def s = (i.toString() as List).sort()

  for (j in 2..6) {
    if (s != (i * j).toString().toList().sort()) break
    if (j == 6) answer = i
  }

  i++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
