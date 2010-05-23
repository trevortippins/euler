#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=9
    http://keyzero.wordpress.com/2010/01/25/project-euler-problem-9/
 *********************************************************************/

def answer = 0

for (a in 1..<500) {
  for (b in (a+1)..500) {
    def c = 1000 - (a + b)
    if ((c > b) && (c * c == a * a + b * b)) {
      answer = a * b * c
      break
    }
  }
  if (answer > 0) break
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
