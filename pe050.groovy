#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=50
    http://keyzero.wordpress.com/2010/05/19/project-euler-problem-50/
 *********************************************************************/

def LIMIT = 999999
def SQRT_LIMIT = (int)Math.sqrt(LIMIT)

def isPrime = new boolean[LIMIT+1]
Arrays.fill(isPrime, true)
(0..1).each { isPrime[it] = false }

for (i in 2..SQRT_LIMIT) {
  if (!isPrime[i]) continue
  def j = i + i
  while (j < LIMIT) {
    isPrime[j] = false
    j += i
  }
}

def primes = (2..LIMIT).findAll { isPrime[it] }

def ( max, answer ) = [ 0, 0 ]

primes.eachWithIndex { prime, idx ->
  def ( len, sum ) = [ 1, prime ]
  for (i in idx+1..<primes.size()) {
    sum += primes[i]
    if (sum > LIMIT) break
    len++
    if ((len > max) && isPrime[sum]) (max, answer) = [ len, sum ]
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
