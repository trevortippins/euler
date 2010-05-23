#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=27
    http://keyzero.wordpress.com/2010/02/14/project-euler-problem-27/
 *********************************************************************/

def isPrime = new boolean[12000]
Arrays.fill(isPrime, true)
(0..1).each { isPrime[it] = false }

for (i in 2..<(int)Math.sqrt(isPrime.size())) {
  if (!isPrime[i]) continue
  def j = i + i
  while (j < isPrime.size()) {
    isPrime[j] = false
    j += i
  }
}

def ( answer, maxlen ) = [ 0, 0 ]

for (a in -999..<1000) {
  if (!isPrime[Math.abs(a)]) continue
  for (b in 1..<1000) {
    if (!isPrime[b]) continue
    def n = 0
    while (isPrime[ (n * n) + (a * n) + b ]) {
      n++
    }
    if (n > maxlen) (maxlen, answer) = [ n, a * b ]
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
