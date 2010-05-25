#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=115
    http://keyzero.wordpress.com/2010/05/20/project-euler-problem-115/
 *********************************************************************/

def count(m, gap, cache) {

  if (gap < m) return 0
  if (cache[gap] != -1) return cache[gap]

  def total = 0L
  for (len in m..gap) {
    total += gap - len + 1
    def maxpos = gap - len + 1
    for (pos in 0..maxpos) {
      total += count(m, gap - len - pos - 1, cache)
    }
  }
  cache[gap] = total
}

def F(m, n) {
  def cache = new long[n+1]
  Arrays.fill(cache,-1)
  cache[m] = 1
  1 + count(m, n, cache)
}

def ( BLOCK_LEN, LIMIT ) = [ 50, 1e6 ]

def answer = BLOCK_LEN

while (F(BLOCK_LEN, answer) <= LIMIT) {
  answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
