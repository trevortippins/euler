#!/usr/bin/env groovy

import groovy.transform.CompileStatic

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=52
    http://keyzero.wordpress.com/2010/04/30/project-euler-problem-52/
 *********************************************************************/

def ( i, answer ) = [ 1, 0 ]

while (answer == 0) {

  def s = (i.toString() as List).sort()

  for (j in 2..6) {
    if (s != (i * j).toString().toList().sort()) break
    if (j == 6) answer = i
  }

  i++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"





@CompileStatic
def solve052_1() {

  def ( i, answer ) = [ 1, 0 ]

  while (answer == 0) {

    answer =
            ( ((1..6).collect { (i * it).toString().toList().sort() } as Set)
                    .size() == 1 ) ? i : 0

    i++
  }

  answer
}

@CompileStatic
def solve052_2() {

  def ( i, answer ) = [ 1, 0 ]

  while (answer == 0) {

    def s = (i.toString() as List).sort()

    for (j in 2..6) {
      if (s != (i * j).toString().toList().sort()) break
      if (j == 6) answer = i
    }

    i++
  }

  answer
}

_ticks = System.nanoTime()
answer = solve052_1()
_ticks = System.nanoTime() - _ticks

println "Answer (1): $answer"
println "Elapsed: ${_ticks / 1e6} ms"

_ticks = System.nanoTime()
answer = solve052_2()
_ticks = System.nanoTime() - _ticks

println "Answer (2): $answer"
println "Elapsed: ${_ticks / 1e6} ms"
