#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=10
    http://keyzero.wordpress.com/2010/01/07/project-euler-problem-10/
 *********************************************************************/

def isPrime = new boolean[2000000]
Arrays.fill(isPrime, true)
isPrime[1] = false

for (i in 2..(int)Math.sqrt(isPrime.size())) {
  if (isPrime[i]) {
    def j = i + i
    while (j < isPrime.size()) {
      isPrime[j] = false
      j += i
    }
  }
}

def answer = 0L

for (i in 2..<isPrime.size()) {
  if (isPrime[i]) answer += i
}


/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
