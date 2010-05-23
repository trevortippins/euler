#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=34
    http://keyzero.wordpress.com/2010/02/23/project-euler-problem-34/
 *********************************************************************/

def fact = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]

def solve(n, sum, fact) {
  def total = ((n > 9) && (n == sum)) ? n : 0
  if (n * 10 <= sum + fact[9]) {
    def s = (n == 0) ? 1 : 0
    for (i in s..9)
      total += solve(n * 10 + i, sum + fact[i], fact)
  }
  return total
}

def answer = solve(0, 0, fact)

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
