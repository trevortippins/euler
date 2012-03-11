#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=108
    http://keyzero.wordpress.com/2010/06/05/project-euler-problem-108/
 *********************************************************************/

def divisors(num, primes) {

  def (n, count, idx) = [ num, 1, 0 ]

  while (n > 1) {
    def base = primes[idx]
    while (n % base != 0) {
      base = primes[++idx]
    }

    def exp = 1
    while ((n > 0) && (n % base == 0)) {
      n = n.intdiv(base)
      exp++
    }
    idx++
    count *= exp
  }
  count
}

def primes = (2..17).findAll { it.toBigInteger().isProbablePrime(100) }
def inc = primes[0..<6].inject(1) { p, v -> p * v }
def n = inc + inc
def (answer, LIMIT) = [ 0, 1999 ]

while (answer == 0) {
  if (divisors(n ** 2, primes) > LIMIT) answer = n
  n += inc
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
