#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=65
    http://keyzero.wordpress.com/2012/01/29/project-euler-problem-65/
 *********************************************************************/

def f(p1, p2, tc) {
  if (tc == 101) return p1
  def m = p1 + p2
  def n = ((tc + 1).intdiv(3) * 2) * m + p1
  f(n + m, n, tc + 3)
}

def answer =
    (f(2G, 1G, 2).toString() as List)*.toInteger().sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
