#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=42
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-42/
 *********************************************************************/

def answer =
    new URL("http://projecteuler.net/project/words.txt")
             .getText()
             .replaceAll("\"","").split(",")
             .findAll { word ->
        def wv = word.collect { c -> ((char)c).charValue() - 64 }.sum()
        def sqrt = (int)((wv * 2) ** 0.5)
        sqrt * (sqrt + 1) == wv * 2
    }.size()


/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
