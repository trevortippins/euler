#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=110
    http://keyzero.wordpress.com/2010/06/12/project-euler-problem-110/
 *********************************************************************/

def ( LIMIT, POWER_RANGE ) = [ 4e6, (0..5) ]
def primes =
    (2..47).findAll { it.toBigInteger().isProbablePrime(100) }

def gen_powers(range, maxlen, yield) {
  gen_powers(range, maxlen, [], yield)
}

def gen_powers(range, maxlen, pows, yield) {
  if (pows.size() == maxlen)
    yield(pows)
  else if (pows.size() == 0)
    range.each { gen_powers(range, maxlen, [it], yield) }
  else
    range.findAll { it >= pows[0] }
         .each { gen_powers(range, maxlen, [it]+pows, yield) }
}

def answer = Long.MAX_VALUE

gen_powers(POWER_RANGE, primes.size()) { powers ->
  if ((1 + powers.inject(1) { p, v -> p * (2 * v + 1) }).intdiv(2) >= LIMIT) {
    def n = 1G
    powers.eachWithIndex { v, i -> n *= primes[i] ** v }
    answer = [ answer, n ].min()
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
