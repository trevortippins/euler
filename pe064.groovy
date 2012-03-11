#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=64
    http://keyzero.wordpress.com/2012/03/04/project-euler-problem-64/
 *********************************************************************/

def cf(n) {
  def ( i, j, c, k ) = [ 0, 1, 0, null ]
  def sqrt_n = Math.sqrt(n)
  while (true) {
    j = (n - (i * i)).intdiv(j)
    i = -(i - ((int)(sqrt_n + i)).intdiv(j) * j)
    if ([i, j] == k) return c - 1
    if (c == 1) k = [i, j]
    c++
  }
}

def answer = (2..10000).count {
  (((int)Math.sqrt(it)) ** 2 != it) && (cf(it) % 2)
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"