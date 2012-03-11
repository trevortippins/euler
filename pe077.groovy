#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=77
    http://keyzero.wordpress.com/2010/09/04/project-euler-problem-77/
 *********************************************************************/

def primes =
    (1..<100).findAll { new BigInteger(it).isProbablePrime(100) }

def ( answer, total ) = [ 0, 11 ]

while (!answer) {

  def nways = [1] + [0]*total

  primes.findAll { it < total }.each { prime ->
    prime.upto(total) { nways[it] += nways[it - prime] }
  }

  if (nways[total] > 5000) answer = total
  total++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
