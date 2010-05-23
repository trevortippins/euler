#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=26
    http://keyzero.wordpress.com/2010/02/14/project-euler-problem-26/
 *********************************************************************/

def answer =
    (1..<1000).collect {
        def ( found, remainder, divisor ) = [ [:], 10, 2 ]
        while (true) {
          if (remainder == 0) return [ it, 0 ]
          if (found.containsKey(remainder))
            return [ it, divisor - found[remainder] ]
          found[remainder] = divisor
          ( remainder, divisor )  = [ 10 * (remainder % it), divisor+1 ]
        }
    }.max { it[1] }[0]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
