#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    https://projecteuler.net/problem=22
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-22/
 *********************************************************************/

def (answer, BASE_CHAR) = [ 0, ((char)'A').charValue() - 1 ]

new URL("https://projecteuler.net/resources/documents/0022_names.txt")
        .getText()
        .replaceAll("\"","")
        .split(",")
        .sort()
        .eachWithIndex { name, idx ->
            answer += (idx+1) * name.toList().sum(0) {
                (it as char).charValue() - BASE_CHAR
            }
        }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
