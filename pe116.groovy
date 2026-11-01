#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    https://projecteuler.net/problem=116
    http://keyzero.wordpress.com/2010/05/20/project-euler-problem-116/
 *********************************************************************/

def count(int m, int gap, long[] cache) {

  if (gap < m) return 0
  if (cache[gap] != -1) return cache[gap]

  def total = gap - m + 1L
  def maxpos = total
  for (int pos in 0..maxpos) {
    total += count(m, gap - m - pos, cache)
  }
  cache[gap] = total
}

def F(int m, int n) {
  def cache = new long[n+1]
  Arrays.fill(cache,-1)
  cache[m] = 1L
  count(m, n, cache)
}

def answer = (2..4).sum { F(it,50) }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
