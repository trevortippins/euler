#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=24
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-24/
 *********************************************************************/

def (s, perm) = [ "0123456789", 1000000-1 ]
def (elems, len) = [ s.toList(), s.size() ]

def fact = (2..<len).inject(1) { p, v -> p * v }

for (i in 0..<len-1) {
  def p = perm.intdiv(fact) % (len-i)
  def temp = elems[i+p];
  (i+p).downto(i+1) { elems[it] = elems[it-1] }
  elems[i] = temp;
  fact = fact.intdiv(len-(i+1))
}

def answer = elems.join("")

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
