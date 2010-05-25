#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=74
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-74/
 *********************************************************************/

Integer.metaClass.sumDigitFactorials { ->
  def factorials = [ 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 ]
  def sum = 0
  def str = delegate.toString()
  for (i in str) {
    sum += factorials[i.toInteger()]
  }
  sum
}

def cache = new int[6 * 362880 + 1]
def answer = 0

for (i in 1..<1000000) {

  def len = 0

  if (cache[i] != 0) {
    len = cache[i]
  }
  else {
    def chain = [i]
    def n = i.sumDigitFactorials()

    while ((cache[n] == 0) && !chain.contains(n)) {
      chain << n
      n = n.sumDigitFactorials()
    }

    len = chain.size()
    if (cache[n] != 0) len += cache[n]
    cache[i] = len
  }

  if (len == 60) answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
