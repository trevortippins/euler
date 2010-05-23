#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=55
    http://keyzero.wordpress.com/2010/05/20/project-euler-problem-55/
 *********************************************************************/

BigInteger.metaClass.isPalindrome() { ->
  def s = delegate.toString()
  s == s.reverse()
}

BigInteger.metaClass.reverse() { ->
  delegate.toString().reverse().toBigInteger()
}

def answer = 0

for (i in 1G..<10000G) {
  def n = i
  answer++
  for (c in 0..50) {
    n += n.reverse()
    if (n.isPalindrome()) {
      answer--
      break
    }
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
