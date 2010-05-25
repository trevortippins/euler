#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=117
    http://keyzero.wordpress.com/2010/05/20/project-euler-problem-117/
 *********************************************************************/

def count(m, gap, cache) {

  if (gap < m[0]) return 0
  if (cache[gap] != -1) return cache[gap]

  def total = 0L
  for (len in m) {
    def maxpos = gap - len + 1
    total += maxpos
    for (pos in 0..maxpos) {
      total += count(m, gap - len - pos, cache)
    }
  }
  cache[gap] = total
}

def F(m, n) {
  def cache = new long[n+1]
  Arrays.fill(cache,-1)
  cache[m[0]] = 1
  1 + count(m, n, cache)
}

def answer = F((2..4), 50)

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
