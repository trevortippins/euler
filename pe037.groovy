#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=37
    http://keyzero.wordpress.com/2010/05/04/project-euler-problem-37-3/
 *********************************************************************/

def LIMIT = 1000000
def isPrime = new boolean[LIMIT+1]
Arrays.fill(isPrime, true)
(0..1).each { isPrime[it] = false }

for (int i in 2..<Math.sqrt(LIMIT)) {
    if (!isPrime[i]) continue
    def j = i + i
    while (j < LIMIT) {
        isPrime[j] = false
        j += i
    }
}

def (answer, c) = [ 0, 0 ]

for (i in 11..<LIMIT) {
  if (isPrime[i]) {
    def n = i.intdiv(10)
    while ((n > 0) && isPrime[n]) {
      n = n.intdiv(10)
    }
    if (n > 0) continue
    def m = 10 ** (int)Math.log10(i)
    n = i % m
    while ((n > 0) && isPrime[n]) {
      m = m.intdiv(10)
      n %= m
    }
    if (n == 0) {
        answer += i
        if (++c == 11) break
    }
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
