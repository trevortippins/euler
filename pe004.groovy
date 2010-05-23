#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=4
    http://keyzero.wordpress.com/2009/11/07/project-euler-problem-4/
**********************************************************************/

String.metaClass.isPalindrome = { ->
    delegate == delegate.reverse()
}

def answer = 0

for (i in 999..100) {
    for (j in 999..100) {
       def p = i * j
       if ((p > answer) && (p.toString().isPalindrome())) answer = p
    }
}

/*********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
