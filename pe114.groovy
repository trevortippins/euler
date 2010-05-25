#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=114
    http://keyzero.wordpress.com/2010/05/20/project-euler-problem-114/
 *********************************************************************/

def cache = new long[51]
Arrays.fill(cache,-1)
cache[3] = 1

def count(gap, cache) {

  if (gap < 3) return 0
  if (cache[gap] != -1) return cache[gap]

  def total = 0L
  for (len in 3..gap) {
    total += gap - len + 1
    def maxpos = gap - len + 1
    for (pos in 0..maxpos) {
      total += count(gap - len - pos - 1, cache)
    }
  }
  cache[gap] = total
}

def answer = 1 + count(50, cache)

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
