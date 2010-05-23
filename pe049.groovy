#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=49
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-49/
 *********************************************************************/

def answer = ""

(1003..9997).findAll { BigInteger n -> n.isProbablePrime(100) }
            .groupBy { it.toString().toList().sort().join() }
            .findAll { it.key != "1478" && it.value.size() > 2 }
            .each {
              def p = it.value
              for (i in 0..<p.size()-2) {
                for (j in (i+1)..<p.size()-1) {
                  def p3 = 2 * p[j] - p[i]
                  if (p.contains(p3)) {
                    answer = [ p[i], p[j], p3 ].join()
                  }
                }
              }
            }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
