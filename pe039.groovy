#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=39
    http://keyzero.wordpress.com/2010/04/30/project-euler-problem-39/
 *********************************************************************/

def LIMIT = 1000
def ( c, max, answer ) = [ [0]*LIMIT, 0, 0 ]

for (i in 1..<LIMIT.intdiv(2)) {
  for (j in 1..<LIMIT-i) {
    def hyp = ((i * i) + (j * j)) ** 0.5
    if ((int)hyp == hyp) {
      def p = i + j + hyp
      if (p < LIMIT) {
        c[p]++
        if (c[p] > max) ( max, answer ) = [ c[p], p ]
      }
    }
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
