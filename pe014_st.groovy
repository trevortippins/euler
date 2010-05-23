#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=14
    http://keyzero.wordpress.com/2010/01/29/project-euler-problem-14/
 *********************************************************************/

def ( maxlen, answer ) = [ 0, 0 ]

def CACHE_SIZE = 1000000
def cache = new int[CACHE_SIZE]

for (i in 1..<1000000) {
  long n = i
  def len = 1
  while (n > 1) {
    if ((n < CACHE_SIZE) && (cache[(int)n] != 0)) {
      len += cache[(int)n] - 1
      break
    }
    if ((n & 1) == 0) {
      n >>= 1
      len++
    }
    else {
      n = (n + n + n + 1) >> 1
      len += 2
    }
    len++
  }
  cache[i] = len
  if (len > maxlen) ( maxlen, answer ) = [ len, i ]
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
