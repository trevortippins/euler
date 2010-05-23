#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=70
    http://keyzero.wordpress.com/2010/05/05/project-euler-problem-70/
 *********************************************************************/

def LIMIT = 10000000
def UPRIME=(int)Math.ceil((Math.sqrt(LIMIT) * 1.3))
def LPRIME=(int)Math.floor((Math.sqrt(LIMIT) * 0.7))

def isPrime = new boolean[UPRIME]
Arrays.fill(isPrime, true)
(0..1).each { isPrime[it] = false }

for (i in 2..<Math.sqrt(UPRIME)) {
  if (!isPrime[i]) continue
  def j = i + i
  while (j < UPRIME) {
    isPrime[j] = false
    j += i
  }
}

def primes = []
for (i in LPRIME..<UPRIME) { if (isPrime[i]) primes << i }

def ( answer, min ) = [ 0, Double.MAX_VALUE ]

for (i in 0..<primes.size()-1) {
  for (j in i+1..<primes.size()) {
    def n = primes[i] * primes[j]
    if (n > LIMIT) break
    def phi = (primes[i]-1) * (primes[j]-1)
    if (n.toString().toList().sort().join()
        == phi.toString().toList().sort().join()) {
      def ratio = n / phi
      if ( ratio < min ) ( answer, min ) = [ n, ratio ]
    }
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
