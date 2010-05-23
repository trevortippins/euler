#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=40
    http://keyzero.wordpress.com/2010/05/19/project-euler-problem-40/
 *********************************************************************/

def LIMIT = 1000000
def sb = new StringBuilder(LIMIT+10)
sb.append(".")

def i = 1
while (sb.length() <= LIMIT) {
  sb.append(i.toString())
  i++
}

i = 1
def answer = 1
while (i <= LIMIT) {
  answer *= sb[i].toInteger()
  i *= 10
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
