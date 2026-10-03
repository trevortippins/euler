#!/usr/bin/env groovy
import groovy.transform.CompileStatic

def _ticks = System.nanoTime()

/**********************************************************************
 http://projecteuler.net/index.php?section=problems&id=60
 http://keyzero.wordpress.com/YYYY/MM/DD/project-euler-problem-60/
 *********************************************************************/

@CompileStatic
boolean isPrime(final int num) {

  if (num <= 1) return false
  if (num <= 3) return true
  if ((num % 2 == 0) || (num % 3 == 0)) return false

  int r = (int)Math.sqrt(num)
  int f = 5

  while (f <= r) {
    if (num % f == 0) return false
    if (num % (f + 2) == 0) return false
    f += 6
  }

  true
}

def getPrimePairs(maxnum) {

  def primes = ((2..maxnum).findAll { isPrime(it) })*.toString()
  def primeCount = primes.size()
  def pairs = [:]

  for (ip1 in 0..<primeCount - 1) {
    def sp1 = primes[ip1]
    pairs[sp1] = [] as Set
    for (ip2 in (ip1 + 1)..<primeCount) {
      def sp2 = primes[ip2]
      if (isPrime((sp1 + sp2).toInteger()) &&
          isPrime((sp2 + sp1).toInteger())) {
        pairs[sp1] << sp2
      }
    }
    if (pairs[sp1].size() < 4) pairs.remove(sp1)
  }
  pairs
}

def find5(list, min, pairs) {

  def sum = list*.toInteger().sum()
  if (list.size() == 5) return sum

  pairs[list[-1]].findAll { p -> ((sum + p.toInteger()) < min) &&
                                  (list.every { pairs[it].contains(p) }) }
                 .each { min = [ min, find5(list + it, min, pairs) ].min() }
  min
}

def (answer, primePairs) = [ Integer.MAX_VALUE, getPrimePairs(10000) ]

for (p in primePairs.keySet()) {
  answer = [ answer, find5([p], answer, primePairs) ].min()
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
