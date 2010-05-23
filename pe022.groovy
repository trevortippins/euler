#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=22
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-22/
 *********************************************************************/

def (answer, BASE_CHAR) = [ 0, ((char)'A').charValue() - 1 ]

new URL("http://projecteuler.net/project/names.txt")
        .getText()
        .replaceAll("\"","")
        .split(",")
        .sort()
        .eachWithIndex { name, idx ->
            answer += (idx+1) * name.toList().sum {
                ((char)it).charValue() - BASE_CHAR
            }
        }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
