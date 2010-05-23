#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=7
    http://keyzero.wordpress.com/2010/01/06/project-euler-problem-7/
 *********************************************************************/

def isPrime = new boolean[200000]
Arrays.fill(isPrime, true);
isPrime[1] = false

for (int i in 2..(int)Math.sqrt(isPrime.size())) {
  if (isPrime[i]) {
    for (j = i + i; j < isPrime.size(); j += i) isPrime[j] = false
  }
}

def (answer, n) = [ 0, 0 ]
for (i in 2..<isPrime.size()) {
  if (isPrime[i]) {
    n++
    if (n == 10001) {
      answer = i
      break
    }
  }
}

/*********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
