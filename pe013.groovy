#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=13
    http://keyzero.wordpress.com/2010/01/27/project-euler-problem-13/
 *********************************************************************/

def answer =
    new File("pe013_nums.txt").text.split("\n")*.toBigInteger()
                              .sum()
                              .toString()[0..9]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
