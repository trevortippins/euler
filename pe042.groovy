#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    https://projecteuler.net/problem=42
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-42/
 *********************************************************************/

def answer =
    new URL("https://projecteuler.net/resources/documents/0042_words.txt")
             .getText()
             .replaceAll("\"","").split(",")
             .findAll { word ->
        def wv = word.collect { c -> (c as char).charValue() - 64 }.sum()
        def sqrt = (int)((wv * 2) ** 0.5)
        sqrt * (sqrt + 1) == wv * 2
    }.size()


/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
