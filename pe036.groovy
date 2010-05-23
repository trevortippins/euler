#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=36
    http://keyzero.wordpress.com/2010/05/03/project-euler-problem-36/
 *********************************************************************/

String.metaClass.isPalindrome = { ->
  delegate == delegate.reverse()
}

def answer =
    (1..<1000000).findAll {
                    ((it % 10 != 0) && ((it & 1) == 1)
                     && it.toString().isPalindrome()
                     && Integer.toBinaryString(it).isPalindrome())
                  }.sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
