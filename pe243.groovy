#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=243
    http://keyzero.wordpress.com/2012/01/21/project-euler-problem-243/
 *********************************************************************/

def gen_powers(range, maxlen, pows, yield) {
  if (pows.size() == maxlen)
    yield(pows)
  else if (pows.size() == 0)
    range.each { gen_powers(range, maxlen, [it], yield) }
  else
    range.findAll { it >= pows[0] }
         .each { gen_powers(range, maxlen, [it]+pows, yield) }
}

def ( answer, TARGET, POWER_RANGE ) = [ Long.MAX_VALUE, 15499/94744, (0..4) ]
def primes = [ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ]

gen_powers(POWER_RANGE, primes.size(), [1] * primes.size()- 1) { powers ->
  def (d, factors) = [ 1G, [] ]
  powers.eachWithIndex { v, i ->
    d *= primes[i] ** v
    if (v > 0) factors << primes[i]
  }
  if ((d > 1) &&
      (answer > d) &&
      (((int)(factors.inject(d) { p, v -> p * (1 - 1/v) })) / (d-1) < TARGET)) {
    answer = d
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
