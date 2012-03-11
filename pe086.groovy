#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=86
    http://keyzero.wordpress.com/2011/05/24/project-euler-problem-86/
 *********************************************************************/

def ( answer, solutions ) = [ 1, 0 ]

while (true) {
  for (i in 2..(2 * answer)) {
    def hyp = Math.sqrt(answer * answer + i * i)
    if (hyp == Math.floor(hyp)) {
      solutions += (i > answer + 1) ?
          (answer + answer + 2 - i).intdiv(2) : i.intdiv(2)
    }
  }
  if (solutions > 1e6) break
  answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
